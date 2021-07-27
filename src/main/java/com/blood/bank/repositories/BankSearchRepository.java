package com.blood.bank.repositories;

import com.blood.bank.model.BankDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankSearchRepository extends MongoRepository<BankDetails,String> {

}
