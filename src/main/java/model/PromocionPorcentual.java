package model;

import java.io.InputStream;
import java.util.Objects;

public class PromocionPorcentual extends Promocion {

	private int descuento;

	/*
	 * Constructor usado para crear objetos nuevos sin id (se asigna en base de
	 * datos automaticamente)
	 */
	public PromocionPorcentual(String nombre, Atraccion[] packAtracciones, TipoAtraccion tipo, int descuento) {
		super(nombre, packAtracciones, tipo);
		this.descuento = descuento;
	}
	
	/*
	 * Constructor usado para instanciar objetos a partir de base de datos
	 */
	public PromocionPorcentual(Integer id, String nombre, Atraccion[] packAtracciones, TipoAtraccion tipo, int descuento) {
		super(id, nombre, packAtracciones, tipo);
		this.descuento = descuento;
	}
	
	/*
	 * Constructor usado para que no falle la webapp en caso de null
	 */
	public PromocionPorcentual() {
	}

	// realiza el descuento porcentual para un pack de atracciones
	@Override
	public Double getMonto() {
		double precioFinal = 0;
		for (Atraccion atraccion : this.packAtracciones) {
			precioFinal += atraccion.getMonto();
		}

		precioFinal -= precioFinal / 100 * this.getDescuento();

		return precioFinal;
	}


	@Override
	public String toString() {
		var aux = '\n'  + getNombre() + ": " + "descuento: " + descuento + ", precio: " 
		+ getMonto() + ", duracion: " + getTiempo() + ", tipo: " + getTipo()
		+ ", atracciones incluidas: " + '\n';
		
		for (Atraccion atraccion : packAtracciones) {
			aux += atraccion.toString();
		}
		return aux;
	}

	/*
	 * se espera que devuelva el descuento
	 */
	@Override
	public int getDescuento() {
		return descuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(descuento);
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
		PromocionPorcentual other = (PromocionPorcentual) obj;
		return Double.doubleToLongBits(descuento) == Double.doubleToLongBits(other.descuento);
	}

	@Override
	public int compareTo(Ofertable otro) {
		return -this.getMonto().compareTo(otro.getMonto());
	}

	public boolean esValida(String nombre, Atraccion[] packAtracciones, TipoAtraccion tipo, int descuento) {
		return ((nombre != null) && (descuento > 0) && (descuento < 100) && (packAtracciones != null)
		&& (tipo == TipoAtraccion.DEGUSTACION || tipo == TipoAtraccion.PAISAJE
				|| tipo == TipoAtraccion.AVENTURA));
	}

	

	@Override
	public InputStream getImagen() {
		// TODO Auto-generated method stub
		return null;
	}
}
