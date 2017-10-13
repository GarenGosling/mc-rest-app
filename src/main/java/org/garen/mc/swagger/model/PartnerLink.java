package org.garen.mc.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PartnerLink
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-13T02:54:43.490Z")

public class PartnerLink   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("md5")
  private String md5 = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("status")
  private Integer status = null;

  public PartnerLink id(Long id) {
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

  public PartnerLink code(String code) {
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

  public PartnerLink name(String name) {
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

  public PartnerLink url(String url) {
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

  public PartnerLink md5(String md5) {
    this.md5 = md5;
    return this;
  }

   /**
   * 图片MD5值
   * @return md5
  **/
  @ApiModelProperty(value = "图片MD5值")

 @Size(max=50)
  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }

  public PartnerLink description(String description) {
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

  public PartnerLink status(Integer status) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartnerLink partnerLink = (PartnerLink) o;
    return Objects.equals(this.id, partnerLink.id) &&
        Objects.equals(this.code, partnerLink.code) &&
        Objects.equals(this.name, partnerLink.name) &&
        Objects.equals(this.url, partnerLink.url) &&
        Objects.equals(this.md5, partnerLink.md5) &&
        Objects.equals(this.description, partnerLink.description) &&
        Objects.equals(this.status, partnerLink.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, name, url, md5, description, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartnerLink {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    md5: ").append(toIndentedString(md5)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

