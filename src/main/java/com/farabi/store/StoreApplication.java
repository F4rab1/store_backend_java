package com.farabi.store;

import com.farabi.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
//        var user = User.builder()
//                .name("Farabi")
//                .password("Farabi")
//                .email("farabi@farabi.com")
//                .build();
//        System.out.println(user);
    }

}
