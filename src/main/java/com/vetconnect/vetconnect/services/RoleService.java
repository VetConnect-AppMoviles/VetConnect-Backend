package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.RoleDTO;
import com.vetconnect.vetconnect.entities.Role;
import com.vetconnect.vetconnect.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<RoleDTO> getAllRoles() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO getRoleById(Long id) {
        Optional<Role> role = repository.findById(id);
        if (role.isPresent()) {
            return convertToDTO(role.get());
        } else {
            throw new RuntimeException("Role con ID " + id + " no encontrado.");
        }
    }

    public RoleDTO saveRole(RoleDTO roleDTO) {
        Role role = convertToEntity(roleDTO);
        return convertToDTO(repository.save(role));
    }

    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        Optional<Role> existingRole = repository.findById(id);
        if (existingRole.isPresent()) {
            Role role = existingRole.get();
            role.setName(roleDTO.getName());
            return convertToDTO(repository.save(role));
        } else {
            throw new RuntimeException("Role con ID " + id + " no encontrado.");
        }
    }

    public void deleteRole(Long id) {
        repository.deleteById(id);
    }

    private RoleDTO convertToDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    private Role convertToEntity(RoleDTO dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
