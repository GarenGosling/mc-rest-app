package org.garen.mc.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Menu
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-24T02:47:40.809Z")

public class Menu   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("code")
  private String code = null;

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

  @JsonProperty("level")
  private Integer level = null;

  @JsonProperty("parentCode")
  private String parentCode = null;

  public Menu id(Long id) {
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

  public Menu code(String code) {
    this.code = code;
    return this;
  }

   /**
   * 编码
   * @return code
  **/
  @ApiModelProperty(value = "编码")

 @Size(max=64)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Menu name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 名字
   * @return name
  **/
  @ApiModelProperty(value = "名字")

 @Size(max=20)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Menu url(String url) {
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

  public Menu description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 描述信息
   * @return description
  **/
  @ApiModelProperty(value = "描述信息")

 @Size(max=255)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Menu status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 0表示不显示首页，1表示显示首页
   * @return status
  **/
  @ApiModelProperty(value = "0表示不显示首页，1表示显示首页")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Menu orderBy(Integer orderBy) {
    this.orderBy = orderBy;
    return this;
  }

   /**
   * 菜单显示顺序
   * @return orderBy
  **/
  @ApiModelProperty(value = "菜单显示顺序")


  public Integer getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(Integer orderBy) {
    this.orderBy = orderBy;
  }

  public Menu level(Integer level) {
    this.level = level;
    return this;
  }

   /**
   * 菜单等级，暂时有三级菜单
   * @return level
  **/
  @ApiModelProperty(value = "菜单等级，暂时有三级菜单")


  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Menu parentCode(String parentCode) {
    this.parentCode = parentCode;
    return this;
  }

   /**
   * 父菜单编码
   * @return parentCode
  **/
  @ApiModelProperty(value = "父菜单编码")

 @Size(max=64)
  public String getParentCode() {
    return parentCode;
  }

  public void setParentCode(String parentCode) {
    this.parentCode = parentCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Menu menu = (Menu) o;
    return Objects.equals(this.id, menu.id) &&
        Objects.equals(this.code, menu.code) &&
        Objects.equals(this.name, menu.name) &&
        Objects.equals(this.url, menu.url) &&
        Objects.equals(this.description, menu.description) &&
        Objects.equals(this.status, menu.status) &&
        Objects.equals(this.orderBy, menu.orderBy) &&
        Objects.equals(this.level, menu.level) &&
        Objects.equals(this.parentCode, menu.parentCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, name, url, description, status, orderBy, level, parentCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Menu {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    orderBy: ").append(toIndentedString(orderBy)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    parentCode: ").append(toIndentedString(parentCode)).append("\n");
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

