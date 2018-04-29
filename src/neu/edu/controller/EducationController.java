package neu.edu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.entity.*;

/**
 * Servlet implementation class EducationServlet
 */
@WebServlet("/EducationController")
public class EducationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EducationController() {
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
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		} else {
			String action = request.getParameter("action");
			if (action.matches("Next")) {
				//Get the AddressTable attribute from session
				AddressTable cityAttribute = (AddressTable) request.getSession().getAttribute("cityAttribute");

				//Get the inputs provided by the user
				String street = request.getParameter("street");
				String country = request.getParameter("country");
				String state = request.getParameter("state");
				String city = request.getParameter("city");
				String zipcode = request.getParameter("zipcode");

				//Set this user provided input to the session attribute
				cityAttribute.setStreet(street);
				cityAttribute.setCountry(country);
				cityAttribute.setState(state);
				cityAttribute.setCity(city);
				cityAttribute.setZipcode(zipcode);

				request.getSession().setAttribute("cityAttribute", cityAttribute);
				//Redirect to Education jsp
				request.getRequestDispatcher("/Education.jsp").forward(request, response);
			}
			//If user clicks previous button redirect to Education jsp
			if (action.matches("Previous")) {
				request.getRequestDispatcher("/Education.jsp").forward(request, response);
			}
		}
	}
}
