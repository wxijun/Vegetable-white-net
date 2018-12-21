package com.net.white.VegetableUser.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "token")
public class Token implements Serializable {
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")//这个是hibernate注解、生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Column(name="token_id")
    private String tokenId;

    @Column(name="user_id")
    private String userId;

    @Column(name="create_date")
    private Integer createDate;

    @Column(name="token")
    private String token;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenId='" + tokenId + '\'' +
                ", userId='" + userId + '\'' +
                ", createDate=" + createDate +
                ", token='" + token + '\'' +
                '}';
    }
}
