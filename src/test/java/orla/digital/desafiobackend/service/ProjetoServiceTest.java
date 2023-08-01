package orla.digital.desafiobackend.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioProjetoV1DTO;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioV1DTO;
import orla.digital.desafiobackend.domain.dto.v1.ProjetoV1DTO;
import orla.digital.desafiobackend.entity.Funcionario;
import orla.digital.desafiobackend.entity.Projeto;
import orla.digital.desafiobackend.exception.ProjetoNaoEncontradoException;
import orla.digital.desafiobackend.mapper.ProjetoMapper;
import orla.digital.desafiobackend.repository.ProjetoRepository;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProjetoServiceTest {

    @InjectMocks
    private ProjetoService projetoService;

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private FuncionarioService funcionarioService;

    @Test
    public void testCreateProjeto() {
        ProjetoV1DTO novoProjeto = new ProjetoV1DTO();
        novoProjeto.setNome("Projeto Teste");

        Projeto projeto = ProjetoMapper.INSTANCE.toModel(novoProjeto);

        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        projetoService.createProjeto(novoProjeto);

        verify(projetoRepository, times(1)).save(projeto);
    }

    @Test
    public void testSearchProjetoByIdNotFound() {
        when(projetoRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ProjetoNaoEncontradoException.class, () -> projetoService.searchProjetoById(1));
    }

    @Test
    public void testUpdateProjeto() {
        FuncionarioV1DTO funcionarioDTO = new FuncionarioV1DTO();
        funcionarioDTO.setCpf("12345678901");

        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("12345678901");

        ProjetoV1DTO projetoDTO = new ProjetoV1DTO();
        projetoDTO.setNome("Projeto Atualizado");
        FuncionarioProjetoV1DTO funcionarioProjetoDTO = new FuncionarioProjetoV1DTO();
        funcionarioProjetoDTO.setCpf("12345678901");
        projetoDTO.setFuncionarios(Arrays.asList(funcionarioProjetoDTO));

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Original");

        when(projetoRepository.findById(any(Long.class))).thenReturn(Optional.of(projeto));
        when(funcionarioService.searchFuncionarioByCpf(any(String.class))).thenReturn(Optional.of(funcionarioDTO));
        when(projetoRepository.save(any(Projeto.class))).thenAnswer(i -> i.getArguments()[0]);

        ProjetoV1DTO projetoAtualizado = projetoService.updateProjeto(1, projetoDTO);

        assertEquals(projetoDTO.getNome(), projetoAtualizado.getNome());
        assertEquals(projetoDTO.getFuncionarios().size(), projetoAtualizado.getFuncionarios().size());
    }
}

