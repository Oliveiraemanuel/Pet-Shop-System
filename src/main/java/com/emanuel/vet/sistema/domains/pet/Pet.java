package com.emanuel.vet.sistema.domains.pet;

import com.emanuel.vet.sistema.domains.owner.Owner;
import com.emanuel.vet.sistema.domains.pet.enums.Species;
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

    private Owner owner;

    private String name;

    private Species species;

    private String birthDate;
}
