package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.HoursDTO;
import com.vetconnect.vetconnect.dto.ServiceDTO;
import com.vetconnect.vetconnect.dto.VetCenterDTO;
import com.vetconnect.vetconnect.entities.Hours;
import com.vetconnect.vetconnect.entities.VetCenter;
import com.vetconnect.vetconnect.repositories.VetCenterRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VetCenterService {
    private final VetCenterRepository repository;

    public VetCenterService(VetCenterRepository repository) {
        this.repository = repository;
    }

    public List<VetCenterDTO> getAllVetCenters() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VetCenterDTO saveVetCenter(VetCenterDTO vetCenterDTO) {
        VetCenter vetCenter = convertToEntity(vetCenterDTO);
        return convertToDTO(repository.save(vetCenter));
    }

    public VetCenterDTO updateVetCenter(VetCenterDTO vetCenterDTO) {
        Optional<VetCenter> existingVetCenter = repository.findById(vetCenterDTO.getId());

        if (existingVetCenter.isPresent()) {
            VetCenter vetCenter = existingVetCenter.get();
            vetCenter.setUserId(vetCenterDTO.getUserId());
            vetCenter.setName(vetCenterDTO.getName());
            vetCenter.setEmail(vetCenterDTO.getEmail());
            vetCenter.setPassword(vetCenterDTO.getPassword());
            vetCenter.setImageProfile(vetCenterDTO.getImageProfile());
            vetCenter.setDescription(vetCenterDTO.getDescription());
            vetCenter.setLocation(vetCenterDTO.getLocation());
            vetCenter.setServices(vetCenterDTO.getServices().stream().map(this::convertToEntity).collect(Collectors.toList()));
            vetCenter.setSamplePhotos(vetCenterDTO.getSamplePhotos());
            vetCenter.setHours(vetCenterDTO.getHours());

            return convertToDTO(repository.save(vetCenter));
        } else {
            throw new RuntimeException("VetCenter with ID " + vetCenterDTO.getId() + " not found.");
        }
    }

    public void deleteVetCenter(Long id) {
        repository.deleteById(id);
    }

    private VetCenterDTO convertToDTO(VetCenter vetCenter) {
        VetCenterDTO dto = new VetCenterDTO();
        dto.setId(vetCenter.getId());
        dto.setUserId(vetCenter.getUserId());
        dto.setName(vetCenter.getName());
        dto.setEmail(vetCenter.getEmail());
        dto.setPassword(vetCenter.getPassword());
        dto.setImageProfile(vetCenter.getImageProfile());
        dto.setDescription(vetCenter.getDescription());
        dto.setLocation(vetCenter.getLocation());
        dto.setServices(vetCenter.getServices().stream().map(this::convertToDTO).collect(Collectors.toList()));
        dto.setSamplePhotos(vetCenter.getSamplePhotos());
        dto.setHours(vetCenter.getHours());
        return dto;
    }

    private VetCenter convertToEntity(VetCenterDTO dto) {
        VetCenter vetCenter = new VetCenter();
        vetCenter.setId(dto.getId());
        vetCenter.setUserId(dto.getUserId());
        vetCenter.setName(dto.getName());
        vetCenter.setEmail(dto.getEmail());
        vetCenter.setPassword(dto.getPassword());
        vetCenter.setImageProfile(dto.getImageProfile());
        vetCenter.setDescription(dto.getDescription());
        vetCenter.setLocation(dto.getLocation());
        vetCenter.setServices(dto.getServices().stream().map(this::convertToEntity).collect(Collectors.toList()));
        vetCenter.setSamplePhotos(dto.getSamplePhotos());
        vetCenter.setHours(dto.getHours());
        return vetCenter;
    }

    private ServiceDTO convertToDTO(com.vetconnect.vetconnect.entities.Service service) {
        ServiceDTO dto = new ServiceDTO();
        dto.setName(service.getName());
        dto.setPrice(service.getPrice());
        return dto;
    }

    private com.vetconnect.vetconnect.entities.Service convertToEntity(ServiceDTO dto) {
        com.vetconnect.vetconnect.entities.Service service = new com.vetconnect.vetconnect.entities.Service();
        service.setName(dto.getName());
        service.setPrice(dto.getPrice());
        return service;
    }
}