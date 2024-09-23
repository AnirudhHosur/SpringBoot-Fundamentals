package com.example.crud2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    List<Customer> customerList = new ArrayList<Customer>();

    public Customer saveCustomer(Customer customer) {
        // save cust into the list
        Customer newCustomer = new Customer();
        newCustomer.setId(customer.getId());
        newCustomer.setName(customer.getName());
        customerList.add(newCustomer);
        return newCustomer;
    }

    public Customer findById(int id) {
        return customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
