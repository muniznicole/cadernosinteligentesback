package org.acme.dto;

import org.acme.model.Municipio;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record EnderecoRequest(

@NotNull
Long usuarioid,
@NotNull
Boolean principal,
@NotBlank
String logradouro,
@NotBlank
String bairro,
@NotBlank
String numero,
@NotBlank
String complemento,
@NotBlank
String cep,
@NotNull
Long municipio
) {
    
}
