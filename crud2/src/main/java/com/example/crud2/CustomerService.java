package com.example.crud2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        if (customer.getName() == null || customer.getName().isEmpty() || customer.getName().matches("^\\d+$")) {
            throw CustomException.invalidCustomerName(customer.getName());
        }
        return customerRepository.saveCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        Customer customer = customerRepository.findById(id);
        if (customer == null) {
            throw CustomException.customerNotFound(id);
        }
        return customer;
    }
}
