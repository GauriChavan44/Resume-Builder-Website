package neu.edu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AboutMeSevlet
 */
@WebServlet("/AboutMeController")
public class AboutMeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AboutMeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//User is redirected to Login page if he logs out or session times out
		HttpSession session = request.getSession(false);
		if (session == null) {
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/AboutMe.jsp").forward(request, response);
		}
	}
}
