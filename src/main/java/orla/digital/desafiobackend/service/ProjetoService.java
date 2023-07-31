package orla.digital.desafiobackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import orla.digital.desafiobackend.controller.v1.ProjetosApi;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioV1DTO;
import orla.digital.desafiobackend.domain.dto.v1.ProjetoV1DTO;
import orla.digital.desafiobackend.entity.Funcionario;
import orla.digital.desafiobackend.exception.FuncionarioNaoEncontradoException;
import orla.digital.desafiobackend.exception.ProjetoNaoEncontradoException;
import orla.digital.desafiobackend.mapper.FuncionarioMapper;
import orla.digital.desafiobackend.mapper.ProjetoMapper;
import orla.digital.desafiobackend.repository.ProjetoRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetoService implements ProjetosApi {

    private final ProjetoRepository projetoRepository;

    private final FuncionarioService funcionarioService;

    @Override
    public void createProjeto(final ProjetoV1DTO novoProjeto) {
        projetoRepository.save(ProjetoMapper.INSTANCE.toModel(novoProjeto));
    }

    @Override
    public List<ProjetoV1DTO> searchProjeto() {
        return projetoRepository.findAll().stream().map(ProjetoMapper.INSTANCE::toDTO).toList();
    }

    @Override
    public ProjetoV1DTO searchProjetoById(Integer id) {
        return projetoRepository.findById(Long.valueOf(id)).map(ProjetoMapper.INSTANCE::toDTO).orElseThrow(ProjetoNaoEncontradoException::new);
    }

    @Override
    public ProjetoV1DTO updateProjeto(Integer id, ProjetoV1DTO projeto) {
        return projetoRepository.findById(Long.valueOf(id)).map(projetoEncontrado -> {
            projetoEncontrado.setNome(projeto.getNome());
            projetoEncontrado.setDataCriacao(projeto.getDataCriacao());
            Set<Funcionario> novosFuncionarios = projeto.getFuncionarios()
                    .stream()
                    .map(funcionarioDTO -> {
                        FuncionarioV1DTO funcionarioEncontrado = funcionarioService.searchFuncionarioByCpf(funcionarioDTO.getCpf())
                                .orElseThrow(FuncionarioNaoEncontradoException::new);
                        return FuncionarioMapper.INSTANCE.toModel(funcionarioEncontrado);
                    })
                    .collect(Collectors.toSet());
            projetoEncontrado.setFuncionarios(novosFuncionarios);
            return projetoRepository.save(projetoEncontrado);
        }).map(ProjetoMapper.INSTANCE::toDTO).orElseThrow(ProjetoNaoEncontradoException::new);
    }
}
