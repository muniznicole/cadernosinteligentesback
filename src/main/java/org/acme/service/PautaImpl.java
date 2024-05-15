package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.MunicipioResponse;
import org.acme.dto.PautaRequest;
import org.acme.dto.PautaResponse;
import org.acme.model.Pauta;
import org.acme.repository.PautaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PautaImpl implements PautaService {

    @Inject
    PautaRepository repository;

    @Override
    public PautaResponse adicionar(PautaRequest adicionarPauta) {
        Pauta pauta = new Pauta();

        pauta.setQuantidadePauta(adicionarPauta.quantidadePauta());

        repository.persist(pauta);

        return PautaResponse.valueOf(pauta);
    }

    @Override
    public PautaResponse buscar(Long idPauta) {
        Pauta buscarPauta = new Pauta();

        buscarPauta = repository.findById(idPauta);

        return PautaResponse.valueOf(buscarPauta);

    }

    @Override
    public PautaResponse alterar(Long idPauta, PautaRequest novoPauta) {
        Pauta antigoPauta = new Pauta();

        antigoPauta = repository.findById(idPauta);

        antigoPauta.setQuantidadePauta(novoPauta.quantidadePauta());

        return PautaResponse.valueOf(antigoPauta);

    }

    @Override
    public void delete(Long idPauta) {
        repository.delete(repository.findById(idPauta));
    }

    @Override
    public List<PautaResponse> buscarTodos() {
       List<PautaResponse> listaPautaResponses = repository.findAll().stream().map(pauta -> {
                    return PautaResponse.valueOf(pauta);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaPautaResponses;
    }

}
