package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.HotelDao;
import br.com.fiap.traveller.models.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDao {

    public HotelDaoImpl(EntityManager em) {
        super(em);
    }

    public void save(Hotel hotel) {
        em.persist(hotel);
        em.getTransaction().commit();
        em.close();
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
        String jpql = "SELECT u FROM Hotel u";
        TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
        List<Hotel> hotels = query.getResultList();
        return hotels;

    }

    public void update(Hotel hotel) {
        em.getTransaction().begin();
        em.merge(hotel);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public Hotel findById(Integer id) {
        return em.find(Hotel.class, id);
    }

    @Override
    public void delete(Hotel hotel) {
        Hotel u = em.find(Hotel.class, hotel.getId());
        em.getTransaction().begin();
        em.remove(hotel);
        em.flush();
        em.getTransaction().commit();
    }

}
