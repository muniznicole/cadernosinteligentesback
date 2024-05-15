package org.acme.dto;

import org.acme.model.Pauta;

public record PautaResponse(
    Long id,
    Integer quantidadePauta

) {
    public static PautaResponse valueOf(Pauta pauta){
        return new PautaResponse(
            pauta.getId(),
            pauta.getQuantidadePauta());
    }
}
