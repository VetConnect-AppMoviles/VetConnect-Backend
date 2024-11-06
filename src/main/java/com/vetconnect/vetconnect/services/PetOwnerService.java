package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.PetOwnerDTO;
import com.vetconnect.vetconnect.entities.PetOwner;
import com.vetconnect.vetconnect.repositories.PetOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetOwnerService {
    private final PetOwnerRepository repository;

    public PetOwnerService(PetOwnerRepository repository) {
        this.repository = repository;
    }

    public List<PetOwnerDTO> getAllPetOwners() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PetOwnerDTO savePetOwner(PetOwnerDTO petOwnerDTO) {
        PetOwner petOwner = convertToEntity(petOwnerDTO);
        return convertToDTO(repository.save(petOwner));
    }

    private PetOwnerDTO convertToDTO(PetOwner petOwner) {
        PetOwnerDTO dto = new PetOwnerDTO();
        dto.setId(petOwner.getId());
        dto.setUserId(petOwner.getUserId());
        dto.setPhoto(petOwner.getPhoto());
        dto.setAddress(petOwner.getAddress());
        dto.setPhone(petOwner.getPhone());
        return dto;
    }

    private PetOwner convertToEntity(PetOwnerDTO dto) {
        PetOwner petOwner = new PetOwner();
        petOwner.setId(dto.getId());
        petOwner.setUserId(dto.getUserId());
        petOwner.setPhoto(dto.getPhoto());
        petOwner.setAddress(dto.getAddress());
        petOwner.setPhone(dto.getPhone());
        return petOwner;
    }
}
