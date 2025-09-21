package com.example.dreamscape_1.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "taxis")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String provider;
    private String type;
    private float price;
    private String imageUrl;
    private String estimatedTime;

    public Taxi() {}

    public Taxi(Long id, String provider, String type, float price, String imageUrl, String estimatedTime) {
        this.id = id;
        this.provider = provider;
        this.type = type;
        this.price = price;
        this.imageUrl = imageUrl;
        this.estimatedTime = estimatedTime;
    }
}
