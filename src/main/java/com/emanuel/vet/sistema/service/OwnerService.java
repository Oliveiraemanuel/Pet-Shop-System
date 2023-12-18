package com.emanuel.vet.sistema.service;

import com.emanuel.vet.sistema.domains.owner.Owner;
import com.emanuel.vet.sistema.dtos.OwnerDTO;
import com.emanuel.vet.sistema.repositories.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Transactional
    public void saveOwner(Owner owner){
        this.ownerRepository.save(owner);
    }

    @Transactional
    public void deleteOwner(Owner owner){
        this.ownerRepository.delete(owner);
    }

    public Owner createOwner(OwnerDTO ownerDTO){

        var owner = new Owner(ownerDTO);

        saveOwner(owner);

        return owner;
    }

    public Page<Owner> findAllOwners(Pageable pageable){
        return this.ownerRepository.findAll(pageable);
    }

    public Optional<Owner> findById(Long id) throws Exception {
        return Optional.ofNullable(this.ownerRepository.findById(id).orElseThrow(() -> new Exception("Id não encontrado")));
    }
}