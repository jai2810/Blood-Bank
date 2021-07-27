package com.blood.bank.controllers;

import com.blood.bank.model.BankDetails;
import com.blood.bank.repositories.BankSearchRepository;
import com.blood.bank.requests.UserSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    BankSearchRepository bankSearchRepository;

    @Autowired
    MongoOperations mongoOperations;

    @PostMapping("/bank")
    public List<BankDetails> searchBanks(@RequestBody UserSearchRequest searchRequest){
        List<BankDetails> bankDetails = new ArrayList<>();
        if(searchRequest.getCity()==null && searchRequest.getPinCode()==null && searchRequest.getState()==null){
            return bankDetails;
        }
        Query query = new Query();
        if(searchRequest.getPinCode()!=null){
            query.addCriteria(Criteria.where("pinCode").is(searchRequest.getPinCode()));
        }
        if(searchRequest.getState()!=null){
            query.addCriteria(Criteria.where("state").is(searchRequest.getState()));
        }
        if(searchRequest.getCity()!=null){
            query.addCriteria(Criteria.where("city").is(searchRequest.getCity()));
        }
        bankDetails = mongoOperations.find(query,BankDetails.class);
        return bankDetails;
    }



}
