package com.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entities.Admin;
import com.statelessbeans.AdminServiceBeanRemote;

@WebServlet("/registerAdmin")
public class AdminRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@EJB
//	private AuthenticationServiceBeanRemote authenticationService;

	@EJB
	private AdminServiceBeanRemote adminService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email != null && password != null) {
			// Process registration if parameters are provided
			try {
				Admin admin = new Admin();
				admin.setEmail(email);
				admin.setPassword(password);

				adminService.registerAdmin(admin);

				request.getSession().setAttribute("successMessage", "Admin registration successful! Please log in.");
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "An error occurred during registration: " + e.getMessage());
				request.getRequestDispatcher("/WEB-INF/views/adminRegistration.jsp").forward(request, response);
			}
		} else {
			// Display registration form if parameters are missing
			request.getRequestDispatcher("/WEB-INF/views/adminRegistration.jsp").forward(request, response);
		}
	}
}
