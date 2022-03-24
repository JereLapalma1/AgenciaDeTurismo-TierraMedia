package services;

import model.Usuario;
import model.nullobjects.NullUser;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class LoginService {

	public Usuario login(String nombre, String password) throws Exception {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
    	Usuario usuario = usuarioDao.findByNombre(nombre);
    	
    	if (usuario.isNull() || !usuario.checkPassword(password)) {
    		usuario = NullUser.build();
    	}
    	return usuario;
	}
	
}
