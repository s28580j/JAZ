package com.example.repositories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Getter
@RequiredArgsConstructor
@Repository
public class Catalog {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final UserRepository userRepository;

}
