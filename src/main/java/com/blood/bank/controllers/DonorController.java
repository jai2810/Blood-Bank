package com.blood.bank.controllers;

import com.blood.bank.model.BankDetails;
import com.blood.bank.model.DonorDetails;
import com.blood.bank.repositories.BankSearchRepository;
import com.blood.bank.repositories.DonorSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/donor")
public class DonorController {

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    DonorSearchRepository searchRepository;

    @Autowired
    BankSearchRepository bankSearchRepository;


    @GetMapping("/all")
    public List<DonorDetails> getAllDonors(){
        return searchRepository.findAll();
    }

    @PostMapping("/add")
    public String addDonor(@RequestBody DonorDetails donorDetails){
        searchRepository.insert(donorDetails);
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(donorDetails.getDonorBank()));
        BankDetails bankDetails = mongoOperations.findOne(query,BankDetails.class);
        if(bankDetails.getBloodGroupsAvailable()!=null){
            int count = bankDetails.getBloodGroupsAvailable().getOrDefault(donorDetails.getBloodGroup(),0);
            bankDetails.getBloodGroupsAvailable().put(donorDetails.getBloodGroup(),count+1);
        }
        else {
            bankDetails.getBloodGroupsAvailable().put(donorDetails.getBloodGroup(),1);
        }

        bankSearchRepository.save(bankDetails);
        return "Donor added successfully!";
    }

    @DeleteMapping("/delete")
    public String deleteDonor(@RequestParam String id){
        Query query = new Query(),query1 = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        DonorDetails donor = mongoOperations.findOne(query,DonorDetails.class);
        if(donor==null){
            return "Donor not found";
        }
        query1.addCriteria(Criteria.where("name").is(donor.getDonorBank()));
        mongoOperations.remove(donor);
        BankDetails bankDetails = mongoOperations.findOne(query1,BankDetails.class);
        int count = bankDetails.getBloodGroupsAvailable().getOrDefault(donor.getBloodGroup(),0);
        if(count>0){
            bankDetails.getBloodGroupsAvailable().put(donor.getBloodGroup(),count-1);
            bankSearchRepository.save(bankDetails);
        }

        return "Donor deleted successfully!";
    }

    @GetMapping("/{id}")
    public Optional<DonorDetails> getDonor (@PathVariable String id){
        Optional<DonorDetails> donorDetails = searchRepository.findById(id);
        return donorDetails;
    }
}
