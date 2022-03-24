package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;
import model.PromocionAbsoluta;

import persistence.PromocionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import model.Atraccion;
import model.Promocion;


public class PromocionDAOImpl implements PromocionDAO {

	private AtraccionDAOImpl atraccionDao;

	public PromocionDAOImpl() {
		this.atraccionDao = new AtraccionDAOImpl();
	}
	
	/*
	 * Inserta una promocion nueva en la base de datos
	 */
	@Override
	public int insert(Promocion promocion) throws SQLException {
		String sql = "INSERT INTO Promocion  ( ID_Atraccion1, ID_Atraccion2, nombre ,Tipo,monto,Tiempo,AtraccionGratis,Descuento,PromocionTipo) VALUES "
				+ "((SELECT ID_Atraccion FROM Atraccion WHERE Nombre = ?),(SELECT ID_Atraccion FROM Atraccion WHERE Nombre = ?),?,?,?,?,(SELECT ID_Atraccion FROM Atraccion WHERE Nombre = ?),?,?)";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setObject(1, promocion.getPackAtracciones()[0].getNombre());//
		statement.setObject(2, promocion.getPackAtracciones()[1].getNombre());//

		statement.setString(3, promocion.getNombre());
		statement.setObject(4, promocion.getTipo());
		statement.setDouble(6, promocion.getTiempo());

		if (promocion.getClass().getSimpleName().equals(PromocionAxB.class.getSimpleName())) {
			statement.setObject(7, ((PromocionAxB) promocion).getAtraccionGratis().getNombre());
			statement.setString(9, "AxB");
		}
		
		if (promocion.getClass().getSimpleName().equals(PromocionPorcentual.class.getSimpleName())) {
			statement.setObject(8, ((PromocionPorcentual) promocion).getDescuento());
			statement.setString(9, "PORCENTUAL");
		}
		
		if (promocion.getClass().getSimpleName().equals(PromocionAbsoluta.class.getSimpleName())) {
			statement.setDouble(5, ((PromocionAbsoluta)promocion).getMonto());
			statement.setString(9, "ABSOLUTA");
		}

		int rows = statement.executeUpdate();

		return rows;

	}

	/*
	 * Busca una promocion por su id y la actualiza en la base de datos
	 */
	@Override
	public int update(Promocion promocion) throws SQLException {
		String sql = "UPDATE Promocion SET ID_Atraccion1 = ?, ID_Atraccion2 = ?,"
				+ "Nombre = ?, Tipo = ?, Monto = ?, AtraccionGratis = ?,"
				+ "Descuento = ?  WHERE ID_Promocion  = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, promocion.getPackAtracciones1().getId());
		statement.setInt(2, promocion.getPackAtracciones2().getId());
		statement.setString(3, promocion.getNombre());
		statement.setObject(4, promocion.getTipo());
		statement.setDouble(5, promocion.getMonto());
		statement.setObject(6, promocion.getAtraccionGratis().getId());
		statement.setInt(7, promocion.getDescuento());
		statement.setInt(8, promocion.getId());
		int rows = statement.executeUpdate();

		return rows;

	}

	/*
	 * Pasa los datos para la creacion de una promocion
	 */
	private Promocion toPromo(ResultSet resultados) throws Exception {

		Integer id = resultados.getInt(1);
		TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(resultados.getString(5));
		Atraccion[] packAtracciones = atraccionesDeLaPromocion(resultados.getLong(2), resultados.getLong(3));
		String nombre = resultados.getString(4);
		String promocionTipo = resultados.getString(10);
		Promocion promo = null;
		promo = creacionPromo(resultados, id, tipoAtraccion, packAtracciones, nombre, promocionTipo, promo);
		return promo;

	}

	/*
	 * Usando los datos pasados por toPromo, instancia algun tipo de promocion
	 */
	private Promocion creacionPromo(ResultSet resultados, Integer id, TipoAtraccion tipoAtraccion, Atraccion[] packAtracciones,
			String nombre, String promocionTipo, Promocion promo) throws SQLException {
		if (promocionTipo.equals("AxB")) {
			Atraccion gratis = atraccionDao.findOne(resultados.getInt(8));
			promo = new PromocionAxB(id, nombre, packAtracciones, tipoAtraccion, gratis);
		} else if (promocionTipo.equals("PORCENTUAL")) {
			int descuento = resultados.getInt(9);
			promo = new PromocionPorcentual(id, nombre, packAtracciones, tipoAtraccion, descuento);
		} else if (promocionTipo.equals("ABSOLUTA")) {
			double monto = resultados.getInt(6);
			promo = new PromocionAbsoluta(id, nombre, packAtracciones, tipoAtraccion, monto);
		}
		return promo;
	}

	/*
	 * Carga las atracciones de la promocion
	 */
	private Atraccion[] atraccionesDeLaPromocion(Long atraccion1, Long atraccion2) throws Exception {
		Atraccion[] packs = new Atraccion[2];
		try {

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlAtraccion());
			statement.setLong(1, atraccion1);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				packs[0] = atraccionDao.toAtraccion(result);
			}
			statement.setLong(1, atraccion2);
			ResultSet result2 = statement.executeQuery();
			while (result2.next()) {
				packs[1] = atraccionDao.toAtraccion(result2);
			}
			return packs;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	/*
	 * sql utilizado en el metodo atraccionesDeLaPromocion
	 */
	private String sqlAtraccion() {
		String sql = "select *" + "from Atraccion WHERE ID_Atraccion = ?";
		return sql;
	}

	/*
	 * Busca y devuelve todas las promociones de la base de datos
	 */
	@Override
	public List<Promocion> findAll() throws SQLException {

		String sql = "SELECT * FROM Promocion WHERE Estado <> 0";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<Promocion> promo = new LinkedList<Promocion>();
		while (resultados.next()) {
			try {
				promo.add(toPromo(resultados));
			} catch (Exception e) {

				throw new MissingDataException(e);
			}
		}
		return promo;
	}

	/*
	 * Busca una promocion por su id y realiza un borrado logico:
	 * Settea la propiedad Estado en cero
	 */
	@Override
	public int deleteLogico(Integer id) throws SQLException {
		try {
			String sql = "UPDATE Promocion SET Estado = ? WHERE ID_Promocion = ?";
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
	 * Busca una promocion por su id y la retorna
	 */
	@Override
	public Promocion findOne(Integer id) throws SQLException {
		try {
			String sql = "SELECT * FROM Promocion WHERE ID_Promocion=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;

			while (resultados.next()) {
				promocion = toPromo(resultados);
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
