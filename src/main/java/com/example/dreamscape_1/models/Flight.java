package com.example.dreamscape_1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float basePrice;
    private String imageUrl;
    private String fromCity;
    private String toCity;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    public Flight() {}

    public Flight(Long id, String fromCity, String toCity, float price, String imageUrl, LocalDate departureDate) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.basePrice = price;
        this.imageUrl = imageUrl;
        this.departureDate = departureDate;
    }
}