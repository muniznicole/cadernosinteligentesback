package org.acme.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.acme.dto.MeioPagamentoResponse;
import org.acme.dto.MunicipioRequest;
import org.acme.dto.MunicipioResponse;
import org.acme.model.Municipio;
import org.acme.repository.EstadoRepository;
import org.acme.repository.MunicipioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;

@ApplicationScoped
public class MunicipioImpl implements MunicipioService {

    @Inject
    MunicipioRepository repository;
    @Inject
    EstadoRepository estadoRepository;
    @Override
    public MunicipioResponse adicionar(MunicipioRequest adicionarMunicipio) {
        Municipio municipio = new Municipio();

        municipio.setNome(adicionarMunicipio.nome());
        municipio.setEstado(estadoRepository.findById(adicionarMunicipio.estado()));

        repository.persist(municipio);

        return MunicipioResponse.valueOf(municipio);

    }

    @Override
    public MunicipioResponse buscar(Long idMunicipio) {
    Municipio buscarMunicipio = new Municipio();
    
    buscarMunicipio = repository.findById(idMunicipio);

    return MunicipioResponse.valueOf(buscarMunicipio);
    
    }

    @Override
    public MunicipioResponse alterar(Long idMunicipio, MunicipioRequest novoMunicipio) {
        Municipio antigoMunicipio = new Municipio();

        antigoMunicipio.setNome(novoMunicipio.nome());
        antigoMunicipio.setEstado(estadoRepository.findById(novoMunicipio.estado()));
     
        return MunicipioResponse.valueOf(antigoMunicipio);
    }

    @Override
    public void delete(Long idMunicipio) {
       repository.delete(repository.findById(idMunicipio)); 
    }

    @Override
    public List<MunicipioResponse> buscarTodos() {
        List<Municipio> list = repository.buscarTodos2();
        return list.stream().map(e -> MunicipioResponse.valueOf(e)).collect(Collectors.toList());
    }

}
