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
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public boolean exist(User user) {
        TypedQuery<User> query = em
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
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        return query.getResultList();
    }

    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public User findById(Integer id) {
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public void delete(User user) {
        User u = em.find(User.class, user.getId());
        em.getTransaction().begin();
        em.remove(user);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }


}
