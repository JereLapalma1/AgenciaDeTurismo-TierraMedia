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
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import persistence.commons.MissingDataException;
import services.PromocionServicio;

@WebServlet("/actualizar-promo.do")
public class BuscarPromocionParaActualizarServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 8536444325033506081L;
	private PromocionServicio promoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promoService = new PromocionServicio();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actualizar-promo.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Promocion promo = null;
		try {			
			promo = promoService.buscar(id);			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		if (promo != null) {
			req.getSession().setAttribute("promoAEditar", promo);
			req.getSession().setAttribute("tipoDeAtraccion", model.TipoAtraccion.values());
			if (promo instanceof PromocionAbsoluta) {
				resp.sendRedirect("actualizar-promoabs-form.jsp");  
			}
			if (promo instanceof PromocionPorcentual) {
				resp.sendRedirect("actualizar-promopor-form.jsp");  
				
			} 
			if (promo instanceof PromocionAxB){
				resp.sendRedirect("actualizar-promoaxb-form.jsp");  
			}
			  	
		} else {
    		req.setAttribute("flash", "No existe promoción con esa ID");
    		
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/actualizar-promo.jsp");
      		    dispatcher.forward(req, resp);
    	}
	}

}
