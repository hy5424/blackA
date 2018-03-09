package com.lc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_history")
public class AHistory extends BaseIdEntity implements java.io.Serializable {

    private static final long serialVersionUID = 4097057234931234159L;
    // Fields

    private Long userId;
    private Long accountId;
    private Long count;
    private Long win;
    private Long lost;
    private Date matchTime;

    // Constructors

    /** default constructor */
    public AHistory() {
    }

    /** minimal constructor */
    public AHistory(Long userId, Long accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    /** full constructor */
    public AHistory(Long userId, Long accountId, Long count, Long win, Long lost, Date matchTime) {
        this.userId = userId;
        this.accountId = accountId;
        this.count = count;
        this.win = win;
        this.lost = lost;
        this.matchTime = matchTime;
    }

    @Column(name = "USER_ID", nullable = false, scale = 0)
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "ACCOUNT_ID", nullable = false, precision = 20, scale = 0)
    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(name = "COUNT", scale = 0)
    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "WIN", scale = 0)
    public Long getWin() {
        return this.win;
    }

    public void setWin(Long win) {
        this.win = win;
    }

    @Column(name = "LOST", scale = 0)
    public Long getLost() {
        return this.lost;
    }

    public void setLost(Long lost) {
        this.lost = lost;
    }

    @Column(name = "MATCH_TIME", length = 19)
    public Date getMatchTime() {
        return this.matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

}
