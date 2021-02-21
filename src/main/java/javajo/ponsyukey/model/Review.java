package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.UUID;
import javajo.ponsyukey.model.ReviewSaketomo;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Review
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-21T08:00:01.182023100Z[UTC]")
public class Review   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("saketomo")
  private ReviewSaketomo saketomo;

  @JsonProperty("createdAt")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private Date createdAt;

  @JsonProperty("rating")
  private Integer rating;

  @JsonProperty("comment")
  private String comment;

  public Review id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Review saketomo(ReviewSaketomo saketomo) {
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

  public Review createdAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * 作成日時
   * @return createdAt
  */
  @ApiModelProperty(value = "作成日時")

  @Valid

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Review rating(Integer rating) {
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

  public Review comment(String comment) {
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
    Review review = (Review) o;
    return Objects.equals(this.id, review.id) &&
        Objects.equals(this.saketomo, review.saketomo) &&
        Objects.equals(this.createdAt, review.createdAt) &&
        Objects.equals(this.rating, review.rating) &&
        Objects.equals(this.comment, review.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, saketomo, createdAt, rating, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Review {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    saketomo: ").append(toIndentedString(saketomo)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

