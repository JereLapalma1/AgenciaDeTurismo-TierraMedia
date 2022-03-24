package controller.usuarios;

import java.io.IOException;

import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoAtraccion;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/insertar-usuario.do")
public class CrearUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/insertar-usuario.jsp");
		dispatcher.forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
	
		String password = req.getParameter("password");
	
		double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
	
		double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
	
		TipoAtraccion tipoFavorito = TipoAtraccion.valueOf(req.getParameter("tipoDeAtraccion"));//aca solo se me ocurre parsearlo como String, pero habria que reformatear el metodo de creacion

		
		boolean admin = false;
		
		Usuario usuario_2 = new Usuario();
		try {
			
			usuario_2 = usuarioService.crear(nombre, presupuesto, tiempoDisponible, tipoFavorito, password, admin);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		if (usuario_2.esUsuarioValido(nombre, password, presupuesto, tiempoDisponible, tipoFavorito)) {
			resp.sendRedirect("/turismoHDR/listar-usuario.do");
		} else {
			req.setAttribute("usuario", usuario_2);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/insertar-usuario.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
