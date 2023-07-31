package orla.digital.desafiobackend.exception.handler;

import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.validation.ConstraintViolation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import orla.digital.desafiobackend.domain.dto.v1.ApiErrorV1DTO;
import orla.digital.desafiobackend.exception.AppException;
import orla.digital.desafiobackend.mapper.AppExceptionMapper;

import java.util.Optional;

@Component
public class GlobalExceptionBusiness {

    public static final String UNEXPECTED_VALUE = "Unexpected value";
    public static final String VALOR_INESPERADO = "Valor inesperado";

    public ResponseEntity<ApiErrorV1DTO> getApiErrorV1DTO(AppException appException) {
        return ResponseEntity
                .status(appException.getHttpStatus())
                .body(AppExceptionMapper.APP_EXCEPTION_MAPPER.toApiErrorV1Dto(appException));
    }

    private String getMensagemErroValidacao(ObjectError erro) {
        return Optional.of(erro)
                .map(ObjectError::getClass)
                .filter(FieldError.class::isAssignableFrom)
                .map(erroClass -> getMensagemErro((FieldError) erro))
                .orElse(getMensagemErro(erro));
    }

    private String getMensagemErro(FieldError erro) {
        return formatarMensagem(erro.getField(), erro.getDefaultMessage());
    }

    private String getMensagemErro(ObjectError erro) {
        return formatarMensagem(erro.getObjectName(), erro.getDefaultMessage());
    }


    private String getMensagemErro(ConstraintViolation<?> constraintViolation) {
        return formatarMensagem(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
    }

    private String formatarMensagem(String campo, String mensagem) {
        return String.format("%s: %s", campo, mensagem);
    }

    private String getMensagemJsonMappingException(JsonMappingException jsonMappingException) {
        String originalMessage = jsonMappingException.getOriginalMessage();
        String localizedMessage = jsonMappingException.getLocalizedMessage();
        String message = jsonMappingException.getMessage();
        return Optional.of(jsonMappingException)
                .map(Throwable::getCause)
                .map(Throwable::getMessage)
                .map(mensagemCausa -> StringUtils.replace(mensagemCausa, UNEXPECTED_VALUE, VALOR_INESPERADO))
                .orElse(StringUtils.firstNonBlank(originalMessage, localizedMessage, message));
    }

    private JsonMappingException getAsJsonMappingException(HttpMessageNotReadableException ex) {
        return Optional.ofNullable(ex)
                .map(Throwable::getCause)
                .filter(JsonMappingException.class::isInstance)
                .map(JsonMappingException.class::cast)
                .orElseThrow(() -> ex);
    }
}
