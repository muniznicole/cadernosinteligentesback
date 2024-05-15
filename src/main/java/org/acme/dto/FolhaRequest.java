package org.acme.dto;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record FolhaRequest(

@NotBlank
String nome,
@NotBlank
String descricao,
@NotNull
Double precoUnitario,
@NotNull
Integer quantidade,
@NotNull
Long cor,
@NotNull
Long pauta

) {
    
}
