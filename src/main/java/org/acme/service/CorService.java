package org.acme.service;

import java.util.List;

import org.acme.dto.CorRequest;
import org.acme.dto.CorResponse;

public interface CorService {
    public CorResponse adicionar(CorRequest adicionarCor);

    public CorResponse buscar(Long idCor);

    public List<CorResponse> buscarTodos();

    public CorResponse alterar(Long idCor, CorRequest novaCor);

    public void delete(Long idCor);
}
