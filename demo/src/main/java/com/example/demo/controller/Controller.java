package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// This comment was added by Joel

@RestController
@RequestMapping("/api/v1/customers")
public class Controller {

   @Autowired
   private CustomerService customerService;

    // Create a new customer
    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // Retrieve all customers
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Retrieve a specific customer by ID
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        return customerService.findById(customerId);
    }

    // Update an existing customer
    @PutMapping("/update/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(customerId,updatedCustomer);
    }

    // Delete a customer by ID
    @DeleteMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        return customerService.deleteCustomer(customerId);
    }
}
