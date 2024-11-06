package com.vetconnect.vetconnect.controllers;

import com.vetconnect.vetconnect.dto.BookingDTO;
import com.vetconnect.vetconnect.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    /**
     * Obtiene todas las reservas.
     */
    @GetMapping
    public List<BookingDTO> getAllBookings() {
        return service.getAllBookings();
    }

    /**
     * Crea una nueva reserva.
     */
    @PostMapping
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        return service.saveBooking(bookingDTO);
    }

    /**
     * Obtiene una reserva por su ID.
     */
    @GetMapping("/{id}")
    public BookingDTO getBookingById(@PathVariable Long id) {
        return service.getBookingById(id);
    }

    /**
     * Actualiza una reserva existente.
     */
    @PutMapping("/{id}")
    public BookingDTO updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        return service.updateBooking(id, bookingDTO);
    }

    /**
     * Elimina una reserva por su ID.
     */
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        service.deleteBooking(id);
    }
}
