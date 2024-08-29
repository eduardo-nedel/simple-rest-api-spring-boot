package com.example.simplesprintgbootrestapi.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    public final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    public Customer createCustomer(CreateCustomerRequest createCustomerRequest) {
        return this.customerRepository.save(new Customer(createCustomerRequest.name(), createCustomerRequest.email(), createCustomerRequest.address()));
    }

    public void deleteCustomer(Long id) {
        this.customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, CreateCustomerRequest createCustomerRequest) {
        Customer customer = this.customerRepository.findById(id).orElseThrow();
        customer.setName(createCustomerRequest.name());
        customer.setEmail(createCustomerRequest.email());
        customer.setAddress(createCustomerRequest.address());
        return this.customerRepository.save(customer);
    }
}
