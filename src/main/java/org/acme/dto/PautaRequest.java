package org.acme.dto;

import io.smallrye.common.constraint.NotNull;

public record PautaRequest(

        @NotNull 
        Integer quantidadePauta
        
        ) {

}
