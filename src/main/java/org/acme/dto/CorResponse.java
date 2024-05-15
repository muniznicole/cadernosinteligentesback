package org.acme.dto;

import org.acme.model.Cor;

public record CorResponse(
    Long id,
    String cor
) {
    public static CorResponse valueOf(Cor cor){
        return new CorResponse(
        cor.getId(),    
        cor.getCor());
    }
}  

   
