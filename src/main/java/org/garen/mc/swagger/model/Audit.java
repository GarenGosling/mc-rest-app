package org.garen.mc.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 审核对象
 */
@ApiModel(description = "审核对象")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-03T17:48:26.934Z")

public class Audit   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("remark")
  private String remark = null;

  public Audit id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * id
   * @return id
  **/
  @ApiModelProperty(value = "id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Audit status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 审核状态
   * @return status
  **/
  @ApiModelProperty(value = "审核状态")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Audit remark(String remark) {
    this.remark = remark;
    return this;
  }

   /**
   * 驳回理由
   * @return remark
  **/
  @ApiModelProperty(value = "驳回理由")


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Audit audit = (Audit) o;
    return Objects.equals(this.id, audit.id) &&
        Objects.equals(this.status, audit.status) &&
        Objects.equals(this.remark, audit.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Audit {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
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

