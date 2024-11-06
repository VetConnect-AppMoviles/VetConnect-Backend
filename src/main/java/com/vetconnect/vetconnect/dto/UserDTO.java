package com.vetconnect.vetconnect.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Long roleId;
}
