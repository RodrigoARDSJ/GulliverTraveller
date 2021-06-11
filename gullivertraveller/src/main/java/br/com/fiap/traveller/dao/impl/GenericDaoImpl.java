package br.com.fiap.traveller.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.traveller.dao.GenericDao;
import br.com.fiap.traveller.exception.CommitException;
import br.com.fiap.traveller.exception.EntityNotFoundException;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K>{
	
	protected EntityManager em;
	private Class<E> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType)
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public void create(E entity) {
		em.persist(entity);
	}

	@Override
	public E read(K id) throws EntityNotFoundException {
		E entity = em.find(clazz, id);
		if (entity == null) throw new EntityNotFoundException();
		
		return entity;
	}

	@Override
	public void update(E entity) {
		em.merge(entity);
	}

	@Override
	public void delete(K id) throws EntityNotFoundException {
		E entity = read(id);
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
		
	}
	
	
	
}
