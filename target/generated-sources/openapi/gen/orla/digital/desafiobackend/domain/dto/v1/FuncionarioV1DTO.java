package orla.digital.desafiobackend.domain.dto.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import orla.digital.desafiobackend.domain.dto.v1.ProjetoV1DTO;
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

@Schema(name = "Funcionario", description = "Informações sobre o funcionário")
@JsonTypeName("Funcionario")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-31T20:18:49.114273100-03:00[America/Fortaleza]")
public class FuncionarioV1DTO {

  private Long id;

  private String nome;

  private String cpf;

  private String email;

  private BigDecimal salario;

  @Valid
  private List<@Valid ProjetoV1DTO> projetos;

  public FuncionarioV1DTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do funcionário
   * @return id
  */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, example = "1", description = "Identificador do funcionário", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FuncionarioV1DTO nome(String nome) {
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

  public FuncionarioV1DTO cpf(String cpf) {
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

  public FuncionarioV1DTO email(String email) {
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

  public FuncionarioV1DTO salario(BigDecimal salario) {
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

  public FuncionarioV1DTO projetos(List<@Valid ProjetoV1DTO> projetos) {
    this.projetos = projetos;
    return this;
  }

  public FuncionarioV1DTO addProjetosItem(ProjetoV1DTO projetosItem) {
    if (this.projetos == null) {
      this.projetos = new ArrayList<>();
    }
    this.projetos.add(projetosItem);
    return this;
  }

  /**
   * Projetos nos quais o funcionário esta envolvido
   * @return projetos
  */
  @Valid 
  @Schema(name = "projetos", accessMode = Schema.AccessMode.READ_ONLY, description = "Projetos nos quais o funcionário esta envolvido", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("projetos")
  public List<@Valid ProjetoV1DTO> getProjetos() {
    return projetos;
  }

  public void setProjetos(List<@Valid ProjetoV1DTO> projetos) {
    this.projetos = projetos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FuncionarioV1DTO funcionario = (FuncionarioV1DTO) o;
    return Objects.equals(this.id, funcionario.id) &&
        Objects.equals(this.nome, funcionario.nome) &&
        Objects.equals(this.cpf, funcionario.cpf) &&
        Objects.equals(this.email, funcionario.email) &&
        Objects.equals(this.salario, funcionario.salario) &&
        Objects.equals(this.projetos, funcionario.projetos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, cpf, email, salario, projetos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FuncionarioV1DTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    salario: ").append(toIndentedString(salario)).append("\n");
    sb.append("    projetos: ").append(toIndentedString(projetos)).append("\n");
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

