package com.testautomation.epam.homework.controllers;

import com.testautomation.epam.homework.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    private CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }
    @RequestMapping("/customers")
    public String getCustomer(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/list";
    }
}
