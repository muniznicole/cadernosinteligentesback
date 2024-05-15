package org.acme.dto;

import org.acme.model.ItemCompra;
import org.acme.model.Produto;

public record ItemCompraResponse(
    Long id,
    Integer quantidade,
    Double preco,
    ProdutoResponse produto
) {
    public static ItemCompraResponse valueOf(ItemCompra itemCompra){
        return new ItemCompraResponse(
            itemCompra.getId(),
            itemCompra.getQuantidade(),
             itemCompra.getPreco(),
              ProdutoResponse.valueOf(itemCompra.getProduto()));
    }
}
