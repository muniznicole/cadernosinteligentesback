package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.FolhaDeRostoResponse;
import org.acme.dto.FolhaRequest;
import org.acme.dto.FolhaResponse;
import org.acme.model.Folha;
import org.acme.repository.CorRepository;
import org.acme.repository.FolhaRepository;
import org.acme.repository.PautaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FolhaImpl implements FolhaService {

    @Inject
    FolhaRepository repository;
    @Inject
    CorRepository corRepository;
    @Inject
    PautaRepository pautaRepository;

    @Override
    public FolhaResponse adicionar(FolhaRequest adicionarFolha) {
        Folha folha = new Folha();

        folha.setNome(adicionarFolha.nome());
        folha.setDescricao(adicionarFolha.descricao());
        folha.setPrecoUnitario(adicionarFolha.precoUnitario());
        folha.setQuantidade(adicionarFolha.quantidade());
        folha.setCor(corRepository.findById(adicionarFolha.cor()));
        folha.setPauta(pautaRepository.findById(adicionarFolha.pauta()));

        repository.persist(folha);

        return FolhaResponse.valueOf(folha);
    }

    @Override
    public FolhaResponse buscar(Long idFolha) {
        Folha buscarFolha = new Folha();

        buscarFolha = repository.findById(idFolha);

        return FolhaResponse.valueOf(buscarFolha);
    }

    @Override
    public FolhaResponse alterar(Long idFolha, FolhaRequest novoFolha) {
    Folha antigoFolha = new Folha();
    
    antigoFolha = repository.findById(idFolha);

    antigoFolha.setNome(novoFolha.nome());
    antigoFolha.setDescricao(novoFolha.descricao());
    antigoFolha.setPrecoUnitario(novoFolha.precoUnitario());
    antigoFolha.setQuantidade(novoFolha.quantidade());
    antigoFolha.setCor(corRepository.findById(novoFolha.cor()));
    antigoFolha.setPauta(pautaRepository.findById(novoFolha.pauta()));

    return FolhaResponse.valueOf(antigoFolha);
    }

    @Override
    public void delete(Long idFolha) {
    repository.delete(repository.findById(idFolha));  
    }

    @Override
    public List<FolhaResponse> buscarTodos() {
 List<FolhaResponse> listaFolhaResponses = repository.findAll().stream().map(folha -> {
                    return FolhaResponse.valueOf(folha);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaFolhaResponses;
    }

}
