package com.example.demo.service;

import com.example.demo.entity.Cat;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public String getPublicAPI() {
        String url = "https://catfact.ninja/fact";
        RestTemplate restTemplate = new RestTemplate();
        Cat obj = restTemplate.getForObject(url, Cat.class);
        return obj.getFact();
    }
}
