package br.com.fiap.traveller.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.traveller.dao.HotelDao;
import br.com.fiap.traveller.models.Hotel;
import br.com.fiap.traveller.models.User;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDao {

	public HotelDaoImpl(EntityManager em) {
		super(em);
	}

	public void save(Hotel hotel) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		manager.getTransaction().begin();
		manager.persist(hotel);
		manager.getTransaction().commit();
		manager.close();
		

	}

	@Override
	public List<Hotel> searchForAcceptableDistance(Double distance) {
		TypedQuery<Hotel> query = em.createQuery("from Hotel h where h.avPaulistaDistance < :d", Hotel.class);
		query.setParameter("d", distance);
		return query.getResultList();
	}

	@Override
	public List<Hotel> searchByName(String name) {
		TypedQuery<Hotel> query = em.createQuery("from Hotel h where h.name like :n", Hotel.class);
		query.setParameter("n", "%" + name + "%");
		return query.getResultList();
	}

	@Override
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

	@Override
	public Hotel findById(Integer id) {
		EntityManager em = EntityManagerSingleton.getInstance();
		Hotel hotel = em.find(Hotel.class, id);
		return hotel;
	}

	@Override
	public void delete(Hotel hotel) {
		EntityManager manager = EntityManagerSingleton.getInstance();
		Hotel u = manager.find(Hotel.class, hotel.getId());
		manager.getTransaction().begin();
		manager.remove(hotel);
		manager.flush();
		manager.getTransaction().commit();

	}

}
