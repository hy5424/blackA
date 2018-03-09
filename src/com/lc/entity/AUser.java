package com.lc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_user")
public class AUser extends BaseIdEntity implements java.io.Serializable {

    private static final long serialVersionUID = -4413327608828209212L;
    // Fields

    private Long idSql;
    private String name;
    private Integer sex;
    private String pwd;
    private Date lastDate;

    // Constructors

    /** default constructor */
    public AUser() {
    }

    /** minimal constructor */
    public AUser(String name, Integer sex, String pwd, Date lastDate) {
        this.name = name;
        this.sex = sex;
        this.pwd = pwd;
        this.lastDate = lastDate;
    }

    /** full constructor */
    public AUser(Long idSql, String name, Integer sex, String pwd, Date lastDate) {
        this.idSql = idSql;
        this.name = name;
        this.sex = sex;
        this.pwd = pwd;
        this.lastDate = lastDate;
    }

    @Column(name = "ID_SQL", scale = 0)
    public Long getIdSql() {
        return this.idSql;
    }

    public void setIdSql(Long idSql) {
        this.idSql = idSql;
    }

    @Column(name = "NAME", nullable = false, length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SEX", nullable = false)
    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "PWD", nullable = false, length = 20)
    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "LAST_DATE", nullable = false, length = 19)
    public Date getLastDate() {
        return this.lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

}
