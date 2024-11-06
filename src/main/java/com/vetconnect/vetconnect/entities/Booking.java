package com.vetconnect.vetconnect.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long petOwnerId;
    private Long vetCenterId;
    private String serviceType;
    private LocalDateTime appointmentDateTime;
    private String additionalInfo;
    private Double price;
    private LocalDateTime bookingDate;
}