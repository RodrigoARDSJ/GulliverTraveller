package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.UserDao;
import br.com.fiap.traveller.models.User;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

    public UserDaoImpl(EntityManager em) {
        super(em);
    }

    public void save(User user) {
        EntityManager manager = EntityManagerSingleton.getInstance();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();

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

    @Override
    public List<User> getAll() {
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
        manager.close();
    }

    @Override
    public User findById(Integer id) {
        EntityManager manager = EntityManagerSingleton.getInstance();
        User user = manager.find(User.class, id);
        manager.close();
        return user;
    }

    @Override
    public void delete(User user) {
        EntityManager manager = EntityManagerSingleton.getInstance();
        User u = manager.find(User.class, user.getId());
        manager.getTransaction().begin();
        manager.remove(user);
        manager.flush();
        manager.getTransaction().commit();
        manager.close();

    }


}
