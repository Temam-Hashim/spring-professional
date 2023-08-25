package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
