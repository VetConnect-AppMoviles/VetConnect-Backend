package com.vetconnect.vetconnect.repositories;

import com.vetconnect.vetconnect.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
