package com.statelessbeans;

import com.entities.Customer;
import com.entities.Admin;
import com.entities.BankStaff;
import javax.ejb.Remote;

@Remote
public interface AuthenticationServiceBeanRemote {
	Customer authenticateCustomer(String email, String password);

	BankStaff authenticateBankStaff(String email, String password);

	Admin authenticateAdmin(String email, String password);
}
