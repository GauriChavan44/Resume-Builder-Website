package neu.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import neu.edu.entity.*;
import neu.edu.dao.UserAccountDAO;

/**
 * Servlet implementation class InfoSubmitController
 */
@WebServlet("/InfoSubmitController")
public class InfoSubmitController extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public InfoSubmitController() {
		super();
	}

	@Autowired
	UserAccountDAO userAccountDAO;

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
		//Get the SkillTable attribute from the session
		SkillTable skillAttribute = (SkillTable) request.getSession().getAttribute("skillAttribute");

		//Get the values entered by user
		String skill1 = request.getParameter("skill1");
		String skill1Rating = request.getParameter("skill1Rating");
		if (!skill1Rating.isEmpty()) {
			int skill1RatingInt = Integer.parseInt(skill1Rating);
			skillAttribute.setSkill1rating(skill1RatingInt);
		}

		String skill2 = request.getParameter("skill2");
		String skill2Rating = request.getParameter("skill2Rating");
		if (!skill2Rating.isEmpty()) {
			int skill2RatingInt = Integer.parseInt(skill2Rating);
			skillAttribute.setSkill2rating(skill2RatingInt);
		}

		String skill3 = request.getParameter("skill3");
		String skill3Rating = request.getParameter("skill3Rating");
		if (!skill3Rating.isEmpty()) {
			int skill3RatingInt = Integer.parseInt(skill3Rating);
			skillAttribute.setSkill3rating(skill3RatingInt);
		}

		String skill4 = request.getParameter("skill4");
		String skill4Rating = request.getParameter("skill4Rating");
		if (!skill4Rating.isEmpty()) {
			int skill4RatingInt = Integer.parseInt(skill4Rating);
			skillAttribute.setSkill4rating(skill4RatingInt);
		}

		String skill5 = request.getParameter("skill5");
		String skill5Rating = request.getParameter("skill5Rating");
		if (!skill5Rating.isEmpty()) {
			int skill5RatingInt = Integer.parseInt(skill5Rating);
			skillAttribute.setSkill5rating(skill5RatingInt);
		}
		
		//Set these values to the skillAttribute session
		skillAttribute.setSkill1(skill1);
		skillAttribute.setSkill2(skill2);
		skillAttribute.setSkill3(skill3);
		skillAttribute.setSkill4(skill4);
		skillAttribute.setSkill5(skill5);

		request.getSession().setAttribute("skillAttribute", skillAttribute);

		Boolean checkIfRecordExists = false;

		Users user = (Users) request.getSession().getAttribute("user1");

		//Check if user record is present in the database
		checkIfRecordExists = userAccountDAO.checkIfUserNamePresent(user.getUserName());

		AboutMeTable aboutMeAttribute = (AboutMeTable) request.getSession().getAttribute("aboutMeAttribute");
		AddressTable cityAttribute = (AddressTable) request.getSession().getAttribute("cityAttribute");
		EducationTable educationAttribute = (EducationTable) request.getSession().getAttribute("educationAttribute");
		ProjectTable projectAttribute = (ProjectTable) request.getSession().getAttribute("projectAttribute");
		skillAttribute = (SkillTable) request.getSession().getAttribute("skillAttribute");
		//userAccountDAO.updateUser(user, aboutMeAttribute, cityAttribute, educationAttribute, projectAttribute,
		//		skillAttribute1);

		//If record does not exist then create a new record in the database
		if (checkIfRecordExists == false) {
			userAccountDAO.createUserResume(user, aboutMeAttribute, cityAttribute, educationAttribute, projectAttribute,
					skillAttribute);
		} 
		//If record exists update the existing record in the database
		else {
			userAccountDAO.updateUser(user, aboutMeAttribute, cityAttribute, educationAttribute, projectAttribute,
					skillAttribute);
		}
		//Redirect page to Dashboard
		request.getRequestDispatcher("/Dashboardjsp.jsp").forward(request, response);
	}
}