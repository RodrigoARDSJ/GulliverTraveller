package br.com.fiap.traveller.dao;

import br.com.fiap.traveller.exception.EntityNotFoundException;
import br.com.fiap.traveller.models.Reserve;
import br.com.fiap.traveller.models.User;

public interface ReserveDao extends GenericDao<Reserve, Integer>{
	
	Boolean reserveIsActive(Integer id) throws EntityNotFoundException;
	Reserve activeForAUser(User user); 
	
}
