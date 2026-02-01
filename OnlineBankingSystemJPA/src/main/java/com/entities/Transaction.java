package com.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq_gen")
	@SequenceGenerator(name = "transaction_seq_gen", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID", nullable = false)
	private Account account;

	@Column(name = "AMOUNT", nullable = false)
	private double amount;

	@Column(name = "TRANSACTION_TYPE", nullable = false)
	private String transactionType;

	@Column(name = "TRANSACTION_DATE", nullable = false)
	private Timestamp transactionDate;

	@Column(name = "APPROVAL_DATE")
	private Timestamp approvalDate;

	@ManyToOne
	@JoinColumn(name = "APPROVED_BY")
	private BankStaff approvedBy;

	@ManyToOne
	@JoinColumn(name = "TO_ACCOUNT_ID")
	private Account toAccount;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Timestamp getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Timestamp approvalDate) {
		this.approvalDate = approvalDate;
	}

	public BankStaff getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(BankStaff approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

}
