package com.vetconnect.vetconnect.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long id;
    private Long petOwnerId;
    private Long vetCenterId;
    private String serviceType;
    private LocalDateTime appointmentDateTime;
    private String additionalInfo;
    private Double price;
    private LocalDateTime bookingDate;
}