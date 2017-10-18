package org.garen.mc.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Author
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-17T09:09:21.807Z")

public class Author   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userCode")
  private String userCode = null;

  @JsonProperty("idNum")
  private String idNum = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("realName")
  private String realName = null;

  @JsonProperty("penName")
  private String penName = null;

  @JsonProperty("status")
  private Integer status = null;

  public Author id(Long id) {
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

  public Author userCode(String userCode) {
    this.userCode = userCode;
    return this;
  }

   /**
   * 编码
   * @return userCode
  **/
  @ApiModelProperty(value = "编码")

 @Size(max=64)
  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public Author idNum(String idNum) {
    this.idNum = idNum;
    return this;
  }

   /**
   * 身份证
   * @return idNum
  **/
  @ApiModelProperty(value = "身份证")

 @Size(max=18)
  public String getIdNum() {
    return idNum;
  }

  public void setIdNum(String idNum) {
    this.idNum = idNum;
  }

  public Author phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * 手机号
   * @return phone
  **/
  @ApiModelProperty(value = "手机号")

 @Size(max=11)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Author realName(String realName) {
    this.realName = realName;
    return this;
  }

   /**
   * 真实姓名
   * @return realName
  **/
  @ApiModelProperty(value = "真实姓名")

 @Size(max=20)
  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Author penName(String penName) {
    this.penName = penName;
    return this;
  }

   /**
   * 笔名
   * @return penName
  **/
  @ApiModelProperty(value = "笔名")

 @Size(max=32)
  public String getPenName() {
    return penName;
  }

  public void setPenName(String penName) {
    this.penName = penName;
  }

  public Author status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 0禁用，1启用
   * @return status
  **/
  @ApiModelProperty(value = "0禁用，1启用")


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
    Author author = (Author) o;
    return Objects.equals(this.id, author.id) &&
        Objects.equals(this.userCode, author.userCode) &&
        Objects.equals(this.idNum, author.idNum) &&
        Objects.equals(this.phone, author.phone) &&
        Objects.equals(this.realName, author.realName) &&
        Objects.equals(this.penName, author.penName) &&
        Objects.equals(this.status, author.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userCode, idNum, phone, realName, penName, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Author {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userCode: ").append(toIndentedString(userCode)).append("\n");
    sb.append("    idNum: ").append(toIndentedString(idNum)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    realName: ").append(toIndentedString(realName)).append("\n");
    sb.append("    penName: ").append(toIndentedString(penName)).append("\n");
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

