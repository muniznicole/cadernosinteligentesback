package org.acme.dto;

import org.acme.model.Cor;
import org.acme.model.Tema;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record CapaContraCapaRequest(

@NotNull
String nome,
@NotBlank
String descricao,
@NotNull
Double precoUnitario,
@NotNull
Integer estoque,
@NotNull
Long cor,
@NotNull
Long tema

) {
    
}
