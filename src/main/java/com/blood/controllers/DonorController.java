package com.blood.controllers;

import com.blood.model.BankDetails;
import com.blood.model.DonorDetails;
import com.blood.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DonorController {

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    DonorDetails donorDetails;

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    MongoRepository mongoRepository;

    @GetMapping("/all")
    public List<BankDetails> findAll(){
        return mongoRepository.findAll();
    }
}
