package com.example.converters;

import com.example.dto.ContactDto;
import com.example.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter {

    public Contact toEntity(ContactDto dto) {
        Contact contact = new Contact();
        contact.setEmail(dto.email());
        contact.setCity(dto.city());
        contact.setAddress(dto.address());
        contact.setPhone(dto.phone());
        return contact;
    }

    public ContactDto toDto(Contact entity) {
        return new ContactDto(
                entity.getEmail(),
                entity.getPhone(),
                entity.getCity(),
                entity.getAddress()
        );
    }

}
