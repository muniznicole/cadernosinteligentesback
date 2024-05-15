package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.EstadoResponse;
import org.acme.dto.FolhaDeRostoRequest;
import org.acme.dto.FolhaDeRostoResponse;
import org.acme.model.FolhaDeRosto;
import org.acme.repository.CampoIdentificacaoRepository;
import org.acme.repository.CorRepository;
import org.acme.repository.FolhaDeRostoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FolhaDeRostoImpl implements FolhaDeRostoService{

    @Inject
    FolhaDeRostoRepository repository;
    @Inject
    CorRepository corRepository;
    @Inject
    CampoIdentificacaoRepository camposFolhadeRostoRepository;

    @Override
    public FolhaDeRostoResponse adicionar(FolhaDeRostoRequest adicionarFolhaDeRosto) {
    FolhaDeRosto folhaDeRosto = new FolhaDeRosto();

    folhaDeRosto.setNome(adicionarFolhaDeRosto.nome());
    folhaDeRosto.setDescricao(adicionarFolhaDeRosto.descricao());
    folhaDeRosto.setPrecoUnitario(adicionarFolhaDeRosto.precoUnitario());
    folhaDeRosto.setEstoque(adicionarFolhaDeRosto.estoque());
    folhaDeRosto.setCor(corRepository.findById(adicionarFolhaDeRosto.cor()));
    folhaDeRosto.setCamposFolhaDeRosto(camposFolhadeRostoRepository.findById(adicionarFolhaDeRosto.camposFolhaDeRosto()));
  
    repository.persist(folhaDeRosto);

    return FolhaDeRostoResponse.valueOf(folhaDeRosto);
    }

    @Override
    public FolhaDeRostoResponse buscar(Long idFolhaDeRosto) {
   FolhaDeRosto buscarFolhaDeRosto = new FolhaDeRosto();

   buscarFolhaDeRosto = repository.findById(idFolhaDeRosto);

   return FolhaDeRostoResponse.valueOf(buscarFolhaDeRosto);
   
    }

    @Override
    public FolhaDeRostoResponse alterar(Long idFolhaDeRosto, FolhaDeRostoRequest novoFolhaDeRosto) {
    
        FolhaDeRosto antigoFolhaDeRosto = new FolhaDeRosto();

        antigoFolhaDeRosto.setNome(novoFolhaDeRosto.nome());
        antigoFolhaDeRosto.setDescricao(novoFolhaDeRosto.descricao());
        antigoFolhaDeRosto.setPrecoUnitario(novoFolhaDeRosto.precoUnitario());
        antigoFolhaDeRosto.setEstoque(novoFolhaDeRosto.estoque());
        antigoFolhaDeRosto.setCor(corRepository.findById( novoFolhaDeRosto.cor()));
        antigoFolhaDeRosto.setCamposFolhaDeRosto(camposFolhadeRostoRepository.findById(novoFolhaDeRosto.camposFolhaDeRosto()));

        return FolhaDeRostoResponse.valueOf(antigoFolhaDeRosto);
    }

    @Override
    public void delete(Long idFolhaDeRosto) {
    repository.delete(repository.findById(idFolhaDeRosto));  
    
    }

    @Override
    public List<FolhaDeRostoResponse> buscarTodos() {
       List<FolhaDeRostoResponse> listaFplhaDeRostoResponses = repository.findAll().stream().map(folhaDeRosto -> {
                    return FolhaDeRostoResponse.valueOf(folhaDeRosto);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaFplhaDeRostoResponses;
    }
    
}
