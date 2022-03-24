package persistence;

import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoAtraccion;
import persistence.commons.GenericDAO;


public interface AtraccionDAO extends GenericDAO<Atraccion> {
	
		public Atraccion findOne(Integer id) throws SQLException;

		public abstract int deleteLogico(Integer id) throws SQLException;

		public int update(Atraccion atraccion) throws SQLException;

		
	}
