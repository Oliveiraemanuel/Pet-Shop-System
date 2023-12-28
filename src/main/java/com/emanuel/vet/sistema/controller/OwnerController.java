package com.emanuel.vet.sistema.controller;

import com.emanuel.vet.sistema.domains.owner.Owner;
import com.emanuel.vet.sistema.dtos.OwnerDTO;
import com.emanuel.vet.sistema.service.OwnerService;
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
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/newowner")
    public ResponseEntity<Owner> createOwner(@RequestBody @Valid OwnerDTO data){

        var newOwner = this.ownerService.createOwner(data);

        return new ResponseEntity<>(newOwner, HttpStatus.CREATED);
    }

    @GetMapping("/allowners")
    public ResponseEntity<Owner> getAllOwners(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<Owner> allOwners = this.ownerService.findAllOwners(pageable);

        return new ResponseEntity(allOwners, HttpStatus.OK);
    }

    @GetMapping("/findowner/{id}")
    public ResponseEntity<Owner> getById(@PathVariable(value = "id")Long id) throws Exception {

        Owner ownerById = this.ownerService.findById(id);

        return new ResponseEntity(ownerById, HttpStatus.OK);
    }
}
