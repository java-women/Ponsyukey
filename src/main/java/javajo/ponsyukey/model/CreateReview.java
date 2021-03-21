package javajo.ponsyukey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

/**
 * CreateReview
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T15:29:30.596334700+09:00[Asia/Tokyo]")
public class CreateReview   {
  @JsonProperty("saketomo")
  private ReviewSaketomo saketomo;

  @JsonProperty("rating")
  private Integer rating;

  @JsonProperty("comment")
  private String comment;

  public CreateReview saketomo(ReviewSaketomo saketomo) {
    this.saketomo = saketomo;
    return this;
  }

  /**
   * Get saketomo
   * @return saketomo
  */
  @ApiModelProperty(value = "")

  @Valid

  public ReviewSaketomo getSaketomo() {
    return saketomo;
  }

  public void setSaketomo(ReviewSaketomo saketomo) {
    this.saketomo = saketomo;
  }

  public CreateReview rating(Integer rating) {
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

  public CreateReview comment(String comment) {
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
    CreateReview createReview = (CreateReview) o;
    return Objects.equals(this.saketomo, createReview.saketomo) &&
        Objects.equals(this.rating, createReview.rating) &&
        Objects.equals(this.comment, createReview.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saketomo, rating, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateReview {\n");
    
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

