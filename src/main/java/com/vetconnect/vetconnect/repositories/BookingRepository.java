package com.vetconnect.vetconnect.repositories;

import com.vetconnect.vetconnect.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
