package com.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import com.entities.BankStaff;
import com.statelessbeans.AdminServiceBeanRemote;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private AdminServiceBeanRemote adminService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("adminId") == null) {
			response.sendRedirect("index.jsp?error=Please login as admin");
			return;
		}

		String action = request.getParameter("action");

		try {
			switch (action == null ? "adminDashboard" : action) {
			case "adminDashboard":
				request.getRequestDispatcher("/WEB-INF/views/adminDashboard.jsp").forward(request, response);
				break;
			case "manageBankStaff":
				List<BankStaff> bankStaffList = adminService.getAllBankStaff();
				request.setAttribute("bankStaffList", bankStaffList);
				request.getRequestDispatcher("/WEB-INF/views/manageBankStaff.jsp").forward(request, response);
				break;
			case "createBankStaff":
				request.getRequestDispatcher("/WEB-INF/views/createBankStaff.jsp").forward(request, response);
				break;
			case "processCreateBankStaff":
				processCreateBankStaff(request, response);
				break;
			case "deleteBankStaff":
				Long deleteId = Long.parseLong(request.getParameter("id"));
				adminService.deleteBankStaff(deleteId);
				response.sendRedirect("admin?action=manageBankStaff");
				break;
			case "editBankStaff":
				Long editId = Long.parseLong(request.getParameter("id"));
				BankStaff staffToEdit = adminService.getBankStaffById(editId);
				request.setAttribute("staff", staffToEdit);
				request.getRequestDispatcher("/WEB-INF/views/editBankStaff.jsp").forward(request, response);
				break;
			case "viewSystemLogs":
				List<String> systemLogs = adminService.getSystemLogs();
				request.setAttribute("logs", systemLogs);
				request.getRequestDispatcher("/WEB-INF/views/systemLogs.jsp").forward(request, response);
				break;
			case "performMaintenance":
				adminService.performDatabaseBackup();
				request.setAttribute("maintenanceMessage", "Database backup completed successfully.");
				request.getRequestDispatcher("/WEB-INF/views/systemMaintenance.jsp").forward(request, response);
				break;
			default:
				request.setAttribute("errorMessage", "Unknown action");
				request.getRequestDispatcher("/WEB-INF/views/adminDashboard.jsp").forward(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/adminDashboard.jsp").forward(request, response);
		}
	}

	private void processCreateBankStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			BankStaff newStaff = new BankStaff();
			newStaff.setName(name);
			newStaff.setEmail(email);
			newStaff.setPassword(password);

			adminService.createBankStaff(newStaff);
			response.sendRedirect("admin?action=manageBankStaff");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("admin?action=manageBankStaff&error=Unable to create bank staff account");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			if ("updateBankStaff".equals(action)) {
				// Process the update of a bank staff member
				Long staffId = Long.parseLong(request.getParameter("id"));
				String name = request.getParameter("name");
				String email = request.getParameter("email");

				BankStaff staff = adminService.getBankStaffById(staffId);
				staff.setName(name);
				staff.setEmail(email);
				adminService.updateBankStaff(staff);

				response.sendRedirect("admin?action=manageBankStaff");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred while updating the bank staff: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/editBankStaff.jsp").forward(request, response);
		}
	}
}
