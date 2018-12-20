package com.net.white.VegetableUser.controller;

import com.net.white.VegetableUser.annotation.MyLog;
import com.net.white.VegetableUser.entity.SysUser;
import com.net.white.VegetableUser.entity.Token;
import com.net.white.VegetableUser.repository.SysUserRepository;
import com.net.white.VegetableUser.repository.TokenRepository;
import com.net.white.VegetableUser.util.Result;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
    @Autowired
    private TokenRepository tokenRepository;

    @MyLog(value = "查询用户表记录")//这里添加了AOP的自定义注解
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public String test(
            @RequestParam (value = "userName", required = false, defaultValue = "") String userName,
            @RequestParam (value = "userPass", required = false, defaultValue = "") String userPass
            ,@RequestParam (value = "token", required = false, defaultValue = "") String token
    )throws Exception{
        SysUser user = userRepository.Login(userName,userPass,token);
        if(!user.equals("")){
            return user.toString();
        }else{
            return user.toString();
        }
    }
    @MyLog(value = "用户注册")//这里添加了AOP的自定义注解
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String userReg(
            @RequestParam (value = "userName", required = false, defaultValue = "") String userName,
            @RequestParam (value = "userPass", required = false, defaultValue = "") String userPass
    )throws Exception{
        SysUser user = new SysUser();
        if(!"".equals(userName.trim())||userName.trim()!=null){
            user.setUserName(userName.trim());
        }else{
            return  "";
        }
        if(!"".equals(userPass.trim())||userPass.trim()!=null){
            user.setUserPass(userPass.trim());
        }else{
            return "";
        }
        user.setCreateDate(new Date());
        userRepository.save(user);
        return "";
    }


    @RequestMapping("/index")
    public String showindex() {
        return "index";
    }
    @RequestMapping("/login")
    public String showlogin() {
        return "login";
    }
    @ResponseBody
    @RequestMapping("/yanzheng")
    public Result yanzheng(SysUser resqUser, HttpServletRequest request) {
        //创建返回信息对象
        Result result = new Result();
        //判断用户信息为空
        if ("".equals(resqUser.getUserName()) || "".equals(resqUser.getUserPass())) {
            result.setMsg("传入的用户名/密码为空！");
            return result;
        }

        //根据客户用户名查找数据库的usre对象
        SysUser myUser = userRepository.findByUserName(resqUser.getUserName());
        //判断用户不存在
        if (null == myUser) {
            result.setMsg("用户不存在");
            return result;
        }
        //判断用户不存在
        if (!resqUser.getUserPass().equals(myUser.getUserPass())) {
            result.setMsg("密码不正确");
            return result;
        }

        //根据数据库的用户信息查询Token
        Token token = tokenRepository.findByUserId(myUser.getId());
        //为生成Token准备
        String TokenStr = "";
        Date date = new Date();
        int nowtime = (int) (date.getTime() / 1000);
        //生成Token
        TokenStr = creatToken(myUser, date);
        if (null == token) {
            //第一次登陆
            token = new Token();
            token.setToken(TokenStr);
            token.setCreateDate(nowtime);
            token.setUserId(myUser.getId());
            tokenRepository.addToken(token);
        }else{
            //登陆就更新Token信息
            TokenStr = creatToken(myUser, date);
            token.setToken(TokenStr);
            token.setCreateDate(nowtime);
            tokenRepository.updataToken(token);
        }
        //返回Token信息给客户端
        result.setFlag(true);
        result.setMsg("登录成功");
        result.setToken(TokenStr);
        return result;
    }
    //生成Token信息方法（根据有效的用户信息）
    private String creatToken(SysUser user, Date date) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT") // 设置header
                .setHeaderParam("alg", "HS256").setIssuedAt(date) // 设置签发时间
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60 * 24 * 3))
                .claim("userid",String.valueOf(user.getId()) ) // 设置内容
                .setIssuer("lws")// 设置签发人
                .signWith(signatureAlgorithm, "dahao"); // 签名，需要算法和key
        String jwt = builder.compact();
        return jwt;
    }

}
