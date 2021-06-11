package br.com.fiap.traveller.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_HOTEL")
@SequenceGenerator(name = "hotel", sequenceName = "SQ_TB_HOTEL", allocationSize = 1)
public class Hotel {
	
	@Id 
	@Column(name = "cd_hotel") 
	@GeneratedValue(generator = "hotel", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "nm_hotel", nullable = false, length = 60)
	private String name;
	
	@Column(name = "ds_hotel", nullable = false)
	private String description;
	
	@Column(name = "vl_preco", nullable = false)
	private BigDecimal value;
	
	@Column(name = "ds_link")
	private String link;
	
	@Column(name = "nm_bairro", nullable = false, length = 30)
	private String neighbourhood;
	
	@Column(name = "vl_distancia_avpaulista", nullable = false)
	private Double avPaulistaDistance;
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Rating> rating;
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Reserve> reserves;
	
	@OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Location location;
	
	public Hotel() {
	}
	
	public Hotel(Integer id,
			String name,
			String description,
			BigDecimal value,
			String link,
			String neighbourhood
			) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
		this.link = link;
		this.neighbourhood = neighbourhood;
	}
	
	public Hotel(
			String name,
			String description,
			BigDecimal value,
			String link,
			String neighbourhood
			) {
		
		this.name = name;
		this.description = description;
		this.value = value;
		this.link = link;
		this.neighbourhood = neighbourhood;
	}

	public Hotel(Integer id,
			String name,
			String description,
			BigDecimal value,
			String link,
			String neighbourhood,
			Double avPaulistaDistance,
			List<Rating> rating) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
		this.link = link;
		this.neighbourhood = neighbourhood;
		this.avPaulistaDistance = avPaulistaDistance;
		this.rating = rating;
	}
	
	public Hotel(
			String name,
			String description,
			BigDecimal value,
			String link,
			String neighbourhood,
			Double avPaulistaDistance
			) {
		
		this.name = name;
		this.description = description;
		this.value = value;
		this.link = link;
		this.neighbourhood = neighbourhood;
		this.avPaulistaDistance = avPaulistaDistance;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Double getAvPaulistaDistance() {
		return avPaulistaDistance;
	}
	public void setAvPaulistaDistance(Double avPaulistaDistance) {
		this.avPaulistaDistance = avPaulistaDistance;
	}
	public String getNeighbourhood() {
	return neighbourhood;
	}
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public List<Reserve> getReserves() {
		return reserves;
	}

	public void setReserves(List<Reserve> reserves) {
		this.reserves = reserves;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
