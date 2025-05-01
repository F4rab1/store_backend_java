package com.farabi.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
//        //      One to Many Relationship
//        var user = User.builder()
//                .name("Farabi")
//                .password("Farabi")
//                .email("farabi@farabi.com")
//                .build();
//
//        var address = Address.builder()
//                .street("street")
//                .city("city")
//                .state("state")
//                .zip("zip")
//                .build();
//
//        user.addAddress(address);
//        System.out.println(user);
//
//        //      Many to Many Relationship
//        var user2 = User.builder()
//                .name("Farabi")
//                .password("Farabi")
//                .email("farabi@farabi.com")
//                .build();
//
//        user2.addTag("tag1");
//
//        System.out.println(user2);
//
//        //      One to One Relationship
//        var user3 = User.builder()
//                .name("Farabi")
//                .password("Farabi")
//                .email("farabi@farabi.com")
//                .build();
//
//        var profile = Profile.builder()
//                .bio("profile")
//                .build();
//
//        user3.setProfile(profile);
//        profile.setUser(user3);
//
//        System.out.println(user3);
    }

}
