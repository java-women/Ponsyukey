package javajo.ponsyukey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

/**
 * CreateSake
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T15:29:30.596334700+09:00[Asia/Tokyo]")
public class CreateSake   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("image")
  private String image;

  @JsonProperty("brewery")
  private SakeBrewery brewery;

  @JsonProperty("alcohol")
  private Float alcohol;

  @JsonProperty("polishingRatio")
  private Float polishingRatio;

  @JsonProperty("type")
  private String type;

  @JsonProperty("description")
  private String description;

  @JsonProperty("taste")
  private Object taste;

  public CreateSake name(String name) {
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

  public CreateSake image(String image) {
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

  public CreateSake brewery(SakeBrewery brewery) {
    this.brewery = brewery;
    return this;
  }

  /**
   * Get brewery
   * @return brewery
  */
  @ApiModelProperty(value = "")

  @Valid

  public SakeBrewery getBrewery() {
    return brewery;
  }

  public void setBrewery(SakeBrewery brewery) {
    this.brewery = brewery;
  }

  public CreateSake alcohol(Float alcohol) {
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

  public CreateSake polishingRatio(Float polishingRatio) {
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

  public CreateSake type(String type) {
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

  public CreateSake description(String description) {
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

  public CreateSake taste(Object taste) {
    this.taste = taste;
    return this;
  }

  /**
   * 味情報は固定カラムを持たずに、自由入力。(例)J-SON、ハッシュタグ
   * @return taste
  */
  @ApiModelProperty(value = "味情報は固定カラムを持たずに、自由入力。(例)J-SON、ハッシュタグ")


  public Object getTaste() {
    return taste;
  }

  public void setTaste(Object taste) {
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
    CreateSake createSake = (CreateSake) o;
    return Objects.equals(this.name, createSake.name) &&
        Objects.equals(this.image, createSake.image) &&
        Objects.equals(this.brewery, createSake.brewery) &&
        Objects.equals(this.alcohol, createSake.alcohol) &&
        Objects.equals(this.polishingRatio, createSake.polishingRatio) &&
        Objects.equals(this.type, createSake.type) &&
        Objects.equals(this.description, createSake.description) &&
        Objects.equals(this.taste, createSake.taste);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, image, brewery, alcohol, polishingRatio, type, description, taste);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSake {\n");
    
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

