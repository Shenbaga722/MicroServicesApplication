package com.example.demo.Controller;
import com.example.demo.Model.Account;
import com.example.demo.Model.Customer;
import com.example.demo.Model.CustomerAccount;
import com.example.demo.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CustomerController {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    RestTemplate restTemplate;
    @PostMapping("/createCustomerAccount")
    public ResponseEntity<CustomerAccount> createCustomer( @RequestBody CustomerAccount customer1) {
        try {
            Customer customer = customerRepo.save(new Customer(customer1.getCustomer().getCustomerName(),customer1.getCustomer().getAge(),customer1.getCustomer().getCity(),customer1.getCustomer().getEmailid(),customer1.getCustomer().getPhonenumber()));
            Account account = new Account(customer1.getAccount().getAccountType(), customer1.getAccount().getIFSCCode(),customer1.getAccount().getBranch());
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Account> httpEntity = new HttpEntity<>(account,header);
            restTemplate.exchange("http://AccountServiceApplication/account/createAccounts",HttpMethod.POST,httpEntity,void.class);
            return new ResponseEntity<>(customer1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String name){
        try {
            List<Customer> customers = new ArrayList<>();

            if (name == null)
                customerRepo.findAll().forEach(customers::add);
            else
                customerRepo.findByName().forEach(customers::add);

            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
