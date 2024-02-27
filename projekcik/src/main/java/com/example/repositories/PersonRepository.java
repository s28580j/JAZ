package com.example.repositories;

import com.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {


    Optional<Person> findByNameAndLastName(String name,String lastName);
}
