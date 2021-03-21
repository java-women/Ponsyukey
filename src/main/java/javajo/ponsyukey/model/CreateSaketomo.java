package javajo.ponsyukey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

/**
 * CreateSaketomo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T15:29:30.596334700+09:00[Asia/Tokyo]")
public class CreateSaketomo   {
  @JsonProperty("saketomo")
  private CreateSaketomoSaketomo saketomo;

  public CreateSaketomo saketomo(CreateSaketomoSaketomo saketomo) {
    this.saketomo = saketomo;
    return this;
  }

  /**
   * Get saketomo
   * @return saketomo
  */
  @ApiModelProperty(value = "")

  @Valid

  public CreateSaketomoSaketomo getSaketomo() {
    return saketomo;
  }

  public void setSaketomo(CreateSaketomoSaketomo saketomo) {
    this.saketomo = saketomo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSaketomo createSaketomo = (CreateSaketomo) o;
    return Objects.equals(this.saketomo, createSaketomo.saketomo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saketomo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSaketomo {\n");
    
    sb.append("    saketomo: ").append(toIndentedString(saketomo)).append("\n");
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

