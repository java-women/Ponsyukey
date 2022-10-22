package javajo.ponsyukey.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javajo.ponsyukey.model.SakeResponse;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SakeListResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-22T16:06:48.697644+09:00[Asia/Tokyo]")
public class SakeListResponse   {
  @JsonProperty("totalCount")
  private Integer totalCount;

  @JsonProperty("sakeList")
  @Valid
  private List<SakeResponse> sakeList = null;

  public SakeListResponse totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Get totalCount
   * @return totalCount
  */
  @ApiModelProperty(value = "")


  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public SakeListResponse sakeList(List<SakeResponse> sakeList) {
    this.sakeList = sakeList;
    return this;
  }

  public SakeListResponse addSakeListItem(SakeResponse sakeListItem) {
    if (this.sakeList == null) {
      this.sakeList = new ArrayList<SakeResponse>();
    }
    this.sakeList.add(sakeListItem);
    return this;
  }

  /**
   * Get sakeList
   * @return sakeList
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<SakeResponse> getSakeList() {
    return sakeList;
  }

  public void setSakeList(List<SakeResponse> sakeList) {
    this.sakeList = sakeList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SakeListResponse sakeListResponse = (SakeListResponse) o;
    return Objects.equals(this.totalCount, sakeListResponse.totalCount) &&
        Objects.equals(this.sakeList, sakeListResponse.sakeList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, sakeList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SakeListResponse {\n");
    
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    sakeList: ").append(toIndentedString(sakeList)).append("\n");
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

