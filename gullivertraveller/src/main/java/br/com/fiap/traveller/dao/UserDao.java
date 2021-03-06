package br.com.fiap.traveller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.traveller.models.User;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

public class UserDao {
	public void create(User user) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		

	}

	public boolean exist(User user) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		TypedQuery<User> query = manager
				.createQuery("SELECT u FROM User u " + "WHERE u.email = :email AND u.password = :password", User.class);
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		try {
			query.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;

	}


	public List<User> getAll(){
		EntityManager em = EntityManagerSingleton.getInstance();
		String jpql = "SELECT u FROM User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
	    List<User> users = query.getResultList();
	    return users;
		
	
	}
	
	public void update(User user) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		manager.getTransaction().begin();
		manager.merge(user);
		manager.flush();
		manager.getTransaction().commit();
	
	}


	public User findById(Integer id) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		User user = manager.find(User.class, id);
		manager.close();
		return user;
	}


	public void delete(User user) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		User u = manager.find(User.class, user.getId());
		manager.getTransaction().begin();
		manager.remove(u);
		manager.flush();
		manager.getTransaction().commit();
	
	}	

}
