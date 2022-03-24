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
import model.Usuario;
import services.UsuarioService;

@WebServlet("/actualizar-usuario.do")
public class BuscarUsuarioParaActualizarServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1514416506442129436L;
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actualizar-usuario.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioService.buscar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (usuario != null) {
			req.getSession().setAttribute("usuarioAEditar", usuario);
			req.getSession().setAttribute("tipoDeAtraccion", model.TipoAtraccion.values());
			resp.sendRedirect("actualizar-usuario-form.jsp");    		
       	} else {
    		req.setAttribute("flash", "No existe usuario con ese ID");
    		
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/actualizar-usuario.jsp");
      		    dispatcher.forward(req, resp);
    	}
	}

}
