package com.blood.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchResponse {

    private String name;

    private String city;

    private String state;

    private String pinCode;

    private String phoneNumber;

    private HashMap<String,Integer> bloodGroupsAvailable;
}
