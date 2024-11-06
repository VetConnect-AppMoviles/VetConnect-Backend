package com.vetconnect.vetconnect.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vet_center_id", nullable = false)
    private Long vetCenterId;

    @Column(name = "pet_owner_id", nullable = false)
    private Long petOwnerId;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comments", length = 500)
    private String comments;
}
