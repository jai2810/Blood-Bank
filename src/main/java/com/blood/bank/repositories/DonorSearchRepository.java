package com.blood.bank.repositories;

import com.blood.bank.model.DonorDetails;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorSearchRepository extends MongoRepository<DonorDetails, String>{

    //public List<UserSearchResponse> findByPin(String pinCode);

}
