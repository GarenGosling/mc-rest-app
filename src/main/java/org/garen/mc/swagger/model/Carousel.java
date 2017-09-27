package org.garen.mc.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Carousel
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-27T06:55:57.026Z")

public class Carousel   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("md5")
  private String md5 = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("place")
  private String place = null;

  @JsonProperty("orderBy")
  private Integer orderBy = null;

  public Carousel id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID
   * @return id
  **/
  @ApiModelProperty(value = "ID")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Carousel md5(String md5) {
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

  public Carousel description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 轮播图描述信息
   * @return description
  **/
  @ApiModelProperty(value = "轮播图描述信息")

 @Size(max=50)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Carousel status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 轮播图状态信息，1显示首页，0不显示首页
   * @return status
  **/
  @ApiModelProperty(value = "轮播图状态信息，1显示首页，0不显示首页")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Carousel place(String place) {
    this.place = place;
    return this;
  }

   /**
   * 轮播图的位置
   * @return place
  **/
  @ApiModelProperty(value = "轮播图的位置")

 @Size(max=50)
  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public Carousel orderBy(Integer orderBy) {
    this.orderBy = orderBy;
    return this;
  }

   /**
   * 轮播图排序字段
   * @return orderBy
  **/
  @ApiModelProperty(value = "轮播图排序字段")


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
    Carousel carousel = (Carousel) o;
    return Objects.equals(this.id, carousel.id) &&
        Objects.equals(this.md5, carousel.md5) &&
        Objects.equals(this.description, carousel.description) &&
        Objects.equals(this.status, carousel.status) &&
        Objects.equals(this.place, carousel.place) &&
        Objects.equals(this.orderBy, carousel.orderBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, md5, description, status, place, orderBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Carousel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    md5: ").append(toIndentedString(md5)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
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

