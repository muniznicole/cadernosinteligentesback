package org.acme.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.acme.dto.EnderecoResponse;
import org.acme.dto.EstadoResponse;
import org.acme.dto.EstadoResquest;
import org.acme.model.Estado;
import org.acme.repository.EstadoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EstadoImpl implements EstadoService {

    @Inject
    EstadoRepository repository;

    @Override
    public EstadoResponse adicionar(EstadoResquest adicionarEstado) {
        Estado estado = new Estado();

        estado.setNome(adicionarEstado.nome());
        estado.setSigla(adicionarEstado.sigla());

        repository.persist(estado);

        return EstadoResponse.valueOf(estado);
    }

    @Override
    public EstadoResponse buscar(Long idEstado) {
        Estado buscarEstado = new Estado();

        buscarEstado = repository.findById(idEstado);

        return EstadoResponse.valueOf(buscarEstado);
    }

    @Override
    public EstadoResponse alterar(Long idEstado, EstadoResquest novoEstado) {
    Estado antigoEstado = new Estado();
    
    antigoEstado = repository.findById(idEstado);

    antigoEstado.setNome(novoEstado.nome());
    antigoEstado.setSigla(novoEstado.sigla());

    return EstadoResponse.valueOf(antigoEstado);
    
    }

    @Override
    public void delete(Long idEstado) {
       repository.delete(repository.findById(idEstado));
    }

    @Override
    public List<EstadoResponse> buscarTodos(int page, int pageSize) {
        List<Estado> list = repository
                            .findAll()
                            .page(page, pageSize)
                            .list();
    
        return list.stream().map(e -> EstadoResponse.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

}
