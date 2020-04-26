package com.testautomation.epam.homework.controllers;

import com.testautomation.epam.homework.model.Customer;
import com.testautomation.epam.homework.model.Product;
import com.testautomation.epam.homework.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    private ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) { this.productRepository = productRepository;}
    @RequestMapping("/products")
    public String getProduct(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products/list";
    }
    @GetMapping("/products/create")
    public String createProductForm(Product product){
        return "products/create";
    }
    @PostMapping("products/create")
    public String createProduct(Product product){
        productRepository.save(product);
        return "redirect:/customers";
    }
}
