
package com.lc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * ********************************************************
 * 
 * @ClassName: CommonUser
 * @Description: 用户表
 * @author 用lcy改进版的代码自动生成器
 * @date 2018-03-13 下午 05:36:59
 */
@Entity(name = "COMMON_USER")
public class CommonUser extends BaseIdEntity {

    private static final long serialVersionUID = -257763960345631455L;

    private String name; // 昵称
    private Integer sex; // 性别
    private String pwd; // 密码
    private Date lastDate; // 上次登录日期
    private String roomId; // 房间
    private String tableId; // 桌子
    private String status; // 状态

    @Column(name = "NAME", length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SEX")
    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "PWD", length = 20)
    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "LAST_DATE")
    public Date getLastDate() {
        return this.lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    @Column(name = "ROOM_ID", length = 20)
    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Column(name = "TABLE_ID", length = 20)
    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Column(name = "STATUS", length = 1)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
