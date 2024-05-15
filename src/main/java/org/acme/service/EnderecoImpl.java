package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.DiscoResponse;
import org.acme.dto.EnderecoRequest;
import org.acme.dto.EnderecoResponse;
import org.acme.model.Endereco;
import org.acme.repository.EnderecoRepository;
import org.acme.repository.MunicipioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class EnderecoImpl implements EnderecoService {


    @Inject
    EnderecoRepository repository;

    @Inject
    MunicipioRepository municipioRepository;

    @Override
    public EnderecoResponse adicionar(EnderecoRequest adicionarEndereco) {
    Endereco endereco = new Endereco();

    endereco.setPrincipal(adicionarEndereco.principal());
    endereco.setLogradouro(adicionarEndereco.logradouro());
    endereco.setBairro(adicionarEndereco.bairro());
    endereco.setNumero(adicionarEndereco.numero());
    endereco.setComplemento(adicionarEndereco.complemento());
    endereco.setCep(adicionarEndereco.cep());
    endereco.setMunicipio(municipioRepository.findById(adicionarEndereco.municipio()));
    
    repository.persist(endereco);

    return EnderecoResponse.valueOf(endereco);
    }

    @Override
    public EnderecoResponse buscar(Long idEndereco) {
    Endereco buscarEndereco = new Endereco();
    
    buscarEndereco = repository.findById(idEndereco);

    return EnderecoResponse.valueOf(buscarEndereco);
    
    }

    @Override
    public EnderecoResponse alterar(Long idEndereco, EnderecoRequest novoEndereco) {
        Endereco antigoEndereco = new Endereco();

        antigoEndereco =  repository.findById(idEndereco);

        antigoEndereco.setPrincipal(novoEndereco.principal());
        antigoEndereco.setLogradouro(novoEndereco.logradouro());
        antigoEndereco.setBairro(novoEndereco.bairro());
        antigoEndereco.setNumero(novoEndereco.numero());
        antigoEndereco.setComplemento(novoEndereco.complemento());
        antigoEndereco.setCep(novoEndereco.cep());
        antigoEndereco.setMunicipio(municipioRepository.findById(novoEndereco.municipio()));

      return  EnderecoResponse.valueOf(antigoEndereco);
    }

    @Override
    public void delete(Long idEndereco) {
       repository.delete(repository.findById(idEndereco));
    }

    @Override
    public List<EnderecoResponse> buscarTodos() {
List<EnderecoResponse> listaEnderecoResponses = repository.findAll().stream().map(endereco -> {
                    return EnderecoResponse.valueOf(endereco);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaEnderecoResponses;
    }
    
}
