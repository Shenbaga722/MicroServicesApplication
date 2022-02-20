package com.example.demo.Controller;

import com.example.demo.Exception.AccountNotFound;
import com.example.demo.Model.Account;
import com.example.demo.Service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {
    String accNotFound = "Account Not found for : ";

    @Autowired
    private AccountService accountService;


    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccount() {
        return accountService.getAllAccount();
    }

    @PostMapping("/createaccount")
    public ResponseEntity<Account> addAccount( @RequestBody Account account ) {
        Account account1 = accountService.addAccount(account);
        return new ResponseEntity<Account>(account1, HttpStatus.CREATED);
    }

    @GetMapping("/accountdetailsbyaccountid/{id}")//account application
    public ResponseEntity<Account> getAccountDetailsByAccountId( @PathVariable("id") Integer id ) {
        if (Boolean.FALSE.equals(accountService.isActive(id)))
            throw new AccountNotFound(accNotFound + id);
        return new ResponseEntity<>(accountService.getAccountDetailsByAccountId(id), HttpStatus.FOUND);
    }

}
