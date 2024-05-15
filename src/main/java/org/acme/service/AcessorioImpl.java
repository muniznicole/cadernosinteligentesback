package org.acme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.AcessorioRequest;
import org.acme.dto.AcessorioRespose;
import org.acme.model.Acessorio;

import org.acme.repository.AcessorioRepository;
import org.acme.repository.CorRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AcessorioImpl implements AcessorioService {

    @Inject
    AcessorioRepository repository;
    @Inject
    CorRepository corRepository;
  

    @Override
    public AcessorioRespose adicionar(AcessorioRequest adicionarAcessorio) {
        Acessorio acessorio = new Acessorio();

        acessorio.setNome(adicionarAcessorio.nome());
        acessorio.setDescricao(adicionarAcessorio.descricao());
        acessorio.setPreco(adicionarAcessorio.preco());
        acessorio.setEstoque(adicionarAcessorio.estoque());
        acessorio.setCor(corRepository.findById(adicionarAcessorio.cor()));
        repository.persist(acessorio);

        return AcessorioRespose.valueOf(acessorio);

    }

    @Override
    public AcessorioRespose buscar(Long idAcessorio) {
        Acessorio buscarAcessorio = new Acessorio();

        buscarAcessorio = repository.findById(idAcessorio);

        return AcessorioRespose.valueOf(buscarAcessorio);
    }

    @Override
    public AcessorioRespose alterar(Long idAcessorio, AcessorioRequest novoAcessorio) {
        Acessorio antigoAcessorio = new Acessorio();
        
        antigoAcessorio = repository.findById(idAcessorio);

        antigoAcessorio.setNome(novoAcessorio.nome());
        antigoAcessorio.setDescricao(novoAcessorio.descricao());
        antigoAcessorio.setPreco(novoAcessorio.preco());
        antigoAcessorio.setEstoque(novoAcessorio.estoque());
        antigoAcessorio.setCor(corRepository.findById(novoAcessorio.cor()));

        return AcessorioRespose.valueOf(antigoAcessorio);
    }

    @Override
    public void delete(Long idAcessorio) {
        repository.delete(repository.findById(idAcessorio));
    }

    @Override
    public List<AcessorioRespose> buscarTodos() {
    
        // Mapear a lista de acessórios para uma lista de respostas de acessório
        List<AcessorioRespose> listaAcessorioResponse = repository.findAll().stream().map(acessorio -> {
                    return AcessorioRespose.valueOf(acessorio);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaAcessorioResponse;
    }
    
}
