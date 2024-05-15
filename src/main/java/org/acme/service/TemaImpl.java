package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.ProdutoResponse;
import org.acme.dto.TemaRequest;
import org.acme.dto.TemaResponse;
import org.acme.model.Tema;
import org.acme.repository.TemaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TemaImpl implements TemaService {

    @Inject
    TemaRepository repository;

    @Override
    public TemaResponse adicionar(TemaRequest adicionarTema) {
        Tema tema = new Tema();

        tema.setNometema(adicionarTema.nometema());

        repository.persist(tema);

        return TemaResponse.valueOf(tema);
    }

    @Override
    public TemaResponse buscar(Long idTema) {
        Tema buscarTema = new Tema();

        buscarTema = repository.findById(idTema);

        return TemaResponse.valueOf(buscarTema);
    }

    @Override
    public TemaResponse alterar(Long idTema, TemaRequest novoTema) {
    Tema antigoTema = new Tema();

    antigoTema = repository.findById(idTema);

    antigoTema.setNometema(novoTema.nometema());

    return TemaResponse.valueOf(antigoTema);
    }

    @Override
    public void delete(Long idTema) {
    
        repository.delete(repository.findById(idTema));
    }

    @Override
    public List<TemaResponse> buscarTodos() {
         List<TemaResponse> listaTemaResponses = repository.findAll().stream().map(tema -> {
                    return TemaResponse.valueOf(tema);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaTemaResponses;
    }

}
