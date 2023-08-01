package orla.digital.desafiobackend.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import orla.digital.desafiobackend.domain.dto.v1.ApiErrorV1DTO;
import orla.digital.desafiobackend.exception.AppException;
import orla.digital.desafiobackend.exception.handler.Erro;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-31T21:12:04-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class AppExceptionMapperImpl implements AppExceptionMapper {

    @Override
    public ApiErrorV1DTO toApiErrorV1Dto(AppException appException) {
        if ( appException == null ) {
            return null;
        }

        ApiErrorV1DTO.ApiErrorV1DTOBuilder<?, ?> apiErrorV1DTO = ApiErrorV1DTO.builder();

        apiErrorV1DTO.codigo( appExceptionErroCodigo( appException ) );
        apiErrorV1DTO.mensagem( appException.getMessage() );
        apiErrorV1DTO.httpStatus( appException.getHttpStatus() );
        List<String> list = appException.getErros();
        if ( list != null ) {
            apiErrorV1DTO.erros( new ArrayList<String>( list ) );
        }

        apiErrorV1DTO.dataHora( LocalDateTime.now() );

        return apiErrorV1DTO.build();
    }

    private String appExceptionErroCodigo(AppException appException) {
        if ( appException == null ) {
            return null;
        }
        Erro erro = appException.getErro();
        if ( erro == null ) {
            return null;
        }
        String codigo = erro.getCodigo();
        if ( codigo == null ) {
            return null;
        }
        return codigo;
    }
}
