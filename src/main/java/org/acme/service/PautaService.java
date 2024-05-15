package org.acme.service;

import java.util.List;

import org.acme.dto.MeioPagamentoResponse;
import org.acme.dto.PautaRequest;
import org.acme.dto.PautaResponse;

public interface PautaService {
    public PautaResponse adicionar(PautaRequest adicionarPauta);

    public PautaResponse buscar(Long idPauta);
public List<PautaResponse> buscarTodos();
    public PautaResponse alterar(Long idPauta, PautaRequest novoPauta);

    public void delete(Long idPauta);
}
