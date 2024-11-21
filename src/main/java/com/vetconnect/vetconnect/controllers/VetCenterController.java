package com.vetconnect.vetconnect.controllers;

import com.vetconnect.vetconnect.dto.VetCenterDTO;
import com.vetconnect.vetconnect.services.VetCenterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vet-centers")
public class VetCenterController {
    private final VetCenterService service;

    public VetCenterController(VetCenterService service) {
        this.service = service;
    }

    @GetMapping
    public List<VetCenterDTO> getAllVetCenters() {
        return service.getAllVetCenters();
    }

    @PostMapping
    public VetCenterDTO createVetCenter(@RequestBody VetCenterDTO vetCenterDTO) {
        return service.saveVetCenter(vetCenterDTO);
    }

    @PatchMapping("/{id}")
    public VetCenterDTO updateVetCenter(@PathVariable Long id, @RequestBody VetCenterDTO vetCenterDTO) {
        vetCenterDTO.setId(id);
        return service.updateVetCenter(vetCenterDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVetCenter(@PathVariable Long id) {
        service.deleteVetCenter(id);
    }
}