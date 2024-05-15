package org.acme.dto;

import java.util.Date;

import org.acme.model.Cartao;

public record CartaoResponse(
        Long id,
        String titularCartao,
        String numeroCartao,
        Integer cv,
        Date validade) {

    public static CartaoResponse valueOf(Cartao cartao) {
        return new CartaoResponse(
                cartao.getId(),
                cartao.getTitularCartao(),
                cartao.getNumeroCartao(),
                cartao.getCv(),
                cartao.getValidade());
    }
}
