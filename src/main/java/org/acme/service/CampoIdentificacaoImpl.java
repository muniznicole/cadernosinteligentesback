package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.CadernoPersonalizadoResponse;
import org.acme.dto.CampoIdentificacaoRequest;
import org.acme.dto.CampoIdentificacaoResponse;
import org.acme.model.CampoIdentificacao;
import org.acme.repository.CampoIdentificacaoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CampoIdentificacaoImpl implements CampoIdentificacaoService {

    @Inject
    CampoIdentificacaoRepository repository;

    @Override
    public CampoIdentificacaoResponse adicionar(CampoIdentificacaoRequest adicionarCampoIdentificacao) {
       
        CampoIdentificacao campoIdentificacao=new CampoIdentificacao();

        campoIdentificacao.setNomeCampo(adicionarCampoIdentificacao.nomeCampo());

        repository.persist(campoIdentificacao);

        return CampoIdentificacaoResponse.valueOf(campoIdentificacao);
    }

    @Override
    public CampoIdentificacaoResponse buscar(Long idCampoIdentificacao) {
        CampoIdentificacao buscarCampoIdentificacao= new CampoIdentificacao();

        buscarCampoIdentificacao=repository.findById(idCampoIdentificacao);

        return CampoIdentificacaoResponse.valueOf(buscarCampoIdentificacao);
    }

    @Override
    public CampoIdentificacaoResponse alterar(Long idCampoIdentificacao,
            CampoIdentificacaoRequest novoCampoIdentificacao) {
    CampoIdentificacao antigoCampoIdentificacao = new CampoIdentificacao();

    antigoCampoIdentificacao=repository.findById(idCampoIdentificacao);

    antigoCampoIdentificacao.setNomeCampo(novoCampoIdentificacao.nomeCampo());

    return CampoIdentificacaoResponse.valueOf(antigoCampoIdentificacao);
    }

    @Override
    public void delete(Long idCampoIdentificacao) {
       repository.delete(repository.findById(idCampoIdentificacao));
    }

    @Override
    public List<CampoIdentificacaoResponse> buscarTodos() {
        // Mapear a lista de acessórios para uma lista de respostas de acessório
        List<CampoIdentificacaoResponse> listaCampoIdentificacaoResponse = repository.findAll().stream().map(campoIdentificacao -> {
                    return CampoIdentificacaoResponse.valueOf(campoIdentificacao);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaCampoIdentificacaoResponse;
    }

}
