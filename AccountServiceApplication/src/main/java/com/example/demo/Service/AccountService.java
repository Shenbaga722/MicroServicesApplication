package com.example.demo.Service;

import com.example.demo.Model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public List<Account> getAllAccount();

    public Account addAccount( Account account );

    public Account getAccountDetailsByAccountId( Integer id );

    Boolean isActive( Integer id );
}

;