package orla.digital.desafiobackend.domain.dto.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GetHealth200ResponseV1DTO
 */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.experimental.SuperBuilder(toBuilder = true)

@JsonTypeName("getHealth_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-31T20:18:49.114273100-03:00[America/Fortaleza]")
public class GetHealth200ResponseV1DTO {

  private String status;

  public GetHealth200ResponseV1DTO status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Estado da aplicação
   * @return status
  */
  
  @Schema(name = "status", description = "Estado da aplicação", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetHealth200ResponseV1DTO getHealth200Response = (GetHealth200ResponseV1DTO) o;
    return Objects.equals(this.status, getHealth200Response.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetHealth200ResponseV1DTO {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

