package com.example.assignment3_restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "hub_rates")
public class HubRate {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hubLocation;

    private Double rate;

    public String getHubLocation() {
        return hubLocation;
    }

    public void setHubLocation(String hubLocation) {
        this.hubLocation = hubLocation;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }


    public HubRate() {}

    public HubRate(String hubLocation, Double rate) {
        this.hubLocation = hubLocation;
        this.rate = rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
