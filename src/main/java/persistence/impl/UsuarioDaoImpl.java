package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TipoAtraccion;
import model.Usuario;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import persistence.UsuarioDAO;

public class UsuarioDaoImpl implements UsuarioDAO {

	/*
	 * Busca y devuelve todos los usuarios de la base de datos
	 */
	@Override
	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM USUARIO WHERE Estado <> 0";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUser(resultados));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	/*
	 * Inserta un usuario nuevo en la base de datos
	 */
	@Override
	public int insert(Usuario usuario) throws SQLException {
		try {
			String sql = "INSERT INTO USUARIO (NOMBRE, PRESUPUESTO,TIEMPODISPONIBLE,"
					+ "TIPOFAVORITO, PASSWORD) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setDouble(2, usuario.getPresupuesto());
			statement.setDouble(3, usuario.getTiempoDisponible());
			statement.setObject(4, usuario.getTipoFavorito());
			statement.setString(5, usuario.getPassword());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	/*
	 * Actualiza el presupuesto y tiempoDisponible de un usuario en la base de datos
	 */
	@Override
	public int update(Usuario usuario) throws SQLException {
		String sql = "UPDATE USUARIO SET NOMBRE = ?, PRESUPUESTO = ?, TIEMPODISPONIBLE = ?,"
				+ "TipoFavorito = ?, Admin = ?  WHERE ID_Usuario = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		statement.setDouble(2, usuario.getPresupuesto());
		statement.setDouble(3, usuario.getTiempoDisponible());
		statement.setObject(4, usuario.getTipoFavorito());
		statement.setBoolean(5, usuario.getAdmin());
		statement.setInt(6, usuario.getId());
		int rows = statement.executeUpdate();

		return rows;

	}

	/*
	 * Usado por el Servicio de Login
	 * Busca por nombre a un usuario en la base de datos y lo devuelve
	 */
	@Override
	public Usuario findByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM USUARIO WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = null;

			if (resultados.next()) {
				usuario = toUser(resultados);
			}
			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	/*
	 * Instancia un Usuario a partir de la base de datos
	 */
	private Usuario toUser(ResultSet resultados) throws Exception {
		Integer id = resultados.getInt(1);
		String nombre = resultados.getString(2);
		Double presupuesto = resultados.getDouble(3);
		Double tiempoDisponible = resultados.getDouble(4);
		TipoAtraccion tipoFavorito = TipoAtraccion.valueOf(resultados.getString(5));
		String password = resultados.getString(6);
		Boolean admin = resultados.getBoolean(7);
		return new Usuario(id, nombre, presupuesto, tiempoDisponible, tipoFavorito, password, admin);
	}

	/*
	 * Busca un usuario en la base de datos por su id y realiza borrado logico:
	 * Settea la propiedad Estado en cero
	 */
	@Override
	public int deleteLogico(Integer id) throws SQLException {
		try {
			String sql = "UPDATE Usuario SET Estado = ? WHERE ID_Usuario = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, 0);
			statement.setLong(2, id);

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	/*
	 * Busca un usuario en la base de datos por su id y lo retorna
	 */
	@Override
	public Usuario findOne(Integer id) throws SQLException {
		try {
			String sql = "SELECT * FROM USUARIO WHERE ID_Usuario = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = new Usuario();

			if (resultados.next()) {
				usuario = toUser(resultados);
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
