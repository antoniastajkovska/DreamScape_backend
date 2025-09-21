package com.example.dreamscape_1.web.controller;


import com.example.dreamscape_1.models.Booking;
import com.example.dreamscape_1.models.Flight;
import com.example.dreamscape_1.models.Hotel;
import com.example.dreamscape_1.models.Taxi;
import com.example.dreamscape_1.service.TravelService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/travel")
@CrossOrigin(origins = {"*"}, allowCredentials = "false")
public class TravelController {
    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam(required = false) String fromCity,
            @RequestParam(required = false) String toCity,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {

        System.out.println("=== TRAVEL CONTROLLER ===");
        System.out.println("Request params: fromCity=" + fromCity + ", toCity=" + toCity + ", departureDate=" + departureDate);

        List<Flight> flights = travelService.searchFlights(fromCity, toCity, departureDate);

        System.out.println("Returning " + flights.size() + " flights to frontend");
        flights.forEach(flight ->
                System.out.println("  - " + flight.getFromCity() + " → " + flight.getToCity() + " ($" + flight.getBasePrice() + ")")
        );

        return ResponseEntity.ok(flights);
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
        Flight flight = travelService.getFlightById(id);
        if (flight == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> searchHotels(@RequestParam(required = false) String city) {
        List<Hotel> hotels = travelService.searchHotels(city);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id) {
        Hotel hotel = travelService.getHotelById(id);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/taxis")
    public ResponseEntity<List<Taxi>> getAllTaxis() {
        List<Taxi> taxis = travelService.getAllTaxis();
        return ResponseEntity.ok(taxis);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createdBooking = travelService.createBooking(booking);
        return ResponseEntity.ok(createdBooking);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getUserBookings(@RequestParam String userEmail) {
        List<Booking> bookings = travelService.getUserBookings(userEmail);
        return ResponseEntity.ok(bookings);
    }
}
