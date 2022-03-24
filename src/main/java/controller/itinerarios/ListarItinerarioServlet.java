package controller.itinerarios;

import java.io.IOException;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ofertable;
import model.Usuario;
import services.ItinerarioServicio;

@WebServlet("/listar-itinerario.do")
public class ListarItinerarioServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 3289163451632910661L;
	private ItinerarioServicio itinerarioServicio;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioServicio = new ItinerarioServicio();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Set<Ofertable> itinerarios = null;
		try {
			usuario.getOfertables().addAll(itinerarioServicio.listar(usuario.getNombre()));
			itinerarios = usuario.getOfertables();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("itinerarios", itinerarios);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listar-itinerario.jsp");
		dispatcher.forward(req, resp);

	}
}
