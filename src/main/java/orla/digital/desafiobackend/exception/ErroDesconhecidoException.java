package orla.digital.desafiobackend.exception;

import org.springframework.http.HttpStatus;
import orla.digital.desafiobackend.exception.handler.Erro;

import java.util.List;

public class ErroDesconhecidoException extends AppException {

    public ErroDesconhecidoException() {
        this(null);
    }

    public ErroDesconhecidoException(List<String> erros) {
        super(Erro.ERRO_DESCONHECIDO, HttpStatus.INTERNAL_SERVER_ERROR, erros);
    }

}