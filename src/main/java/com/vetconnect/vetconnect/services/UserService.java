package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.UserDTO;
import com.vetconnect.vetconnect.entities.User;
import com.vetconnect.vetconnect.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> getAllUsers() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return convertToDTO(user.get());
        } else {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado.");
        }
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return convertToDTO(repository.save(user));
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> existingUser = repository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setPhone(userDTO.getPhone());
            user.setRoleId(userDTO.getRoleId());

            return convertToDTO(repository.save(user));
        } else {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado.");
        }
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setPhone(user.getPhone());
        dto.setRoleId(user.getRoleId());
        return dto;
    }

    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setRoleId(dto.getRoleId());
        return user;
    }
}
