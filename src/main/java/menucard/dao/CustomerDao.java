package menucard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import menucard.dto.Customer;
import menucard.dto.Menucard;

public class CustomerDao {
	
	EntityManager manager= Persistence.createEntityManagerFactory("rani").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public int saveMenucard(Menucard menucard) {
		try {
			transaction.begin();
			manager.persist(menucard);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public List<Menucard> displayMenu() {
		String jpql="Select m From Menucard m";
		return manager.createQuery(jpql).getResultList();
	}
	
	public int deleteMenu(int id) {
		Menucard menucard=manager.find(Menucard.class, id);
		if (menucard!=null) {
			transaction.begin();
			manager.remove(menucard);
			transaction.commit();
			return 1;
		} else {
			return 0;
		}
	}
	
	public int saveCustomer(Customer customer) {
		try {
			transaction.begin();
			manager.persist(customer);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public Customer customerLog(String email) {
		String jpql="Select m From Customer m where m.email=?1";
		Customer customer= (Customer) manager.createQuery(jpql).setParameter(1, email).getSingleResult();
		if (customer!=null) {
			return customer;
		} else {
			return null;
		}
	}
	
	public Menucard fetchMenuById(int id) {
		Menucard menucard=manager.find(Menucard.class, id);
		if (menucard!=null) {
			return menucard;
		} else {
			return null;
		}
	}
}
