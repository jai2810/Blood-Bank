package com.blood.bank.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="Donor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorDetails {

    @Id
    @ApiModelProperty(hidden = true)
    private String id;

    private String name;

    private Integer age;

    private String state;

    private String donorBank;

    private String city;

    private String pinCode;

    private String bloodGroup;

    private String phoneNumber;

    private String email;

    private List<String> allergies = new ArrayList<>();
}
