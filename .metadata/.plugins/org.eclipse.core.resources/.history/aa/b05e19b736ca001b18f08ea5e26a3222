package br.com.fiap.traveller.dao.impl;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.traveller.dao.ReserveDao;
import br.com.fiap.traveller.exception.EntityNotFoundException;
import br.com.fiap.traveller.models.Reserve;
import br.com.fiap.traveller.models.User;

public class ReserveDaoImpl extends GenericDaoImpl<Reserve, Integer> implements ReserveDao {
	public ReserveDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public Boolean reserveIsActive(Integer id) throws EntityNotFoundException {
		Reserve reserve = read(id);
		if(reserve == null) throw new EntityNotFoundException();
		if(reserve.getCheckOut().isBefore(LocalDate.now())) return false;
		return true;
	}

	@Override
	public Reserve activeForAUser(User user) {
		//TODO
		TypedQuery<Reserve> query = 
				em.createQuery("from Reserve r where r.user = :id and r.checkOut > :date", Reserve.class);
		query.setParameter("id", user.getId());
		query.setParameter("date", LocalDate.now());
		return query.getSingleResult();
	}
}
