package com.blood.repositories;

import com.blood.model.BankDetails;
import com.blood.responses.UserSearchResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository {

    public List<UserSearchResponse> findByPin(String pinCode);

}
