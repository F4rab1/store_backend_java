package com.farabi.store;

import com.farabi.store.entities.User;
import com.farabi.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var repository =  context.getBean(UserRepository.class);

//      Create
        var user = User.builder()
                .name("Farabi")
                .email("farabi@farabi.com")
                .password("farabi")
                .build();
        var saved = repository.save(user);
        System.out.println("Saved: " + saved);

        repository.findById(1L).orElseThrow();
        repository.findAll().forEach(System.out::println);

        repository.deleteById(1L);
    }

}
