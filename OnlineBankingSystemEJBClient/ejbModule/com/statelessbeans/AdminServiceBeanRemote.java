package com.statelessbeans;

import com.entities.Admin;
import com.entities.BankStaff;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AdminServiceBeanRemote {
	void registerAdmin(Admin admin);

	List<BankStaff> getAllBankStaff();

	BankStaff getBankStaffById(Long id);

	void createBankStaff(BankStaff staff);

	void updateBankStaff(BankStaff staff);

	void deleteBankStaff(Long id);

	List<String> getSystemLogs(); // For system logs display

	void performDatabaseBackup(); // For maintenance
}
