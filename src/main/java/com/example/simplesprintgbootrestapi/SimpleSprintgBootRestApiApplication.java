package com.example.simplesprintgbootrestapi;

import com.example.simplesprintgbootrestapi.customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SimpleSprintgBootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSprintgBootRestApiApplication.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return List.of(new Customer(1L, "Ned", "ned@gmaaal.com", "Rua ned, 752, Nederland"));
    }

}
