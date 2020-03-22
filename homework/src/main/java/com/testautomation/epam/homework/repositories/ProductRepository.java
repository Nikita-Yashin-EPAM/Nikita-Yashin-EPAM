package com.testautomation.epam.homework.repositories;

import com.testautomation.epam.homework.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
