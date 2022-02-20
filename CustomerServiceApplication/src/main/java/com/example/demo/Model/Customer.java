package com.example.demo.Model;

//import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Document(collection="customers")
@Data
public class Customer {
    @Id
        private String customerId;
        private String customerName;
        private int age;
        private String city;
        private String emailid;
    @Size(min = 10,message = "phone number should be a 10 digit number")
        private String phonenumber;

        public Customer( String customerName, int age, String city, String emailid, String phonenumber) {
        this.customerName = customerName;
        this.age = age;
        this.city = city;
        this.emailid = emailid;
        this.phonenumber=phonenumber;
    }
    public Customer() {
        }
}
