package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.service.CustomerService;

import java.util.List;

//Implement Put method
//Implement condition to check if existing email for Put/Post

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id,
                               @RequestBody @Valid CustomerDto customerDto)  {
        customerService.updateCustomer(id, customerDto);
    }

}
