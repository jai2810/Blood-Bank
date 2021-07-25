package com.blood.functionalities;

import com.blood.repositories.SearchRepository;
import com.blood.responses.UserSearchResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Functions implements SearchRepository {

    public List<UserSearchResponse> findByPin(String pinCode) {
        return null;
    }
}
