package com.statelessbeans;

import com.entities.Account;
import com.entities.BankStaff;
import com.entities.Customer;
import com.entities.Transaction;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class BankStaffService implements BankStaffServiceRemote {

	@PersistenceContext(unitName = "OnlineBankingSystemJPA")
	private EntityManager entityManager;

	@Override
	public void registerBankStaff(BankStaff bankStaff) {
		// Check for existing bank staff with the same email
		try {
			TypedQuery<BankStaff> query = entityManager.createQuery("SELECT b FROM BankStaff b WHERE b.email = :email",
					BankStaff.class);
			query.setParameter("email", bankStaff.getEmail());
			BankStaff existingStaff = query.getSingleResult();
			throw new RuntimeException("A bank staff with this email already exists.");
		} catch (NoResultException e) {
			// No existing bank staff with this email, proceed with registration
			entityManager.persist(bankStaff);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error during bank staff registration: " + e.getMessage(), e);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
	}

	@Override
	public List<Account> getAccountsForCustomer(Long customerId) {
		TypedQuery<Account> query = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.customer.id = :customerId", Account.class);
		query.setParameter("customerId", customerId);
		return query.getResultList();
	}

	@Override
	public List<Transaction> getTransactionsForCustomer(Long customerId) {
		TypedQuery<Transaction> query = entityManager.createQuery(
				"SELECT t FROM Transaction t WHERE t.account.customer.id = :customerId ORDER BY t.transactionDate DESC",
				Transaction.class);
		query.setParameter("customerId", customerId);
		return query.getResultList();
	}

	@Override
	public List<Transaction> getPendingRequestsForCustomer(Long customerId) {
		TypedQuery<Transaction> query = entityManager.createQuery(
				"SELECT t FROM Transaction t WHERE t.account.customer.id = :customerId AND t.status = 'PENDING'",
				Transaction.class);
		query.setParameter("customerId", customerId);
		return query.getResultList();
	}

	@Override
	public String generateCustomerReport(Long customerId) {
		// Generate a simple report based on customer's transactions
		List<Transaction> transactions = getTransactionsForCustomer(customerId);
		StringBuilder report = new StringBuilder("Customer Transaction Report\n");
		report.append("Customer ID: ").append(customerId).append("\n\n");
		for (Transaction transaction : transactions) {
			report.append("Date: ").append(transaction.getTransactionDate()).append(", Amount: ")
					.append(transaction.getAmount()).append(", Type: ").append(transaction.getTransactionType())
					.append("\n");
		}
		return report.toString();
	}
}