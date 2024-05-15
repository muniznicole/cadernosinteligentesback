package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.CorResponse;
import org.acme.dto.DiscoRequest;
import org.acme.dto.DiscoResponse;
import org.acme.model.Disco;
import org.acme.repository.CorRepository;
import org.acme.repository.DiscoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DiscoImpl implements DiscoService {

    @Inject
    DiscoRepository repository;
    @Inject
    CorRepository corRepository;

    @Override
    public DiscoResponse adicionar(DiscoRequest adicionarDisco) {
        Disco disco = new Disco();

        disco.setNome(adicionarDisco.nome());
        disco.setDescricao(adicionarDisco.descricao());
        disco.setPrecoUnitario(adicionarDisco.precoUnitario());
        disco.setEstoque(adicionarDisco.estoque());
        disco.setCor(corRepository.findById(adicionarDisco.cor()));

        repository.persist(disco);

        return DiscoResponse.valueOf(disco);
    }

    @Override
    public DiscoResponse buscar(Long idDisco) {
        
        Disco buscarDisco = new Disco();

        buscarDisco = repository.findById(idDisco);

        return DiscoResponse.valueOf(buscarDisco);
    }

    @Override
    public DiscoResponse alterar(Long idDisco, DiscoRequest novoDisco) {

        Disco antigoDisco = new Disco();

        antigoDisco = repository.findById(idDisco);

        antigoDisco.setNome(novoDisco.nome());
        antigoDisco.setDescricao(novoDisco.descricao());
        antigoDisco.setPrecoUnitario(novoDisco.precoUnitario());
        antigoDisco.setEstoque(novoDisco.estoque());
        antigoDisco.setCor(corRepository.findById(novoDisco.cor()));
        
        return DiscoResponse.valueOf(antigoDisco);
        }

    @Override
    public void delete(Long idDisco) {
    repository.delete(repository.findById(idDisco));
    }

    @Override
    public List<DiscoResponse> buscarTodos() {
            List<DiscoResponse> listaDiscoResponses = repository.findAll().stream().map(disco -> {
                    return DiscoResponse.valueOf(disco);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaDiscoResponses;
    }

}
