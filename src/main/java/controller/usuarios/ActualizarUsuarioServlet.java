package controller.usuarios;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoAtraccion;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/actualizar-usuario-form.do")
public class ActualizarUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7177079145051436170L;
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuarioAEditar = (Usuario) req.getSession().getAttribute("usuarioAEditar");
		Integer id = usuarioAEditar.getId();
		String password = usuarioAEditar.getPassword();
		String nombre = req.getParameter("nombre");
		Double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		TipoAtraccion tipo = TipoAtraccion.valueOf(req.getParameter("tipo"));
		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
		
		Usuario usuario = new Usuario();
		try {
			usuario = new Usuario(id, nombre, presupuesto, tiempo, tipo, password, admin);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			usuarioService.update(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (usuario.esValidoFull(nombre, presupuesto, tiempo, tipo, admin)) {
			resp.sendRedirect("/turismoHDR/listar-usuario.do");
		} else {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actualizar-usuario-form.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
