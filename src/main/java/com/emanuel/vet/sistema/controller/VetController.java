package com.emanuel.vet.sistema.controller;

import com.emanuel.vet.sistema.domains.vet.Vet;
import com.emanuel.vet.sistema.dtos.VetDTO;
import com.emanuel.vet.sistema.service.VetService;
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
@RequestMapping("/veterinario")
public class VetController {

    @Autowired
    private VetService vetService;

    @PostMapping("/newvet")
    public ResponseEntity<Vet> createVet(@RequestBody @Valid VetDTO data){

        var newVet = this.vetService.createVet(data);

        return new ResponseEntity<>(newVet, HttpStatus.CREATED);
    }

    @GetMapping("/allvets")
    public ResponseEntity<Vet> getAllVets(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){

        Page<Vet> allVets = this.vetService.findAllVets(pageable);

        return new ResponseEntity(allVets, HttpStatus.OK);
    }

    @GetMapping("/findvet/{id}")
    public ResponseEntity<Vet> getById(@PathVariable(value = "id")Long id) throws Exception {

        Optional<Vet> vetById = this.vetService.findById(id);

        return new ResponseEntity(vetById, HttpStatus.OK);
    }
}
