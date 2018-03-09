package com.lc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * AAccount entity. @author MyEclipse Persistence Tools
 */
@Entity(name = "A_Account")
public class AAccount extends BaseIdEntity implements java.io.Serializable {

	// Fields

	
    private static final long serialVersionUID = -8539986373425784988L;
    
    private Long userId;
	private Long historyId;
	private Byte vip;
	private Long gold;
	private Integer rmb;
	private String status;
	private Date createTime;
	private Date updateTime;
	private String updateBy;

	// Constructors

	/** default constructor */
	public AAccount() {
	}

	/** minimal constructor */
	public AAccount(Long userId, Byte vip, Long gold,
			Integer rmb, Date createTime, Date updateTime,
			String updateBy) {
		this.userId = userId;
		this.vip = vip;
		this.gold = gold;
		this.rmb = rmb;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
	}

	/** full constructor */
	public AAccount(Long userId, Long historyId,
			Byte vip, Long gold, Integer rmb, String status,
			Date createTime, Date updateTime, String updateBy) {
		this.userId = userId;
		this.historyId = historyId;
		this.vip = vip;
		this.gold = gold;
		this.rmb = rmb;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
	}

	@Column(name = "USER_ID", nullable = false, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "HISTORY_ID", scale = 0)
	public Long getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	@Column(name = "VIP", nullable = false, precision = 2, scale = 0)
	public Byte getVip() {
		return this.vip;
	}

	public void setVip(Byte vip) {
		this.vip = vip;
	}

	@Column(name = "GOLD", nullable = false, precision = 11, scale = 0)
	public Long getGold() {
		return this.gold;
	}

	public void setGold(Long gold) {
		this.gold = gold;
	}

	@Column(name = "RMB", nullable = false, precision = 8, scale = 0)
	public Integer getRmb() {
		return this.rmb;
	}

	public void setRmb(Integer rmb) {
		this.rmb = rmb;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "CREATE_TIME", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_TIME", nullable = false, length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "UPDATE_BY", nullable = false, length = 20)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}