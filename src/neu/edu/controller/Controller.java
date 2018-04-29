package neu.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
//Main controller which handles the flow of pages
@WebServlet(value = "/Controller")
@org.springframework.stereotype.Controller
public class Controller extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public Controller() {
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
		//Check the action received from the pages
		String action = request.getParameter("action");

		//If action matches Login then redirect to Login Controller
		if (action.matches("Login")) {
			request.getRequestDispatcher("/LoginController").forward(request, response);
		}
		
		//If action matches Registration then redirect to Registration Controller
		else if (action.matches("Registration")) {
			request.getRequestDispatcher("/Registration").forward(request, response);
		}

		//If action matches Dashboard then redirect to Dashboard Controller
		else if (action.matches("Dashboard")) {
			String pageName = request.getParameter("pageName");
			if (pageName.matches("displayresumejsp")) {
				request.getRequestDispatcher("/Dashboard").forward(request, response);
			}
		}

		//If action matches Register then redirect to Registration Controller
		else if (action.matches("Register")) {
			String pageName = request.getParameter("pageName");
			if (pageName.matches("registrationjsp")) {
				request.getRequestDispatcher("/Registration").forward(request, response);
			}
			if (pageName.matches("registrationError")) {
				request.getRequestDispatcher("/ErrorUserNameExist.jsp").forward(request, response);
			}
		}

		//If action matches dashboardjsp then check if user wants to enter details or view resume and redirect to according Controller
		else if (action.matches("dashboardjsp")) {
			String task = request.getParameter("task");
			if (task.matches("Enter Details")) {
				request.getRequestDispatcher("/AboutMeController").forward(request, response);
			} else if (task.matches("View Resume")) {
				request.getRequestDispatcher("/DisplayResumeController").forward(request, response);
			}
		}

		//If action matches Next then redirect to specific page Controller
		else if (action.matches("Next")) {
			String pageName = request.getParameter("pageName");

			if (pageName.matches("aboutMejsp")) {
				request.getRequestDispatcher("/AddressController").forward(request, response);
			}
			if (pageName.matches("addressjsp")) {
				request.getRequestDispatcher("/EducationController").forward(request, response);
			}
			if (pageName.matches("educationjsp")) {
				request.getRequestDispatcher("/ProjectController").forward(request, response);
			}
			if (pageName.matches("academicprojectjsp")) {
				request.getRequestDispatcher("/SkillSetController").forward(request, response);
			}
		}

		//If action matches Previous then redirect to specific page Controller
		else if (action.matches("Previous")) {
			String pageName = request.getParameter("pageName");

			if (pageName.matches("addressjsp")) {
				request.getRequestDispatcher("/AboutMeController").forward(request, response);
			}
			if (pageName.matches("educationjsp")) {
				request.getRequestDispatcher("/AddressController").forward(request, response);
			}
			if (pageName.matches("academicprojectjsp")) {
				request.getRequestDispatcher("/EducationController").forward(request, response);
			}
			if (pageName.matches("skillsetjsp")) {
				request.getRequestDispatcher("/ProjectController").forward(request, response);
			}
			if (pageName.matches("registrationError")) {
				request.getRequestDispatcher("/Registration").forward(request, response);
			}
			if (pageName.matches("userNotFoundError")) {
				request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			}
		}

		//If action matches Submit then redirect to Information Submit Controller
		else if (action.matches("Submit")) {
			String pageName = request.getParameter("pageName");
			if (pageName.matches("skillsetjsp")) {
				request.getRequestDispatcher("/InfoSubmitController").forward(request, response);
			}
		}

		else if (action.matches("Update")) {
			String pageName = request.getParameter("pageName");
			if (pageName.matches("referencesjsp")) {
				request.getRequestDispatcher("/InfoSubmitController").forward(request, response);
			}
		}
	}
}
