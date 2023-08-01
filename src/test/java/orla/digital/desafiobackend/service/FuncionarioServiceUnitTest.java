package orla.digital.desafiobackend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioV1DTO;
import orla.digital.desafiobackend.entity.Funcionario;
import orla.digital.desafiobackend.exception.FuncionarioNaoEncontradoException;
import orla.digital.desafiobackend.mapper.FuncionarioMapper;
import orla.digital.desafiobackend.repository.FuncionarioRepository;
import orla.digital.desafiobackend.service.util.GeradorCpfUtil;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceUnitTest {

    @InjectMocks
    private FuncionarioService funcionarioService;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    private GeradorCpfUtil geradorCpfUtil = new GeradorCpfUtil();

    @Test
    public void testSearchFuncionarioById() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("Teste");

        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));

        FuncionarioV1DTO funcionarioDTO = funcionarioService.searchFuncionarioById(1);

        assertEquals(funcionario.getNome(), funcionarioDTO.getNome());
    }

    @Test
    public void testSearchFuncionarioByIdNotFound() {
        when(funcionarioRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(FuncionarioNaoEncontradoException.class, () -> funcionarioService.searchFuncionarioById(1));
    }

    @Test
    public void testCreateFuncionario() {
        FuncionarioV1DTO novoFuncionarioDTO = new FuncionarioV1DTO();
        novoFuncionarioDTO.setNome("Teste");

        Funcionario funcionario = FuncionarioMapper.INSTANCE.toModel(novoFuncionarioDTO);

        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionario);

        funcionarioService.createFuncionario(novoFuncionarioDTO);

        verify(funcionarioRepository, times(1)).save(funcionario);
    }
}
