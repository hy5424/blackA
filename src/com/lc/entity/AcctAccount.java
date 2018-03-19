
package com.lc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ********************************************************
 * 
 * @ClassName: AcctAccount
 * @Description: 用户账户表
 * @author 用lcy改进版的代码自动生成器
 * @date 2018-03-13 下午 05:16:38
 */
@Entity
@Table(name = "ACCT_ACCOUNT")
public class AcctAccount extends BaseIdEntity {

    private static final long serialVersionUID = 4446747951077446120L;
    
    private Long userId; // 用户表ID
    private Long historyId; // 记录表ID
    private Long vip; // VIP等级
    private Long gold; // 当前用户拥有游戏金币数量
    private Long rmb; // 当前用户拥有点券数量
    private String status; // 状态

    @Column(name = "USER_ID")
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "HISTORY_ID")
    public Long getHistoryId() {
        return this.historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    @Column(name = "VIP")
    public Long getVip() {
        return this.vip;
    }

    public void setVip(Long vip) {
        this.vip = vip;
    }

    @Column(name = "GOLD")
    public Long getGold() {
        return this.gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    @Column(name = "RMB")
    public Long getRmb() {
        return this.rmb;
    }

    public void setRmb(Long rmb) {
        this.rmb = rmb;
    }

    @Column(name = "STATUS", length = 1)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
