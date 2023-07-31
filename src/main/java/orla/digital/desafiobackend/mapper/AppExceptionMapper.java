package orla.digital.desafiobackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import orla.digital.desafiobackend.domain.dto.v1.ApiErrorV1DTO;
import orla.digital.desafiobackend.exception.AppException;

import java.time.LocalDateTime;

@Mapper(imports = {LocalDateTime.class})
public interface AppExceptionMapper {

    AppExceptionMapper APP_EXCEPTION_MAPPER = Mappers.getMapper(AppExceptionMapper.class);

    @Mapping(target = "dataHora", expression = "java(LocalDateTime.now())")
    @Mapping(target = "codigo", source = "appException.erro.codigo")
    @Mapping(target = "mensagem", source = "message")
    ApiErrorV1DTO toApiErrorV1Dto(AppException appException);
}
