package org.acme.dto;

import org.acme.model.Cor;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record DiscoRequest(

@NotBlank
String nome,
@NotBlank
String descricao,
@NotNull
Double precoUnitario,
@NotNull
Integer estoque,
@NotNull
Long cor
) {
} 
