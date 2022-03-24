package controller.ofertables;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.OfertaSegunPreferencia;
import model.Ofertable;
import model.Promocion;
import model.Usuario;
import services.AtraccionService;
import services.PromocionServicio;

@WebServlet("/listar-ofertador.do")
public class ListarOfertablesServlet extends HttpServlet {
	private static final long serialVersionUID = 5891454500032445943L;
	private AtraccionService atraccionService;
	private PromocionServicio promocionServicio;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.promocionServicio = new PromocionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Atraccion> atracciones = null;
		try {
			atracciones = atraccionService.list();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Promocion> promociones = null;
		try {
			promociones = promocionServicio.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Usuario usuario = (Usuario)req.getSession().getAttribute("usuario");
		
		Set<Ofertable> ofertables = new TreeSet<Ofertable>(new OfertaSegunPreferencia(usuario.getTipoFavorito()));
		ofertables.addAll(promociones);
		ofertables.addAll(atracciones);

		req.setAttribute("ofertables", ofertables);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listar-ofertador.jsp");
		dispatcher.forward(req, resp);
		

	}

}
