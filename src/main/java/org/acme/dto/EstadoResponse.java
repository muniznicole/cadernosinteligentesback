package org.acme.dto;

import org.acme.model.Estado;

public record EstadoResponse(
Long id,
String nome,
String sigla
) {
    
    public static EstadoResponse valueOf(Estado estado){
        return new EstadoResponse(
            estado.getId(),
            estado.getNome(),
             estado.getSigla());
    }
}
