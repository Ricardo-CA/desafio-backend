package orla.digital.desafiobackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import orla.digital.desafiobackend.domain.dto.v1.ProjetoV1DTO;
import orla.digital.desafiobackend.entity.Projeto;

import java.util.List;

@Mapper
public interface ProjetoMapper {

    ProjetoMapper INSTANCE = Mappers.getMapper(ProjetoMapper.class);

     Projeto toModel(ProjetoV1DTO projetoDTO);

     ProjetoV1DTO toDTO(Projeto projeto);

    List<Projeto> toModelProjetoList(List<ProjetoV1DTO> projetos);
    List<ProjetoV1DTO> toDTOProjetoList(List<Projeto> projetos);
}
