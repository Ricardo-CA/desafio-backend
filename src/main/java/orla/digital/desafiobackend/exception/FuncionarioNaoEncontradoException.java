package orla.digital.desafiobackend.exception;

import org.springframework.http.HttpStatus;

import static orla.digital.desafiobackend.exception.handler.Erro.FUNCIONARIO_NAO_ENCONTRADO;

public class FuncionarioNaoEncontradoException extends AppException {
    public FuncionarioNaoEncontradoException() {
        super(FUNCIONARIO_NAO_ENCONTRADO, HttpStatus.NOT_FOUND, null);
    }
}
