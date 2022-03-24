package controller.attractions;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/actualizar-atraccion.do")
public class BuscarAtraccionParaActualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 7156352618798976882L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actualizar-atraccion.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Atraccion atraccion = new Atraccion();
		try {
			atraccion = atraccionService.buscar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (atraccion != null) {
			req.getSession().setAttribute("atraccionAEditar", atraccion);
			req.getSession().setAttribute("tipoDeAtraccion", model.TipoAtraccion.values());
			resp.sendRedirect("actualizar-atraccion-form.jsp");    		
       	} else {
    		req.setAttribute("flash", "No existe atracción con esa ID");
    		
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/actualizar-atraccion.jsp");
      		    dispatcher.forward(req, resp);
    	}
	}

}
