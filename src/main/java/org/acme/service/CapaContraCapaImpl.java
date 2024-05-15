package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.CampoIdentificacaoResponse;
import org.acme.dto.CapaContraCapaRequest;
import org.acme.dto.CapaContraCapaResponse;
import org.acme.model.CapaContraCapa;
import org.acme.repository.CapaContraCapaRepository;
import org.acme.repository.CorRepository;
import org.acme.repository.TemaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CapaContraCapaImpl implements CapaContraCapaService {


    @Inject
    CapaContraCapaRepository repository;
    @Inject
    CorRepository corRepository;
    @Inject
    TemaRepository temaRepository;

    @Override
    public CapaContraCapaResponse adicionar(CapaContraCapaRequest adicionarCapaContraCapa) {
    CapaContraCapa capaContraCapa=new CapaContraCapa();

    capaContraCapa.setNome(adicionarCapaContraCapa.nome());
    capaContraCapa.setDescricao(adicionarCapaContraCapa.descricao());
    capaContraCapa.setPrecoUnitario(adicionarCapaContraCapa.precoUnitario());
    capaContraCapa.setEstoque(adicionarCapaContraCapa.estoque());
    capaContraCapa.setCor(corRepository.findById( adicionarCapaContraCapa.cor()));
    capaContraCapa.setTema(temaRepository.findById(adicionarCapaContraCapa.tema()));

    repository.persist(capaContraCapa);

    return CapaContraCapaResponse.valueOf(capaContraCapa);
    }

    @Override
    public CapaContraCapaResponse buscar(Long idCapaContraCapa) {
        CapaContraCapa buscarcapaContraCapa=new CapaContraCapa();

        buscarcapaContraCapa=repository.findById(idCapaContraCapa);

        return CapaContraCapaResponse.valueOf(buscarcapaContraCapa);
    }

    @Override
    public CapaContraCapaResponse alterar(Long idCapaContraCapa, CapaContraCapaRequest novoCapaContraCapa) {
        CapaContraCapa antigoCapaContraCapa=new CapaContraCapa();

        antigoCapaContraCapa=repository.findById(idCapaContraCapa);

        antigoCapaContraCapa.setNome(novoCapaContraCapa.nome());
        antigoCapaContraCapa.setDescricao(novoCapaContraCapa.descricao());
        antigoCapaContraCapa.setPrecoUnitario(novoCapaContraCapa.precoUnitario());
        antigoCapaContraCapa.setEstoque(novoCapaContraCapa.estoque());
        antigoCapaContraCapa.setCor(corRepository.findById( novoCapaContraCapa.cor()));
        antigoCapaContraCapa.setTema(temaRepository.findById(novoCapaContraCapa.cor()));

        return CapaContraCapaResponse.valueOf(antigoCapaContraCapa);
    }

    @Override
    public void delete(Long idCapaContraCapa) {
      repository.delete(repository.findById(idCapaContraCapa));
    }

    @Override
    public List<CapaContraCapaResponse> buscarTodos() {
       // Mapear a lista de acessórios para uma lista de respostas de acessório
        List<CapaContraCapaResponse> listaCapaContraCapaResponse = repository.findAll().stream().map(capaContraCapa -> {
                    return CapaContraCapaResponse.valueOf(capaContraCapa);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaCapaContraCapaResponse;
    }
    
}
