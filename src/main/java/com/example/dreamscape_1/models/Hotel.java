package com.example.dreamscape_1.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private float pricePerNight;
    private String imageUrl;
    private String city;

    public Hotel() {}

    public Hotel(Long id, String name, float pricePerNight, String city, String imageUrl) {
        this.id = id;
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.city = city;
        this.imageUrl = imageUrl;
    }
}
