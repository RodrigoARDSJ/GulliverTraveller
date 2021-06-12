package br.com.fiap.traveller.dao;

import br.com.fiap.traveller.exception.CommitException;
import br.com.fiap.traveller.exception.EntityNotFoundException;

public interface GenericDao<E, K> {
	
	void create(E entity);
	E read(K id) throws EntityNotFoundException;
	void update(E entity);
	void delete(K id) throws EntityNotFoundException;
	void commit() throws CommitException;
	
}
