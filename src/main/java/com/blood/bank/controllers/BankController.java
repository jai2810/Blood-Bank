package com.blood.bank.controllers;

import com.blood.bank.model.BankDetails;
import com.blood.bank.repositories.BankSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    @Autowired
    BankSearchRepository searchRepository;

    @Autowired
    MongoOperations mongoOperations;

    @GetMapping("/all")
    public List<BankDetails> getAllBanks (){
        return searchRepository.findAll();
    }

    @PostMapping("/add")
    public String addBank (@RequestBody BankDetails bankDetails){
        searchRepository.insert(bankDetails);
        return "Bank added successfully";
    }

    @DeleteMapping("/delete")
    public String deleteBank (@RequestParam String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        BankDetails bankDetails = mongoOperations.findOne(query,BankDetails.class);
        if(bankDetails==null)return "Bank not found";
        mongoOperations.remove(bankDetails);
        return "Bank deleted successfully";
    }

    @GetMapping("/{id}")
    public Optional<BankDetails> getBank (@PathVariable String id){
        Optional<BankDetails> bankDetails = searchRepository.findById(id);
        return bankDetails;
    }

}
