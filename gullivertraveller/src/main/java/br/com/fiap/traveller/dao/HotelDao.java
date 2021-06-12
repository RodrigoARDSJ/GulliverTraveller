package br.com.fiap.traveller.dao;

import br.com.fiap.traveller.models.Hotel;

import java.util.List;

public interface HotelDao extends GenericDao<Hotel, Integer> {

    List<Hotel> searchForAcceptableDistance(Double distance);

    List<Hotel> searchByName(String name);

    List<Hotel> getAll();

    Hotel findById(Integer id);

    void delete(Hotel hotel);

}
