package com.klef.fsad.exam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "hotel_table")
public class Hotel {

    @Id
    @Column(name = "hotel_id", nullable = false)
    private Long hotelId;

    @Column(name = "hotel_name", nullable = false)
    private String name;

    @Column(name = "hotel_date")
    private LocalDate date;

    @Column(name = "hotel_status")
    private String status;

    @Column(name = "hotel_location")
    private String location;

    @Column(name = "hotel_rating")
    private Double rating;

    // Getters and Setters
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
