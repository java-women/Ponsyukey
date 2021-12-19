package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SakeBrewery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-19T16:53:27.171759500+09:00[Asia/Tokyo]")
public class SakeBrewery   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("prefecture")
  private String prefecture;

  public SakeBrewery name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SakeBrewery prefecture(String prefecture) {
    this.prefecture = prefecture;
    return this;
  }

  /**
   * Get prefecture
   * @return prefecture
  */
  @ApiModelProperty(value = "")


  public String getPrefecture() {
    return prefecture;
  }

  public void setPrefecture(String prefecture) {
    this.prefecture = prefecture;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SakeBrewery sakeBrewery = (SakeBrewery) o;
    return Objects.equals(this.name, sakeBrewery.name) &&
        Objects.equals(this.prefecture, sakeBrewery.prefecture);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, prefecture);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SakeBrewery {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    prefecture: ").append(toIndentedString(prefecture)).append("\n");
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

