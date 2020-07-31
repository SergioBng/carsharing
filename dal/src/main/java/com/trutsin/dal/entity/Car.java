package com.trutsin.dal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String model;

    @OneToMany(mappedBy = "car")
    private List<Trip> tripList = new ArrayList<>();

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public Car(String model, List<Trip> tripList) {
        this.model = model;
        this.tripList = tripList;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", tripList=" + tripList +
                '}';
    }
}
