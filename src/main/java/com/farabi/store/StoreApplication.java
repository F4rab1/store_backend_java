package com.farabi.store;

import com.farabi.store.entities.Address;
import com.farabi.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);

        User user = new User();
        user.setName("John");
        user.setPassword("password");
        user.setEmail("john@codewithmosh.com");

        Address address = new Address();
        address.setStreet("street");
        address.setCity("city");
        address.setState("state");
        address.setZip("zip");

        user.addAddress(address);
        System.out.println(user);
        System.out.println(address);
    }
}
