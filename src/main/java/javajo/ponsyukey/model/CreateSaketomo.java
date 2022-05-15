package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javajo.ponsyukey.model.CreateSaketomoSaketomo;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateSaketomo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-15T15:59:15.741154700+09:00[Asia/Tokyo]")
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

