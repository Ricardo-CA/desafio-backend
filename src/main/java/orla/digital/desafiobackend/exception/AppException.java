package orla.digital.desafiobackend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import orla.digital.desafiobackend.exception.handler.Erro;

import java.util.List;

@Getter
public abstract class AppException extends RuntimeException {
    private Erro erro;
    private HttpStatus httpStatus;
    private List<String> erros;

    protected AppException(Erro erro, HttpStatus httpStatus, List<String> erros, Object... args) {
        super(erro.formatar(args));
        this.erro = erro;
        this.httpStatus = httpStatus;
        this.erros = erros;
    }
}
