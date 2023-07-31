package orla.digital.desafiobackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import orla.digital.desafiobackend.controller.v1.FuncionariosApi;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioV1DTO;
import orla.digital.desafiobackend.entity.Funcionario;
import orla.digital.desafiobackend.exception.FuncionarioNaoEncontradoException;
import orla.digital.desafiobackend.mapper.FuncionarioMapper;
import orla.digital.desafiobackend.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService implements FuncionariosApi {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public void createFuncionario(FuncionarioV1DTO novoFuncionario) {
        funcionarioRepository.save(FuncionarioMapper.INSTANCE.toModel(novoFuncionario));
    }

    @Override
    public List<FuncionarioV1DTO> searchFuncionario() {
        return funcionarioRepository.findAll().stream().map(FuncionarioMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public FuncionarioV1DTO searchFuncionarioById(Integer id) {
        return funcionarioRepository.findById(Long.valueOf(id)).map(FuncionarioMapper.INSTANCE::toDTO).orElseThrow(FuncionarioNaoEncontradoException::new);
    }

    @Override
    public FuncionarioV1DTO updateFuncionario(Integer id, FuncionarioV1DTO funcionario) {
        Funcionario funcionarioAtualizado = funcionarioRepository.findById(Long.valueOf(id)).map(funcionarioEncontrado -> {
            funcionarioEncontrado.setNome(funcionario.getNome());
            funcionarioEncontrado.setSalario(funcionario.getSalario().doubleValue());
            return funcionarioRepository.save(funcionarioEncontrado);
        }).orElseThrow(FuncionarioNaoEncontradoException::new);
        return FuncionarioMapper.INSTANCE.toDTO(funcionarioAtualizado);
    }


    public Optional<FuncionarioV1DTO> searchFuncionarioByCpf(String cpf) {
        return funcionarioRepository.findByCpf(cpf).map(FuncionarioMapper.INSTANCE::toDTO);
    }
}
