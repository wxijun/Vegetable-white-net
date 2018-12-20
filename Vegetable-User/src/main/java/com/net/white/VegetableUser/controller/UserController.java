package com.net.white.VegetableUser.controller;

import com.net.white.VegetableUser.annotation.MyLog;
import com.net.white.VegetableUser.entity.SysUser;
import com.net.white.VegetableUser.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private SysUserRepository userRepository;

    @MyLog(value = "查询用户表记录")//这里添加了AOP的自定义注解
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public String test(
            @RequestParam ("userName") String userName,
            @RequestParam ("userPass") String userPass
            ,@RequestParam (value = "token", required = false, defaultValue = "") String token
    )throws Exception{
        SysUser user = userRepository.Login(userName,userPass,token);
        if(!user.equals("")){
            return user.toString();
        }else{
            return user.toString();
        }
    }
}
