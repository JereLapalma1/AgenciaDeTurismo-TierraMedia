package persistence.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import persistence.commons.ConnectionProvider;

import persistence.commons.MissingDataException;
import persistence.AtraccionDAO;
import model.Atraccion;
import model.TipoAtraccion;

public class AtraccionDAOImpl implements AtraccionDAO {

	/*
	 * Busca y devuelve todas las atracciones de la base de datos
	 */
	@Override
	public List<Atraccion> findAll() throws SQLException {
		try {
			String sql = "SELECT Atraccion.ID_Atraccion, Atraccion.Nombre, Atraccion.Costo, Atraccion.Tiempo, Atraccion.Cupo_Disponible, TipoAtraccion.id_tipoAtraccion, Atraccion.Imagen\r\n"
					+ "FROM Atraccion INNER JOIN TipoAtraccion\r\n"
					+ "ON Atraccion.TipoDeAtraccion = TipoAtraccion.id_tipoAtraccion\r\n"
					+ "WHERE Atraccion.Estado <> 0";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
			while (resultados.next()) {
				atracciones.add(toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	/*
	 * Instancia un objeto atraccion a partir de la base de datos
	 */
	public Atraccion toAtraccion(ResultSet resultados) throws Exception {

		Integer id = resultados.getInt(1);
		String nombre = resultados.getString(2);
		double costo = resultados.getDouble(3);
		double tiempo = resultados.getDouble(4);
		int cupoDisponible = resultados.getInt(5);
		TipoAtraccion tipo = TipoAtraccion.valueOf(resultados.getString(6).toUpperCase());
		InputStream imagen = resultados.getBinaryStream(7);

		return new Atraccion(id, nombre, costo, tiempo, cupoDisponible, tipo, imagen);

	}	
	
	/*
	 * Busca una atraccion por su id y la actualiza en la base de datos
	 */
	@Override
	public int update(Atraccion atraccion) throws SQLException {
		try {
			String sql = "UPDATE Atraccion SET Nombre = ?, Costo = ?, Tiempo = ?, Cupo_Disponible = ?, TipoDeAtraccion = ? WHERE ID_Atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setDouble(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getTiempo());
			statement.setInt(4, atraccion.getCupoDisponible());
			statement.setObject(5, atraccion.getTipoAtraccion());
			statement.setInt(6, atraccion.getId());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Atraccion atraccion) throws SQLException {
		String sql = "INSERT INTO ATRACCION (NOMBRE, COSTO, TIEMPO, CUPO_DISPONIBLE, TIPODEATRACCION) VALUES (?,?,?,?,?)";

		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setString(1, atraccion.getNombre());
		statement.setDouble(2, atraccion.getCosto());
		statement.setDouble(3, atraccion.getTiempo());
		statement.setInt(4, atraccion.getCupoDisponible());
		statement.setObject(5, atraccion.getTipoAtraccion());

		int rows = statement.executeUpdate();

		return rows;
	}

	/*
	 * Actualiza Estado de atraccion en la base de datos para borrado lógico
	 */
	@Override
	public int deleteLogico(Integer id) throws SQLException {
		try {
			String sql = "UPDATE Atraccion SET Estado = ? WHERE ID_Atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, 0);
			statement.setInt(2, id);

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	/*
	 * Busca una atraccion por id y retorna esa atraccion
	 */
	@Override
	public Atraccion findOne(Integer id) throws SQLException {
		try {
			String sql = "SELECT Atraccion.ID_Atraccion, Atraccion.Nombre,Atraccion.Costo ,"
					+ " Atraccion.Tiempo, Atraccion.Cupo_Disponible," + "  Atraccion.TipoDeAtraccion"
					+ " FROM Atraccion" + " WHERE Atraccion.Id_Atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Atraccion atraccion = new Atraccion();

			if (resultados.next()) {
				atraccion = toAtraccion(resultados);
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	

}
