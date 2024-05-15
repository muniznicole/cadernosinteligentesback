package org.acme.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.model.Cartao;
import org.acme.model.MeioPagamento;
import org.acme.model.TipoPagamento;

public record MeioPagamentoResponse(

Long id,
TipoPagamento meioPagamento,
CartaoResponse cartao

) {
    public static MeioPagamentoResponse valueOf(MeioPagamento meioPagamento){

        return new MeioPagamentoResponse(
            meioPagamento.getId(),
            meioPagamento.getMeioPagamento(),
             CartaoResponse.valueOf(meioPagamento.getCartao()));
    }
}
