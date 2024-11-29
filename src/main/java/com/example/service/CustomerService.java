package com.example.service;

import com.example.dto.CustomerDto;
import com.example.entity.Customer;
import org.springframework.stereotype.Service;
import com.example.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        if (customerDto.email() != null) {
            for (Customer customer1; ;) {
                if (customerDto.email().equals(customer.getEmail())) {
                    throw new RuntimeException("This email already exists!");
                }
                else {
                    customer.setEmail(customerDto.email());
                }
            }
        }
        customer.setF_name(customerDto.f_name());
        customer.setL_name(customerDto.l_name());
        customer.setPhone(customerDto.phone());
        customer.setAge(customerDto.age());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Integer id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        if (customerDto.f_name() != null) {
            customer.setF_name(customerDto.f_name());
        }
        if (customerDto.l_name() != null) {
            customer.setL_name(customerDto.l_name());
        }
        if (customerDto.phone() != null) {
            customer.setPhone(customerDto.phone());
        }
        if (customerDto.age() != null) {
            customer.setAge(customerDto.age());
        }

        if (customerDto.email() != null) {
            for (Customer customer1; ;) {
                if (customerDto.email().equals(customer.getEmail())) {
                    throw new RuntimeException("This email already exists!");
                }
                else {
                    customer.setEmail(customerDto.email());
                }
            }
        }
        customerRepository.save(customer);
    }

}