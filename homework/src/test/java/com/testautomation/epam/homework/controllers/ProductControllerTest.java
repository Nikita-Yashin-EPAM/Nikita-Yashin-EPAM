package com.testautomation.epam.homework.controllers;


import com.testautomation.epam.homework.model.Product;
import com.testautomation.epam.homework.repositories.ProductRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {
    @Mock
    Model model;

    @Mock
    Product product;
    
    @Mock
    ProductRepository productRepository;

    ProductController productController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productController = new ProductController(productRepository);
        product = new Product();

    }

    @Test
    public void getProduct() {
        String viewName = productController.getProduct(model);
        assertEquals("products/list", viewName);
        verify(productRepository, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("products"), anyCollection());
    }

    @Test
    public void createProductForm() {
        String viewName = productController.createProductForm(product);
        assertEquals("products/create", viewName);
    }

    @Test
    public void createProduct() {
        String viewName = productController.createProduct(product);
        assertEquals("redirect:/customers", viewName);
        verify(productRepository, times(1)).save(product);
    }
}