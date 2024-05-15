package org.acme.dto;

import org.acme.model.CampoIdentificacao;
import org.acme.model.Cor;
import org.acme.model.FolhaDeRosto;

public record FolhaDeRostoResponse(
Long  id,
String nome,
String descricao,
Double precoUnitario,
Integer estoque,
CorResponse cor,
CampoIdentificacaoResponse camposFolhaDeRosto
) {
    public static FolhaDeRostoResponse valueOf(FolhaDeRosto folhaDeRosto){
        return new FolhaDeRostoResponse(
            folhaDeRosto.getId(),
            folhaDeRosto.getNome(),
             folhaDeRosto.getDescricao(),
              folhaDeRosto.getPrecoUnitario(),
               folhaDeRosto.getEstoque(),
                CorResponse.valueOf(folhaDeRosto.getCor()),
                 CampoIdentificacaoResponse.valueOf(folhaDeRosto.getCamposFolhaDeRosto()));
    }
}
