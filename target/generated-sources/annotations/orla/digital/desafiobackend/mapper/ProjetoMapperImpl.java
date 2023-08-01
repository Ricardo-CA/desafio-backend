package orla.digital.desafiobackend.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import orla.digital.desafiobackend.domain.dto.v1.FuncionarioProjetoV1DTO;
import orla.digital.desafiobackend.domain.dto.v1.ProjetoV1DTO;
import orla.digital.desafiobackend.entity.Funcionario;
import orla.digital.desafiobackend.entity.Projeto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-31T21:12:04-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class ProjetoMapperImpl implements ProjetoMapper {

    @Override
    public Projeto toModel(ProjetoV1DTO projetoDTO) {
        if ( projetoDTO == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.id( projetoDTO.getId() );
        projeto.nome( projetoDTO.getNome() );
        projeto.dataCriacao( projetoDTO.getDataCriacao() );
        projeto.funcionarios( funcionarioProjetoV1DTOListToFuncionarioSet( projetoDTO.getFuncionarios() ) );

        return projeto.build();
    }

    @Override
    public ProjetoV1DTO toDTO(Projeto projeto) {
        if ( projeto == null ) {
            return null;
        }

        ProjetoV1DTO.ProjetoV1DTOBuilder<?, ?> projetoV1DTO = ProjetoV1DTO.builder();

        projetoV1DTO.id( projeto.getId() );
        projetoV1DTO.nome( projeto.getNome() );
        projetoV1DTO.dataCriacao( projeto.getDataCriacao() );
        projetoV1DTO.funcionarios( funcionarioSetToFuncionarioProjetoV1DTOList( projeto.getFuncionarios() ) );

        return projetoV1DTO.build();
    }

    @Override
    public List<Projeto> toModelProjetoList(List<ProjetoV1DTO> projetos) {
        if ( projetos == null ) {
            return null;
        }

        List<Projeto> list = new ArrayList<Projeto>( projetos.size() );
        for ( ProjetoV1DTO projetoV1DTO : projetos ) {
            list.add( toModel( projetoV1DTO ) );
        }

        return list;
    }

    @Override
    public List<ProjetoV1DTO> toDTOProjetoList(List<Projeto> projetos) {
        if ( projetos == null ) {
            return null;
        }

        List<ProjetoV1DTO> list = new ArrayList<ProjetoV1DTO>( projetos.size() );
        for ( Projeto projeto : projetos ) {
            list.add( toDTO( projeto ) );
        }

        return list;
    }

    protected Funcionario funcionarioProjetoV1DTOToFuncionario(FuncionarioProjetoV1DTO funcionarioProjetoV1DTO) {
        if ( funcionarioProjetoV1DTO == null ) {
            return null;
        }

        Funcionario funcionario = new Funcionario();

        if ( funcionarioProjetoV1DTO.getId() != null ) {
            funcionario.setId( funcionarioProjetoV1DTO.getId().longValue() );
        }
        funcionario.setNome( funcionarioProjetoV1DTO.getNome() );
        funcionario.setCpf( funcionarioProjetoV1DTO.getCpf() );
        funcionario.setEmail( funcionarioProjetoV1DTO.getEmail() );
        if ( funcionarioProjetoV1DTO.getSalario() != null ) {
            funcionario.setSalario( funcionarioProjetoV1DTO.getSalario().doubleValue() );
        }

        return funcionario;
    }

    protected Set<Funcionario> funcionarioProjetoV1DTOListToFuncionarioSet(List<FuncionarioProjetoV1DTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Funcionario> set = new LinkedHashSet<Funcionario>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( FuncionarioProjetoV1DTO funcionarioProjetoV1DTO : list ) {
            set.add( funcionarioProjetoV1DTOToFuncionario( funcionarioProjetoV1DTO ) );
        }

        return set;
    }

    protected FuncionarioProjetoV1DTO funcionarioToFuncionarioProjetoV1DTO(Funcionario funcionario) {
        if ( funcionario == null ) {
            return null;
        }

        FuncionarioProjetoV1DTO.FuncionarioProjetoV1DTOBuilder<?, ?> funcionarioProjetoV1DTO = FuncionarioProjetoV1DTO.builder();

        if ( funcionario.getId() != null ) {
            funcionarioProjetoV1DTO.id( BigDecimal.valueOf( funcionario.getId() ) );
        }
        funcionarioProjetoV1DTO.nome( funcionario.getNome() );
        funcionarioProjetoV1DTO.cpf( funcionario.getCpf() );
        funcionarioProjetoV1DTO.email( funcionario.getEmail() );
        if ( funcionario.getSalario() != null ) {
            funcionarioProjetoV1DTO.salario( BigDecimal.valueOf( funcionario.getSalario() ) );
        }

        return funcionarioProjetoV1DTO.build();
    }

    protected List<FuncionarioProjetoV1DTO> funcionarioSetToFuncionarioProjetoV1DTOList(Set<Funcionario> set) {
        if ( set == null ) {
            return null;
        }

        List<FuncionarioProjetoV1DTO> list = new ArrayList<FuncionarioProjetoV1DTO>( set.size() );
        for ( Funcionario funcionario : set ) {
            list.add( funcionarioToFuncionarioProjetoV1DTO( funcionario ) );
        }

        return list;
    }
}
