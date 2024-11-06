package com.vetconnect.vetconnect.dto;

import lombok.Data;

import java.util.List;

@Data
public class VetCenterDTO {
    private Long id;
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String imageProfile;
    private String description;
    private String location;
    private List<ServiceDTO> services;
    private List<String> samplePhotos;
    private List<String> hours;
}