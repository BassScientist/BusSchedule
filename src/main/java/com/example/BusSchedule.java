package com.example;




import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus_timetable")
public class BusSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "price")
    private Double price;

    @Column(name = "origin_city")
    private String originCity;

    @Column(name = "destination_city")
    private String destinationCity;

    public BusSchedule() {
    }

    public BusSchedule(String departureTime, String arrivalTime, Double price) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    // Hashcode and equals

    @Override
    public int hashCode() {
        return Objects.hash(departureTime, arrivalTime, price, originCity, destinationCity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        BusSchedule other = (BusSchedule) obj;
        return Objects.equals(departureTime, other.departureTime) && Objects.equals(arrivalTime, other.arrivalTime)
                && Objects.equals(price, other.price) && Objects.equals(originCity, other.originCity)
                && Objects.equals(destinationCity, other.destinationCity);
    }

}

