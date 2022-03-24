package controller.attractions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.BuyAttractionService;

@WebServlet("/comprar.do")
public class BuyAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private BuyAttractionService buyAttractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.buyAttractionService = new BuyAttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idOfertable = Integer.parseInt(req.getParameter("id"));
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Map<String, String> errors = new HashMap<String, String>();
		try {
			errors = buyAttractionService.buy(usuario.getId(), idOfertable);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Usuario usuario2 = new Usuario();
		try {
			usuario2 = DAOFactory.getUsuarioDAO().findOne(usuario.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getSession().setAttribute("usuario", usuario2);
		
		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/listar-ofertador.do");
		dispatcher.forward(req, resp);
		
	}
	
}
