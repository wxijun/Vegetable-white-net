package com.net.white.VegetableUser.repository;

import com.net.white.VegetableUser.entity.SysUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface SysUserRepository extends CrudRepository<SysUser,Integer> {

    @Query("SELECT u FROM SysUser u WHERE u.userName = :userName AND u.userPass = :userPass AND u.token = :token")
    SysUser Login(@Param("userName")String userName, @Param("userPass")String userPass, @Param("token")String token);

    @Query("SELECT u FROM SysUser u WHERE u.userName = :userName")
    SysUser findByUserName(String userName);
}
