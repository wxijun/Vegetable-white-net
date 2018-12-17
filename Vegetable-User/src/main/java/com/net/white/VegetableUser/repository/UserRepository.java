package com.net.white.VegetableUser.repository;

import com.net.white.VegetableUser.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.user_name = :userName AND u.user_pass = :userPass AND u.token = :token")
    User Login(@Param("userName")String userName, @Param("userPass")String userPass,@Param("token")String token);
}
