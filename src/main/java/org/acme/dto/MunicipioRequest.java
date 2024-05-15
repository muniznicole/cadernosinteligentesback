package org.acme.dto;

import org.acme.model.Estado;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record MunicipioRequest(

@NotBlank
String nome,
@NotNull
Long estado
) {
    
}
