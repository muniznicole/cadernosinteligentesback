package org.acme.dto;

import org.acme.model.Estado;
import org.acme.model.Municipio;

public record MunicipioResponse(
Long id,
String nome,
EstadoResponse estado
) {
    public static MunicipioResponse valueOf(Municipio municipio){
        return new MunicipioResponse(
            municipio.getId(),
            municipio.getNome(),
            EstadoResponse.valueOf(municipio.getEstado()));
    }
}
