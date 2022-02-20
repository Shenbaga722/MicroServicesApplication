package com.example.demo.feign;

import com.example.demo.Model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "AccountServiceApplication")
public interface AccountFeignClient {

    @GetMapping(value = "/accountdetail/accountdetailsbyaccountid/{id}")
    Account getIds(@PathVariable Integer id);

    @GetMapping("/getAllAccounts")
    ResponseEntity<List<Account>> getAllAccount();
}

