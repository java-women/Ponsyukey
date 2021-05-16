package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javajo.ponsyukey.model.Sake;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SakeResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-16T15:18:54.213477800+09:00[Asia/Tokyo]")
public class SakeResponse   {
  @JsonProperty("resultCode")
  private String resultCode;

  @JsonProperty("sake")
  private Sake sake;

  public SakeResponse resultCode(String resultCode) {
    this.resultCode = resultCode;
    return this;
  }

  /**
   * Get resultCode
   * @return resultCode
  */
  @ApiModelProperty(value = "")


  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public SakeResponse sake(Sake sake) {
    this.sake = sake;
    return this;
  }

  /**
   * Get sake
   * @return sake
  */
  @ApiModelProperty(value = "")

  @Valid

  public Sake getSake() {
    return sake;
  }

  public void setSake(Sake sake) {
    this.sake = sake;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SakeResponse sakeResponse = (SakeResponse) o;
    return Objects.equals(this.resultCode, sakeResponse.resultCode) &&
        Objects.equals(this.sake, sakeResponse.sake);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resultCode, sake);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SakeResponse {\n");
    
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
    sb.append("    sake: ").append(toIndentedString(sake)).append("\n");
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

