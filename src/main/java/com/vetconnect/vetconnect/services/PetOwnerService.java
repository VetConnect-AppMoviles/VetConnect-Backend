package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.PetOwnerDTO;
import com.vetconnect.vetconnect.entities.PetOwner;
import com.vetconnect.vetconnect.repositories.PetOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    
    public PetOwnerDTO updatePetOwner(PetOwnerDTO petOwnerDTO) {
        Optional<PetOwner> existingPetOwner = repository.findById(petOwnerDTO.getId());

        if (existingPetOwner.isPresent()) {
            PetOwner petOwner = existingPetOwner.get();
            petOwner.setUserId(petOwnerDTO.getUserId());
            petOwner.setPhoto(petOwnerDTO.getPhoto());
            petOwner.setAddress(petOwnerDTO.getAddress());
            petOwner.setPhone(petOwnerDTO.getPhone());

            return convertToDTO(repository.save(petOwner));
        } else {
            throw new RuntimeException("petOwner with ID " + petOwnerDTO.getId() + " not found.");
        }
    }

    public void deletePetOwner(Long id) {
        repository.deleteById(id);
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
