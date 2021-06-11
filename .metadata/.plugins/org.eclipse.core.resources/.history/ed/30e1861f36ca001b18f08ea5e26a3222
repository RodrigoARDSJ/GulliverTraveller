package br.com.fiap.traveller.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCALIZACAO")
@SequenceGenerator(name = "localizacao", sequenceName = "SQ_TB_LOCALIZACAO", allocationSize = 1)
public class Location {
	
	@Id
	@Column(name = "cd_localizacao")
	@GeneratedValue(generator = "localizacao", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "nm_logradouro", nullable = false, length = 70)
	private String name;
	
	@Column(name = "nr_logradouro", nullable = false)
	private Integer number;
	
	@Column(name = "ds_maps")
	private String maps;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cd_hotel", nullable = false, unique = true)
	private Hotel hotel;
	
	
	
	public Location() {
	}

	public Location(Integer id, String name, Integer number, String maps, Hotel hotel) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.maps = maps;
		this.hotel = hotel;
	}
	
	public Location(String name, Integer number, String maps, Hotel hotel) {
		this.name = name;
		this.number = number;
		this.maps = maps;
		this.hotel = hotel;
	}
	
	public Location(String name, Integer number, String maps) {
		this.name = name;
		this.number = number;
		this.maps = maps;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getMaps() {
		return maps;
	}

	public void setMaps(String maps) {
		this.maps = maps;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	
}
