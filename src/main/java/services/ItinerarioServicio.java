package services;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import model.Itinerario;
import model.Ofertable;
import persistence.commons.DAOFactory;

public class ItinerarioServicio {
	/*
	 * Servicio usado por ListarPromocionServlet
	 */
	public Set<Ofertable> listar(String nombre) throws Exception {
		return DAOFactory.getItinerarioDAO().findByNombre(nombre);
	}

	public List<Itinerario> listarTodos() throws SQLException {
		return DAOFactory.getItinerarioDAO().findAll();
	}
}
