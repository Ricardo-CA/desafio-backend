package orla.digital.desafiobackend.exception;

import org.springframework.http.HttpStatus;

import static orla.digital.desafiobackend.exception.handler.Erro.PROJETO_NAO_ENCONTRADO;

public class ProjetoNaoEncontradoException extends AppException {
    public ProjetoNaoEncontradoException() {
        super(PROJETO_NAO_ENCONTRADO, HttpStatus.NOT_FOUND, null);
    }
}
