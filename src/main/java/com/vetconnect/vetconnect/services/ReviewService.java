package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.ReviewDTO;
import com.vetconnect.vetconnect.entities.Review;
import com.vetconnect.vetconnect.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Obtener todas las reseñas
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Crear una nueva reseña
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setVetCenterId(reviewDTO.getVetCenterId());
        review.setPetOwnerId(reviewDTO.getPetOwnerId());
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());

        review = reviewRepository.save(review);
        return convertToDTO(review);
    }

    // Actualizar una reseña existente
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setVetCenterId(reviewDTO.getVetCenterId());
        review.setPetOwnerId(reviewDTO.getPetOwnerId());
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());

        review = reviewRepository.save(review);
        return convertToDTO(review);
    }

    // Eliminar una reseña
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found");
        }
        reviewRepository.deleteById(id);
    }

    // Convertir entidad a DTO
    private ReviewDTO convertToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setVetCenterId(review.getVetCenterId());
        dto.setPetOwnerId(review.getPetOwnerId());
        dto.setRating(review.getRating());
        dto.setComments(review.getComments());
        return dto;
    }
}
