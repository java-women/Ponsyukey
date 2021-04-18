package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DeleteReview
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-18T16:39:18.697306+09:00[Asia/Tokyo]")
public class DeleteReview   {
  @JsonProperty("saketomoId")
  private UUID saketomoId;

  public DeleteReview saketomoId(UUID saketomoId) {
    this.saketomoId = saketomoId;
    return this;
  }

  /**
   * 登録者ID
   * @return saketomoId
  */
  @ApiModelProperty(value = "登録者ID")

  @Valid

  public UUID getSaketomoId() {
    return saketomoId;
  }

  public void setSaketomoId(UUID saketomoId) {
    this.saketomoId = saketomoId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteReview deleteReview = (DeleteReview) o;
    return Objects.equals(this.saketomoId, deleteReview.saketomoId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saketomoId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteReview {\n");
    
    sb.append("    saketomoId: ").append(toIndentedString(saketomoId)).append("\n");
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

