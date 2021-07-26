package com.blood.bank.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchRequest {

    private String pinCode;

    private String state;

    private String city;

    //private String bloodGroup;
}
