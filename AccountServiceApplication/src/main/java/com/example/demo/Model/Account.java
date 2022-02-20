package com.example.demo.Model;

import com.example.demo.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Entity
@Table(name = "AccountDetails")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    private int accountId;
    @Min(value = 1, message = "Valid positive value")
    private int customerId;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String ifscCode;
    private String branch;
    @Min(value = 1, message = "Enter some valid amount")
    private int balance;
    private Boolean isActive;


}
