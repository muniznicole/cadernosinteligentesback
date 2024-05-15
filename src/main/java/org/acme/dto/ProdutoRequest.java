package org.acme.dto;

import java.util.List;

import org.acme.model.Acessorio;
import org.acme.model.CadernoPersonalizado;

import io.smallrye.common.constraint.NotNull;

public record ProdutoRequest(

@NotNull
List<Long> cadernoPersonalizado,
@NotNull
List<Long> acessorio

) {
    
}
