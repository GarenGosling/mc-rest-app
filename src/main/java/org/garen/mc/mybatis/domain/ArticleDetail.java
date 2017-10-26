package org.garen.mc.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class ArticleDetail implements Serializable {
    /**
     * id
     */
    private Long id;

    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 文字内容
     */
    private String text;

    /**
     * 图片MD5
     */
    private String md5;

    private String articleCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }
}