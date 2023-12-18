package com.emanuel.vet.sistema.domains.owner;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "owners")
@Getter
@Setter
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
}
