package com.example.controllers;
import com.example.contract.AddressDto;
import com.example.contract.PersonDto;
import com.example.contract.UserDto;
import com.example.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;

    @PostMapping("/{id}")
    public ResponseEntity savePerson(@PathVariable("id")int personId, @RequestBody PersonDto personDto){
        dataService.savePerson(personId,personDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/address/{id}")
    public ResponseEntity saveAddress(@PathVariable("id")int personId, @RequestBody AddressDto addressDto){
        dataService.saveAddress(personId, addressDto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody UserDto userDto){
        dataService.saveUser(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/address")
    public ResponseEntity getAddress(@PathVariable("id") int personId){
        return ResponseEntity.ok(dataService.getAddress(personId));
    }
//    TODO: naprawic usuwanie
//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable("id") int personId){
//        service.deleteUser(personId);
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/{id}")
    public ResponseEntity getPersonById(@PathVariable("id") int id){
        return ResponseEntity.ok(dataService.getPersonById(id));
    }

    @GetMapping
    public ResponseEntity getAllPerson() {
        return ResponseEntity.ok(dataService.getAllPerson());
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(dataService.getAllUser());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") int id,@RequestBody PersonDto personDto){
        dataService.update(id, personDto);
        return ResponseEntity.ok().build();
    }
}
