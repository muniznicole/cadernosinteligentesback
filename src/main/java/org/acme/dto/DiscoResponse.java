package org.acme.dto;

import org.acme.model.Disco;

public record DiscoResponse(
    CorResponse cor,
Long id,
String nome,
String descricao,
Double precoUnitario,
Integer estoque
) {

    public static DiscoResponse valueOf(Disco disco){
        return new DiscoResponse(
            CorResponse.valueOf(disco.getCor()),
            disco.getId(),
            disco.getNome(),
             disco.getDescricao(),
              disco.getPrecoUnitario(), 
              disco.getEstoque());
    }
}
