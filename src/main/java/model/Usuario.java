package model;

import java.util.LinkedHashSet;
import java.util.Set;

import utils.Crypt;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private TipoAtraccion tipoFavorito;
	private Set<Ofertable> ofertables; // Las sugerencias que va aceptando.
	private String password;
	private Boolean admin;
	protected Integer id;
	
	public Usuario(String nombre, Double presupuesto, Double tiempoDisponible, TipoAtraccion tipoFavorito,
			String password, Boolean admin) throws Exception {

		this.nombre = nombre;
		validandoPresupuesto(presupuesto);
		validandoTiempoDisponible(tiempoDisponible);
		this.tipoFavorito = tipoFavorito;
		this.ofertables = new LinkedHashSet<>();
		this.password = password;
		this.admin = admin;

	}
	
	public Usuario(Integer id, String nombre, Double presupuesto, Double tiempoDisponible, TipoAtraccion tipoFavorito,
			String password, Boolean admin) throws Exception {

		this.id = id;
		this.nombre = nombre;
		validandoPresupuesto(presupuesto);
		validandoTiempoDisponible(tiempoDisponible);
		this.tipoFavorito = tipoFavorito;
		this.ofertables = new LinkedHashSet<>();
		this.password = password;
		this.admin = admin;

	}

	public Usuario() {
	}
	
	public void agregarAItinerario(Ofertable atraccion) {
		this.presupuesto -= atraccion.getMonto();
		this.tiempoDisponible -= atraccion.getTiempo();
	}
	
	public boolean puedeComprar(Ofertable atraccion) {
		return atraccion.getMonto() <= this.presupuesto;
	}
	
	public boolean puedeAsistir(Ofertable atraccion) {
		return atraccion.getTiempo() <= this.tiempoDisponible;
	}

	/*
	 * validación para evitar presupuesto negativo, si lo es, lanza una excepción
	 */
	private void validandoPresupuesto(double presupuesto) throws Exception {
		if (presupuesto < 0.0)
			throw new SinMontoDisponible();
	this.presupuesto = presupuesto;
	}

	/*
	 * validación para evitar tiempo negativo, si lo es, lanza una excepción
	 */
	private void validandoTiempoDisponible(double tiempo) throws Exception {
		if (tiempo < 0.0)
			throw new SinTiempoDisponible();
		this.tiempoDisponible = tiempo;
	}
	
	/*
	 * se espera que devuelva el tiempo disponible
	 */
	public double getTiempoDisponible() {
		return this.tiempoDisponible;
	}

	/*
	 * se espera que devuelva el presupuesto
	 */
	public double getPresupuesto() {
		return this.presupuesto;
	}

	/*
	 * se espera que devuelva el tipo favorito de atraccion
	 */

	public TipoAtraccion getTipoFavorito() {//<<=============================================== esto lo agregue porque dado que lo pase a string no tiene uso, y rompe todo si se lo saco
		return this.tipoFavorito;
	}

	/*
	 * se espera que devuelva el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/*
	 * se espera que devuelva una lista de ofertables
	 */
	public Set<Ofertable> getOfertables() {
		return this.ofertables;
	}

	public boolean esUsuarioValido(String nombre, String password, Double presupuesto, Double tiempoDisponible,TipoAtraccion tipoFavorito) {
		
		return ((nombre != null) && (password != null) && (presupuesto > 0) && (tiempoDisponible > 0)&&((tipoFavorito == TipoAtraccion.AVENTURA)||(tipoFavorito == TipoAtraccion.DEGUSTACION)||(tipoFavorito == TipoAtraccion.PAISAJE)));

	}

	/*
	 * Muestra todos los datos del usuario mas sus ofertables aceptados en formato
	 * itinerario, calculando el tiempo y costo total para completar su agenda.
	 */
	@Override
	public String toString() {
		String aux = '\n' + nombre + ", presupuesto: " + presupuesto + ", tiempo disponible: "
				+ tiempoDisponible + ", tipo favorito: " + tipoFavorito;
		return aux;
	}

	/*
	 * @Param tiempo metodo privado para restar un tiempo al atributo
	 * tiempoDisponible
	 */
	double restarTiempo(double tiempo) {
		return this.tiempoDisponible -= tiempo;
	}

	/*
	 * @Param monto metodo privado para restar un presupuesto al atributo
	 * presupuesto
	 */
	double restarPresupuesto(double monto) {
		return this.presupuesto -= monto;
	}

	/*
	 * @Param o pasa el ofertable que el usuario va a comprar al aceptar sugerencia
	 * una vez que el usuario compra un ofertable sugerido se le restara el
	 * presupuesto y el tiempo del ofertable comprado finalmente guarda el ofertable
	 * en su lista de ofertables
	 */
	
	public void comprarOfertable(Ofertable o) {
		double tiempoO = o.getTiempo();
		double presupuesto = o.getMonto();

		restarTiempo(tiempoO);
		restarPresupuesto(presupuesto);
		ofertables.add(o);

}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

	public Boolean getAdmin() {
		return admin;
	}

	public String getPassword() {
		return password;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}

	public void setTiempoDisponible(Double tiempo) {
		this.tiempoDisponible = tiempo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public boolean esValidoFull(String nombre, Double presupuesto, Double tiempo, TipoAtraccion tipo,
			Boolean admin) {
		return ((nombre != null) && (presupuesto >= 0) && (tiempo >= 0) && 
				((admin = true) || (admin = false))
				&& (tipo == TipoAtraccion.DEGUSTACION || tipo == TipoAtraccion.PAISAJE
						|| tipo == TipoAtraccion.AVENTURA));
	}

}
