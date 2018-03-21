
package com.lc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ********************************************************
 * 
 * @ClassName: CommonImage
 * @Description: 图片表
 * @author 用lcy改进版的代码自动生成器
 * @date 2018-03-13 下午 05:17:16
 */
@Entity
@Table(name = "COMMON_IMAGE")
public class CommonImage extends BaseIdEntity {

    private static final long serialVersionUID = 8041506618517953472L;

    private String path; // 图片保存路径
    private String objectId; // 对象ID
    private String imageType; // 图片类型
    private String status; // 状态

    @Column(name = "PATH", length = 200)
    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "OBJECT_ID", length = 20)
    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Column(name = "IMAGE_TYPE", length = 3)
    public String getImageType() {
        return this.imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Column(name = "STATUS", length = 1)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
