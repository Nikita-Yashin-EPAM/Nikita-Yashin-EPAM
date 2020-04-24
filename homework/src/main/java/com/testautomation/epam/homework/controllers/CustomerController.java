package com.testautomation.epam.homework.controllers;

import com.testautomation.epam.homework.model.Customer;
import com.testautomation.epam.homework.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("customer-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        customerRepository.deleteById(id);
        return "redirect:/customers";
    }

    @GetMapping("/customer/create")
    public String createCustomerForm(Customer customer){
        return "customer/create";
    }
    @PostMapping("customer/create")
    public String createUser(Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customer-update/{id}")
    public String updateCustomerhtseForm(@PathVariable("id") Long id, Model model){
        Customer customer = customerRepository.findById(id).orElse(null);
        model.addAttribute("customer", customer);
        return "customer/update";
    }
    @PostMapping("/customer/update")
    public String updateCustomer(Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }
}
