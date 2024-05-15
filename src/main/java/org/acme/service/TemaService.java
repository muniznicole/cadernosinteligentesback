package org.acme.service;

import java.util.List;

import org.acme.dto.ProdutoResponse;
import org.acme.dto.TemaRequest;
import org.acme.dto.TemaResponse;

public interface TemaService {
    public TemaResponse adicionar(TemaRequest adicionarTema);

    public TemaResponse buscar(Long idTema);

    public List<TemaResponse> buscarTodos();

    public TemaResponse alterar(Long idTema, TemaRequest novoTema);

    public void delete(Long idTema);
}
