package com.farabi.store.services;

import com.farabi.store.entities.Address;
import com.farabi.store.entities.User;
import com.farabi.store.repositories.ProductRepository;
import com.farabi.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    public UserService(UserRepository userRepository, ProductRepository productRepository , EntityManager entityManager) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
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

    public void showRelatedEntities() {
        var user = userRepository.findById(2L).orElseThrow();
        System.out.println(user.getEmail());
        // profile is eager loaded
    }

    public void persistRelated() {
        var user = User.builder()
                .name("Yers")
                .email("yers@example.com")
                .password("password")
                .build();

        var address = Address.builder()
                .street("Street 1")
                .city("City 1")
                .state("State 1")
                .zip("Zip 1")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(8L).orElseThrow();
        var address = user.getAddresses().stream().findFirst().get();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
        var user = userRepository.findById(3L).orElseThrow();
        var products = productRepository.findAll();
        products.forEach(user::addFavoriteProduct);
        userRepository.save(user);
    }

    @Transactional
    public void fetchUserByEmail() {
        var user = userRepository.findByEmail("john.doe@example.com").orElseThrow();
        System.out.println(user);
    }

}
