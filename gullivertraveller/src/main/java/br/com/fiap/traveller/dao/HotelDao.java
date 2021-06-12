package br.com.fiap.traveller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.traveller.models.Hotel;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

public class HotelDao {
	public void create(Hotel hotel) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		manager.getTransaction().begin();
		manager.persist(hotel);
		manager.getTransaction().commit();
	
		

	}


	public List<Hotel> searchForAcceptableDistance(Double distance) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		TypedQuery<Hotel> query = manager.createQuery("from Hotel h where h.avPaulistaDistance < :d", Hotel.class);
		query.setParameter("d", distance);
		return query.getResultList();
	}


	public List<Hotel> searchByName(String name) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		TypedQuery<Hotel> query = manager.createQuery("from Hotel h where h.name like :n", Hotel.class);
		query.setParameter("n", "%" + name + "%");
		return query.getResultList();
	}


	public List<Hotel> getAll() {
		EntityManager em = EntityManagerSingleton.getInstance();
		String jpql = "SELECT u FROM Hotel u";
		TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
		List<Hotel> hotels = query.getResultList();
		return hotels;

	}

	public void update(Hotel hotel) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		manager.getTransaction().begin();
		manager.merge(hotel);
		manager.flush();
		manager.getTransaction().commit();
	}


	public Hotel findById(Integer id) {
		EntityManager em = EntityManagerSingleton.getInstance();
		Hotel hotel = em.find(Hotel.class, id);
		return hotel;
	}


	public void delete(Hotel hotel) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		Hotel u = manager.find(Hotel.class, hotel.getId());
		manager.getTransaction().begin();
		manager.remove(u);
		manager.flush();
		manager.getTransaction().commit();

	}

	
}
