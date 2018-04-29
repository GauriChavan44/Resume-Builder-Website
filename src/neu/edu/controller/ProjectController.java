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
 * Servlet implementation class AcademicProjectServlet
 */
@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//User is redirected to Login page if he logs out or session times out
		HttpSession session = request.getSession(false);
		if (session == null) {
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		} else {
			String action = request.getParameter("action");
			if (action.matches("Next")) {
				//Get the EducationTable attribute from the session
				EducationTable educationAttribute = (EducationTable) request.getSession()
						.getAttribute("educationAttribute");

				//Get the input provided by the user
				String graduateSchoolName = request.getParameter("graduateSchoolName");
				String underGraduateSchoolName = request.getParameter("underGraduateSchoolName");
				String graduateMajor = request.getParameter("graduateMajor");
				String underGraduateMajor = request.getParameter("underGraduateMajor");
				String graduateCourses = request.getParameter("graduateCourses");
				String underGraduateCourses = request.getParameter("underGraduateCourses");
				String graduatecgpaString = request.getParameter("graduatecgpa");
				if (!graduatecgpaString.isEmpty()) {
					float graduatecgpa = Float.parseFloat(graduatecgpaString);
					educationAttribute.setGraduatecgpa(graduatecgpa);
				}
				String underGraduatecgpaString = request.getParameter("underGraduatecgpa");
				if (!underGraduatecgpaString.isEmpty()) {
					float underGraduatecgpa = Float.parseFloat(underGraduatecgpaString);
					educationAttribute.setUnderGraduatecgpa(underGraduatecgpa);
				}

				//Set the input provided by user to the session attribute
				educationAttribute.setGraduateSchoolName(graduateSchoolName);
				educationAttribute.setUnderGraduateSchoolName(underGraduateSchoolName);
				educationAttribute.setGraduateMajor(graduateMajor);
				educationAttribute.setUnderGraduateMajor(underGraduateMajor);
				educationAttribute.setGraduateCourses(graduateCourses);
				educationAttribute.setUnderGraduateCourses(underGraduateCourses);

				request.getSession().setAttribute("educationAttribute", educationAttribute);

				//Redirect to Academic Project page
				request.getRequestDispatcher("/AcademicProject.jsp").forward(request, response);
			}
			if (action.matches("Previous")) {
				request.getRequestDispatcher("/AcademicProject.jsp").forward(request, response);
			}
		}
	}
}