package org.garen.mc.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CooperativeBrand implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 编码
     */
    private String code;

    /**
     * 品牌名
     */
    private String name;

    /**
     * 品牌链接md5
     */
    private String urlMd5;

    /**
     * 品牌描述信息
     */
    private String description;

    /**
     * 图片链接md5
     */
    private String imgUrlMd5;

    /**
     * 图片链接缩略图md5
     */
    private String imgUrlThumbMd5;

    /**
     * 合作品牌状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

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

    public String getUrlMd5() {
        return urlMd5;
    }

    public void setUrlMd5(String urlMd5) {
        this.urlMd5 = urlMd5;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrlMd5() {
        return imgUrlMd5;
    }

    public void setImgUrlMd5(String imgUrlMd5) {
        this.imgUrlMd5 = imgUrlMd5;
    }

    public String getImgUrlThumbMd5() {
        return imgUrlThumbMd5;
    }

    public void setImgUrlThumbMd5(String imgUrlThumbMd5) {
        this.imgUrlThumbMd5 = imgUrlThumbMd5;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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