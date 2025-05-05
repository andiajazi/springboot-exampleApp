package com.example.controller;


import com.example.dto.OwnerDto;
import com.example.entity.Owner;
import com.example.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/owner/")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public void saveOwner(@RequestBody @Valid OwnerDto ownerDto) {
        ownerService.addOwner(ownerDto);
    }

    @GetMapping
    public List<OwnerDto> getOwners(OwnerDto ownerDto) {
        return ownerService.getOwners();
    }

    @GetMapping("{id}")
    public OwnerDto getOwnerById(@PathVariable("ownerId") Integer ownerId) {
        return ownerService.getOwnerById(ownerId);
    }

    @PutMapping("id/{id}")
    public void updateOwner(@PathVariable("ownerId") Integer ownerId,
                            @RequestBody @Valid OwnerDto ownerDto) {
        ownerService.updateOwner(ownerId,ownerDto);
    }



}
