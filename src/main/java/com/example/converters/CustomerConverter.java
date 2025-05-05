package com.example.converters;

import com.example.dto.CustomerDto;
import com.example.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    private final ContactConverter contactConverter = new ContactConverter();


    public Customer toEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setAge(dto.getAge());
        customer.setContact(contactConverter.toEntity(dto.getContact()));
        return customer;
    }

    public CustomerDto toDto(Customer entity) {
        return new CustomerDto(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAge(),
                contactConverter.toDto(entity.getContact())
        );
    }

}
