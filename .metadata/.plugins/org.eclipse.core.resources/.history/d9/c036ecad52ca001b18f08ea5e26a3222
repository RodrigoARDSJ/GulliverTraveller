package br.com.fiap.traveller.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import br.com.fiap.traveller.dao.impl.HotelDaoImpl;
import br.com.fiap.traveller.dao.impl.LocationDaoImpl;
import br.com.fiap.traveller.dao.impl.RatingDaoImpl;
import br.com.fiap.traveller.dao.impl.ReserveDaoImpl;
import br.com.fiap.traveller.dao.impl.UserDaoImpl;
import br.com.fiap.traveller.models.Hotel;
import br.com.fiap.traveller.models.Location;
import br.com.fiap.traveller.models.Rating;
import br.com.fiap.traveller.models.Reserve;
import br.com.fiap.traveller.models.User;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

public class TestView {
	
	public static void main(String[] args) {
		//Criação dos Models
		Hotel hotel1 = new Hotel( "IBIS Styles São Paulo Anhembi",
				"Com um design criativo, baseado no tema \"aviação\", o ibis Styles São Paulo Anhembi une a praticidade para o trabalho com um espaço receptivo para família por uma ótima relação custo-benefício.",
				new BigDecimal(129.9),
				"https://all.accor.com/ssr/app/accor/rates/9596/index.pt-br.shtml?dateIn=2021-06-27&nights=1&compositions=2&stayplus=false&utm_campaign=9596-BR-cpa-desktop-default-0--localuniversal-2089186530-0-0-1&utm_medium=partenariats&utm_source=Google%20Hotel%20Ads",
				"Santana",
				8900.0);
		Location locationHotel1 = new Location(
				"Av. Cruzeiro do Sul",
				1709,
				"1d3658.4665610353636!2d-46.62782508502304!3d-23.515715984705576!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce58859029337b%3A0x1128b91971707df1!2sibis%20Styles%20S%C3%A3o%20Paulo%20Anhembi!5e0!3m2!1spt-BR!2sbr!4v1623246336463!5m2!1spt-BR!2sbr"
				);
		User user1 = new User("João", "joao@gmail.com", "12345678910", "senha123");
		
		Reserve reserve1 = new Reserve(LocalDate.now(), LocalDate.of(2021, Month.JUNE, 16), new BigDecimal(909.3));
		
		Rating rating1 = new Rating( 4.3, "Muito Bom!");
		
		//Criação dos Dao's
		HotelDaoImpl hotelDao = new HotelDaoImpl(EntityManagerSingleton.getInstance());
		UserDaoImpl userDao = new UserDaoImpl(EntityManagerSingleton.getInstance());
		ReserveDaoImpl reserveDao = new ReserveDaoImpl(EntityManagerSingleton.getInstance());
		LocationDaoImpl locationDao = new LocationDaoImpl(EntityManagerSingleton.getInstance());
		RatingDaoImpl ratingDao = new RatingDaoImpl(EntityManagerSingleton.getInstance());
		
		try {
			hotelDao.create(hotel1);
			hotelDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			userDao.create(user1);
			userDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			reserve1.setUser(userDao.read(16));
			System.out.println("Usuário: id: "+ reserve1.getUser().getId());
			reserve1.setHotel(hotelDao.read(16));
			reserveDao.create(reserve1);
			reserveDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			locationHotel1.setHotel(hotelDao.read(16));
			locationDao.create(locationHotel1);
			locationDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			rating1.setUser(userDao.read(16));
			rating1.setHotel(hotelDao.read(16));
			ratingDao.create(rating1);
			ratingDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
