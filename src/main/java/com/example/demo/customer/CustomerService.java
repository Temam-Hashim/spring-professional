package com.example.demo.customer;


import com.example.demo.customer.exception.NotFoundException;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    Customer getCustomer(long id){

        return customerRepository.findById(id)
                .orElseThrow(
                () ->{
                    NotFoundException notFoundException = new NotFoundException("No customer found with Id " + id);
                    LOGGER.error("Error getting customer with id {}",id,notFoundException);
                    return notFoundException;
                });


//                .stream()
//                .filter(customer -> customer.getId() == id)
//                .findFirst().
//        .orElseThrow(()->new NotFoundException("Customer not found with id "+id));
    }




}
