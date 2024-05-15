package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.AcessorioRespose;
import org.acme.dto.CadernoPersonalizadoRequest;
import org.acme.dto.CadernoPersonalizadoResponse;
import org.acme.model.CadernoPersonalizado;
import org.acme.repository.CadernoPersonalizadoRepository;
import org.acme.repository.CapaContraCapaRepository;
import org.acme.repository.DiscoRepository;
import org.acme.repository.FolhaRepository;
import org.acme.repository.PautaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CadernoPersonalizadoImpl implements CadernoPersonalizadoService {

    @Inject
    CadernoPersonalizadoRepository repository;
    @Inject
    FolhaRepository folhaRepository;
    @Inject
    PautaRepository pautaRepository;
    @Inject
    CapaContraCapaRepository capaContraCapaRepository;
    @Inject
    DiscoRepository discoRepository;

    @Override
    public CadernoPersonalizadoResponse adicionar(CadernoPersonalizadoRequest adicionarCadernoPersonalizado) {

        CadernoPersonalizado cadernoPersonalizado = new CadernoPersonalizado();

        cadernoPersonalizado.setPrecoTotal(adicionarCadernoPersonalizado.precoTotal());
        cadernoPersonalizado.setFolha(folhaRepository.findById( adicionarCadernoPersonalizado.folha()));
        cadernoPersonalizado.setTamanho( adicionarCadernoPersonalizado.tamanho());
        cadernoPersonalizado.setPauta(pautaRepository.findById( adicionarCadernoPersonalizado.pauta()));
        cadernoPersonalizado.setCapaContraCapa(capaContraCapaRepository.findById( adicionarCadernoPersonalizado.capaContraCapa()));
        cadernoPersonalizado.setDisco(discoRepository.findById(adicionarCadernoPersonalizado.disco()));

        repository.persist(cadernoPersonalizado);

        return CadernoPersonalizadoResponse.valueOf(cadernoPersonalizado);
    }

    @Override
    public CadernoPersonalizadoResponse buscar(Long idCadernoPersonalizado) {
        CadernoPersonalizado buscarCadernoPersonalizado = new CadernoPersonalizado();

        buscarCadernoPersonalizado = repository.findById(idCadernoPersonalizado);

        return CadernoPersonalizadoResponse.valueOf(buscarCadernoPersonalizado);
    }

    @Override
    public CadernoPersonalizadoResponse alterar(Long idCadernoPersonalizado,CadernoPersonalizadoRequest novoCadernoPersonalizado) {
        
    CadernoPersonalizado antigoCadernoPersonalizado=new CadernoPersonalizado();

    antigoCadernoPersonalizado=repository.findById(idCadernoPersonalizado);
    antigoCadernoPersonalizado.setPrecoTotal(novoCadernoPersonalizado.precoTotal());
    antigoCadernoPersonalizado.setFolha(folhaRepository.findById( novoCadernoPersonalizado.folha()));
    antigoCadernoPersonalizado.setTamanho(novoCadernoPersonalizado.tamanho());
    antigoCadernoPersonalizado.setPauta(pautaRepository.findById(novoCadernoPersonalizado.pauta()));
    antigoCadernoPersonalizado.setCapaContraCapa(capaContraCapaRepository.findById(novoCadernoPersonalizado.capaContraCapa()));
    antigoCadernoPersonalizado.setDisco(discoRepository.findById(novoCadernoPersonalizado.disco()));

    return CadernoPersonalizadoResponse.valueOf(antigoCadernoPersonalizado);
    }

    @Override
    public void delete(Long idCadernoPersonalizado) {
       repository.delete(repository.findById(idCadernoPersonalizado));
    }

    @Override
    public List<CadernoPersonalizadoResponse> buscarTodos() {
    
        // Mapear a lista de acessórios para uma lista de respostas de acessório
        List<CadernoPersonalizadoResponse> listaCadernoPersonalizadoResponse = repository.findAll().stream().map(cadernoPersonalizado -> {
                    return CadernoPersonalizadoResponse.valueOf(cadernoPersonalizado);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaCadernoPersonalizadoResponse;
    }

}
