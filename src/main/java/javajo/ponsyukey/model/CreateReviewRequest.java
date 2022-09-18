package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javajo.ponsyukey.model.Saketomo;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateReviewRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-18T16:13:46.002251+09:00[Asia/Tokyo]")
public class CreateReviewRequest   {
  @JsonProperty("saketomo")
  private Saketomo saketomo;

  @JsonProperty("rating")
  private Integer rating;

  @JsonProperty("comment")
  private String comment;

  public CreateReviewRequest saketomo(Saketomo saketomo) {
    this.saketomo = saketomo;
    return this;
  }

  /**
   * Get saketomo
   * @return saketomo
  */
  @ApiModelProperty(value = "")

  @Valid

  public Saketomo getSaketomo() {
    return saketomo;
  }

  public void setSaketomo(Saketomo saketomo) {
    this.saketomo = saketomo;
  }

  public CreateReviewRequest rating(Integer rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
  */
  @ApiModelProperty(value = "")


  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public CreateReviewRequest comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
  */
  @ApiModelProperty(value = "")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateReviewRequest createReviewRequest = (CreateReviewRequest) o;
    return Objects.equals(this.saketomo, createReviewRequest.saketomo) &&
        Objects.equals(this.rating, createReviewRequest.rating) &&
        Objects.equals(this.comment, createReviewRequest.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saketomo, rating, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateReviewRequest {\n");
    
    sb.append("    saketomo: ").append(toIndentedString(saketomo)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

