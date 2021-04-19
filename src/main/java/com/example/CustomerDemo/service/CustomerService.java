package com.example.CustomerDemo.service;

import com.example.CustomerDemo.DAO.CustomerRepo;
import com.example.CustomerDemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceInterface{

    @Autowired
    CustomerRepo customerRepo;

    @Override
    @Transactional
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> all = new ArrayList<>();

        for(Customer customer : customerRepo.findAll())
        {
            all.add(customer);
        }

        return all;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepo.findById(id).get();
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {

        customerRepo.save(customer);

    }

    @Override
    @Transactional
    public void removeCustomer(int id) {
        Optional<Customer> optcustomer = customerRepo.findById(id);

        Customer customer = optcustomer.get();

        customerRepo.delete(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(int id, Customer newCust) {
        Optional<Customer> optionalCustomer = customerRepo.findById(id);

        Customer customer = optionalCustomer.get();

        customer.updateFrom(newCust);

        customerRepo.save(customer);
    }
}
