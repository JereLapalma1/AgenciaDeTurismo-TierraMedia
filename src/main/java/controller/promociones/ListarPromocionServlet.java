package controller.promociones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.PromocionServicio;

@WebServlet("/listar-promo.do")
public class ListarPromocionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -7746591559407022129L;
	private PromocionServicio promocionServicio;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionServicio = new PromocionServicio();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Promocion> promociones = null;
		try {
			promociones = promocionServicio.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("promociones", promociones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listar-promo.jsp");
		dispatcher.forward(req, resp);

	}
}
