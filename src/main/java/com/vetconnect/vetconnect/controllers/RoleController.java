package com.vetconnect.vetconnect.controllers;

import com.vetconnect.vetconnect.dto.RoleDTO;
import com.vetconnect.vetconnect.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return service.getAllRoles();
    }

    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable Long id) {
        return service.getRoleById(id);
    }

    @PostMapping
    public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
        return service.saveRole(roleDTO);
    }

    @PutMapping("/{id}")
    public RoleDTO updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        return service.updateRole(id, roleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        service.deleteRole(id);
    }
}
