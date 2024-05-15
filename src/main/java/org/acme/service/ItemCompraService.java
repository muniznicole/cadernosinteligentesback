package org.acme.service;

import java.util.List;

import org.acme.dto.ItemCompraRequest;
import org.acme.dto.ItemCompraResponse;

public interface ItemCompraService {
    public ItemCompraResponse adicionar(ItemCompraRequest adicionarItemCompra);

    public ItemCompraResponse buscar(Long idItemCompra);

    public List<ItemCompraResponse> buscarTodos();

    public ItemCompraResponse alterar(Long idItemCompra, ItemCompraRequest novoItemCompra);

    public void delete(Long idItemCompra);
}
