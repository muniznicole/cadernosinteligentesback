package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record CampoIdentificacaoRequest(

    @NotBlank
    String nomeCampo

) {}
