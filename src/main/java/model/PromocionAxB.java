package model;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;

import persistence.impl.AtraccionDAOImpl;

public class PromocionAxB extends Promocion {

	private Atraccion atraccionGratis;

	/*
	 * Constructor usado para crear objetos nuevos sin id (se asigna en base de
	 * datos automaticamente)
	 */
	public PromocionAxB(String nombre, Atraccion[] atraccion, TipoAtraccion tipo, Atraccion atraccionGratis) {
		super(nombre, atraccion, tipo);
		this.atraccionGratis = atraccionGratis;
	}
	
	/*
	 * Constructor usado para instanciar objetos a partir de base de datos
	 */
	public PromocionAxB(Integer id, String nombre, Atraccion[] atraccion, TipoAtraccion tipo, Atraccion atraccionGratis) {
		super(id, nombre, atraccion, tipo);
		this.atraccionGratis = atraccionGratis;
	}
	
	/*
	 * Constructor usado para que no falle la webapp en caso de null
	 */
	public PromocionAxB() {		
	}

	/*
	 * se calcula el descuento de estas promociones y a su vez se le deposita a
	 * usuario una nueva atraccion
	 */

	@Override
	public Double getMonto() {
		double precioFinal = 0;
		for (Atraccion atraccion : this.packAtracciones) {
			precioFinal += atraccion.getMonto();
		}
		return precioFinal;
	}

	/*
	 * calcula el tiempo que necesita el usuario para adiquir una promocion
	 */
	@Override
	public Double getTiempo() {
		double tiempo = 0;
		for (Atraccion atraccion : this.packAtracciones) {
			tiempo += atraccion.getTiempo();
		}

		tiempo += this.atraccionGratis.getTiempo();
		return tiempo;
	}

	/*
	 * se espera que devuelva una atraccion gratis
	 */

	@Override
	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	/*
	 * pregunta si hay cupo disponible tanto en el pack de atracciones como en la
	 * promocion que se otorga gratis
	 */
	public boolean hayCupo() {

		return ((this.packAtracciones[0].getCupoDisponible() > 0) && (this.packAtracciones[1].getCupoDisponible() > 0)
				&& this.atraccionGratis.getCupoDisponible() > 0);
	}
	
	@Override
	public boolean puedeAlbergar(int i) {
		return ((this.packAtracciones[0].getCupoDisponible() > 0) && (this.packAtracciones[1].getCupoDisponible() > 0)
				&& this.atraccionGratis.getCupoDisponible() > 0);
	}

	/*
	 * si hay cupo disponible en la atraccion gratis se resta un cupo
	 */
	@Override
	public void reservarCupo() throws SQLException {
		AtraccionDAOImpl aDAO = new AtraccionDAOImpl();
		for (Atraccion atraccion : packAtracciones) {
			atraccion.cupoDisponible -= 1;
		}
		atraccionGratis.cupoDisponible -= 1;
	}
	
	@Override
	public void albergar(int i) {
		for (Atraccion atraccion : packAtracciones) {
			atraccion.cupoDisponible -= 1;
		}
		atraccionGratis.cupoDisponible -= 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(atraccionGratis);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromocionAxB other = (PromocionAxB) obj;
		return Objects.equals(atraccionGratis, other.atraccionGratis);
	}

	@Override
	public String toString() {
		var aux = '\n' + getNombre() + ": " + "precio: " + getMonto() + ", duracion: " + getTiempo() + ", tipo: "
				+ getTipo() + ", atracciones incluidas: \n";
		for (Atraccion atraccion : packAtracciones) {
			aux += atraccion.toString();
		}
		aux += "Atraccion gratis: " + atraccionGratis;
		return aux;
	}

	@Override
	public int compareTo(Ofertable otro) {
		return -this.getMonto().compareTo(otro.getMonto());
	}

	public boolean esValida(String nombre, Atraccion[] pack, TipoAtraccion tipo, Atraccion gratis) {
		return ((nombre != null) && (gratis != null) && (packAtracciones != null)
				&& (tipo == TipoAtraccion.DEGUSTACION || tipo == TipoAtraccion.PAISAJE
						|| tipo == TipoAtraccion.AVENTURA));
	}



	@Override
	public InputStream getImagen() {
		// TODO Auto-generated method stub
		return null;
	}

}
