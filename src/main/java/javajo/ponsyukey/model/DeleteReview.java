package javajo.ponsyukey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;
import java.util.UUID;

/**
 * DeleteReview
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T15:29:30.596334700+09:00[Asia/Tokyo]")
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

