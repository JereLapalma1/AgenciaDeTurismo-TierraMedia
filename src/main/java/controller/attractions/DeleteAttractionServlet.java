package controller.attractions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.commons.MissingDataException;
import services.AtraccionService;

@WebServlet("/borrar-atraccion.do")
public class DeleteAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = -4562462717346197435L;
	private AtraccionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AtraccionService();
	}

	/*
	 * Muestra el formulario para borrar atraccion
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/borrar-atraccion.jsp");
		dispatcher.forward(req, resp);
	}
	
	/*
	 * Toma el id pasado por el usuario para borrar la atraccion correspondiente
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		try {
			attractionService.delete(id);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

		resp.sendRedirect("/turismoHDR/listar-atraccion.do");
	}
}
