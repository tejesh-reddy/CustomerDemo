package com.example.CustomerDemo.DAO;

import com.example.CustomerDemo.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
}
