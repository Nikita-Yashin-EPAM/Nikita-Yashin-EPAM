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
        Product economyPackage = new Product("Economy Package");
        nikita.getProducts().add(economyPackage);
        economyPackage.getCustomers().add(nikita);

        customerRepository.save(nikita);
        productRepository.save(economyPackage);

    }
}
