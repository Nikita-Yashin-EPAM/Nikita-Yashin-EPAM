package com.testautomation.epam.homework.controllers;

import com.testautomation.epam.homework.model.Customer;
import com.testautomation.epam.homework.repositories.CustomerRepository;
import com.testautomation.epam.homework.repositories.ProductRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class CustomerControllerTest {

    CustomerController customerController;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    ProductRepository productRepository;
    @Mock
    Model model;
    @Mock
    Customer customer;
    @BeforeMethod
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        customerController = new CustomerController(customerRepository, productRepository);
        customer = new Customer();
    }

    @Test
    void getCustomer() {
        String viewName = customerController.getCustomer(model);
        assertEquals("customers/list", viewName);
        verify(customerRepository, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("customers"), anyCollection());
    }

    @Test
    void deleteUser() {
        String viewName = customerController.deleteUser(anyLong());
        assertEquals("redirect:/customers", viewName);
        verify(customerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void createCustomerForm() {
        String viewName = customerController.createCustomerForm(customer);
        assertEquals("customer/create", viewName);
    }

    @Test
    void createUser() {
        String viewName = customerController.createUser(customer);
        assertEquals("redirect:/customers", viewName);
        verify(customerRepository, times(1)).save(customer);
    }
    @Test
    void updateCustomerhtseForm() {
        String viewName = customerController.createUser(customer);
        assertEquals("customer/update", viewName);
    }
    @Test
    void updateCustomer() {
        String viewName = customerController.createUser(customer);
        assertEquals("redirect:/customers", viewName);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void deleteProductForCustomer() {
        String viewName = customerController.createUser(customer);
        assertEquals("redirect:/customer-update/{customerId}", viewName);

    }

    @Test
    void addProductForCustomer() {
        String viewName = customerController.createUser(customer);
        assertEquals("redirect:/customer-update/{customerId}", viewName);
    }
}
