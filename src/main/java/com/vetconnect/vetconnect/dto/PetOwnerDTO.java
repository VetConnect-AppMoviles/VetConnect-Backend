package com.vetconnect.vetconnect.dto;

import lombok.Data;

@Data
public class PetOwnerDTO {
    private Long id;
    private Long userId;
    private String photo;
    private String address;
    private String phone;
}