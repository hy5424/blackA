
package com.lc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * ********************************************************
 * 
 * @ClassName: CommonTable
 * @Description: 牌局表
 * @author 用lcy改进版的代码自动生成器
 * @date 2018-03-13 下午 05:19:07
 */
@Entity(name = "COMMON_TABLE")
public class CommonTable extends BaseIdEntity {

    private static final long serialVersionUID = 2168258348520061809L;

    private String name; // 昵称
    private String roomId; // 房间ID
    private String status; // 状态

    @Column(name = "NAME", length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ROOM_ID", length = 20)
    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Column(name = "STATUS", length = 1)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
