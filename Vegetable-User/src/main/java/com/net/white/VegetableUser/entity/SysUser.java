package com.net.white.VegetableUser.entity;

import javax.persistence.*;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author wangxijun
 * @Date 2018/12/17 13:49
 * @Version 1.0
 **/
@Entity
@Table(name = "user")
public class SysUser {
    @Id
    private String id;

    private String user_name;

    private String user_pass;

    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_pass='" + user_pass + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
