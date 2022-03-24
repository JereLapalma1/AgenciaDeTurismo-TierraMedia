package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = -4819822600796550037L;
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (session == null) {
			RequestDispatcher dispatcher = getServletContext()
		  		      .getRequestDispatcher("/login.jsp");
		  		    dispatcher.forward(req, resp);
		}

    }
}
