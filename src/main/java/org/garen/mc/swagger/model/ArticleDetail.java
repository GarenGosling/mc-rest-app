package org.garen.mc.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * 文章详情
 */
@ApiModel(description = "文章详情")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-24T05:54:51.190Z")

public class ArticleDetail   {
  @JsonProperty("text")
  private String text = null;

  @JsonProperty("md5")
  private String md5 = null;

  public ArticleDetail text(String text) {
    this.text = text;
    return this;
  }

   /**
   * 文字段落
   * @return text
  **/
  @ApiModelProperty(value = "文字段落")

 @Size(max=4000)
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public ArticleDetail md5(String md5) {
    this.md5 = md5;
    return this;
  }

   /**
   * 图片md5
   * @return md5
  **/
  @ApiModelProperty(value = "图片md5")

 @Size(max=64)
  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArticleDetail articleDetail = (ArticleDetail) o;
    return Objects.equals(this.text, articleDetail.text) &&
        Objects.equals(this.md5, articleDetail.md5);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, md5);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArticleDetail {\n");
    
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    md5: ").append(toIndentedString(md5)).append("\n");
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

