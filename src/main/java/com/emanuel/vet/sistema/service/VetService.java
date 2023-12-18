package com.emanuel.vet.sistema.service;

import com.emanuel.vet.sistema.domains.vet.Vet;
import com.emanuel.vet.sistema.dtos.VetDTO;
import com.emanuel.vet.sistema.repositories.VetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VetService {

    @Autowired
    private VetRepository vetRepository;

    @Transactional
    public void saveVet(Vet vet){
        this.vetRepository.save(vet);
    }

    @Transactional
    public void deleteVet(Vet vet){
        this.vetRepository.delete(vet);
    }

    public Vet createVet(VetDTO vetDTO){

        var vet = new Vet(vetDTO);

        saveVet(vet);

        return vet;
    }

    public Page<Vet> findAllMunicipios(Pageable pageable){
        return this.vetRepository.findAll(pageable);
    }

    public Optional<Vet> findById(Long id){
        return this.vetRepository.findById(id);
    }
}
