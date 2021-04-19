package com.example.CustomerDemo.service;

import com.example.CustomerDemo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CustomerServiceInterface {
    ArrayList<Customer> getCustomers();
    Customer getCustomerById(int id);
    void addCustomer(Customer customer);
    void removeCustomer(int id);
    void updateCustomer(int id, Customer newCust);
}
