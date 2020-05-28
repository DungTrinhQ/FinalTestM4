package com.codegym.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Nation")
public class Nation {
    @Id
    @GeneratedValue
    private  Long id;

    private String name;
    private Long GDP;

    @OneToMany(mappedBy = "nation")
    private List<City> cityList;

    public Nation() {
    }

    public Nation(Long id, String name, Long GDP, List<City> cityList) {
        this.id = id;
        this.name = name;
        this.GDP = GDP;
        this.cityList = cityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
