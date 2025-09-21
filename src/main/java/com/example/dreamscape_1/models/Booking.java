package com.example.dreamscape_1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String fromPlace;
    private String toPlace;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private int seniorCount;
    private int adultCount;
    private int childCount;
    private float flightPrice;
    private Long selectedFlightId;
    private String selectedHotel;
    private Long selectedHotelId;
    private float hotelPrice;
    private boolean taxiChosen;
    private Long selectedTaxiId;
    private float taxiPrice;
    private float totalPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bookingDate;

    public Booking() {}
    public Booking(String username, String fromPlace, String toPlace, LocalDate startDate, LocalDate endDate,
                   int seniorCount, int adultCount, int childCount, float flightPrice, Long selectedFlightId,
                   String selectedHotel, Long selectedHotelId, float hotelPrice, boolean taxiChosen,
                   Long selectedTaxiId, float taxiPrice, float totalPrice) {
        this.username = username;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.startDate = startDate;
        this.endDate = endDate;
        this.seniorCount = seniorCount;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.flightPrice = flightPrice;
        this.selectedFlightId = selectedFlightId;
        this.selectedHotel = selectedHotel;
        this.selectedHotelId = selectedHotelId;
        this.hotelPrice = hotelPrice;
        this.taxiChosen = taxiChosen;
        this.selectedTaxiId = selectedTaxiId;
        this.taxiPrice = taxiPrice;
        this.totalPrice = totalPrice;
        this.bookingDate = LocalDateTime.now();
    }

}
