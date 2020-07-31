package com.trutsin.dal.entity;

import javax.persistence.*;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private int time;

    @Column
    private double cost;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Trip(int time, double cost, String status, User user, Car car) {
        this.time = time;
        this.cost = cost;
        this.status = status;
        this.user = user;
        this.car = car;
    }

    public Trip(int time, double cost, String status) {
        this.time = time;
        this.cost = cost;
        this.status = status;
    }

    public Trip() {
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", time=" + time +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", user=" + user.toString() +
                ", car=" + car.toString() +
                '}';
    }
}
