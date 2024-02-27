package com.example.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {

    @JsonProperty("user_name")
    private String userName;
    private String password;



}
