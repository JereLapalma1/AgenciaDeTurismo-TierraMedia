package persistence.commons;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import model.Itinerario;
import model.Usuario;

public interface GenericDAO<T> {

	public int insert(T t) throws SQLException;
	
	public List<T> findAll() throws SQLException;

}
