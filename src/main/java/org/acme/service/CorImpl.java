package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.CompraResponse;
import org.acme.dto.CorRequest;
import org.acme.dto.CorResponse;
import org.acme.repository.CorRepository;
import org.acme.model.Cor;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CorImpl implements CorService{


    @Inject
    CorRepository repository;


    @Override
    public CorResponse adicionar(CorRequest adicionarCor) {
        Cor cor = new Cor();

        cor.setCor(adicionarCor.cor());

        repository.persist(cor);

        return CorResponse.valueOf(cor);

    }

    @Override
    public CorResponse buscar(Long idCor) {
        
        Cor buscarCor = new Cor();

        buscarCor = repository.findById(idCor);

        return CorResponse.valueOf(buscarCor);
    }

    @Override
    public CorResponse alterar(Long idCor, CorRequest novaCor) {
        Cor antigaCor = new Cor();

        antigaCor = repository.findById(idCor);

        antigaCor.setCor(novaCor.cor());

        return CorResponse.valueOf(antigaCor);
    }

    @Override
    public void delete(Long idCor) {
        repository.delete(repository.findById(idCor));
    }

    @Override
    public List<CorResponse> buscarTodos() {
          List<CorResponse> listaCorResponses = repository.findAll().stream().map(cor -> {
                    return CorResponse.valueOf(cor);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaCorResponses;
    }
    
}
