package com.vetconnect.vetconnect.controllers;

import com.vetconnect.vetconnect.dto.PetOwnerDTO;
import com.vetconnect.vetconnect.services.PetOwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet-owners")
public class PetOwnerController {
    private final PetOwnerService service;

    public PetOwnerController(PetOwnerService service) {
        this.service = service;
    }

    @GetMapping
    public List<PetOwnerDTO> getAllPetOwners() {
        return service.getAllPetOwners();
    }

    @PostMapping
    public PetOwnerDTO createPetOwner(@RequestBody PetOwnerDTO petOwnerDTO) {
        return service.savePetOwner(petOwnerDTO);
    }

    @PatchMapping("/{id}")
    public PetOwnerDTO updatePetOwner(@PathVariable Long id, @RequestBody PetOwnerDTO petOwnerDTO) {
        petOwnerDTO.setId(id);
        return service.updatePetOwner(petOwnerDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePetOwner(@PathVariable Long id) {
        service.deletePetOwner(id);
    }

}
