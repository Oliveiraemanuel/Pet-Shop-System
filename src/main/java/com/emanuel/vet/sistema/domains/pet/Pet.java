package com.emanuel.vet.sistema.domains.pet;

import com.emanuel.vet.sistema.domains.owner.Owner;
import com.emanuel.vet.sistema.domains.pet.enums.Species;
import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "owner_id")
    private Owner owner;

    private String name;

    private Species species;

    private String birthDate;
}
