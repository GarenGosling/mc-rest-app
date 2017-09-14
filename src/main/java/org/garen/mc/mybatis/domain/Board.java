package org.garen.mc.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Board implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 编码
     */
    private String code;

    /**
     * 版块名
     */
    private String name;

    /**
     * 板块链接
     */
    private String url;

    /**
     * 版块默认图片url的md5值
     */
    private String defaultImgMd5;

    /**
     * 版块默认缩略图url的md5值
     */
    private String defaultImgThumbMd5;

    /**
     * 板块描述信息
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 板块状态
     */
    private Integer status;

    /**
     * 是否显示在首页菜单（1显示0不显示）
     */
    private Integer isMenu;

    /**
     * 是够显示在首页热门板块处(1显示，0不显示）
     */
    private Integer isHot;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDefaultImgMd5() {
        return defaultImgMd5;
    }

    public void setDefaultImgMd5(String defaultImgMd5) {
        this.defaultImgMd5 = defaultImgMd5;
    }

    public String getDefaultImgThumbMd5() {
        return defaultImgThumbMd5;
    }

    public void setDefaultImgThumbMd5(String defaultImgThumbMd5) {
        this.defaultImgThumbMd5 = defaultImgThumbMd5;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
}