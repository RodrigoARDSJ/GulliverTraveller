package br.com.fiap.traveller.dao;

import java.util.List;

import br.com.fiap.traveller.models.User;

public interface UserDao extends GenericDao<User, Integer> {
	public void save(User user);

	public List<User> getAll();

	public User findById(Integer id);

	public void delete(User user);

}
