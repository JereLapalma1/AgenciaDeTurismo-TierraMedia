package controller.usuarios;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Usuario;
import services.UsuarioService;


@WebServlet("/listar-usuario.do")
public class ListarUsuariosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private UsuarioService usuarioServicio;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioServicio = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioServicio.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("usuarios", usuarios);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listar-usuario.jsp");
		dispatcher.forward(req, resp);

}
	
	
	
}
