package com.vetconnect.vetconnect.dto;

import lombok.Data;

@Data
public class ReviewDTO {

    private Long id;
    private Long vetCenterId;
    private Long petOwnerId;
    private int rating;
    private String comments;
}
