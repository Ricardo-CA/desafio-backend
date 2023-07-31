package orla.digital.desafiobackend.exception.handler;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import orla.digital.desafiobackend.domain.dto.v1.ApiErrorV1DTO;
import orla.digital.desafiobackend.exception.AppException;
import orla.digital.desafiobackend.exception.ErroDesconhecidoException;

import java.util.Optional;

@Log4j2
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final GlobalExceptionBusiness globalExceptionBusiness;

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiErrorV1DTO> exception(AppException ex) {
        return globalExceptionBusiness.getApiErrorV1DTO(ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void exception(IllegalArgumentException ex, HttpServletResponse res) {
        HttpStatus notImplemented = HttpStatus.NOT_IMPLEMENTED;
        Optional.of(ex)
                .map(Throwable::getMessage)
                .filter(notImplemented.getReasonPhrase()::equalsIgnoreCase)
                .orElseThrow(() -> ex);
        res.setStatus(notImplemented.value());
    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiErrorV1DTO> exception(Exception ex) {
        log.error("Erro genérico. ", ex);
        return exception(new ErroDesconhecidoException());
    }
}
