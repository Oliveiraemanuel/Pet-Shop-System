package com.emanuel.vet.sistema.domains.owner;

import com.emanuel.vet.sistema.domains.pet.Pet;
import com.emanuel.vet.sistema.dtos.OwnerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "owners")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    private String lastName;

    private String adress;

    private String city;

    private String houseNumber;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "pet_id")
    private List<Pet> pets;

    public Owner(OwnerDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.adress = data.adress();
        this.city = data.city();
        this.houseNumber = data.houseNumber();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
    }
}