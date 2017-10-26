package org.garen.mc.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class LifeWizard implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 项目名
     */
    private String name;

    /**
     * 链接
     */
    private String url;

    /**
     * 项目描述信息
     */
    private String description;

    /**
     * 图片MD5值
     */
    private String md5;

    /**
     * 状态（0：不显示；1：显示）
     */
    private Integer status;

    /**
     * 排列顺序
     */
    private Integer orderBy;

    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}