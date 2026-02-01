package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entities.Account;
import com.entities.Customer;
import com.entities.Transaction;
import com.statelessbeans.CustomerServiceBeanRemote;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CustomerServiceBeanRemote customerServiceBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		// Log customerId to verify it's in the session
		Long customerId = (session != null) ? (Long) session.getAttribute("customerId") : null;
//		System.out.println("Customer ID in session: " + customerId);

		if (session == null || session.getAttribute("customerId") == null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}

//		Long customerId = (Long) session.getAttribute("customerId");
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "viewAccounts":
				viewAccounts(request, response, customerId);
				break;
			case "transfer":
				showTransferForm(request, response, customerId);
				break;
			case "processTransfer":
				processTransfer(request, response, customerId);
				break;
			case "payBill":
				showPayBillForm(request, response, customerId);
				break;
			case "processBill":
				processBillPayment(request, response, customerId);
				break;
			case "viewTransactions":
				handleViewTransactions(request, response, customerId);
				break;
			default:
				loadDashboard(request, response, customerId);
				break;
			}
		} catch (Exception e) {
			handleError(request, response, e);
		}
	}

	private void loadDashboard(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		Customer customer = customerServiceBean.getCustomer(customerId);
		List<Account> accounts = customerServiceBean.getCustomerAccounts(customerId);
		request.setAttribute("customer", customer);
		request.setAttribute("accounts", accounts);
		request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
	}

	private void viewAccounts(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		List<Account> accounts = customerServiceBean.getCustomerAccounts(customerId);

		// Log the size of accounts to verify data retrieval
		System.out.println("Number of accounts retrieved: " + accounts.size());

		request.setAttribute("accounts", accounts);
		request.getRequestDispatcher("/WEB-INF/views/accountDetails.jsp").forward(request, response);
	}

	private void showTransferForm(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		List<Account> customerAccounts = customerServiceBean.getCustomerAccounts(customerId);
		List<Account> allAccounts = customerServiceBean.getAllAccounts();

		request.setAttribute("customerAccounts", customerAccounts);
		request.setAttribute("allAccounts", allAccounts);
		request.getRequestDispatcher("/WEB-INF/views/transferFunds.jsp").forward(request, response);
	}

	protected void processTransfer(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		try {
			Long fromAccountId = Long.parseLong(request.getParameter("fromAccountId"));
			Long toAccountId = Long.parseLong(request.getParameter("toAccountId"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			customerServiceBean.transferFunds(customerId, fromAccountId, toAccountId, amount);
			response.sendRedirect("customer?action=viewAccounts&message=Transfer successful");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Transfer failed: " + e.getMessage());
			showTransferForm(request, response, customerId);
		}
	}

	private void showPayBillForm(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		List<Account> accounts = customerServiceBean.getCustomerAccounts(customerId);
		request.setAttribute("accounts", accounts);
		request.getRequestDispatcher("/WEB-INF/views/payBill.jsp").forward(request, response);
	}

	protected void processBillPayment(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		Long accountId = Long.parseLong(request.getParameter("accountId"));
		String[] selectedBills = request.getParameterValues("billType");

		double totalBillAmount = 0;
		for (String bill : selectedBills) {
			switch (bill) {
			case "electricity":
				totalBillAmount += 300;
				break;
			case "housing":
				totalBillAmount += 700;
				break;
			case "wifi":
				totalBillAmount += 50;
				break;
			}
		}

		try {
			customerServiceBean.payBill(customerId, accountId, totalBillAmount);
			request.setAttribute("successMessage", "Bill payment successful.");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Bill payment failed: " + e.getMessage());
		}

		showPayBillForm(request, response, customerId);
	}

	private void handleError(HttpServletRequest request, HttpServletResponse response, Exception e)
			throws ServletException, IOException {
		e.printStackTrace();
		request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
		request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
	}

	private void handleViewTransactions(HttpServletRequest request, HttpServletResponse response, Long customerId)
			throws ServletException, IOException {
		List<Transaction> transactions = customerServiceBean.getTransactionsForCustomer(customerId);
		request.setAttribute("transactions", transactions);
		request.getRequestDispatcher("/WEB-INF/views/transactionHistory.jsp").forward(request, response);
	}
}
