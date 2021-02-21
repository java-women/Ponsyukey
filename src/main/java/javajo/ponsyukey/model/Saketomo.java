package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Saketomo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-21T07:14:50.757524300Z[UTC]")
public class Saketomo   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  /**
   * 既存画像から選んでもらう(キーもしくはURL)。enumにない値もしくは空/nullの場合はバリデーションチェックでエラーにします
   */
  public enum ImageEnum {
    ICON1("icon1"),
    
    ICON2("icon2"),
    
    ICON3("icon3");

    private String value;

    ImageEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ImageEnum fromValue(String value) {
      for (ImageEnum b : ImageEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("image")
  private ImageEnum image;

  public Saketomo id(UUID id) {
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

  public Saketomo name(String name) {
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

  public Saketomo image(ImageEnum image) {
    this.image = image;
    return this;
  }

  /**
   * 既存画像から選んでもらう(キーもしくはURL)。enumにない値もしくは空/nullの場合はバリデーションチェックでエラーにします
   * @return image
  */
  @ApiModelProperty(value = "既存画像から選んでもらう(キーもしくはURL)。enumにない値もしくは空/nullの場合はバリデーションチェックでエラーにします")


  public ImageEnum getImage() {
    return image;
  }

  public void setImage(ImageEnum image) {
    this.image = image;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Saketomo saketomo = (Saketomo) o;
    return Objects.equals(this.id, saketomo.id) &&
        Objects.equals(this.name, saketomo.name) &&
        Objects.equals(this.image, saketomo.image);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, image);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Saketomo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
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

