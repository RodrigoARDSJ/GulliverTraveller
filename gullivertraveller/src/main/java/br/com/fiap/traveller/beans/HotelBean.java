package br.com.fiap.traveller.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.fiap.traveller.dao.HotelDao;
import br.com.fiap.traveller.dao.impl.HotelDaoImpl;
import br.com.fiap.traveller.models.Hotel;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

@Named
@RequestScoped
public class HotelBean {

	private EntityManager em = EntityManagerSingleton.getInstance();

	private Hotel hotel = new Hotel();


	public void save() {

		new HotelDaoImpl(em).save(hotel);
		System.out.println("Salvando..." + this.hotel);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel cadastrado com sucesso!"));
	}
	
	public void update() {

		new HotelDaoImpl(em).update(hotel);
		System.out.println("Atualizando..." + this.hotel);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel cadastrado com sucesso!"));
	}
	
	public void delete() {

		new HotelDaoImpl(em).delete(hotel);
		System.out.println("Deletando..." + this.hotel);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel cadastrado com sucesso!"));
	}
	

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
