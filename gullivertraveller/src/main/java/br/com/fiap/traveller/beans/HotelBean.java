package br.com.fiap.traveller.beans;



import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.traveller.dao.HotelDao;
import br.com.fiap.traveller.models.Hotel;

@Named
@RequestScoped
public class HotelBean {

	

	private Hotel hotel = new Hotel();


	public void save() {

		new HotelDao().create(hotel);
		System.out.println("Salvando..." + this.hotel);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel cadastrado com sucesso!"));
	}
	
	public void update() {

		new HotelDao().update(hotel);
		System.out.println("Atualizando..." + this.hotel);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel cadastrado com sucesso!"));
	}
	
	public void delete() {

		new HotelDao().delete(hotel);
		System.out.println("Deletando..." + this.hotel);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel cadastrado com sucesso!"));
	}
	
	public List<Hotel> getHotels() {
		return new HotelDao().getAll();
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
