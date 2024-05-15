package org.acme.dto;

import java.util.List;

import org.acme.model.Cartao;
import org.acme.model.TipoPagamento;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record MeioPagamentoRequest(

@NotBlank
TipoPagamento meioPagamento,
@NotNull
Long cartao
) {
    
}
