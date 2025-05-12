package com.farabi.store.services;

import com.farabi.store.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());
    }
}
