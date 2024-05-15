package org.acme.dto;

import org.acme.model.Produto;

import io.smallrye.common.constraint.NotNull;


public record ItemCompraRequest(

@NotNull
Integer quantidade,
@NotNull
Double preco,
@NotNull
Long produto
) {
} 
