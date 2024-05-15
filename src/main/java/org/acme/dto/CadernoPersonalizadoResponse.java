package org.acme.dto;

import org.acme.model.CadernoPersonalizado;

public record CadernoPersonalizadoResponse(
Long id,
Double precoTotal,
FolhaResponse folha,
String tamanho,
PautaResponse pauta,
CapaContraCapaResponse capaContraCapa,
DiscoResponse disco
) {
     public static CadernoPersonalizadoResponse valueOf(CadernoPersonalizado cadernoPersonalizado) {        
        return new CadernoPersonalizadoResponse(
         cadernoPersonalizado.getId(),
           cadernoPersonalizado.getPrecoTotal(),
           FolhaResponse.valueOf(cadernoPersonalizado.getFolha()),
           cadernoPersonalizado.getTamanho().name(),
           PautaResponse.valueOf(cadernoPersonalizado.getPauta()),
           CapaContraCapaResponse.valueOf(cadernoPersonalizado.getCapaContraCapa()),
           DiscoResponse.valueOf(cadernoPersonalizado.getDisco())
        );
    } 
}
