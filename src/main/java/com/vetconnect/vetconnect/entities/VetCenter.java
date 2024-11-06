package com.vetconnect.vetconnect.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class VetCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String email;
    private String password;
    private String imageProfile;
    private String description;
    private String location;

    @ElementCollection
    private List<Service> services;

    @ElementCollection
    private List<String> samplePhotos;

    @ElementCollection
    private List<String> hours;
}