package com.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "BillPayment")
public class BillPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billpayment_seq_gen")
	@SequenceGenerator(name = "billpayment_seq_gen", sequenceName = "BILL_PAYMENT_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer customer;

	@Column(name = "AMOUNT", nullable = false)
	private double amount;

	@Column(name = "PAYMENT_DATE", nullable = false)
	private Timestamp paymentDate;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
}
