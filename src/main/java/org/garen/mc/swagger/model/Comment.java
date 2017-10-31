package org.garen.mc.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Comment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-31T02:39:41.567Z")

public class Comment   {
  @JsonProperty("content")
  private String content = null;

  @JsonProperty("articleCode")
  private String articleCode = null;

  public Comment content(String content) {
    this.content = content;
    return this;
  }

   /**
   * 评论内容
   * @return content
  **/
  @ApiModelProperty(value = "评论内容")

 @Size(max=100)
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Comment articleCode(String articleCode) {
    this.articleCode = articleCode;
    return this;
  }

   /**
   * 文章编码
   * @return articleCode
  **/
  @ApiModelProperty(value = "文章编码")

 @Size(max=64)
  public String getArticleCode() {
    return articleCode;
  }

  public void setArticleCode(String articleCode) {
    this.articleCode = articleCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comment comment = (Comment) o;
    return Objects.equals(this.content, comment.content) &&
        Objects.equals(this.articleCode, comment.articleCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, articleCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comment {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    articleCode: ").append(toIndentedString(articleCode)).append("\n");
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

