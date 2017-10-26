package org.garen.mc.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 文章对象
 */
@ApiModel(description = "文章对象")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-24T05:54:51.190Z")

public class Article   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("summary")
  private String summary = null;

  @JsonProperty("md5")
  private String md5 = null;

  @JsonProperty("menuFullCode")
  private String menuFullCode = null;

  @JsonProperty("menuFullName")
  private String menuFullName = null;

  @JsonProperty("subjectName")
  private String subjectName = null;

  @JsonProperty("articleDetails")
  private List<ArticleDetail> articleDetails = null;

  public Article title(String title) {
    this.title = title;
    return this;
  }

   /**
   * 文章标题
   * @return title
  **/
  @ApiModelProperty(value = "文章标题")

 @Size(max=50)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Article summary(String summary) {
    this.summary = summary;
    return this;
  }

   /**
   * 文章简述
   * @return summary
  **/
  @ApiModelProperty(value = "文章简述")

 @Size(max=255)
  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Article md5(String md5) {
    this.md5 = md5;
    return this;
  }

   /**
   * 主题图片的md5值
   * @return md5
  **/
  @ApiModelProperty(value = "主题图片的md5值")

 @Size(max=50)
  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }

  public Article menuFullCode(String menuFullCode) {
    this.menuFullCode = menuFullCode;
    return this;
  }

   /**
   * 菜单码全路径（根据树形菜单可以获取）
   * @return menuFullCode
  **/
  @ApiModelProperty(value = "菜单码全路径（根据树形菜单可以获取）")

 @Size(max=255)
  public String getMenuFullCode() {
    return menuFullCode;
  }

  public void setMenuFullCode(String menuFullCode) {
    this.menuFullCode = menuFullCode;
  }

  public Article menuFullName(String menuFullName) {
    this.menuFullName = menuFullName;
    return this;
  }

   /**
   * 菜单名全路径（根据树形菜单可以获取）
   * @return menuFullName
  **/
  @ApiModelProperty(value = "菜单名全路径（根据树形菜单可以获取）")

 @Size(max=255)
  public String getMenuFullName() {
    return menuFullName;
  }

  public void setMenuFullName(String menuFullName) {
    this.menuFullName = menuFullName;
  }

  public Article subjectName(String subjectName) {
    this.subjectName = subjectName;
    return this;
  }

   /**
   * 专题名称
   * @return subjectName
  **/
  @ApiModelProperty(value = "专题名称")

 @Size(max=20)
  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public Article articleDetails(List<ArticleDetail> articleDetails) {
    this.articleDetails = articleDetails;
    return this;
  }

  public Article addArticleDetailsItem(ArticleDetail articleDetailsItem) {
    if (this.articleDetails == null) {
      this.articleDetails = new ArrayList<ArticleDetail>();
    }
    this.articleDetails.add(articleDetailsItem);
    return this;
  }

   /**
   * 文章内容集合，文章内容分成了多个部分
   * @return articleDetails
  **/
  @ApiModelProperty(value = "文章内容集合，文章内容分成了多个部分")

  @Valid

  public List<ArticleDetail> getArticleDetails() {
    return articleDetails;
  }

  public void setArticleDetails(List<ArticleDetail> articleDetails) {
    this.articleDetails = articleDetails;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return Objects.equals(this.title, article.title) &&
        Objects.equals(this.summary, article.summary) &&
        Objects.equals(this.md5, article.md5) &&
        Objects.equals(this.menuFullCode, article.menuFullCode) &&
        Objects.equals(this.menuFullName, article.menuFullName) &&
        Objects.equals(this.subjectName, article.subjectName) &&
        Objects.equals(this.articleDetails, article.articleDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, summary, md5, menuFullCode, menuFullName, subjectName, articleDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Article {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    md5: ").append(toIndentedString(md5)).append("\n");
    sb.append("    menuFullCode: ").append(toIndentedString(menuFullCode)).append("\n");
    sb.append("    menuFullName: ").append(toIndentedString(menuFullName)).append("\n");
    sb.append("    subjectName: ").append(toIndentedString(subjectName)).append("\n");
    sb.append("    articleDetails: ").append(toIndentedString(articleDetails)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

