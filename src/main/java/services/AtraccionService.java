package services;

import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoAtraccion;
//import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;
import persistence.impl.AtraccionDAOImpl;

public class AtraccionService {

	/*
	 * Servicio usado por ListAttractionsServlet
	 */
	
	public List<Atraccion> list() throws SQLException {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	/*
	 * Servicio usado por CreateAttractionServlet
	 */

	public Atraccion crear(String name, Double cost, Double duration, Integer capacity, TipoAtraccion tipoDeAtraccion)
			throws Exception {

		Atraccion atraccion = new Atraccion(name, cost, duration, capacity, tipoDeAtraccion);

		if (atraccion.esValidoFull(name, cost, duration, capacity, tipoDeAtraccion)) {
			DAOFactory.getAtraccionDAO().insert(atraccion);
		}

		return atraccion;
	}

	/*
	 * Servicio usado por EditAttractionServlet
	 */

	public void update(Atraccion atraccion) throws SQLException {
		DAOFactory.getAtraccionDAO().update(atraccion);
	}
	
	/*
	 * Servicio usado por DeleteAttractionServlet
	 */

	public void delete(Integer id) throws SQLException {
		DAOFactory.getAtraccionDAO().deleteLogico(id);
	}
	
	/*
	 * Servicio usado por BuscarAtraccionParaActualizarServlet
	 */

	public Atraccion buscar(Integer id) throws SQLException {
		return DAOFactory.getAtraccionDAO().findOne(id);
	}
	
	
	public void listarImagen(Integer id,HttpServletResponse response) {
		 DAOFactory.getAtraccionDAO().listarImg(id, response);
	}
	
	

}
