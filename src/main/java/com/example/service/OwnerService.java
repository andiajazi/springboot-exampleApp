package com.example.service;

import com.example.converters.ContactConverter;
import com.example.converters.OwnerConverter;
import com.example.converters.PropertyConverter;
import com.example.dto.ContactDto;
import com.example.dto.OwnerDto;
import com.example.entity.Contact;
import com.example.entity.Owner;
import com.example.entity.Property;
import com.example.repository.OwnerRepository;
import com.example.repository.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PropertyRepository propertyRepository;
    private final OwnerConverter ownerConverter;
    private final PropertyConverter propertyConverter;
    private final ContactConverter contactConverter;


    public OwnerService(OwnerRepository ownerRepository, PropertyRepository propertyRepository, OwnerConverter ownerConverter, PropertyConverter propertyConverter, ContactConverter contactConverter) {
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
        this.ownerConverter = ownerConverter;
        this.propertyConverter = propertyConverter;
        this.contactConverter = contactConverter;
    }

    public List<OwnerDto> getOwners() {
        return ownerRepository.findAll().stream().map(ownerConverter::toDto).toList();
    }

    public OwnerDto getOwnerById(Integer id) {
        return ownerRepository.findById(id).map(ownerConverter::toDto).orElseThrow(
                () -> new RuntimeException("Could not find Owner with id: " +id)
        );
    }

    public void deleteOwner(Integer id) {
        ownerRepository.deleteById(id);
    }

    public void addOwner(OwnerDto ownerDto) {
        ownerRepository.save(ownerConverter.toEntity(ownerDto));
    }

    public void updateOwner(Integer id, OwnerDto ownerDto) {
        Owner owner = ownerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Could not find owner with id: " + id)
        );

        Property property = propertyRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Could not find a property with this id: " + id)
        );

        if (ownerDto.getAccountNumber() != null) {
            owner.setAccountNumber(ownerDto.getAccountNumber());
        }

        if (ownerDto.getLicenceNumber() != null) {
            owner.setLicenceNumber(ownerDto.getLicenceNumber());
        }

        if (ownerDto.getFirstName() != null) {
            owner.setFirstName(ownerDto.getFirstName());
        }

        if (ownerDto.getLastName() != null) {
            owner.setLastName(ownerDto.getLastName());
        }

        if (ownerDto.getAge() != null) {
            owner.setAge(ownerDto.getAge());
        }

//        if (ownerDto.getContact() != null && ownerDto.getContact().email() != null) {
//            owner.setContact(contactConverter.toEntity(contactDto));
//        }

//        if (ownerDto.getContact() != null && ownerDto.getContact().email() != null) {
//            Contact contact = new Contact();
//            contact.setEmail(ownerDto.getContact().email());
//            owner.setContact(contact);
//        }

    }

    public void deleteOwnerById(Integer ownerId) {
        ownerRepository.deleteById(ownerId);
        propertyRepository.deleteById(ownerId);
    }

}