package com.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entities.Customer;
import com.statelessbeans.CustomerServiceBeanRemote;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CustomerServiceBeanRemote customerService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");

		if (name != null && email != null && address != null && password != null) {
			try {
				Customer customer = new Customer();
				customer.setName(name);
				customer.setEmail(email);
				customer.setAddress(address);
				customer.setPassword(password);

				customerService.registerCustomer(customer);

				// Redirect to login page with success message
				request.getSession().setAttribute("successMessage", "Registration successful! Please log in.");
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "An error occurred during registration: " + e.getMessage());
				request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
		}
	}
}
