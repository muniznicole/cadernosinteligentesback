package org.acme.dto;

import org.acme.model.Acessorio;

public record AcessorioRespose(
Long id,
String nome,
String descricao,
Double preco,
Integer estoque,
CorResponse cor
) {
    
    public static AcessorioRespose valueOf(Acessorio acessorio) {        
        return new AcessorioRespose(
            acessorio.getId(),
           acessorio.getNome(),
           acessorio.getDescricao(),
           acessorio.getPreco(),
           acessorio.getEstoque(),
        CorResponse.valueOf( acessorio.getCor())
        );
    } 
}
