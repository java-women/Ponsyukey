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
 * DeleteReviewRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-22T16:06:48.697644+09:00[Asia/Tokyo]")
public class DeleteReviewRequest   {
  @JsonProperty("saketomoId")
  private UUID saketomoId;

  public DeleteReviewRequest saketomoId(UUID saketomoId) {
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
    DeleteReviewRequest deleteReviewRequest = (DeleteReviewRequest) o;
    return Objects.equals(this.saketomoId, deleteReviewRequest.saketomoId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saketomoId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteReviewRequest {\n");
    
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

