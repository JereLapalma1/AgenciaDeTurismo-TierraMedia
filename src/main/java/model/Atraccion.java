package model;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import persistence.impl.AtraccionDAOImpl;

public class Atraccion implements Ofertable, Comparable<Ofertable> {

	protected double costo;
	protected double tiempo;
	protected int cupoDisponible;
	protected TipoAtraccion tipoAtraccion;
	protected String nombre;
	protected Integer id;
	protected InputStream imagen;

	private Map<String, String> errors;

	/*
	 * @Param nombre , costo, tiempo , cupoDisponible y tipo se inicializan todos
	 * los atributos de la atraccion
	 */

	/*
	 * Constructor usado para instanciar objetos a partir de base de datos
	 */
	public Atraccion(Integer id, String nombre, double costo, double tiempo, int cupoDisponible, TipoAtraccion tipoDeAtraccion,InputStream imagen)
			throws Exception {
		super();
		this.id = id;
		this.nombre = nombre;
		validandoCosto(costo);
		validandoTiempo(tiempo);
		validandoCupo(cupoDisponible);
		this.tipoAtraccion = tipoDeAtraccion;
	this.imagen = imagen;
	}
	
	/*
	 * Constructor usado para crear objetos nuevos sin id (se asigna en base de
	 * datos automaticamente)
	 */
	public Atraccion(String nombre, double costo, double tiempo, int cupoDisponible, TipoAtraccion tipoDeAtraccion)
			throws Exception {
		super();
		this.nombre = nombre;
		validandoCosto(costo);
		validandoTiempo(tiempo);
		validandoCupo(cupoDisponible);
		this.tipoAtraccion = tipoDeAtraccion;
	}
	
	public Atraccion() {
	}



	public boolean puedeAlbergar(int i) {
		return this.cupoDisponible >= i;
	}

	public void albergar(int i) {
		this.cupoDisponible -= i;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (this.costo <= 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (this.tiempo <= 0) {
			errors.put("tiempo", "Debe ser positivo");
		}
		if (this.cupoDisponible <= 0) {
			errors.put("cupoDisponible", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}	

	public boolean esValidoFull(String nombre, Double costo, Double tiempo, Integer cupo, TipoAtraccion tipo) {
		return ((nombre != null) && (costo > 0) && (tiempo > 0) && (cupo > 0)
		&& (tipo == TipoAtraccion.DEGUSTACION || tipo == TipoAtraccion.PAISAJE
				|| tipo == TipoAtraccion.AVENTURA));
	}
	
	
	public boolean esValido(Integer cupo) {
		return cupo > 0;
	}

	/*
	 * validaciï¿½n para evitar costo negativo, si lo es, lanza una excepciï¿½n
	 */
	private void validandoCosto(double costo) throws Exception {
		if (costo < 0.0)
			throw new CostoNegativoExcepcion();
		this.costo = costo;
	}

	/*
	 * validaciï¿½n para evitar tiempo negativo, si lo es, lanza una excepciï¿½n
	 */
	private void validandoTiempo(double tiempo) throws Exception {
		if (tiempo < 0.0)
			throw new SinTiempoDisponible();
		this.tiempo = tiempo;
	}

	/*
	 * validaciï¿½n para evitar cupo negativo, si lo es, lanza una excepciï¿½n
	 */
	private void validandoCupo(int cupoDisponible) throws Exception {
		if (cupoDisponible < 0)
			throw new CupoNegativoException();
		this.cupoDisponible = cupoDisponible;
	}
	
	/*
	 * se espera que devuelva el cupo disponible
	 */
	public int getCupoDisponible() {
		return cupoDisponible;
	}

	/*
	 * se espera que devuelva el nombre
	 */
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, nombre, tiempo, tipoAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && Objects.equals(nombre, other.nombre) && tiempo == other.tiempo
				&& tipoAtraccion == other.tipoAtraccion;
	}

	/*
	 * Metodo reservar cupo : si todavia hay cupo de atraccion se restara un cupo
	 * para decir que esta reservado
	 */
	public void reservarCupo() throws SQLException {
		AtraccionDAOImpl aDAO = new AtraccionDAOImpl();
		if (this.hayCupo()) {
			this.cupoDisponible -= 1;
		}

	}

	/*
	 * se espera que devuelva el costo
	 */
	@Override
	public Double getMonto() {

		return this.costo;
	}

	/*
	 * se espera que devuelva el tipo
	 */

	
	@Override
	public TipoAtraccion getTipo() {

		return this.tipoAtraccion;
	}
	

	/*
	 * Metodo hayCupo : pregunta si todavia hay cupo disponible
	 */
	@Override
	public boolean hayCupo() {
		return this.cupoDisponible > 0;
	}

	/*
	 * se espera que devuelva el tiempo
	 */
	@Override
	public Double getTiempo() {

		return this.tiempo;
	}

	/*
	 * aplica toString a las atracciones para que se muestren en el formato
	 * requerido. Aplica un salto de lï¿½nea con \n para mayor legibilidad.
	 */
	@Override
	public String toString() {
		return getNombre() + ": " + "precio: " + getMonto() + ", duracion: " + getTiempo() + ", tipo: " + getTipo()
				+ '\n';
	}

	@Override
	public int compareTo(Ofertable otro) {
		return -this.getMonto().compareTo(otro.getMonto());
	}
	
	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public void setTipoAtraccion(TipoAtraccion tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}


	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Atraccion getPackAtracciones1() {
		return null;
	}

	@Override
	public Atraccion getPackAtracciones2() {
		return null;
	}

	@Override
	public Atraccion getAtraccionGratis() {
		return null;
	}

	@Override
	public int getDescuento() {
		return 0;
	}

	@Override
	public Atraccion[] getPackAtracciones() {
		return null;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public InputStream getImagen() {
		return  this.imagen;
	}

	public void setImagen(InputStream imagen) {
		this.imagen = imagen;
	}

		
}
