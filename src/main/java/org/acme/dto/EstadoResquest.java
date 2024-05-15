package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record EstadoResquest(

@NotBlank
String nome,
@NotBlank
String sigla

) {

}
