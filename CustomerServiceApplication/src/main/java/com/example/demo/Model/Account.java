package com.example.demo.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Account {
    private String AccountType;
    private String IFSCCode;
    private String branch;

    public Account( String AccountType, String IFSCCode, String branch) {
        this.AccountType = AccountType;
        this.IFSCCode = IFSCCode;
        this.branch=branch;
    }
}

