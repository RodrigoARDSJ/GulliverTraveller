package br.com.fiap.traveller.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RESERVA")
@SequenceGenerator(name = "reservas", sequenceName = "SQ_TB_RESERVA")
public class Reserve {
	
	@Id
	@Column(name = "cd_reserva")
	@GeneratedValue(generator = "reservas", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "dt_entrada")
	private LocalDate checkIn;
	
	@Column(name = "dt_saida")
	private LocalDate checkOut;
	
	@ManyToOne
	@JoinColumn(name = "cd_usuario", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "cd_hotel", nullable = false)
	private Hotel hotel;
	
	@Column(name = "vl_total", nullable = false)
	private BigDecimal total;
	
	public Reserve() {
	}

	public Reserve(Integer id, LocalDate checkIn, LocalDate checkOut, User user, Hotel hotel, BigDecimal total) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.user = user;
		this.hotel = hotel;
		this.total = total;
	}
	
	public Reserve(LocalDate checkIn, LocalDate checkOut, User user, Hotel hotel, BigDecimal total) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.user = user;
		this.hotel = hotel;
		this.total = total;
	}
	
	public Reserve(LocalDate checkIn, LocalDate checkOut, BigDecimal total) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
