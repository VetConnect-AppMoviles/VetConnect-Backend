package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.BookingDTO;
import com.vetconnect.vetconnect.entities.Booking;
import com.vetconnect.vetconnect.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public List<BookingDTO> getAllBookings() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        Booking booking = convertToEntity(bookingDTO);
        return convertToDTO(repository.save(booking));
    }

    public BookingDTO getBookingById(Long id) {
        Optional<Booking> booking = repository.findById(id);
        if (booking.isPresent()) {
            return convertToDTO(booking.get());
        } else {
            throw new RuntimeException("Booking with ID " + id + " not found.");
        }
    }

    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Optional<Booking> existingBooking = repository.findById(id);
        if (existingBooking.isPresent()) {
            Booking booking = existingBooking.get();
            booking.setPetOwnerId(bookingDTO.getPetOwnerId());
            booking.setVetCenterId(bookingDTO.getVetCenterId());
            booking.setServiceType(bookingDTO.getServiceType());
            booking.setAppointmentDateTime(bookingDTO.getAppointmentDateTime());
            booking.setAdditionalInfo(bookingDTO.getAdditionalInfo());
            booking.setPrice(bookingDTO.getPrice());
            booking.setBookingDate(bookingDTO.getBookingDate());

            return convertToDTO(repository.save(booking));
        } else {
            throw new RuntimeException("Booking with ID " + id + " not found.");
        }
    }

    public void deleteBooking(Long id) {
        repository.deleteById(id);
    }

    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setPetOwnerId(booking.getPetOwnerId());
        dto.setVetCenterId(booking.getVetCenterId());
        dto.setServiceType(booking.getServiceType());
        dto.setAppointmentDateTime(booking.getAppointmentDateTime());
        dto.setAdditionalInfo(booking.getAdditionalInfo());
        dto.setPrice(booking.getPrice());
        dto.setBookingDate(booking.getBookingDate());
        return dto;
    }

    private Booking convertToEntity(BookingDTO dto) {
        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setPetOwnerId(dto.getPetOwnerId());
        booking.setVetCenterId(dto.getVetCenterId());
        booking.setServiceType(dto.getServiceType());
        booking.setAppointmentDateTime(dto.getAppointmentDateTime());
        booking.setAdditionalInfo(dto.getAdditionalInfo());
        booking.setPrice(dto.getPrice());
        booking.setBookingDate(dto.getBookingDate());
        return booking;
    }
}