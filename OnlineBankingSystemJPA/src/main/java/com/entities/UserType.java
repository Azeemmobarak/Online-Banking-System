package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "USER_TYPE")
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_type_seq_gen")
	@SequenceGenerator(name = "user_type_seq_gen", sequenceName = "USER_TYPE_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "TYPE_NAME", nullable = false, unique = true)
	private String typeName; // e.g., "Customer" or "BankStaff"

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
