package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Account Type Already Exist")
public class AccountAlreadyExist extends RuntimeException{
    public AccountAlreadyExist(String s) {
        super(s);
    }
}