package org.garen.mc.mybatis.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class Article implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 文章编码
     */
    private String code;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章内容简述
     */
    private String summary;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 作者编码
     */
    private String authorCode;

    /**
     * 作者笔名
     */
    private String authorPenName;

    /**
     * 全部菜单码以/分割
     */
    private String menuFullCode;

    /**
     * 全部菜单名以/分割
     */
    private String menuFullName;

    /**
     * 专题名称
     */
    private String subjectName;

    /**
     * 主题图片的md5值
     */
    private String md5;

    /**
     * 查看数
     */
    private Integer viewNum;

    private Integer commentNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private List<ArticleDetail> articleDetails;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
    }

    public String getAuthorPenName() {
        return authorPenName;
    }

    public void setAuthorPenName(String authorPenName) {
        this.authorPenName = authorPenName;
    }

    public String getMenuFullCode() {
        return menuFullCode;
    }

    public void setMenuFullCode(String menuFullCode) {
        this.menuFullCode = menuFullCode;
    }

    public String getMenuFullName() {
        return menuFullName;
    }

    public void setMenuFullName(String menuFullName) {
        this.menuFullName = menuFullName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<ArticleDetail> getArticleDetails() {
        return articleDetails;
    }

    public void setArticleDetails(List<ArticleDetail> articleDetails) {
        this.articleDetails = articleDetails;
    }
}