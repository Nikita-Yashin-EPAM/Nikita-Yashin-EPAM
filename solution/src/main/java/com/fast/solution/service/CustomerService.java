package com.fast.solution.service;

import com.fast.solution.model.Customer;
import com.fast.solution.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // Spring component
public class CustomerService {

    private final CustomerRepository customerRepository;
    // binding by constructor not by @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id){
        return customerRepository.getOne(id);
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }
}
