package org.acme.dto;


import io.smallrye.common.constraint.NotNull;

import jakarta.validation.constraints.NotBlank;

public record AcessorioRequest(
@NotBlank
String nome,
@NotBlank
String descricao,
@NotNull
Double preco,
@NotNull
Integer estoque,
@NotBlank
Long cor
) {
    
}
