package com.example.demo.Service;

import com.example.demo.Model.Account;
import com.example.demo.Repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo repository;

    @Override
    public List<Account> getAllAccount() {
        return (List<Account>) repository.findAll();
    }

    @Override
    public Account addAccount( Account account ) {
        return repository.save(account);
    }

    public Account getAccountDetailsByAccountId( Integer id ) {
        return repository.findByAccountId(id);
    }

    @Override
    public Boolean isActive( Integer id ) {
        Account account = repository.findByAccountId(id);
        //below if checks whether the id passed is valid
        if (account == null) {
            return false;
        }
        return account.getIsActive();
    }
}





