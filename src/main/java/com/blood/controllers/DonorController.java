package com.blood.controllers;

import com.blood.model.DonorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DonorController {

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    DonorDetails donorDetails;
}
