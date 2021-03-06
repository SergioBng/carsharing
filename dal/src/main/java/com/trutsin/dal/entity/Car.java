package com.trutsin.dal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) &&
                Objects.equals(tripList, car.tripList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, tripList);
    }
}
