package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record TemaRequest(

        @NotBlank
        String nometema
        ) {

}
