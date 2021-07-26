package com.blood.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Bank")
public class BankDetails {

    @Id
    ObjectId id;

    private String name;

    private String city;

    private String state;

    private String pinCode;

    private String phoneNumber;

    private HashMap<String,Integer> bloodGroupsAvailable = new HashMap<>(){{
        put("A+",0);
        put("A-",0);
        put("B+",0);
        put("B-",0);
        put("AB+",0);
        put("AB-",0);
        put("O+",0);
        put("O-",0);
    }};

}
