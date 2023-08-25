package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

//@Repository(value="fake")
public class CustomerFakeRepository implements CustomerRepo {

          public List<Customer> getCustomers(){
              return Arrays.asList(
                      new Customer(1L,"Temam Hashim", "Pass123", "email@gmail.com"),
                      new Customer(2L,"Sara Jemal", "123Pass", "email@gmail.com")
              );
        }
}
