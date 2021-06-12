package br.com.fiap.traveller.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_HOTEL")
public class Hotel {

    @Id
    @Column(name = "cd_hotel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private BigDecimal avPaulistaDistance;


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
                 BigDecimal avPaulistaDistance) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.link = link;
        this.neighbourhood = neighbourhood;
        this.avPaulistaDistance = avPaulistaDistance;
    }

    public Hotel(
            String name,
            String description,
            BigDecimal value,
            String link,
            String neighbourhood,
            BigDecimal avPaulistaDistance
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

    public BigDecimal getAvPaulistaDistance() {
        return avPaulistaDistance;
    }

    public void setAvPaulistaDistance(BigDecimal avPaulistaDistance) {
        this.avPaulistaDistance = avPaulistaDistance;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

}
