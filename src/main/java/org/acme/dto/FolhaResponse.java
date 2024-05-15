package org.acme.dto;

import org.acme.model.Folha;

public record FolhaResponse(
Long id,
String nome,
String descricao,
Double precoUnitario,
Integer quantidade,
CorResponse cor,
PautaResponse pauta
) {
    public static FolhaResponse valueOf(Folha folha){
        return new FolhaResponse(
            folha.getId(),
            folha.getNome(),
            folha.getDescricao(),
            folha.getPrecoUnitario(),
            folha.getQuantidade(),
            CorResponse.valueOf(folha.getCor()),
            PautaResponse.valueOf(folha.getPauta())
        );
    }
}
