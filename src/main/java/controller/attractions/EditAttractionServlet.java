package controller.attractions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoAtraccion;
import services.AtraccionService;

@WebServlet("/actualizar-atraccion-form.do")
public class EditAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Atraccion atraccionEditar = (Atraccion) req.getSession().getAttribute("atraccionAEditar");
		Integer id = atraccionEditar.getId();
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		int cupoDisponible = Integer.parseInt(req.getParameter("cupoDisponible"));
		TipoAtraccion tipo = TipoAtraccion.valueOf(req.getParameter("tipo"));
		
		Atraccion atraccion = new Atraccion();
		try {
			atraccion = new Atraccion(id, nombre, costo, tiempo, cupoDisponible, tipo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			atraccionService.update(atraccion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (atraccion.esValidoFull(nombre, costo, tiempo, cupoDisponible, tipo)) {
			resp.sendRedirect("/turismoHDR/listar-atraccion.do");
		} else {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actualizar-atraccion-form.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
}
