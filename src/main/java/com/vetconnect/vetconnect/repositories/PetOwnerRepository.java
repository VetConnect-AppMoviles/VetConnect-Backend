package com.vetconnect.vetconnect.repositories;

import com.vetconnect.vetconnect.entities.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {
}
