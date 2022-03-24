package controller.itinerarios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerario;
import services.ItinerarioServicio;

@WebServlet("/listar-itinerarios.do")
public class ListarItinerariosServlet extends HttpServlet {
	private static final long serialVersionUID = 844974523735038850L;
	private ItinerarioServicio itinerarioServicio;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioServicio = new ItinerarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Itinerario> itinerarios = new ArrayList<Itinerario>();
		try {
			itinerarios = itinerarioServicio.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		req.setAttribute("itinerarios", itinerarios);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listar-itinerarios.jsp");
		dispatcher.forward(req, resp);
		

	}

}
