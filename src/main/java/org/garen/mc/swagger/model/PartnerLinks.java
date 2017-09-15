package org.garen.mc.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PartnerLinks
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T00:55:07.765Z")

public class PartnerLinks   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("urlMd5")
  private String urlMd5 = null;

  public PartnerLinks code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public PartnerLinks name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PartnerLinks urlMd5(String urlMd5) {
    this.urlMd5 = urlMd5;
    return this;
  }

   /**
   * Get urlMd5
   * @return urlMd5
  **/
  @ApiModelProperty(value = "")


  public String getUrlMd5() {
    return urlMd5;
  }

  public void setUrlMd5(String urlMd5) {
    this.urlMd5 = urlMd5;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartnerLinks partnerLinks = (PartnerLinks) o;
    return Objects.equals(this.code, partnerLinks.code) &&
        Objects.equals(this.name, partnerLinks.name) &&
        Objects.equals(this.urlMd5, partnerLinks.urlMd5);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, urlMd5);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartnerLinks {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    urlMd5: ").append(toIndentedString(urlMd5)).append("\n");
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

