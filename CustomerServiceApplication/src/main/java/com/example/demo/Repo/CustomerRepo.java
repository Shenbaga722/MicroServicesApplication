package com.example.demo.Repo;

import com.example.demo.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;



public interface CustomerRepo extends MongoRepository<Customer, String> {
    @Query("{customerName :?0}")
    List<Customer> findByName();
}
