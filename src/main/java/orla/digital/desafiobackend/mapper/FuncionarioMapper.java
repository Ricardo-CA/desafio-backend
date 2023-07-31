package orla.digital.desafiobackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioV1DTO;
import orla.digital.desafiobackend.domain.dto.v1.ProjetoV1DTO;
import orla.digital.desafiobackend.entity.Funcionario;
import orla.digital.desafiobackend.entity.Projeto;

import java.util.List;

@Mapper
public interface FuncionarioMapper {

    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    @Mapping(source = "projetos", target = "projetos")
    Funcionario toModel(FuncionarioV1DTO funcionarioDTO);

    @Mapping(source = "projetos", target = "projetos")
    FuncionarioV1DTO toDTO(Funcionario funcionario);

    List<Projeto> toModelProjetoList(List<ProjetoV1DTO> projetos);
    List<ProjetoV1DTO> toDTOProjetoList(List<Projeto> projetos);
}
