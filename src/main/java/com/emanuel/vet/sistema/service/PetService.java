package com.emanuel.vet.sistema.service;

import com.emanuel.vet.sistema.domains.pet.Pet;
import com.emanuel.vet.sistema.dtos.PetDTO;
import com.emanuel.vet.sistema.repositories.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Transactional
    public void savePet(Pet pet){
        this.petRepository.save(pet);
    }

    @Transactional
    public void deletePet(Pet pet){
        this.petRepository.delete(pet);
    }

    public Pet createPet(PetDTO petDTO){

        var pet = new Pet(petDTO);

        savePet(pet);

        return pet;
    }

    public Page<Pet> findAllMunicipios(Pageable pageable){
        return this.petRepository.findAll(pageable);
    }

    public Optional<Pet> findById(Long id){
        return this.petRepository.findById(id);
    }
}
