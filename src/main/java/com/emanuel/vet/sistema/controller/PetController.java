package com.emanuel.vet.sistema.controller;

import com.emanuel.vet.sistema.domains.owner.Owner;
import com.emanuel.vet.sistema.domains.pet.Pet;
import com.emanuel.vet.sistema.dtos.PetDTO;
import com.emanuel.vet.sistema.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/newpet")
    public ResponseEntity<Pet> createPet(@RequestBody @Valid PetDTO pet) throws Exception {

        Pet newPet = this.petService.createPet(pet);

        return new ResponseEntity<>(newPet, HttpStatus.CREATED);
    }

    @GetMapping("/allpets")
    public ResponseEntity<Pet> getAllPets(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<Pet> allPets = this.petService.findAllPets(pageable);

        return new ResponseEntity(allPets, HttpStatus.OK);
    }

    @GetMapping("/findpet/{id}")
    public ResponseEntity<Pet> getById(@PathVariable(value = "id")Long id) throws Exception {

        Optional<Pet> petsById = this.petService.findById(id);

        return new ResponseEntity(petsById, HttpStatus.OK);
    }
}
