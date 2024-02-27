package com.example.repositories;

import com.example.model.Address;
import com.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    Optional<Address> findByCityAndHomeNumberAndStreet(String city, String homeNumber, String street);


    Optional<Address> findByPerson(Person person);

}
