package com.testautomation.epam.homework.bootstrap;

import com.testautomation.epam.homework.model.Customer;
import com.testautomation.epam.homework.model.Product;
import com.testautomation.epam.homework.repositories.CustomerRepository;
import com.testautomation.epam.homework.repositories.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public DevBootstrap(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Customer nikita = new Customer("Nikita", "Yashin");
        Customer adam = new Customer("Adam", "Smith");
        Product economyPackage = new Product("Economy Package");
        Product standardPackage = new Product("Standard Package");
        nikita.getProducts().add(economyPackage);
        nikita.getProducts().add(standardPackage);
        adam.getProducts().add(standardPackage);
        economyPackage.getCustomers().add(nikita);
        standardPackage.getCustomers().add(nikita);

        customerRepository.save(nikita);
        customerRepository.save(adam);
        productRepository.save(economyPackage);
        productRepository.save(standardPackage);

    }
}
