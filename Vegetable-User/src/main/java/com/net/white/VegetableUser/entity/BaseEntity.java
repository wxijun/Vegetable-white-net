package com.net.white.VegetableUser.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BaseEntity 公共类
 * @Description TODO
 * @Author wangxijun
 * @Date 2018/12/20 16:59
 * @Version 1.0
 **/
@Entity
public class BaseEntity implements Serializable{
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")//这个是hibernate注解、生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Temporal(TemporalType.DATE)//data只有日期
    @Column(name="create_date")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name="update_date")
    private Date updateDate;

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
}
