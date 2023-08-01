package orla.digital.desafiobackend.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

@AllArgsConstructor
@Getter
public enum Erro {

    ERRO_DESCONHECIDO("1", "Erro desconhecido."),
    NAO_PERMITIDO("2", "Não permitido"),
    FUNCIONARIO_NAO_ENCONTRADO("3", "Funcionário não encontrado."),
    PROJETO_NAO_ENCONTRADO("4", "Projeto não encontrado."),
    CPF_INVALIDO("5", "CPF inválido.");

    private final String codigo;
    private final String mensagem;

    public String formatar(Object... args) {
        return MessageFormat.format(this.mensagem, args);
    }

}