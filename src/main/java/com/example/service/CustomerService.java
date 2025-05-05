package com.example.service;

import com.example.converters.CustomerConverter;
import com.example.dto.CustomerDto;
import com.example.entity.Contact;
import com.example.entity.Customer;
import com.example.repository.ContactRepository;
import org.springframework.stereotype.Service;
import com.example.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;
    private final CustomerConverter customerConverter;

    public CustomerService(CustomerRepository customerRepository, ContactRepository contactRepository, CustomerConverter customerConverter) {
        this.customerRepository = customerRepository;
        this.contactRepository = contactRepository;
        this.customerConverter = customerConverter;
    }

    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll().stream().map(customerConverter::toDto).toList(); // converter
    }

    public CustomerDto getCustomerByID (Integer id) {
        return customerRepository.findById(id).map(customerConverter::toDto).orElseThrow(
                () -> new RuntimeException("Could not find customer with id: " +id)
        );
    }

    public void addCustomer(CustomerDto customerDto) {

        if(contactRepository.findByEmail(customerDto.getContact().email()).isPresent()) {
            throw new RuntimeException("This email already exists!");
        }

        Contact contact = new Contact();
        contact.setPhone(customerDto.getContact().phone());
        contact.setEmail(customerDto.getContact().email());
        contact.setAddress(customerDto.getContact().address());
        contact.setCity(customerDto.getContact().city());

        contactRepository.save(contact);

        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setAge(customerDto.getAge());
        customer.setContact(contact);

        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        contactRepository.deleteById(id);
    }

    public void updateCustomer(Integer id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact info not available"));

        if (customerDto.getFirstName() != null) {
            customer.setFirstName(customerDto.getFirstName());
        }

        if (customerDto.getLastName() != null) {
            customer.setLastName(customerDto.getLastName());
        }

        if (customerDto.getAge() != null) {
            customer.setAge(customerDto.getAge());
        }

        if (customerDto.getContact() != null && customerDto.getContact().email() != null) {
            if(contactRepository.findByEmail(customerDto.getContact().email()).isPresent()) {
                throw new RuntimeException("This email already exists!");
            }
            contact.setEmail(customerDto.getContact().email());
        }

        if (customerDto.getContact() != null && customerDto.getContact().phone() != null) {
            contact.setPhone(customerDto.getContact().phone());
        }

        if (customerDto.getContact() != null && customerDto.getContact().city() != null) {
            contact.setCity(customerDto.getContact().city());
        }

        if (customerDto.getContact() != null && customerDto.getContact().address() != null) {
            contact.setAddress(customerDto.getContact().address());
        }

        customerRepository.save(customer);
        contactRepository.save(contact);
    }

}