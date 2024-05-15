package org.acme.service;

import java.util.List;

import org.acme.dto.MeioPagamentoRequest;
import org.acme.dto.MeioPagamentoResponse;

public interface MeioPagamentoService {
     public MeioPagamentoResponse adicionar(MeioPagamentoRequest adicionarMeioPagamento);
    public MeioPagamentoResponse buscar(Long idMeioPagamento);
     public List<MeioPagamentoResponse> buscarTodos();
    public MeioPagamentoResponse alterar(Long idMeioPagamento,MeioPagamentoRequest novoMeioPagamento);
    public void delete(Long idMeioPagamento);
}
