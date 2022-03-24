package model;

import java.io.InputStream;
import java.sql.SQLException;

public interface Ofertable {
	
	/*
	 * Devuelve el id
	 */
	public Integer getId();
	
	/*
	 * devuelve el costo
	 */
	public Double getMonto();

	/*
	 * devuelve el tiempo
	 */
	public Double getTiempo();

	/*
	 * devuelve el tipo
	 */
	public TipoAtraccion getTipo();

	/*
	 * pregunta si hay cupo disponible
	 */
	public boolean hayCupo();

	/*
	 * si hay cupo , resta un cupo disponible en las atracciones involucradas.
	 */
	public void reservarCupo() throws SQLException;
	
	/*
	 * devuelve el nombre del ofertable.
	 */
	public String getNombre();
	
	/*
	 * Los siguientes getters son necesarios para mostrar en el ofertador los
	 * atributos prioritarios de las promociones
	 */
	
	public Atraccion[] getPackAtracciones();
	public Atraccion getPackAtracciones1();
	public Atraccion getPackAtracciones2();
	public Atraccion getAtraccionGratis();
	public int getDescuento();
	
	/*
	 * El siguiente método es necesario para saber si se puede comprar ofertables
	 */
	public boolean puedeAlbergar(int i);
	public void albergar(int i);

	/*
	 * Metodo que devuelve la url de la imagen respectiva del ofetador
	 * */
	public InputStream getImagen();
	
	
	
}
