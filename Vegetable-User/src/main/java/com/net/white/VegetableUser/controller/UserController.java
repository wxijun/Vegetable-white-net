package com.net.white.VegetableUser.controller;

import com.net.white.VegetableUser.entity.User;
import com.net.white.VegetableUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author wangxijun
 * @Date 2018/12/17 13:57
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public String test(
            @RequestParam ("userName") String userName,
            @RequestParam ("userPass") String userPass
            ,@RequestParam (value = "token", required = false, defaultValue = "") String token
    )throws Exception{
        User user = userRepository.Login(userName,userPass,token);
        if(!user.equals("")){
            return user.toString();
        }else{
            return user.toString();
        }
    }
}
