package orla.digital.desafiobackend.domain.dto.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioProjetoV1DTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Informações sobre o projeto
 */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.experimental.SuperBuilder(toBuilder = true)

@Schema(name = "Projeto", description = "Informações sobre o projeto")
@JsonTypeName("Projeto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-31T20:18:49.114273100-03:00[America/Fortaleza]")
public class ProjetoV1DTO {

  private Long id;

  private String nome;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dataCriacao;

  @Valid
  private List<@Valid FuncionarioProjetoV1DTO> funcionarios;

  public ProjetoV1DTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do projeto
   * @return id
  */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, example = "1", description = "Identificador do projeto", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProjetoV1DTO nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome do projeto
   * @return nome
  */
  
  @Schema(name = "nome", example = "Projeto 01", description = "Nome do projeto", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ProjetoV1DTO dataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
    return this;
  }

  /**
   * Data de criação do projeto
   * @return dataCriacao
  */
  @Valid 
  @Schema(name = "dataCriacao", example = "Tue Dec 31 21:00:00 BRT 2019", description = "Data de criação do projeto", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dataCriacao")
  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public ProjetoV1DTO funcionarios(List<@Valid FuncionarioProjetoV1DTO> funcionarios) {
    this.funcionarios = funcionarios;
    return this;
  }

  public ProjetoV1DTO addFuncionariosItem(FuncionarioProjetoV1DTO funcionariosItem) {
    if (this.funcionarios == null) {
      this.funcionarios = new ArrayList<>();
    }
    this.funcionarios.add(funcionariosItem);
    return this;
  }

  /**
   * Funcionários envolvidos no projeto
   * @return funcionarios
  */
  @Valid 
  @Schema(name = "funcionarios", description = "Funcionários envolvidos no projeto", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("funcionarios")
  public List<@Valid FuncionarioProjetoV1DTO> getFuncionarios() {
    return funcionarios;
  }

  public void setFuncionarios(List<@Valid FuncionarioProjetoV1DTO> funcionarios) {
    this.funcionarios = funcionarios;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjetoV1DTO projeto = (ProjetoV1DTO) o;
    return Objects.equals(this.id, projeto.id) &&
        Objects.equals(this.nome, projeto.nome) &&
        Objects.equals(this.dataCriacao, projeto.dataCriacao) &&
        Objects.equals(this.funcionarios, projeto.funcionarios);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, dataCriacao, funcionarios);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjetoV1DTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    dataCriacao: ").append(toIndentedString(dataCriacao)).append("\n");
    sb.append("    funcionarios: ").append(toIndentedString(funcionarios)).append("\n");
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

