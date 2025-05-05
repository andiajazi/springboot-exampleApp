package com.example.controller;

import com.example.dto.ContactDto;
import com.example.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contact/")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDto> getContacts() {
        return contactService.getContacts();
    }

    @GetMapping("email/{email}")
    public ContactDto getContactByEmail(@PathVariable("email") String email) {
        return contactService.getContactByEmail(email);
    }

    @GetMapping("id/{contact_Id}")
    public ContactDto getContactById(@PathVariable("contact_Id") Integer contactId) {
        return contactService.getContactById(contactId);
    }

    @DeleteMapping("{contactId}")
    public void deleteContact(@PathVariable("contactId") Integer id){
        contactService.deleteContact(id);
    }

    @PutMapping("id/{contact_id}")
    public void updateContact(@PathVariable("contact_id") Integer contactId,
                              @RequestBody @Valid ContactDto contactDto) {
        contactService.updateContact(contactId, contactDto);
    }

}
