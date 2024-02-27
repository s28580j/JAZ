package com.example.service;

import com.example.contract.AddressDto;
import com.example.contract.PersonDto;
import com.example.contract.UserDto;

import java.util.List;

public interface IService {
    void savePerson(int userId, PersonDto personDto);

    PersonDto getPersonById(int id);

    List<PersonDto> getAllPerson();

    void update(int personId, PersonDto personDto);

//    void deleteUser(int addressId);
    AddressDto getAddress(int personId);

    void saveAddress(int personId, AddressDto addressDto);

    void saveUser(UserDto userDto);

    List<UserDto> getAllUser();





}
