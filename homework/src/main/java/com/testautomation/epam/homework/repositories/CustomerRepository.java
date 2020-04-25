package com.testautomation.epam.homework.repositories;

import com.testautomation.epam.homework.model.Customer;
import com.testautomation.epam.homework.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
