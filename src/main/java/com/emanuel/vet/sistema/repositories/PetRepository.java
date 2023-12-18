package com.emanuel.vet.sistema.repositories;

import com.emanuel.vet.sistema.domains.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
