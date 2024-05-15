package org.acme.service;

import java.util.List;

import org.acme.dto.EstadoResponse;
import org.acme.dto.EstadoResquest;

public interface EstadoService {
    
    public EstadoResponse adicionar(EstadoResquest adicionarEstado);

    public EstadoResponse buscar(Long idEstado);
    
    public List<EstadoResponse> buscarTodos(int page, int pageSize);

    public EstadoResponse alterar(Long idEstado,EstadoResquest novoEstado);
    
    public void delete(Long idEstado);

    long count();

}
