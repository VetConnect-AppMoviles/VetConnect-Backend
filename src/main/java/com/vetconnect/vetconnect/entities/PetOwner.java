package com.vetconnect.vetconnect.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PetOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String photo;
    private String address;
    private String phone;
}
