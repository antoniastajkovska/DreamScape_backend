package com.example.dreamscape_1.service;

import com.example.dreamscape_1.models.Booking;
import com.example.dreamscape_1.models.Flight;
import com.example.dreamscape_1.models.Hotel;
import com.example.dreamscape_1.models.Taxi;

import java.time.LocalDate;
import java.util.List;

public interface TravelService {
    List<Flight> searchFlights(String fromCity, String toCity, LocalDate departureDate);
    List<Hotel> searchHotels(String city);
    List<Taxi> getAllTaxis();
    Flight getFlightById(Long id);
    Hotel getHotelById(Long id);
    Taxi getTaxiById(Long id);
    Booking createBooking(Booking booking);
    List<Booking> getUserBookings(String username);

}
