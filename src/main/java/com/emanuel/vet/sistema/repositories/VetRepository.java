package com.emanuel.vet.sistema.repositories;

import com.emanuel.vet.sistema.domains.vet.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
