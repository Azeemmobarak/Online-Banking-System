package com.statelessbeans;

import com.entities.Customer;
import com.entities.Admin;
import com.entities.BankStaff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AuthenticationServiceBean implements AuthenticationServiceBeanRemote {

	@PersistenceContext(unitName = "OnlineBankingSystemJPA")
	private EntityManager entityManager;

	@Override
	public Customer authenticateCustomer(String email, String password) {
		try {
			TypedQuery<Customer> query = entityManager.createQuery(
					"SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password", Customer.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null; // Return null if no matching customer is found
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error during customer authentication: " + e.getMessage(), e);
		}
	}

	@Override
	public BankStaff authenticateBankStaff(String email, String password) {
		try {
			TypedQuery<BankStaff> query = entityManager.createQuery(
					"SELECT b FROM BankStaff b WHERE b.email = :email AND b.password = :password", BankStaff.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null; // Return null if no matching bank staff is found
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error during bank staff authentication: " + e.getMessage(), e);
		}
	}

	@Override
	public Admin authenticateAdmin(String email, String password) {
		try {
			TypedQuery<Admin> query = entityManager.createQuery(
					"SELECT a FROM Admin a WHERE a.email = :email AND a.password = :password", Admin.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null; // No admin found
		}
	}
}
