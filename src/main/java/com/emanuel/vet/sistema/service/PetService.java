package com.emanuel.vet.sistema.service;

import com.emanuel.vet.sistema.domains.owner.Owner;
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

    @Autowired
    private OwnerService ownerService;

    @Transactional
    public void savePet(Pet pet){
        this.petRepository.save(pet);
    }

    @Transactional
    public void deletePet(Pet pet){
        this.petRepository.delete(pet);
    }

    public Pet createPet(PetDTO pet) throws Exception {

        Owner owner = ownerService.findById(pet.ownerId());

        var newPet = new Pet();
        newPet.setOwner(owner);
        newPet.setName(pet.name());
        newPet.setSpecies(pet.species());
        newPet.setBirthDate(pet.birthDate());

        savePet(newPet);

        return newPet;
    }

    public Page<Pet> findAllPets(Pageable pageable){
        return this.petRepository.findAll(pageable);
    }

    public Optional<Pet> findById(Long id) throws Exception {
        return Optional.ofNullable(this.petRepository.findById(id).orElseThrow(() -> new Exception("Id não encontrado")));
    }
}
