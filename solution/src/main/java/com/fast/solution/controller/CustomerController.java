package com.fast.solution.controller;

import com.fast.solution.model.Customer;
import com.fast.solution.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"", "/", "/customers"})
    public String findAll(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }
    @GetMapping("/create-customer")
    public String createCustomerForm(Customer customer){
        return "create-customer";
    }
    @PostMapping("/create-customer")
    public String createCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
//    @GetMapping("delete-customer/{id}")
//    public String deleteCustomer(@PathVariable("id") Long id){
//        customerService.deleteById(id);
//        return "redirect:/customers";
//    }
}
