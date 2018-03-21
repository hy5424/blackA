
package com.lc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ********************************************************
 * 
 * @ClassName: CommonRoom
 * @Description: 房间表
 * @author 用lcy改进版的代码自动生成器
 * @date 2018-03-13 下午 05:17:34
 */
@Entity
@Table(name = "COMMON_ROOM")
public class CommonRoom extends BaseIdEntity {

    private static final long serialVersionUID = -5612419891329906131L;

    private String name; // 昵称
    private String status; // 状态

    @Column(name = "NAME", length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "STATUS", length = 1)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
