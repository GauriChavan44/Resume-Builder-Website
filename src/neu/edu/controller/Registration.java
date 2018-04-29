package neu.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import neu.edu.entity.*;
import neu.edu.dao.UserAccountDAO;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public Registration() {
		super();
	}

	@Autowired
	UserAccountDAO userAccountDAO;

	@Autowired
	Users user;

	@Autowired
	UserSessionTable sessionAttribute;

	@Autowired
	AboutMeTable aboutMeAttribute;

	@Autowired
	AddressTable cityAttribute;

	@Autowired
	EducationTable educationAttribute;

	@Autowired
	ProjectTable projectAttribute;

	@Autowired
	SkillTable skillAttribute;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.matches("Registration") || action.matches("Previous")) {
			request.getRequestDispatcher("/Registration.jsp").forward(request, response);
		} else if (action.matches("Register")) {

			//Get the input provided by user on Registration page and store it in variables
			String userName = request.getParameter("userName");
			String userNameUpper = userName.toUpperCase();
			String fullName = request.getParameter("fullName1");
			String emailId = request.getParameter("emailAddress");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");

			//Check if the Username already exists in the database
			Boolean userExist = userAccountDAO.checkIfUserNamePresent(userNameUpper);
			//If user does not exist then create a new user
			if (userExist == false) {
				//Assign the user the values provided by user
				user.setUserName(userName);
				user.setName(fullName);
				user.setEmailId(emailId);
				user.setPassword(password);
				user.setGender(gender);
				user.setAge(Integer.parseInt(age));
				request.getSession().setAttribute("user", user);
				userAccountDAO.createUser(user);
				
				//Set the username in all the tables in database as username is used to uniquely identify a user
				sessionAttribute.setUserName(userName);
				request.getSession().setAttribute("sessionAttribute", sessionAttribute);
				userAccountDAO.createSession(sessionAttribute);

				aboutMeAttribute.setUserName(userName);
				request.getSession().setAttribute("aboutMeAttribute", aboutMeAttribute);
				userAccountDAO.createAboutMe(aboutMeAttribute);

				cityAttribute.setUserName(userName);
				request.getSession().setAttribute("cityAttribute", cityAttribute);
				userAccountDAO.createCity(cityAttribute);

				educationAttribute.setUserName(userName);
				request.getSession().setAttribute("educationAttribute", educationAttribute);
				userAccountDAO.createEducation(educationAttribute);

				projectAttribute.setUserName(userName);
				request.getSession().setAttribute("projectAttribute", projectAttribute);
				userAccountDAO.createProject(projectAttribute);

				skillAttribute.setUserName(userName);
				request.getSession().setAttribute("skillAttribute", skillAttribute);
				userAccountDAO.createSkill(skillAttribute);

				request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			} 
			//If the entered username already exists then redirect to Error page
			else {
				request.getRequestDispatcher("/ErrorUserNameExist.jsp").forward(request, response);
			}
		}
	}
}