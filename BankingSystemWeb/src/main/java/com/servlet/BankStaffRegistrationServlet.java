package com.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.BankStaff;
import com.statelessbeans.BankStaffServiceRemote;

@WebServlet("/registerBankStaff")
public class BankStaffRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BankStaffServiceRemote bankStaffService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (name != null && email != null && password != null) {
			try {
				BankStaff bankStaff = new BankStaff();
				bankStaff.setName(name);
				bankStaff.setEmail(email);
				bankStaff.setPassword(password);

				bankStaffService.registerBankStaff(bankStaff);
				request.getSession().setAttribute("successMessage",
						"Bank staff registered successfully. Please log in.");
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "An error occurred during registration: " + e.getMessage());
				// Forwarding error information back to the registration page
				request.getRequestDispatcher("/WEB-INF/views/bankStaffRegistration.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/views/bankStaffRegistration.jsp").forward(request, response);
		}
	}
}
