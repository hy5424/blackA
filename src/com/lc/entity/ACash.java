package com.lc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ACash entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_cash")
public class ACash extends BaseIdEntity implements java.io.Serializable {

    private static final long serialVersionUID = 8141862323803898278L;
    // Fields

    private Long userId;
    private Long accountId;
    private Long goldAll;
    private Long dropGold;
    private Long riseGold;
    private Long rmb;
    private Long dropRmb;
    private Long riseRmb;
    private Date createTime;

    // Constructors

    /** default constructor */
    public ACash() {
    }

    /** full constructor */
    public ACash(Long userId, Long accountId, Long goldAll, Long dropGold, Long riseGold, Long rmb, Long dropRmb,
            Long riseRmb, Date createTime) {
        this.userId = userId;
        this.accountId = accountId;
        this.goldAll = goldAll;
        this.dropGold = dropGold;
        this.riseGold = riseGold;
        this.rmb = rmb;
        this.dropRmb = dropRmb;
        this.riseRmb = riseRmb;
        this.createTime = createTime;
    }

    @Column(name = "USER_ID", nullable = false, scale = 0)
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "ACCOUNT_ID", nullable = false, scale = 0)
    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(name = "GOLD_ALL", nullable = false, precision = 20, scale = 0)
    public Long getGoldAll() {
        return this.goldAll;
    }

    public void setGoldAll(Long goldAll) {
        this.goldAll = goldAll;
    }

    @Column(name = "DROP_GOLD", nullable = false, precision = 10, scale = 0)
    public Long getDropGold() {
        return this.dropGold;
    }

    public void setDropGold(Long dropGold) {
        this.dropGold = dropGold;
    }

    @Column(name = "RISE_GOLD", nullable = false, precision = 10, scale = 0)
    public Long getRiseGold() {
        return this.riseGold;
    }

    public void setRiseGold(Long riseGold) {
        this.riseGold = riseGold;
    }

    @Column(name = "RMB", nullable = false, precision = 10, scale = 0)
    public Long getRmb() {
        return this.rmb;
    }

    public void setRmb(Long rmb) {
        this.rmb = rmb;
    }

    @Column(name = "DROP_RMB", nullable = false, precision = 10, scale = 0)
    public Long getDropRmb() {
        return this.dropRmb;
    }

    public void setDropRmb(Long dropRmb) {
        this.dropRmb = dropRmb;
    }

    @Column(name = "RISE_RMB", nullable = false, precision = 10, scale = 0)
    public Long getRiseRmb() {
        return this.riseRmb;
    }

    public void setRiseRmb(Long riseRmb) {
        this.riseRmb = riseRmb;
    }

    @Column(name = "CREATE_TIME", nullable = false, length = 19)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
