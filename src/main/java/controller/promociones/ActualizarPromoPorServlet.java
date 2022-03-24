package controller.promociones;

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
import model.Promocion;
import model.PromocionPorcentual;
import model.TipoAtraccion;
import services.AtraccionService;
import services.PromocionServicio;

@WebServlet("/actualizar-promopor-form.do")
public class ActualizarPromoPorServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1922615337381411309L;
	private PromocionServicio promoService;
	private AtraccionService atraccionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promoService = new PromocionServicio();
		this.atraccionService = new AtraccionService();
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Promocion promoAEditar = (Promocion) req.getSession().getAttribute("promoAEditar");
		Integer id = promoAEditar.getId();
		String nombre = req.getParameter("nombre");
		TipoAtraccion tipo = TipoAtraccion.valueOf(req.getParameter("tipoDeAtracciones"));
		int descuento = Integer.parseInt(req.getParameter("descuento"));
		Integer idAtraccion1 = Integer.parseInt(req.getParameter("idAtraccion1"));
		Integer idAtraccion2 = Integer.parseInt(req.getParameter("idAtraccion2"));
		
		Atraccion[] pack = new Atraccion[2];
		try {
			pack[0] = atraccionService.buscar(idAtraccion1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pack[1] = atraccionService.buscar(idAtraccion2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		PromocionPorcentual promocion = new PromocionPorcentual(id, nombre, pack, tipo, descuento);
		try {
			promoService.actualizar(promocion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (promocion.esValida(nombre, pack, tipo, descuento)) {
			resp.sendRedirect("/turismoHDR/listar-promo.do");
		} else {
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/actualizar-promo");
			dispatcher.forward(req, resp);
		}
		
	}
}
