package com.statelessbeans;

import com.entities.Account;
import com.entities.BankStaff;
import com.entities.Customer;
import com.entities.Transaction;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BankStaffServiceRemote {

	void registerBankStaff(BankStaff bankStaff);

	List<Customer> getAllCustomers();

	List<Account> getAccountsForCustomer(Long customerId);

	List<Transaction> getTransactionsForCustomer(Long customerId);

	List<Transaction> getPendingRequestsForCustomer(Long customerId);

	String generateCustomerReport(Long customerId);


}