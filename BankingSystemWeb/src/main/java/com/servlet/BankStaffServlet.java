package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entities.Customer;
import com.entities.Account;
import com.entities.Transaction;
import com.statelessbeans.BankStaffServiceRemote;

@WebServlet("/bankStaff")
public class BankStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BankStaffServiceRemote bankStaffService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String customerIdParam = request.getParameter("customerId");
		Long customerId = customerIdParam != null ? Long.parseLong(customerIdParam) : null;

		try {
			switch (action == null ? "default" : action) {
			case "viewAccounts":
				handleViewAccounts(request, response, customerId);
				break;
			case "viewTransactions":
				handleViewTransactions(request, response, customerId);
				break;
			case "viewPendingRequests":
				handleViewPendingRequests(request, response, customerId);
				break;
			case "generateReport":
				handleGenerateReport(request, response, customerId);
				break;
			default:
				showCustomerList(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}

	private void showCustomerList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Customer> customers = bankStaffService.getAllCustomers();
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/WEB-INF/views/viewCustomers.jsp").forward(request, response);
	}

	private void handleViewAccounts(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		List<Account> accounts = bankStaffService.getAccountsForCustomer(customerId);
		request.setAttribute("accounts", accounts);
		request.getRequestDispatcher("/WEB-INF/views/viewAccounts.jsp").forward(request, response);
	}

	private void handleViewTransactions(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		List<Transaction> transactions = bankStaffService.getTransactionsForCustomer(customerId);
		request.setAttribute("transactions", transactions);
		request.getRequestDispatcher("/WEB-INF/views/viewTransactions.jsp").forward(request, response);
	}

	private void handleViewPendingRequests(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		List<Transaction> pendingTransactions = bankStaffService.getPendingRequestsForCustomer(customerId);
		request.setAttribute("pendingTransactions", pendingTransactions);
		request.getRequestDispatcher("/WEB-INF/views/viewPendingRequests.jsp").forward(request, response);
	}

	private void handleGenerateReport(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		String report = bankStaffService.generateCustomerReport(customerId);
		request.setAttribute("report", report);
		request.getRequestDispatcher("/WEB-INF/views/generateReport.jsp").forward(request, response);
	}
}
