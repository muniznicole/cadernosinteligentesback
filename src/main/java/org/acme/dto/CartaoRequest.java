package org.acme.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public record CartaoRequest(

@NotBlank
String titularCartao,
@NotBlank
String numeroCartao,
@NotBlank
Integer cv,
@NotBlank
Date validade

) {
} 
