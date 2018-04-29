package neu.edu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.entity.AboutMeTable;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddressController() {
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
		HttpSession session = request.getSession(false);
		if (session == null) {
			//If session is null then user is redirected to Login Page
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		} else {
			//Get the action from the speific page
			String action = request.getParameter("action");
			if (action.matches("Next")) {
				//Get the AboutMeTable attribute stored in the session
				AboutMeTable aboutMeAttribute = (AboutMeTable) request.getSession().getAttribute("aboutMeAttribute");
				String aboutMe = request.getParameter("aboutMe");
				aboutMeAttribute.setAboutMe(aboutMe);
				//Replace this attribute with the value user entered
				request.getSession().setAttribute("aboutMeAttribute", aboutMeAttribute);
				//Redirect to Address page
				request.getRequestDispatcher("/Address.jsp").forward(request, response);
			}
			if (action.matches("Previous")) {
				request.getRequestDispatcher("/Address.jsp").forward(request, response);
			}
		}
	}
}
