package neu.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import neu.edu.dao.UserAccountDAO;
import neu.edu.entity.*;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	@Autowired
	UserAccountDAO userAccountDAO;

	@Autowired
	UserSessionTable userSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get the username and password entered by user on login page
		String userParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");

		//Check if entered userName is valid and is present in the database
		Users user = userAccountDAO.validateUser(userParam, passwordParam);
		//If user is valid
		if (user != null) {
			//Get the current session
			HttpSession session = request.getSession();

			//Get all the data related to particular user
			Users getUser = userAccountDAO.validateUser(userParam, passwordParam);
			AboutMeTable aboutMeAttribute = userAccountDAO.validateAboutMe(userParam);
			AddressTable cityAttribute = userAccountDAO.validateCity(userParam);
			EducationTable educationAttribute = userAccountDAO.validateEducation(userParam);
			ProjectTable projectAttribute = userAccountDAO.validateProject(userParam);
			SkillTable skillAttribute = userAccountDAO.validateSkill(userParam);

			if (getUser == null) {
			} else {
				getUser.setUserName(userParam);
				session.setAttribute("user1", getUser);
			}
			userSession.setUserName(userParam);
			userSession.setSessionIdvariable(session.getId());
			
			session.setAttribute("user", userSession);
			session.setAttribute("aboutMeAttribute", aboutMeAttribute);
			session.setAttribute("cityAttribute", cityAttribute);
			session.setAttribute("educationAttribute", educationAttribute);
			session.setAttribute("projectAttribute", projectAttribute);
			session.setAttribute("skillAttribute", skillAttribute);

			//Redirect to Dashboard
			request.getRequestDispatcher("/Dashboard").forward(request, response);
		} 
		//If user is not valid
		else if (user == null) {
			//If user is not found in database redirect to Error page
			request.getRequestDispatcher("ErrorUserNotFound.jsp").forward(request, response);
		}
	}
}