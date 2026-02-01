package com.statelessbeans;

import com.entities.Admin;
import com.entities.BankStaff;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdminServiceBean implements AdminServiceBeanRemote {

	private static final String LOG_FILE_PATH = "D:/Eclipse2022/logfile.log";

	@PersistenceContext(unitName = "OnlineBankingSystemJPA")
	private EntityManager entityManager;

	@Override
	public void registerAdmin(Admin admin) {
		entityManager.persist(admin);
	}

	@Override
	public List<BankStaff> getAllBankStaff() {
		return entityManager.createQuery("SELECT b FROM BankStaff b", BankStaff.class).getResultList();
	}

	// Retrieve a specific bank staff record by ID
	@Override
	public BankStaff getBankStaffById(Long id) {
		return entityManager.find(BankStaff.class, id);
	}

	// Create a new bank staff record in the database
	@Override
	public void createBankStaff(BankStaff staff) {
		try {
			entityManager.persist(staff);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to create new bank staff account", e);
		}
	}

	// Update an existing bank staff record
	@Override
	public void updateBankStaff(BankStaff staff) {
		entityManager.merge(staff);
	}

	// Delete a bank staff record by ID
	@Override
	public void deleteBankStaff(Long id) {
		BankStaff staff = entityManager.find(BankStaff.class, id);
		if (staff != null) {
			entityManager.remove(staff);
		}
	}

	// Retrieve a list of system logs (Stubbed with example data)
	@Override
	public List<String> getSystemLogs() {
		List<String> logs = new ArrayList<>();
		String logFilePath = "D:/Eclipse2022/logfile.log"; 

		try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				logs.add(line);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Log file not found: " + e.getMessage());
			logs.add("Error: Log file not found.");
		} catch (IOException e) {
			System.err.println("Error reading log file: " + e.getMessage());
			logs.add("Error: Unable to read log file.");
		}

		return logs;
	}

	// Perform a database backup...
	@Override
	public void performDatabaseBackup() {
		// Specify the backup folder and file names
		
		String backupFolder = "D:/Eclipse2022"; 
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String backupFileName = "backup_" + timestamp + ".dmp";
		String backupFilePath = backupFolder + File.separator + backupFileName;
		String logFileName = "backup_" + timestamp + ".log";
		String logFilePath = backupFolder + File.separator + logFileName;

		// Construct the command for Oracle Data Pump export (expdp)
		String command = String.format(
				"expdp system/root@localhost:1521/xe DIRECTORY=DATA_PUMP_DIR DUMPFILE=%s LOGFILE=%s", backupFileName,
				logFileName);

		try {
			// Execute the backup command
			ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();

			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("Database backup completed successfully.");
			} else {
				System.err.println("Database backup failed with exit code: " + exitCode);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.err.println("Error during database backup: " + e.getMessage());
		}
	}

}
