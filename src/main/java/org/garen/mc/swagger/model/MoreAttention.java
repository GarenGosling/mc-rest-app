package org.garen.mc.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * 更多关注对象
 */
@ApiModel(description = "更多关注对象")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T15:59:03.592Z")

public class MoreAttention   {
  @JsonProperty("url")
  private String url = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("md5")
  private String md5 = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("orderBy")
  private Integer orderBy = null;

  public MoreAttention url(String url) {
    this.url = url;
    return this;
  }

   /**
   * 关注网站链接
   * @return url
  **/
  @ApiModelProperty(value = "关注网站链接")

 @Size(max=50)
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public MoreAttention description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 描述信息
   * @return description
  **/
  @ApiModelProperty(value = "描述信息")

 @Size(max=100)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MoreAttention md5(String md5) {
    this.md5 = md5;
    return this;
  }

   /**
   * 关注网站主题图片的md5值
   * @return md5
  **/
  @ApiModelProperty(value = "关注网站主题图片的md5值")

 @Size(max=50)
  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }

  public MoreAttention status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态（0：不显示；1：显示）
   * @return status
  **/
  @ApiModelProperty(value = "状态（0：不显示；1：显示）")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public MoreAttention orderBy(Integer orderBy) {
    this.orderBy = orderBy;
    return this;
  }

   /**
   * 排列顺序
   * @return orderBy
  **/
  @ApiModelProperty(value = "排列顺序")


  public Integer getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(Integer orderBy) {
    this.orderBy = orderBy;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoreAttention moreAttention = (MoreAttention) o;
    return Objects.equals(this.url, moreAttention.url) &&
        Objects.equals(this.description, moreAttention.description) &&
        Objects.equals(this.md5, moreAttention.md5) &&
        Objects.equals(this.status, moreAttention.status) &&
        Objects.equals(this.orderBy, moreAttention.orderBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, description, md5, status, orderBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoreAttention {\n");
    
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    md5: ").append(toIndentedString(md5)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    orderBy: ").append(toIndentedString(orderBy)).append("\n");
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

