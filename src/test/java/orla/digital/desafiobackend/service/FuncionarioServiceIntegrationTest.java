package orla.digital.desafiobackend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioV1DTO;
import orla.digital.desafiobackend.service.util.GeradorCpfUtil;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class FuncionarioServiceIntegrationTest {

    @Autowired
    private FuncionarioService funcionarioService;


    private GeradorCpfUtil geradorCpfUtil = new GeradorCpfUtil();

    @Test
    public void testCreateFuncionario() {
        String cpf = geradorCpfUtil.cpf();
        FuncionarioV1DTO novoFuncionario = new FuncionarioV1DTO();
        novoFuncionario.setNome("Teste");
        novoFuncionario.setEmail("testeintegrado@teste.com");
        novoFuncionario.setCpf(cpf);
        novoFuncionario.setSalario(BigDecimal.valueOf(1000.0));

        funcionarioService.createFuncionario(novoFuncionario);

        FuncionarioV1DTO funcionarioDTO = funcionarioService.searchFuncionarioByCpf(cpf).orElse(null);

        assertNotNull(funcionarioDTO);
        assertEquals(novoFuncionario.getNome(), funcionarioDTO.getNome());
    }

    @Test
    public void testUpdateFuncionario() {
        String cpf = geradorCpfUtil.cpf();
        FuncionarioV1DTO novoFuncionario = new FuncionarioV1DTO();
        novoFuncionario.setNome("Teste");
        novoFuncionario.setEmail("testeintegrado@teste.com");
        novoFuncionario.setCpf(cpf);
        novoFuncionario.setSalario(BigDecimal.valueOf(1000.0));

        funcionarioService.createFuncionario(novoFuncionario);
        Long idNovoFuncionario = funcionarioService.searchFuncionarioByCpf(cpf).orElse(null).getId();

        FuncionarioV1DTO funcionarioAtualizado = new FuncionarioV1DTO();
        funcionarioAtualizado.setNome("Teste Atualizado");
        funcionarioAtualizado.setEmail("testeintegradoatualizado@teste.com");
        funcionarioAtualizado.setSalario(BigDecimal.valueOf(2000.0));

        funcionarioService.updateFuncionario(idNovoFuncionario.intValue(), funcionarioAtualizado);

        assertEquals(funcionarioAtualizado.getNome(), funcionarioService.searchFuncionarioByCpf(cpf).get().getNome());
    }

    @Test
    public void testSearchFuncionario() {
        String cpf1 = geradorCpfUtil.cpf();
        FuncionarioV1DTO novoFuncionario1 = new FuncionarioV1DTO();
        novoFuncionario1.setNome("Teste1");
        novoFuncionario1.setEmail("testeintegrado@teste.com");
        novoFuncionario1.setCpf(cpf1);
        novoFuncionario1.setSalario(BigDecimal.valueOf(1000.0));

        String cpf2 = geradorCpfUtil.cpf();
        FuncionarioV1DTO novoFuncionario2 = new FuncionarioV1DTO();
        novoFuncionario2.setNome("Teste2");
        novoFuncionario2.setEmail("testeintegrado2@teste.com");
        novoFuncionario2.setCpf(cpf2);
        novoFuncionario2.setSalario(BigDecimal.valueOf(2000.0));

        funcionarioService.createFuncionario(novoFuncionario1);
        funcionarioService.createFuncionario(novoFuncionario2);

        List<FuncionarioV1DTO> funcionarios = funcionarioService.searchFuncionario();
        assertTrue(funcionarioService.searchFuncionarioByCpf(cpf1).isPresent());
        assertTrue(funcionarioService.searchFuncionarioByCpf(cpf2).isPresent());
    }
}
