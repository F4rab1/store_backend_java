package com.farabi.store.services;

import com.farabi.store.repositories.ProfileRepository;
import com.farabi.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
        // user is lazy loaded (user retrieved when we access it)
    }

    @Transactional
    public void fetchProfilesByLoyaltyPoints() {
        var users = userRepository.findLoyalUsers(4);
        users.forEach(p -> System.out.println(p.getId() + ": " + p.getEmail()));
    }
}
