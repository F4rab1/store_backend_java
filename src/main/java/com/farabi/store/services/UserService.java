package com.farabi.store.services;

import com.farabi.store.entities.User;
import com.farabi.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public UserService(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");


    }
}
