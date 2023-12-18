package com.emanuel.vet.sistema.repositories;

import com.emanuel.vet.sistema.domains.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
