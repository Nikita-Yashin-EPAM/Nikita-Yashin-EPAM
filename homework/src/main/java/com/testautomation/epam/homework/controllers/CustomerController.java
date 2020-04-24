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
    public String createUserForm(Customer customer){
        return "customer/create";
    }
    @PostMapping("customer/create")
    public String createUser(Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }

//    @PostMapping("/user-create")
//    public String createUser(User user){
//        userService.saveUser(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("user-delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id){
//        userService.deleteById(id);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/user-update/{id}")
//    public String updateUserForm(@PathVariable("id") Long id, Model model){
//        User user = userService.findById(id);
//        model.addAttribute("user", user);
//        return "user-update";
//    }
//
//    @PostMapping("/user-update")
//    public String updateUser(User user){
//        userService.saveUser(user);
//        return "redirect:/users";
//    }
}
