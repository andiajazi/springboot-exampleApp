package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{customerId}")
    public CustomerDto getCustomerByID(@PathVariable("customerId") Integer customerId) {
        return customerService.getCustomerByID(customerId);
    }

    @PostMapping
    public void addCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.deleteCustomer(customerId);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer customerId,
                               @RequestBody @Valid CustomerDto customerDto)  {
        customerService.updateCustomer(customerId, customerDto);
    }

}
