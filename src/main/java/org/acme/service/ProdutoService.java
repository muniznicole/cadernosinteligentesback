package org.acme.service;

import java.util.List;

import org.acme.dto.ProdutoRequest;
import org.acme.dto.ProdutoResponse;

public interface ProdutoService {
    public ProdutoResponse adicionar(ProdutoRequest adicionarProduto);

    public ProdutoResponse buscar(Long idProduto);

    public List<ProdutoResponse> buscarTodos();

    public ProdutoResponse alterar(Long idProduto, ProdutoRequest novoPauta);

    public void delete(Long idProduto);
}
