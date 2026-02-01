package com.dataInitializer;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Admin;

@Startup
@Singleton
public class DataInitializer {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		// Check if the default admin user exists
		TypedQuery<Admin> query = entityManager.createQuery("SELECT a FROM Admin a WHERE a.email = :email",
				Admin.class);
		query.setParameter("email", "admin@bank.com");

		if (query.getResultList().isEmpty()) {
			// Create the default admin user
			Admin admin = new Admin();
			admin.setEmail("admin@bank.com");
			admin.setPassword("admin");
			entityManager.persist(admin);
		}
	}
}
