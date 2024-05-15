package org.acme.dto;

import org.acme.model.Tema;

public record TemaResponse(
Long id,
String nometema
) {
    public static TemaResponse valueOf(Tema tema){
        return new TemaResponse(tema.getId(),
         tema.getNometema());
    }
}
