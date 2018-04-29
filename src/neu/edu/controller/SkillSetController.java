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
 * Servlet implementation class SkillSetServlet
 */
@WebServlet("/SkillSetController")
public class SkillSetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SkillSetController() {
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
				//Get the ProjectTable attribute from the user
				ProjectTable projectAttribute = (ProjectTable) request.getSession().getAttribute("projectAttribute");

				//Get the input provided by the user regarding the project title and description
				String project1Title = request.getParameter("project1Title");
				String project1Description = request.getParameter("project1Description");
				String project2Title = request.getParameter("project2Title");
				String project2Description = request.getParameter("project2Description");
				String project3Title = request.getParameter("project3Title");
				String project3Description = request.getParameter("project3Description");

				//Set the user provided values to the session attribute
				projectAttribute.setProject1title(project1Title);
				projectAttribute.setProject1description(project1Description);
				projectAttribute.setProject2title(project2Title);
				projectAttribute.setProject2description(project2Description);
				projectAttribute.setProject3title(project3Title);
				projectAttribute.setProject3description(project3Description);

				request.getSession().setAttribute("projectAttribute", projectAttribute);

				//Redirect to SkillSet page
				request.getRequestDispatcher("/SkillSet.jsp").forward(request, response);
			}

			if (action.matches("Previous")) {
				request.getRequestDispatcher("/SkillSet.jsp").forward(request, response);
			}
		}
	}
}
