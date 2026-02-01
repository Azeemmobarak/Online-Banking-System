package com.statelessbeans;

import com.entities.Account;
import com.entities.Customer;
import com.entities.Transaction;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Stateless
public class CustomerServiceBean implements CustomerServiceBeanRemote {

	@PersistenceContext(unitName = "OnlineBankingSystemJPA")
	private EntityManager entityManager;

	// Retrieve a specific customer by ID
	@Override
	public Customer getCustomer(Long customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	// JPQL method to retrieve all accounts for a customer (using JPA)
	@Override
	public List<Account> getCustomerAccounts(Long customerId) {
		TypedQuery<Account> query = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.customer.id = :customerId", Account.class);
		query.setParameter("customerId", customerId);
		return query.getResultList();
	}

	@Override
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);

		// After persisting the customer, create an associated account
		Account account = new Account();
		account.setCustomer(customer);
		account.setAccountNumber(generateAccountNumber());
		account.setAccountType("Savings"); // Default account type
		account.setBalance(1000.0); // Default initial balance

		// Persist the account entity
		entityManager.persist(account);

	}

	private String generateAccountNumber() {
		// Generate a unique account number, can be customized as needed
		return "ACC" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	@Override
	public List<Account> getAllAccounts() {
		return entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
	}

	@Override
	public void transferFunds(Long customerId, Long fromAccountId, Long toAccountId, double amount) throws Exception {
		Account fromAccount = entityManager.find(Account.class, fromAccountId);
		Account toAccount = entityManager.find(Account.class, toAccountId);

		// Validate the accounts
		if (fromAccount == null || !fromAccount.getCustomer().getId().equals(customerId)) {
			throw new RuntimeException("Invalid account for transfer.");
		}

		if (fromAccount.equals(toAccount)) {
			throw new RuntimeException("Cannot transfer to the same account.");
		}

		if (fromAccount.getBalance() < amount) {
			throw new RuntimeException("Insufficient balance.");
		}

		// Perform the fund transfer
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		// Log the transaction for the fromAccount
		Transaction transaction = new Transaction();
		transaction.setAccount(fromAccount);
		transaction.setAmount(amount);
		transaction.setTransactionType("Transfer");
		transaction.setToAccount(toAccount);
		transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));

		entityManager.persist(transaction);
	}

	@Override
	public void payBill(Long customerId, Long accountId, double amount) {
		Account account = entityManager.find(Account.class, accountId);

		if (account == null || !account.getCustomer().getId().equals(customerId)) {
			throw new RuntimeException("Invalid account for bill payment.");
		}

		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient balance.");
		}

		account.setBalance(account.getBalance() - amount);

		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setAmount(amount);
		transaction.setTransactionType("Bill Payment");
		transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));

		entityManager.persist(transaction);
	}

	@Override
	public List<Transaction> getTransactionsForCustomer(Long customerId) {
		TypedQuery<Transaction> query = entityManager.createQuery(
				"SELECT t FROM Transaction t WHERE t.account.customer.id = :customerId ORDER BY t.transactionDate DESC",
				Transaction.class);
		query.setParameter("customerId", customerId);
		return query.getResultList();
	}
}
