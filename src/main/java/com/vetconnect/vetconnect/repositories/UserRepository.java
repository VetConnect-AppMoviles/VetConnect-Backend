package com.vetconnect.vetconnect.repositories;

import com.vetconnect.vetconnect.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
