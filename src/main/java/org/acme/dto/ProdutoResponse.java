package org.acme.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.model.Produto;

public record ProdutoResponse(
Long id,
List<CadernoPersonalizadoResponse> cadernoPersonalizado,
List<AcessorioRespose> acessorio

) {
    public static ProdutoResponse valueOf(Produto produto){
        List<CadernoPersonalizadoResponse> listaCadernoPersonalizadoResponse = produto.getCadernoPersonalizado().stream().map(cadernoPersonalizado -> {
                    return CadernoPersonalizadoResponse.valueOf(cadernoPersonalizado);
                })
                .collect(Collectors.toList());

                List<AcessorioRespose> listaAcessorioResponse = produto.getAcessorio().stream().map(acessorio -> {
                    return AcessorioRespose.valueOf(acessorio);
                })
                .collect(Collectors.toList()); 
        return new ProdutoResponse(
            produto.getId(),
            listaCadernoPersonalizadoResponse,
             listaAcessorioResponse);
    }
}

