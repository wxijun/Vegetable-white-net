package com.net.white.VegetableUser.repository;

import com.net.white.VegetableUser.entity.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TokenRepository extends CrudRepository<Token,Integer> {
    @Query("SELECT t FROM Token t WHERE t.userId = :userId")
    Token findByUserId(@Param("userId")String userId);
}
