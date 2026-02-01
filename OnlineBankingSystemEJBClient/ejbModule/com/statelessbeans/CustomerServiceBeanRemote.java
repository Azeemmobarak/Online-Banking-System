package com.statelessbeans;

import com.entities.Account;
import com.entities.Customer;
import com.entities.Transaction;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CustomerServiceBeanRemote {

	// Retrieves a customer by their ID
	Customer getCustomer(Long customerId);

	// Retrieves all accounts for a customer using JPQL
	List<Account> getCustomerAccounts(Long customerId);
	
	List<Account> getAllAccounts();

	// Add the registerCustomer method
	void registerCustomer(Customer customer);

	// Transfer funds...
	void transferFunds(Long customerId, Long fromAccountId, Long toAccountId, double amount) throws Exception;

	void payBill(Long customerId, Long accountId, double amount);

	 List<Transaction> getTransactionsForCustomer(Long customerId);
}
