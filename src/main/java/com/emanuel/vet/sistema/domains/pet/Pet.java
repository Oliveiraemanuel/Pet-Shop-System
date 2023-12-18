package com.emanuel.vet.sistema.domains.pet;

import com.emanuel.vet.sistema.domains.owner.Owner;
import com.emanuel.vet.sistema.domains.pet.enums.Species;
import com.emanuel.vet.sistema.dtos.PetDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Owner owner;

    private String name;

    private Species species;

    private String birthDate;

    public Pet(PetDTO data) {
        this.owner = data.owner();
        this.name = data.name();
        this.species = data.species();
        this.birthDate = data.birthDate();
    }
}
