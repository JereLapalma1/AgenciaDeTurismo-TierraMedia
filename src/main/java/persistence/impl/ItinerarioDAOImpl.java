package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import model.Itinerario;
import model.Ofertable;
import model.Usuario;
import persistence.commons.ConnectionProvider;
import persistence.ItinerarioDAO;
import persistence.commons.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	private AtraccionDAOImpl atraccionDao;
	private PromocionDAOImpl promocionDao;
	private UsuarioDaoImpl usuarioDao;
	
	/*
	 * Busca el itinerario por nombre de usuario
	 */
	
	@Override
	public Set<Ofertable> findByNombre(String nombre) {
		try {
			String sql = "SELECT Itinerario.ID_Promocion, Itinerario.ID_Atraccion\r\n" + "FROM Itinerario\r\n"
					+ "INNER JOIN Usuario \r\n" + "ON usuario.ID_Usuario = Itinerario.ID_Usuario\r\n"
					+ "WHERE Usuario.Nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Set<Ofertable> itinerario = new LinkedHashSet<Ofertable>();
			atraccionDao = new AtraccionDAOImpl();
			promocionDao = new PromocionDAOImpl();
			esPromoOesAtraccion(resultados, itinerario);
			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	/*
	 * Busca y devuelve todos los itinerarios existentes
	 */
	
	@Override
	public List<Itinerario> findAll() throws SQLException {
		String sql = "SELECT * FROM Itinerario ORDER BY ID_Usuario";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		List<Itinerario> itinerarios = new LinkedList<Itinerario>();
		while (resultados.next()) {
			try { itinerarios.add(aItinerario(resultados));
			} catch (Exception e) {

				throw new MissingDataException(e);
			}
		} return itinerarios;
	}

	/*
	 * Usado por el metodo findAll()
	 * Instancia un objeto Itinerario a partir de la base de datos
	 */
	
	private Itinerario aItinerario(ResultSet resultados) throws SQLException {
		Integer idPromocion = resultados.getInt(1);
		Long id = resultados.getLong(2);
		usuarioDao = new UsuarioDaoImpl();
		atraccionDao = new AtraccionDAOImpl();
		promocionDao = new PromocionDAOImpl();
		Usuario usuario = this.usuarioDao.findOne(resultados.getInt(3));
		Integer idAtraccion = resultados.getInt(4);
		Ofertable ofertable;
		if (idPromocion > 0) {
			ofertable = this.promocionDao.findOne(idPromocion);
		} else {
			ofertable = this.atraccionDao.findOne(idAtraccion);
		}
		Itinerario itinerario = new Itinerario(id, usuario, ofertable);
		return itinerario;
	}

	/*
	 * Usado por el metodo findByNombre(String)
	 * Define si el ofertable de un itinerario es promocion o atraccion.
	 */
	private void esPromoOesAtraccion(ResultSet resultados, Set<Ofertable> itinerario) throws SQLException {
		while (resultados.next()) {
			Integer idPromocion = resultados.getInt(1);
			Integer idAtraccion = resultados.getInt(2);
			if (idPromocion > 0) {
				itinerario.add(promocionDao.findOne(idPromocion));
			} else {
				itinerario.add(atraccionDao.findOne(idAtraccion));
			}
		}
	}

	/*
	 * Actualiza un itinerario en la base de datos
	 */
	@Override
	public int update(int idAtraccion, int idPromocion, int idUsuario, int idItinerario) {
		try {
			String sql = "UPDATE Itinerario SET ID_Atraccion = ?, ID_Promocion = ?, ID_Usuario = ? \r\n"
					+ "WHERE ID_Itinerario = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idAtraccion);
			statement.setInt(2, idPromocion);
			statement.setInt(3, idUsuario);
			statement.setInt(4, idItinerario);
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	/*
	 * Inserta un itinerario en la base de datos
	 */

	@Override
	public int insert(Itinerario itinerario) throws SQLException {
		try {
			String sql = "INSERT INTO Itinerario (ID_Atraccion, ID_Usuario, ID_Promocion) VALUES ((SELECT ID_Atraccion FROM Atraccion WHERE Nombre = ?)\r\n"
					+ ",(SELECT ID_Usuario FROM Usuario WHERE Nombre = ?),(SELECT ID_Promocion FROM Promocion WHERE Nombre = ?))";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, itinerario.getOfertable().getNombre());
			statement.setString(2, itinerario.getUsuario().getNombre());
			statement.setString(3, itinerario.getOfertable().getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
