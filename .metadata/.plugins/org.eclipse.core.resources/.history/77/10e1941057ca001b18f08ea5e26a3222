package br.com.fiap.traveller.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.traveller.dao.HotelDao;
import br.com.fiap.traveller.models.Hotel;

public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDao{

	public HotelDaoImpl(EntityManager em) {
		super(em);
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

}
