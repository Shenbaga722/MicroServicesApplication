package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerAccount {
    private Account account;
    private Customer customer;

}