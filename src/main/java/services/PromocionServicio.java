package services;

import java.sql.SQLException;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;
import persistence.commons.DAOFactory;

public class PromocionServicio {

	/*
	 * Servicio usado por ListarPromocionServlet
	 */
	public List<Promocion> listar() throws Exception {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public void delete(Integer id) throws SQLException {
		DAOFactory.getPromocionDAO().deleteLogico(id);
	}

	public Promocion buscar(Integer id) throws SQLException {
		return DAOFactory.getPromocionDAO().findOne(id);
	}

	public void actualizar(Promocion promo) throws SQLException {
		DAOFactory.getPromocionDAO().update(promo);

	}
	
	public PromocionPorcentual crearPorcentual(String nombre, Atraccion[] packAtracciones,
			TipoAtraccion tipo, int descuento) throws Exception {
		
		PromocionPorcentual promoP = new PromocionPorcentual(nombre,
				packAtracciones, tipo, descuento);
		if (promoP.esValida(nombre, packAtracciones, tipo, descuento)) {
			DAOFactory.getPromocionDAO().insert(promoP);
		}
				
		return promoP;
		
	}

	public PromocionAxB crearAxB(String nombre, Atraccion[] pack, TipoAtraccion 
			tipoDeAtracciones, Atraccion gratis) throws Exception {
		
		PromocionAxB promoAxB = new PromocionAxB(nombre, pack, tipoDeAtracciones,
				gratis);
		if (promoAxB.esValida(nombre, pack, tipoDeAtracciones, gratis)) {
			DAOFactory.getPromocionDAO().insert(promoAxB);
		}
		
		return promoAxB;
	}

	public PromocionAbsoluta crearAbsoluta(String nombre, Atraccion[] pack, TipoAtraccion tipo, Double monto) throws Exception {
		
		PromocionAbsoluta promoAbsoluta = new PromocionAbsoluta(nombre, pack, tipo, monto);
		if (promoAbsoluta.esValida(nombre, pack, tipo, monto)) {
			DAOFactory.getPromocionDAO().insert(promoAbsoluta);
		}
		return promoAbsoluta;
	}

}
