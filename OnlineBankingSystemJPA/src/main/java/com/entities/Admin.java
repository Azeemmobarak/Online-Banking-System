package com.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "ADMIN")
public class Admin implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq_gen")
	@SequenceGenerator(name = "admin_seq_gen", sequenceName = "ADMIN_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
