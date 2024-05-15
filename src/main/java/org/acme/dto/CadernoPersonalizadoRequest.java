package org.acme.dto;

import org.acme.model.Tamanho;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record CadernoPersonalizadoRequest(

@NotBlank
Double precoTotal,
@NotNull
Long folha,
@NotNull
Tamanho tamanho,
@NotNull
Long pauta,
@NotNull
Long capaContraCapa,
@NotNull
Long disco
) {
    
}
