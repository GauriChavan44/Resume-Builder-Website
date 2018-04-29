package neu.edu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayResumeController
 */
@WebServlet("/DisplayResumeController")
public class DisplayResumeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayResumeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//User is redirected to Login page if he logs out or session times out
		HttpSession session1 = request.getSession(false);
		if (session1 == null) {
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			request.getSession().invalidate();
		} else {
			request.getRequestDispatcher("/Dashboard").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//User is redirected to Login page if he logs out or session times out else he is redirected to DisplayResume jsp
		HttpSession session = request.getSession(false);
		if (session == null) {
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/DisplayResumejsp.jsp").forward(request, response);
		}
	}
}
