package com.blood.bank.controllers;

import com.blood.bank.model.DonorDetails;
import com.blood.bank.repositories.DonorSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donor")
public class DonorController {

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    DonorSearchRepository searchRepository;


    @GetMapping(value = "/all")
    public List<DonorDetails> getAllDonors(){
        return searchRepository.findAll();
    }

    @PostMapping("/add")
    public String addDonor(@RequestBody DonorDetails donorDetails){
        searchRepository.insert(donorDetails);
        return "Donor added successfully!";
    }

    @DeleteMapping("/delete")
    public String deleteDonor(@RequestParam String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        DonorDetails donor = mongoOperations.findOne(query,DonorDetails.class);
        mongoOperations.remove(donor);
        return "Donor deleted successfully!";
    }
}
