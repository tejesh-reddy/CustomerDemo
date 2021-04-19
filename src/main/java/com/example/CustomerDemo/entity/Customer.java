package com.example.CustomerDemo.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank(message = "Required Field")
    private String firstName;
    @NotBlank(message = "Required Field")
    private String lastName;
    @Email(message = "Invalid Email")
    private String email;

    public Customer(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public void updateFrom(Customer newCustomer)
    {
        if(newCustomer.getFirstName().trim().length() > 0)
            setFirstName(newCustomer.getFirstName());
        if(newCustomer.getLastName().trim().length() > 1)
            setLastName(newCustomer.getLastName());
        if(newCustomer.getEmail().trim().length() > 1)
            setEmail(newCustomer.getEmail());
    }
}
