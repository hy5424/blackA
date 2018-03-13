
package com.lc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * ********************************************************
 * 
 * @ClassName: CommonCash
 * @Description: 流水表
 * @author 用lcy改进版的代码自动生成器
 * @date 2018-03-13 下午 05:16:55
 */
@Entity(name = "COMMON_CASH")
public class CommonCash extends BaseIdEntity {

    private static final long serialVersionUID = 4536899909364266709L;
    
    private Long userId; // 当前用户ID
    private Long accountId; // 当前用户账户ID
    private Long goldAll; // 总金币
    private Long dropGold; // 消费金币
    private Long riseGold; // 赢的金币
    private Long rmb; // 总点券
    private Long dropRmb; // 消费的点券
    private Long riseRmb; // 充值的点券

    @Column(name = "USER_ID")
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "ACCOUNT_ID")
    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(name = "GOLD_ALL")
    public Long getGoldAll() {
        return this.goldAll;
    }

    public void setGoldAll(Long goldAll) {
        this.goldAll = goldAll;
    }

    @Column(name = "DROP_GOLD")
    public Long getDropGold() {
        return this.dropGold;
    }

    public void setDropGold(Long dropGold) {
        this.dropGold = dropGold;
    }

    @Column(name = "RISE_GOLD")
    public Long getRiseGold() {
        return this.riseGold;
    }

    public void setRiseGold(Long riseGold) {
        this.riseGold = riseGold;
    }

    @Column(name = "RMB")
    public Long getRmb() {
        return this.rmb;
    }

    public void setRmb(Long rmb) {
        this.rmb = rmb;
    }

    @Column(name = "DROP_RMB")
    public Long getDropRmb() {
        return this.dropRmb;
    }

    public void setDropRmb(Long dropRmb) {
        this.dropRmb = dropRmb;
    }

    @Column(name = "RISE_RMB")
    public Long getRiseRmb() {
        return this.riseRmb;
    }

    public void setRiseRmb(Long riseRmb) {
        this.riseRmb = riseRmb;
    }

}
