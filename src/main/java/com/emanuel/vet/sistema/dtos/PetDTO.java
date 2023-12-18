package com.emanuel.vet.sistema.dtos;

import com.emanuel.vet.sistema.domains.owner.Owner;
import com.emanuel.vet.sistema.domains.pet.enums.Species;

public record PetDTO(Owner owner, String name, Species species, String birthDate) {
}
