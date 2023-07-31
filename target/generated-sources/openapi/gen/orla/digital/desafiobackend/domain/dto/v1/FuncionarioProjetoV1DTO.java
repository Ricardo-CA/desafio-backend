package orla.digital.desafiobackend.domain.dto.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Informações sobre o funcionário
 */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.experimental.SuperBuilder(toBuilder = true)

@Schema(name = "FuncionarioProjeto", description = "Informações sobre o funcionário")
@JsonTypeName("FuncionarioProjeto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-31T20:18:49.114273100-03:00[America/Fortaleza]")
public class FuncionarioProjetoV1DTO {

  private BigDecimal id;

  private String nome;

  private String cpf;

  private String email;

  private BigDecimal salario;

  public FuncionarioProjetoV1DTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do funcionário
   * @return id
  */
  @Valid 
  @Schema(name = "id", example = "1.0", description = "Identificador do funcionário", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public FuncionarioProjetoV1DTO nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome do funcionário
   * @return nome
  */
  
  @Schema(name = "nome", example = "Ricardo Carvalho Agostinho", description = "Nome do funcionário", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public FuncionarioProjetoV1DTO cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * O CPF do funcionário (apenas números)
   * @return cpf
  */
  @Pattern(regexp = "^[0-9]{11}$") 
  @Schema(name = "cpf", example = "12345678901", description = "O CPF do funcionário (apenas números)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cpf")
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public FuncionarioProjetoV1DTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * E-mail do funcionário
   * @return email
  */
  @jakarta.validation.constraints.Email
  @Schema(name = "email", example = "email@teste.com", description = "E-mail do funcionário", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public FuncionarioProjetoV1DTO salario(BigDecimal salario) {
    this.salario = salario;
    return this;
  }

  /**
   * Salário do funcionário
   * @return salario
  */
  @Valid 
  @Schema(name = "salario", example = "1000.0", description = "Salário do funcionário", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("salario")
  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FuncionarioProjetoV1DTO funcionarioProjeto = (FuncionarioProjetoV1DTO) o;
    return Objects.equals(this.id, funcionarioProjeto.id) &&
        Objects.equals(this.nome, funcionarioProjeto.nome) &&
        Objects.equals(this.cpf, funcionarioProjeto.cpf) &&
        Objects.equals(this.email, funcionarioProjeto.email) &&
        Objects.equals(this.salario, funcionarioProjeto.salario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, cpf, email, salario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FuncionarioProjetoV1DTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    salario: ").append(toIndentedString(salario)).append("\n");
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

