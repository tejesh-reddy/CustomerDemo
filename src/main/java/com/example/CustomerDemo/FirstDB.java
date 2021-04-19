package com.example.CustomerDemo;

import com.example.CustomerDemo.entity.Customer;
import com.example.CustomerDemo.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FirstDB {

    @Autowired
    CustomerServiceInterface customerService;

    public void addFirstEntries()
    {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", "john.doe@bond.com"));
        customers.add(new Customer("kick", "buttowski", "kick.buttowski@hero.com"));
        customers.add(new Customer("chota", "bheem", "chota.bheem@dholakpur.com"));

        for(Customer customer : customers)
            customerService.addCustomer(customer);
    }
}
