package com.example.dreamscape_1.service.impl;

import com.example.dreamscape_1.models.Booking;
import com.example.dreamscape_1.models.Flight;
import com.example.dreamscape_1.models.Hotel;
import com.example.dreamscape_1.models.Taxi;
import com.example.dreamscape_1.repository.BookingRepository;
import com.example.dreamscape_1.repository.FlightRepository;
import com.example.dreamscape_1.repository.HotelRepository;
import com.example.dreamscape_1.repository.TaxiRepository;
import com.example.dreamscape_1.service.TravelService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelServiceImpl implements TravelService {

    private final FlightRepository flightRepository;
    private final HotelRepository hotelRepository;
    private final TaxiRepository taxiRepository;
    private final BookingRepository bookingRepository;

    public TravelServiceImpl(FlightRepository flightRepository, HotelRepository hotelRepository, TaxiRepository taxiRepository, BookingRepository bookingRepository) {
        this.flightRepository = flightRepository;
        this.hotelRepository = hotelRepository;
        this.taxiRepository = taxiRepository;
        this.bookingRepository = bookingRepository;
    }

    @PostConstruct
    public void initializeData() {
        System.out.println("=== CHECKING DATABASE DATA ===");
        System.out.println("Flights in DB: " + flightRepository.count());
        System.out.println("Hotels in DB: " + hotelRepository.count());
        System.out.println("Taxis in DB: " + taxiRepository.count());

        // Show all flights in database
        List<Flight> allFlights = flightRepository.findAll();
        System.out.println("All flights in database:");
        allFlights.forEach(flight ->
                System.out.println("  - ID:" + flight.getId() + " " + flight.getFromCity() + " → " + flight.getToCity() + " ($" + flight.getBasePrice() + ") Date:" + flight.getDepartureDate())
        );
    }

    public List<Flight> searchFlights(String fromCity, String toCity, LocalDate departureDate) {
        System.out.println("=== SEARCH FLIGHTS ===");
        System.out.println("Search params: from=" + fromCity + ", to=" + toCity + ", date=" + departureDate);

        List<Flight> allFlights = flightRepository.findAll();
        System.out.println("Total flights in DB: " + allFlights.size());
        allFlights.forEach(flight ->
                System.out.println("  - " + flight.getFromCity() + " → " + flight.getToCity() + " ($" + flight.getBasePrice() + ")")
        );

        List<Flight> filteredFlights = allFlights.stream()
                .filter(flight -> fromCity == null || flight.getFromCity().equalsIgnoreCase(fromCity))
                .filter(flight -> toCity == null || flight.getToCity().equalsIgnoreCase(toCity))
                .collect(Collectors.toList());

        System.out.println("Filtered flights: " + filteredFlights.size());
        filteredFlights.forEach(flight ->
                System.out.println("  - " + flight.getFromCity() + " → " + flight.getToCity() + " ($" + flight.getBasePrice() + ")")
        );

        return filteredFlights;
    }

    @Override
    public List<Hotel> searchHotels(String city) {
        return hotelRepository.findAll().stream()
                .filter(hotel -> city == null || hotel.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Taxi getTaxiById(Long id) {
        return taxiRepository.findById(id).orElse(null);
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getUserBookings(String username) {
        return bookingRepository.findByUsername(username);
    }
}
