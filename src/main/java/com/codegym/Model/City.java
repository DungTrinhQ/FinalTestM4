package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue
    private Long id;


    private String cityName;
    private Long area;


    private Long population;
    private String description;

    @ManyToOne
    @JoinColumn(name = "nationId")
    private Nation nation;

    public City() {
    }

    public City(Long id, String cityName, Long area, Long population, String description, Nation nation) {
        this.id = id;
        this.cityName = cityName;
        this.area = area;
        this.population = population;
        this.description = description;
        this.nation = nation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
