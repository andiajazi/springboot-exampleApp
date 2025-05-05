package com.example.service;

import com.example.converters.ContactConverter;
import com.example.dto.ContactDto;
import com.example.dto.CustomerDto;
import com.example.entity.Contact;
import com.example.repository.ContactRepository;
import com.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactConverter contactConverter;
    private final CustomerRepository customerRepository;

    public ContactService(ContactRepository contactRepository, ContactConverter contactConverter, CustomerRepository customerRepository) {
        this.contactRepository = contactRepository;
        this.contactConverter = contactConverter;
        this.customerRepository = customerRepository;
    }

    public List<ContactDto> getContacts() {
        List<Contact> contactsFromDB = contactRepository.findAll();
        List<ContactDto> dtos = new ArrayList<>();

        contactsFromDB.forEach(contact -> {
            ContactDto cdto = new ContactDto(
                    contact.getEmail(),
                    contact.getPhone(),
                    contact.getCity(),
                    contact.getAddress()
            );
            dtos.add(cdto);
        });

//        return contactRepository.findAll().stream().map(c -> new ContactDto(
//                c.getEmail(),
//                c.getPhone(),
//                c.getCity(),
//                c.getAddress()
//        )).toList();

        return dtos;
    }

    public void updateContact(Integer id, ContactDto contactDto) {
        Contact contact = contactRepository.findById(id).orElseThrow(
                () -> new RuntimeException("There is no contact with this id: +" + id)
        );

        if (contactDto.address() != null) {
            contact.setAddress(contactDto.address());
        }

        if (contactDto.city() != null) {
            contact.setCity(contactDto.city());
        }

        if (contactDto.phone() != null) {
            contact.setPhone(contactDto.phone());
        }

        if (contactDto.email() != null) {
            contact.setEmail(contactDto.email());
        }

        contactRepository.save(contact);

//        if (customerDto.getContact() != null && customerDto.getContact().email() != null) {
//            if(contactRepository.findByEmail(customerDto.getContact().email()).isPresent()) {
//                throw new RuntimeException("This email already exists!");
//            }
//            contact.setEmail(customerDto.getContact().email());
//        }
//
//        if (customerDto.getContact() != null && customerDto.getContact().phone() != null) {
//            contact.setPhone(customerDto.getContact().phone());
//        }
//
//        if (customerDto.getContact() != null && customerDto.getContact().city() != null) {
//            contact.setCity(customerDto.getContact().city());
//        }
//
//        if (customerDto.getContact() != null && customerDto.getContact().address() != null) {
//            contact.setAddress(customerDto.getContact().address());
//        }

    }

    public ContactDto getContactById(Integer id) {
        return contactRepository.findById(id).map(contactConverter::toDto).orElseThrow(
                () -> new RuntimeException("Could not find a contact with the id: " +id)
        );
    }

    public ContactDto getContactByEmail(String email) {
        return contactRepository.findByEmail(email).map(contactConverter::toDto).orElseThrow(
                () -> new RuntimeException("Could not find a contact with this email: " + email)
        );
    }

    public void deleteContact(Integer id){
        contactRepository.deleteById(id);
    }

}
