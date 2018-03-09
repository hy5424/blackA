package com.lc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AImage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_image")
public class AImage extends BaseIdEntity implements java.io.Serializable {

    private static final long serialVersionUID = 287992536326146077L;
    // Fields

    private String path;
    private String objectId;
    private String imageType;
    private String status;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;

    // Constructors

    /** default constructor */
    public AImage() {
    }

    /** minimal constructor */
    public AImage(String path, String status, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.path = path;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    /** full constructor */
    public AImage(String path, String objectId, String imageType, String status, Date createTime, String createBy,
            Date updateTime, String updateBy) {
        this.path = path;
        this.objectId = objectId;
        this.imageType = imageType;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    @Column(name = "PATH", nullable = false, length = 200)
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

    @Column(name = "STATUS", nullable = false, length = 1)
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

    @Column(name = "CREATE_BY", nullable = false, length = 20)
    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
