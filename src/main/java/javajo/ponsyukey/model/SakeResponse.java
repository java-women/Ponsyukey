package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javajo.ponsyukey.model.SakeResponseBrewery;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SakeResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-18T16:13:46.002251+09:00[Asia/Tokyo]")
public class SakeResponse   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("image")
  private String image;

  @JsonProperty("brewery")
  private SakeResponseBrewery brewery;

  @JsonProperty("alcohol")
  private Float alcohol;

  @JsonProperty("polishingRatio")
  private Float polishingRatio;

  @JsonProperty("type")
  private String type;

  @JsonProperty("description")
  private String description;

  @JsonProperty("taste")
  @Valid
  private List<String> taste = null;

  public SakeResponse id(UUID id) {
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

  public SakeResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SakeResponse image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
  */
  @ApiModelProperty(value = "")


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public SakeResponse brewery(SakeResponseBrewery brewery) {
    this.brewery = brewery;
    return this;
  }

  /**
   * Get brewery
   * @return brewery
  */
  @ApiModelProperty(value = "")

  @Valid

  public SakeResponseBrewery getBrewery() {
    return brewery;
  }

  public void setBrewery(SakeResponseBrewery brewery) {
    this.brewery = brewery;
  }

  public SakeResponse alcohol(Float alcohol) {
    this.alcohol = alcohol;
    return this;
  }

  /**
   * Get alcohol
   * @return alcohol
  */
  @ApiModelProperty(value = "")


  public Float getAlcohol() {
    return alcohol;
  }

  public void setAlcohol(Float alcohol) {
    this.alcohol = alcohol;
  }

  public SakeResponse polishingRatio(Float polishingRatio) {
    this.polishingRatio = polishingRatio;
    return this;
  }

  /**
   * Get polishingRatio
   * @return polishingRatio
  */
  @ApiModelProperty(value = "")


  public Float getPolishingRatio() {
    return polishingRatio;
  }

  public void setPolishingRatio(Float polishingRatio) {
    this.polishingRatio = polishingRatio;
  }

  public SakeResponse type(String type) {
    this.type = type;
    return this;
  }

  /**
   * 特定名称 (例)吟醸酒、大吟醸など
   * @return type
  */
  @ApiModelProperty(value = "特定名称 (例)吟醸酒、大吟醸など")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SakeResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SakeResponse taste(List<String> taste) {
    this.taste = taste;
    return this;
  }

  public SakeResponse addTasteItem(String tasteItem) {
    if (this.taste == null) {
      this.taste = new ArrayList<String>();
    }
    this.taste.add(tasteItem);
    return this;
  }

  /**
   * 味情報は固定カラムを持たずに、自由入力。(例)ハッシュタグ
   * @return taste
  */
  @ApiModelProperty(value = "味情報は固定カラムを持たずに、自由入力。(例)ハッシュタグ")


  public List<String> getTaste() {
    return taste;
  }

  public void setTaste(List<String> taste) {
    this.taste = taste;
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
    return Objects.equals(this.id, sakeResponse.id) &&
        Objects.equals(this.name, sakeResponse.name) &&
        Objects.equals(this.image, sakeResponse.image) &&
        Objects.equals(this.brewery, sakeResponse.brewery) &&
        Objects.equals(this.alcohol, sakeResponse.alcohol) &&
        Objects.equals(this.polishingRatio, sakeResponse.polishingRatio) &&
        Objects.equals(this.type, sakeResponse.type) &&
        Objects.equals(this.description, sakeResponse.description) &&
        Objects.equals(this.taste, sakeResponse.taste);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, image, brewery, alcohol, polishingRatio, type, description, taste);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SakeResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    brewery: ").append(toIndentedString(brewery)).append("\n");
    sb.append("    alcohol: ").append(toIndentedString(alcohol)).append("\n");
    sb.append("    polishingRatio: ").append(toIndentedString(polishingRatio)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    taste: ").append(toIndentedString(taste)).append("\n");
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

