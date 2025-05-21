package com.farabi.store.services;

import com.farabi.store.repositories.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
        // user is lazy loaded (user retrieved when we access it)
    }

    @Transactional
    public void fetchProfilesByLoyaltyPoints() {
        var profiles = profileRepository.findByLoyaltyPointsGreaterThanOrderByUserEmail(4);
        profiles.forEach(p -> System.out.println(p.getId() + ": " + p.getUser().getEmail()));
    }
}
