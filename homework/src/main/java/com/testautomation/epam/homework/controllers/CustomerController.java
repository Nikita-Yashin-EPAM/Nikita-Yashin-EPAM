package com.testautomation.epam.homework.controllers;

import com.testautomation.epam.homework.model.Customer;
import com.testautomation.epam.homework.model.Product;
import com.testautomation.epam.homework.repositories.CustomerRepository;
import com.testautomation.epam.homework.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CustomerController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @RequestMapping({"","/","/customers"})
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
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("customer", customer);
        return "customer/update";
    }
    @PostMapping("/customer/update")
    public String updateCustomer(Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/customer-update/{customerId}/products/{prodId}/delete")
    public String deleteProductForCustomer(@PathVariable("prodId") Long prodId,
                                           @PathVariable("customerId") Long customerId)
    {
        Customer customer = customerRepository.findById(customerId).get();
        Product product = productRepository.findById(prodId).get();
        customer.getProducts().remove(product);
        product.getCustomers().remove(customer);
        customerRepository.save(customer);
        productRepository.save(product);
        return "redirect:/customer-update/{customerId}";
    }
    @GetMapping("/customer-update/{customerId}/products/{prodId}/add")
    public String addProductForCustomer(@PathVariable("prodId") Long prodId,
                                        @PathVariable("customerId") Long customerId)
    {
        Customer customer = customerRepository.findById(customerId).get();
        Product product = productRepository.findById(prodId).get();
        customer.getProducts().add(product);
        product.getCustomers().add(customer);
        customerRepository.save(customer);
        productRepository.save(product);
        return "redirect:/customer-update/{customerId}";
    }
}
