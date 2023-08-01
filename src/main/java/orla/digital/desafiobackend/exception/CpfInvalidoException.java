package orla.digital.desafiobackend.exception;

import org.springframework.http.HttpStatus;
import orla.digital.desafiobackend.exception.handler.Erro;

import java.util.List;

import static orla.digital.desafiobackend.exception.handler.Erro.CPF_INVALIDO;

public class CpfInvalidoException extends AppException {
    public CpfInvalidoException() {
        super(CPF_INVALIDO, HttpStatus.BAD_REQUEST, null);
    }
}
