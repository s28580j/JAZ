package com.example.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {


    private String city;

    private String street;
    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("home_number")
    private String homeNumber;
//    @JsonProperty("person_dto")
//    private PersonDto personDto;



}
