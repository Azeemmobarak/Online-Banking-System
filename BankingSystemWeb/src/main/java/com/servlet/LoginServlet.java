package com.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entities.Customer;
import com.entities.Admin;
import com.entities.BankStaff;
import com.statelessbeans.AuthenticationServiceBeanRemote;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private AuthenticationServiceBeanRemote authenticationService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");

		HttpSession session = request.getSession();

		try {
			if ("Customer".equals(userType)) {
				// Customer login logic...
				Customer customer = authenticationService.authenticateCustomer(email, password);
				if (customer != null) {
					session.setAttribute("customerId", customer.getId());
					response.sendRedirect("customer?action=dashboard");
				} else {
					response.sendRedirect("index.jsp?error=Invalid login");
				}
			} else if ("BankStaff".equals(userType)) {
				// BankStaff login logic...
				BankStaff staff = authenticationService.authenticateBankStaff(email, password);
				if (staff != null) {
					session.setAttribute("staffId", staff.getId());
					response.sendRedirect("bankStaff?action=viewCustomers");
				} else {
					response.sendRedirect("index.jsp?error=Invalid login");
				}
			} else if ("Admin".equals(userType)) { // Handle admin login
				Admin admin = authenticationService.authenticateAdmin(email, password);
				if (admin != null) {
					session.setAttribute("adminId", admin.getId());
					response.sendRedirect("admin?action=adminDashboard");
				} else {
					response.sendRedirect("index.jsp?error=Invalid login");
				}
			} else {
				response.sendRedirect("index.jsp?error=Invalid user type");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("index.jsp?error=An error occurred");
		}
	}
}