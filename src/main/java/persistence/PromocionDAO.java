package persistence;
import java.sql.SQLException;
import java.util.List;

import model.Promocion;
import persistence.commons.GenericDAO;

public interface PromocionDAO extends GenericDAO<Promocion> {
	
	public Promocion findOne(Integer id) throws SQLException;
	
	public int update(Promocion promocion) throws SQLException;

	public int deleteLogico(Integer id)throws SQLException;
	
}
