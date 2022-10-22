package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.UUID;
import javajo.ponsyukey.model.Saketomo;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReviewResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-22T16:06:48.697644+09:00[Asia/Tokyo]")
public class ReviewResponse   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("saketomo")
  private Saketomo saketomo;

  @JsonProperty("createdAt")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private Date createdAt;

  @JsonProperty("rating")
  private Integer rating;

  @JsonProperty("comment")
  private String comment;

  public ReviewResponse id(UUID id) {
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

  public ReviewResponse saketomo(Saketomo saketomo) {
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

  public ReviewResponse createdAt(Date createdAt) {
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

  public ReviewResponse rating(Integer rating) {
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

  public ReviewResponse comment(String comment) {
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
    ReviewResponse reviewResponse = (ReviewResponse) o;
    return Objects.equals(this.id, reviewResponse.id) &&
        Objects.equals(this.saketomo, reviewResponse.saketomo) &&
        Objects.equals(this.createdAt, reviewResponse.createdAt) &&
        Objects.equals(this.rating, reviewResponse.rating) &&
        Objects.equals(this.comment, reviewResponse.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, saketomo, createdAt, rating, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReviewResponse {\n");
    
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

