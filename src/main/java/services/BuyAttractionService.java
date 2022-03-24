package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Itinerario;
import model.Ofertable;
import model.Promocion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class BuyAttractionService {

	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();

	public Map<String, String> buy(Integer id, Integer idOfertable) throws SQLException {

		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = usuarioDAO.findOne(id);
		Ofertable ofertable = atraccionDAO.findOne(idOfertable);
		
		if (ofertable == null) {
			
			ofertable = promocionDAO.findOne(idOfertable);
		}
		
		if (!ofertable.puedeAlbergar(1)) {
			errors.put("ofertable", "No hay cupo disponible");
		}
		if (!user.puedeComprar(ofertable)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!user.puedeAsistir(ofertable)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.agregarAItinerario(ofertable);
			ofertable.albergar(1);

			if (ofertable.getClass() != Atraccion.class) {
				promocionDAO.update((Promocion)ofertable);
			} else {
				atraccionDAO.update((Atraccion)ofertable);
			}
			usuarioDAO.update(user);
			Itinerario itinerario = new Itinerario(user, ofertable);
			itinerarioDAO.insert(itinerario);
		}

		return errors;

	}

}