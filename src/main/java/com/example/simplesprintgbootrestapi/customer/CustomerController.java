package com.example.simplesprintgbootrestapi.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        log.info("Creating customer with: {}", createCustomerRequest);
        return this.customerService.createCustomer(createCustomerRequest);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        log.info("Getting customer with id: {}", id);
        return this.customerService.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        log.info("Deleting customer with id: {}", id);
        this.customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody CreateCustomerRequest createCustomerRequest) {
        log.info("Updating customer with id: {} with: {}", id, createCustomerRequest);
        return this.customerService.updateCustomer(id, createCustomerRequest);
    }
}
