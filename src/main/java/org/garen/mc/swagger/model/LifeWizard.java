package org.garen.mc.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * LifeWizard
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-23T09:34:36.321Z")

public class LifeWizard   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("md5")
  private String md5 = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("orderBy")
  private Integer orderBy = null;

  public LifeWizard id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * ID
   * @return id
  **/
  @ApiModelProperty(value = "ID")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LifeWizard md5(String md5) {
    this.md5 = md5;
    return this;
  }

   /**
   * 图片md5值
   * @return md5
  **/
  @ApiModelProperty(value = "图片md5值")

 @Size(max=50)
  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }

  public LifeWizard name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 项目名
   * @return name
  **/
  @ApiModelProperty(value = "项目名")

 @Size(max=20)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LifeWizard url(String url) {
    this.url = url;
    return this;
  }

   /**
   * 链接
   * @return url
  **/
  @ApiModelProperty(value = "链接")

 @Size(max=50)
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public LifeWizard description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 生活向导描述信息
   * @return description
  **/
  @ApiModelProperty(value = "生活向导描述信息")

 @Size(max=100)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LifeWizard status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 生活向导状态信息，1显示首页，0不显示首页
   * @return status
  **/
  @ApiModelProperty(value = "生活向导状态信息，1显示首页，0不显示首页")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public LifeWizard orderBy(Integer orderBy) {
    this.orderBy = orderBy;
    return this;
  }

   /**
   * 生活向导排序字段
   * @return orderBy
  **/
  @ApiModelProperty(value = "生活向导排序字段")


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
    LifeWizard lifeWizard = (LifeWizard) o;
    return Objects.equals(this.id, lifeWizard.id) &&
        Objects.equals(this.md5, lifeWizard.md5) &&
        Objects.equals(this.name, lifeWizard.name) &&
        Objects.equals(this.url, lifeWizard.url) &&
        Objects.equals(this.description, lifeWizard.description) &&
        Objects.equals(this.status, lifeWizard.status) &&
        Objects.equals(this.orderBy, lifeWizard.orderBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, md5, name, url, description, status, orderBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifeWizard {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    md5: ").append(toIndentedString(md5)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

