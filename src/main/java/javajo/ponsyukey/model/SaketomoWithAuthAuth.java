package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SaketomoWithAuthAuth
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T15:13:45.353672600+09:00[Asia/Tokyo]")
public class SaketomoWithAuthAuth   {
  @JsonProperty("password")
  private String password;

  @JsonProperty("email")
  private String email;

  public SaketomoWithAuthAuth password(String password) {
    this.password = password;
    return this;
  }

  /**
   * ハッシュ
   * @return password
  */
  @ApiModelProperty(required = true, value = "ハッシュ")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public SaketomoWithAuthAuth email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaketomoWithAuthAuth saketomoWithAuthAuth = (SaketomoWithAuthAuth) o;
    return Objects.equals(this.password, saketomoWithAuthAuth.password) &&
        Objects.equals(this.email, saketomoWithAuthAuth.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(password, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaketomoWithAuthAuth {\n");
    
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

