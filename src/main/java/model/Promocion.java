package model;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

import persistence.impl.AtraccionDAOImpl;

public abstract class Promocion implements Ofertable, Comparable<Ofertable> {
    

	private String nombre;
	protected Atraccion[] packAtracciones;
	private TipoAtraccion tipoDeAtraccion;
	private double tiempo;
	private Integer id;
	
	/*
	 * Constructor usado para crear objetos nuevos sin id (se asigna en base de
	 * datos automaticamente)
	 */
	public Promocion(String nombre, Atraccion[] atraccion, TipoAtraccion tipoDeAtraccion) {
		this.packAtracciones = atraccion;
		this.nombre = nombre;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
	
	/*
	 * Constructor usado para instanciar objetos a partir de base de datos
	 */
	public Promocion(Integer id, String nombre, Atraccion[] atraccion, TipoAtraccion tipoDeAtraccion) {
		this.id = id;
		this.packAtracciones = atraccion;
		this.nombre = nombre;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
	
	/*
	 * Constructor usado para que no falle la webapp en caso de null
	 */
	public Promocion() {		
	}
	
	protected void setPackAtracciones(Atraccion[] packAtracciones) {
		this.packAtracciones = packAtracciones;
	}
	
	public Atraccion[] getPackAtracciones() {
		return packAtracciones;
	}

	@Override
	public String toString() {
		return Arrays.toString(packAtracciones);
	}
	
	public Atraccion getPackAtracciones1() {
		return packAtracciones[0];
	}
	
	public Atraccion getPackAtracciones2() {
		return packAtracciones[1];
	}
	
	public Atraccion getAtraccionGratis() {
		return null;
	}

	public int getDescuento() {
		return 0;
	}
	/*
	 * se espera que devuelva el nombre
	 */
	@Override
	public String getNombre() {
		return nombre;
	}

	/*
	 * get costo se encargara de calcular los descuentos en cada promocion
	 */
	public abstract Double getMonto();

	/*
	 * calcula el tiempo que necesita el usuario para adiquir una promocion
	 */
	public Double getTiempo() {
		this.tiempo = 0;
		for (Atraccion atraccion : packAtracciones) {
			tiempo += atraccion.getTiempo();
		}

		return tiempo;
	}

	public TipoAtraccion getTipo() {
		return tipoDeAtraccion;
	}
	

	/*
	 * pregunta si hay cupo disponible
	 */
	@Override
	public boolean hayCupo() {

		return ((this.packAtracciones[0].getCupoDisponible() > 0) && 
				(this.packAtracciones[1].getCupoDisponible() > 0));
	}

	@Override
	public void  reservarCupo() throws SQLException {
		AtraccionDAOImpl aDAO = new AtraccionDAOImpl();
		for (Atraccion atraccion : packAtracciones) {
			atraccion.cupoDisponible -= 1;
			}
	}
	
	@Override
	public void albergar(int i) {
		for (Atraccion atraccion : packAtracciones) {
			atraccion.cupoDisponible -= 1;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(packAtracciones);
		result = prime * result + Objects.hash(nombre, tiempo, tipoDeAtraccion);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(nombre, other.nombre) && Arrays.equals(packAtracciones, other.packAtracciones)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo) && tipoDeAtraccion == other.tipoDeAtraccion;
	}
	
	@Override
	public boolean puedeAlbergar(int i) {
		return ((this.packAtracciones[0].getCupoDisponible() > 0) && 
				(this.packAtracciones[1].getCupoDisponible() > 0));
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	
	
}
