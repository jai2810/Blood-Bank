package com.blood.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="Details")
public class DonorDetails {

    @Id
    private ObjectId id;

    private String name;

    private Integer age;

    private String state;

    private String city;

    private String pinCode;

    private String bloodGroup;

    private String phoneNumber;

    private String email;

    private List<String> allergies = new ArrayList<>();
}
