package com.example.service;

import com.example.contract.AddressDto;
import com.example.contract.PersonDto;
import com.example.contract.UserDto;
import com.example.model.Address;
import com.example.model.Person;
import com.example.model.User;
import com.example.repositories.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DataService implements IService{

    private final Catalog catalog;


    @Override
    public void savePerson(int userId, PersonDto personDto) {
        var personEntity = new Person();
        personEntity.setName(personDto.getName());
        personEntity.setLastName(personDto.getLastName());
        personEntity.setAge(personDto.getAge());
        var userFromDB = catalog.getUserRepository().findById(userId).orElse(null);
        if(userFromDB != null){
            personEntity.setUser(userFromDB);
            if(catalog.getPersonRepository()
                    .findByNameAndLastName(personDto.getName()
                            , personEntity.getLastName()).
                    orElse(null) == null){
                catalog.getPersonRepository().save(personEntity);
            }
        }


    }


    @Override
    public void saveAddress(int personId, AddressDto addressDto) {
        var addressEntity = new Address();
        addressEntity.setCity(addressDto.getCity());
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setHomeNumber(addressDto.getHomeNumber());
        addressEntity.setPostalCode(addressDto.getPostalCode());
        var personFromDB = catalog.getPersonRepository().findById(personId).orElse(null);
        if(personFromDB != null){
            addressEntity.setPerson(personFromDB);
            if(catalog.getAddressRepository()
                    .findByCityAndHomeNumberAndStreet(addressDto.getCity()
                            , addressDto.getHomeNumber(),
                            addressDto.getStreet()).orElse(null) == null){
                catalog.getAddressRepository().save(addressEntity);
            }
        }
    }
    @Override
    public void saveUser(UserDto userDto) {
        var userEntity = new User();
        userEntity.setUserName(userDto.getUserName());
        userEntity.setPassword(userDto.getPassword());
        if(catalog.getUserRepository()
                .findByUserName(userDto.getUserName()).orElse(null) == null){
            catalog.getUserRepository().save(userEntity);
        }
    }

    @Override
    public PersonDto getPersonById(int id) {
        var personEntity = new PersonDto();
        var personFromDB = catalog.getPersonRepository().findById(id).orElse(null);
        if(personFromDB != null){
           personEntity.setLastName(personFromDB.getLastName());
           personEntity.setAge(personFromDB.getAge());
           personEntity.setName(personFromDB.getName());
        }
        return personEntity;
    }


    @Override
    public AddressDto getAddress(int personId) {
        var addressEntity = new AddressDto();
        var personFromDB = catalog.getPersonRepository().findById(personId).orElse(null);
        var addressFromDB = catalog.getAddressRepository().findByPerson(personFromDB).orElse(null);
        if(addressFromDB != null){
            addressEntity.setStreet(addressFromDB.getStreet());
            addressEntity.setHomeNumber(addressFromDB.getHomeNumber());
            addressEntity.setPostalCode(addressFromDB.getPostalCode());
            addressEntity.setCity(addressFromDB.getCity());
        }
        return addressEntity;
    }
    @Override
    public List<PersonDto> getAllPerson() {
        var personDto = new ArrayList<PersonDto>();
        for(var personFromDB : catalog.getPersonRepository().findAll()){
            var personEntity = new PersonDto();
            personEntity.setName(personFromDB.getName());
            personEntity.setLastName(personFromDB.getLastName());
            personEntity.setAge(personFromDB.getAge());
            personDto.add(personEntity);
        }
        return personDto;
    }
    @Override
    public List<UserDto> getAllUser() {
        var userDto = new ArrayList<UserDto>();
        for(var userFromDB : catalog.getUserRepository().findAll()){
            var userEntity = new UserDto();
            userEntity.setUserName(userFromDB.getUserName());
            userEntity.setPassword(userFromDB.getPassword());
            userDto.add(userEntity);
        }
        return userDto;
    }

    @Override
    public void update(int personId, PersonDto personDto) {
        var personFromdb = catalog.getPersonRepository().findById(personId).orElse(null);
        if(personFromdb != null){
            personFromdb.setName(personDto.getName());
            personFromdb.setLastName(personDto.getLastName());
            personFromdb.setAge(personDto.getAge());

            catalog.getPersonRepository().save(personFromdb);
        }

    }

//    @Override
//    public void deleteUser(int addressId) {
//        var addressFromDB = catalog.getAddressRepository().findById(addressId).orElse(null);
//        var personFromDB = catalog.getPersonRepository().findById(addressFromDB.getPerson().getId()).orElse(null);
//        var userFromDB = catalog.getUserRepository().findById(personFromDB.getUser().getId()).orElse(null);
//        if(personFromDB != null && addressFromDB != null && userFromDB != null){
//            catalog.getAddressRepository().delete(addressFromDB);
//            catalog.getPersonRepository().delete(personFromDB);
//            catalog.getUserRepository().delete(userFromDB);
//        }
//    }




}
