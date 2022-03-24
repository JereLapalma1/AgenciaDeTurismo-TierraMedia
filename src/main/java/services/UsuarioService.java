package services;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import model.Promocion;
import model.TipoAtraccion;
import model.Usuario;

import persistence.commons.DAOFactory;

public class UsuarioService {

	public List<Usuario> list() throws SQLException {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario crear(String nombre, Double presupuesto, Double tiempoDisponible, TipoAtraccion tipoFavorito,
			String password, Boolean admin) throws Exception {
		Usuario usuario = new Usuario(nombre, presupuesto, tiempoDisponible, tipoFavorito, password, admin);
		usuario.setPassword(password);

		if (usuario.esUsuarioValido(nombre, password, presupuesto, tiempoDisponible, tipoFavorito)) {
			DAOFactory.getUsuarioDAO().insert(usuario);

		}

		return usuario;
	}

	public void delete(Integer id) throws SQLException {
		DAOFactory.getUsuarioDAO().deleteLogico(id);
	}
	
	public Usuario buscar(Integer id) throws SQLException {
		return DAOFactory.getUsuarioDAO().findOne(id);
	}
	
	public void update(Usuario usuario) throws SQLException {
		DAOFactory.getUsuarioDAO().update(usuario);
	}

}
