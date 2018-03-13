
package com.lc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * ********************************************************
 * 
 * @ClassName: CommonHistory
 * @Description: 历史记录表
 * @author 用lcy改进版的代码自动生成器
 * @date 2018-03-13 下午 05:17:05
 */
@Entity(name = "COMMON_HISTORY")
public class CommonHistory extends BaseIdEntity {

    private static final long serialVersionUID = -3500246209865905564L;

    private Long userId; // 当前用户ID
    private Long accountId; // 当前用户账户ID
    private Long count; // 玩的总次数
    private Long win; // 赢的次数
    private Long lost; // 输的次数
    private Date matchTime; // 当前比赛的时间

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

    @Column(name = "COUNT")
    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "WIN")
    public Long getWin() {
        return this.win;
    }

    public void setWin(Long win) {
        this.win = win;
    }

    @Column(name = "LOST")
    public Long getLost() {
        return this.lost;
    }

    public void setLost(Long lost) {
        this.lost = lost;
    }

    @Column(name = "MATCH_TIME")
    public Date getMatchTime() {
        return this.matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

}
