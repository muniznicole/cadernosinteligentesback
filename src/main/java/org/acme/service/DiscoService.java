package org.acme.service;

import java.util.List;

import org.acme.dto.DiscoRequest;
import org.acme.dto.DiscoResponse;

public interface DiscoService {
    public DiscoResponse adicionar(DiscoRequest adicionarDisco);

    public DiscoResponse buscar(Long idDisco);

    public List<DiscoResponse> buscarTodos();

    public DiscoResponse alterar(Long idDisco, DiscoRequest novoDisco);

    public void delete(Long idDisco);
}
