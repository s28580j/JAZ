package com.example.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PersonDto {

    private String name;
    @JsonProperty("last_name")
    private String lastName;

    private int age;
//    @JsonProperty("user_dto")
//    private UserDto userDto;

}
