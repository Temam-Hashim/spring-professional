package com.example.demo.customer;

import com.example.demo.ExternalApi.Posts;
import com.example.demo.customer.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/customers")
@RestController
//@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;

    }

    @GetMapping()
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }


    @GetMapping(path="{customerId}")
    Customer getCustomer(@PathVariable("customerId") long id){
        return customerService.getCustomer(id);

    }

    @GetMapping(path="{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") long id){
       throw new ApiRequestException("ApiRequestException for Customer with id "+id);

    }

    @PostMapping()
    public void createCustomer(@Valid @RequestBody Customer customer){
        System.out.println("POST Method:");
        System.out.println(customer);
    }

    @PutMapping()
    public void updateCustomer(@RequestBody Customer customer){
        System.out.println("PUT Method:");
        System.out.println(customer);
    }

    @DeleteMapping(path="{customerId}")
    public void deleteCustomer(@PathVariable("customerId") long id){
        System.out.println("DELETE METHOD to Delete Customer with Id:"+id);
    }





}
