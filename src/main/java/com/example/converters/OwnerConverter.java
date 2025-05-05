package com.example.converters;

import com.example.dto.OwnerDto;
import com.example.dto.PropertyDto;
import com.example.entity.Owner;
import com.example.entity.Property;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerConverter {
    private final ContactConverter contactConverter = new ContactConverter();
    private final PropertyConverter propertyConverter = new PropertyConverter();

    public Owner toEntity(OwnerDto ownerDto) {
        List<Property> propertyList = new ArrayList<>();
        if (ownerDto.getProperties() != null && !ownerDto.getProperties().isEmpty()) {
            ownerDto.getProperties().forEach(propertyDto -> {
                propertyList.add(propertyConverter.toEntity(propertyDto));
            });
        }

        Owner owner = new Owner();
        owner.setAccountNumber(ownerDto.getAccountNumber());
        owner.setLicenceNumber(ownerDto.getLicenceNumber());
        owner.setProperties(propertyList);
        owner.setAge(ownerDto.getAge());
        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        owner.setContact(contactConverter.toEntity(ownerDto.getContact()));
        return owner;
    }

    public OwnerDto toDto(Owner owner) {
        List<PropertyDto> propertyDtos = new ArrayList<>();

        owner.getProperties().forEach(property -> {
            propertyDtos.add(propertyConverter.toDto(property));
        });

        OwnerDto ownerDto = new OwnerDto(
                owner.getFirstName(),
                owner.getLastName(),
                owner.getAge(),
                contactConverter.toDto(owner.getContact()),
                owner.getLicenceNumber(),
                owner.getAccountNumber(),
                propertyDtos
                //owner.getProperties().stream().map(propertyConverter::toDto).toList()
        );
        return ownerDto;
    }

}
