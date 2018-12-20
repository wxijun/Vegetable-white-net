package com.net.white.VegetableUser.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author wangxijun
 * @Date 2018/12/17 13:49
 * @Version 1.0
 **/
@Entity
@Table(name = "user")
public class SysUser implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")//这个是hibernate注解、生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    private String id;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_pass")
    private String userPass;

    @Column(name="token")
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
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
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
