package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SakeResponseBrewery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-18T16:13:46.002251+09:00[Asia/Tokyo]")
public class SakeResponseBrewery   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("prefecture")
  private String prefecture;

  public SakeResponseBrewery name(String name) {
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

  public SakeResponseBrewery prefecture(String prefecture) {
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
    SakeResponseBrewery sakeResponseBrewery = (SakeResponseBrewery) o;
    return Objects.equals(this.name, sakeResponseBrewery.name) &&
        Objects.equals(this.prefecture, sakeResponseBrewery.prefecture);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, prefecture);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SakeResponseBrewery {\n");
    
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

