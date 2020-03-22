package com.testautomation.epam.homework.repositories;

import com.testautomation.epam.homework.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
