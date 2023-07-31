package orla.digital.desafiobackend.domain.dto.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Informações sobre o erro da requisição
 */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.experimental.SuperBuilder(toBuilder = true)

@Schema(name = "ApiError", description = "Informações sobre o erro da requisição")
@JsonTypeName("ApiError")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-31T20:18:49.114273100-03:00[America/Fortaleza]")
public class ApiErrorV1DTO {

  private String codigo;

  private String mensagem;

  private org.springframework.http.HttpStatus httpStatus;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime dataHora;

  @Valid
  private List<String> erros;

  public ApiErrorV1DTO codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }

  /**
   * Código do erro
   * @return codigo
  */
  @NotNull 
  @Schema(name = "codigo", description = "Código do erro", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codigo")
  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public ApiErrorV1DTO mensagem(String mensagem) {
    this.mensagem = mensagem;
    return this;
  }

  /**
   * Mensagem do erro
   * @return mensagem
  */
  @NotNull 
  @Schema(name = "mensagem", description = "Mensagem do erro", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mensagem")
  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public ApiErrorV1DTO httpStatus(org.springframework.http.HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
    return this;
  }

  /**
   * Código de status http do erro
   * @return httpStatus
  */
  @NotNull @Valid 
  @Schema(name = "httpStatus", description = "Código de status http do erro", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("httpStatus")
  public org.springframework.http.HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(org.springframework.http.HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public ApiErrorV1DTO dataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
    return this;
  }

  /**
   * Data e hora da ocorrência do erro
   * @return dataHora
  */
  @Valid 
  @Schema(name = "dataHora", description = "Data e hora da ocorrência do erro", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dataHora")
  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public ApiErrorV1DTO erros(List<String> erros) {
    this.erros = erros;
    return this;
  }

  public ApiErrorV1DTO addErrosItem(String errosItem) {
    if (this.erros == null) {
      this.erros = new ArrayList<>();
    }
    this.erros.add(errosItem);
    return this;
  }

  /**
   * Lista de mensagens do erro
   * @return erros
  */
  
  @Schema(name = "erros", description = "Lista de mensagens do erro", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("erros")
  public List<String> getErros() {
    return erros;
  }

  public void setErros(List<String> erros) {
    this.erros = erros;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiErrorV1DTO apiError = (ApiErrorV1DTO) o;
    return Objects.equals(this.codigo, apiError.codigo) &&
        Objects.equals(this.mensagem, apiError.mensagem) &&
        Objects.equals(this.httpStatus, apiError.httpStatus) &&
        Objects.equals(this.dataHora, apiError.dataHora) &&
        Objects.equals(this.erros, apiError.erros);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, mensagem, httpStatus, dataHora, erros);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiErrorV1DTO {\n");
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    mensagem: ").append(toIndentedString(mensagem)).append("\n");
    sb.append("    httpStatus: ").append(toIndentedString(httpStatus)).append("\n");
    sb.append("    dataHora: ").append(toIndentedString(dataHora)).append("\n");
    sb.append("    erros: ").append(toIndentedString(erros)).append("\n");
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

