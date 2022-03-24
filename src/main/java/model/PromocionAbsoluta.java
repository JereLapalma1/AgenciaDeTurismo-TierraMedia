package model;

import java.io.InputStream;
import java.util.Objects;

public class PromocionAbsoluta extends Promocion {

	private double monto;

	/*
	 * Constructor usado para crear objetos nuevos sin id (se asigna en base de
	 * datos automaticamente)
	 */
	public PromocionAbsoluta(String nombre, Atraccion[] packAtracciones, TipoAtraccion tipo, double monto) {
		super(nombre, packAtracciones, tipo);
		this.monto = monto;
	}
	
	/*
	 * Constructor usado para instanciar objetos a partir de base de datos
	 */
	public PromocionAbsoluta(Integer id, String nombre, Atraccion[] packAtracciones, TipoAtraccion tipo, double monto) {
		super(id, nombre, packAtracciones, tipo);
		this.monto = monto;
	}
	
	/*
	 * Constructor usado para que no falle la webapp en caso de null
	 */
	public PromocionAbsoluta() {		
	}

	/*
	 * getMonto devuelve el monto final
	 */
	
	public Double getMonto() {
		return monto;
	}

	@Override
	public String toString() {
		var aux = '\n' + getNombre() + ": " + "precio: " + getMonto() + ", duracion: " 
				+ getTiempo() + ", tipo: " + getTipo()
				+ ", atracciones incluidas: \n";
		for (Atraccion atraccion : packAtracciones) {
			aux += atraccion.toString();
		}
		return aux;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(monto);
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
		PromocionAbsoluta other = (PromocionAbsoluta) obj;
		return Double.doubleToLongBits(monto) == Double.doubleToLongBits(other.monto);
	}

	@Override
	public int compareTo(Ofertable otro) {
		return -this.getMonto().compareTo(otro.getMonto());
	}

	public boolean esValida(String nombre, Atraccion[] pack, TipoAtraccion tipo, Double monto) {
		return ((nombre != null) && (packAtracciones != null) && (monto >= 1)
				&& (tipo == TipoAtraccion.DEGUSTACION || tipo == TipoAtraccion.PAISAJE
						|| tipo == TipoAtraccion.AVENTURA));
	}

	
	@Override
	public InputStream getImagen() {
		// TODO Auto-generated method stub
		return null;
	}

}
