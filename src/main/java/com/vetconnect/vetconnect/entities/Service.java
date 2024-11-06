package com.vetconnect.vetconnect.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Service {
    private String name;
    private Double price;
}