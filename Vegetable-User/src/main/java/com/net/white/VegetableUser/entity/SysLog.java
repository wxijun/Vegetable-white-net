package com.net.white.VegetableUser.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysLog
 * @Description TODO
 * @Author wangxijun
 * @Date 2018/12/20 11:01
 * @Version 1.0
 **/
@Entity
@Table(name = "sys_log")
public class SysLog implements Serializable {

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

    @Column(name="user_id")
    private String userId; //用户ID

    @Column(name="user_name")
    private String userName; //用户名

    @Column(name="operation")
    private String operation; //操作

    @Column(name="method")
    private String method; //方法名

    @Column(name="params")
    private String params; //参数

    @Column(name="ip")
    private String Ip; //ip地址

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }
}
