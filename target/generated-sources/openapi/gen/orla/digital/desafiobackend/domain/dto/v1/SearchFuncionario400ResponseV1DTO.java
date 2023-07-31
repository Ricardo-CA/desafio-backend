package orla.digital.desafiobackend.domain.dto.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import orla.digital.desafiobackend.domain.dto.v1.ApiErrorV1DTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SearchFuncionario400ResponseV1DTO
 */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.experimental.SuperBuilder(toBuilder = true)

@JsonTypeName("searchFuncionario_400_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-31T20:18:49.114273100-03:00[America/Fortaleza]")
public class SearchFuncionario400ResponseV1DTO {

  private ApiErrorV1DTO apiError;

  public SearchFuncionario400ResponseV1DTO apiError(ApiErrorV1DTO apiError) {
    this.apiError = apiError;
    return this;
  }

  /**
   * Get apiError
   * @return apiError
  */
  @Valid 
  @Schema(name = "ApiError", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ApiError")
  public ApiErrorV1DTO getApiError() {
    return apiError;
  }

  public void setApiError(ApiErrorV1DTO apiError) {
    this.apiError = apiError;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchFuncionario400ResponseV1DTO searchFuncionario400Response = (SearchFuncionario400ResponseV1DTO) o;
    return Objects.equals(this.apiError, searchFuncionario400Response.apiError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiError);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchFuncionario400ResponseV1DTO {\n");
    sb.append("    apiError: ").append(toIndentedString(apiError)).append("\n");
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

