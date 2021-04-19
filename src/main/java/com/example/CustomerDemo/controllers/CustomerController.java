package com.example.CustomerDemo.controllers;

import com.example.CustomerDemo.FirstDB;
import com.example.CustomerDemo.entity.Customer;
import com.example.CustomerDemo.service.CustomerService;
import com.example.CustomerDemo.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/cust")
public class CustomerController {

    @Autowired
    CustomerServiceInterface customerService;

    @Autowired
    FirstDB firstDB;

    @GetMapping("/setup")
    public String setup()
    {
        firstDB.addFirstEntries();

        return "redirect:/cust";
    }

    @GetMapping
    public String showAll(Model model)
    {
        ArrayList<Customer> allCustomers = customerService.getCustomers();

        model.addAttribute("customers", allCustomers);

        return "customer-list";
    }

    @GetMapping("/add")
    public String addCustomer(Model model)
    {
        model.addAttribute("customer", new Customer());

        return "add-customer";
    }

    @PostMapping("/add")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, Errors errors)
    {
        if(errors.hasErrors())
            return "add-customer";

        customerService.addCustomer(customer);

        return "redirect:/cust";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam(name="id") int id, Model model)
    {
        model.addAttribute("id", id);

        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);

        model.addAttribute("newCust", new Customer());

        return "update-customer";
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute("customer") Customer customer, @ModelAttribute("id") int id, Errors errors)
    {
        if(errors.hasErrors())
            return "update-customer";


        customerService.updateCustomer(id, customer);

        return "redirect:/cust";
    }

}
