package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ModalidadePagamentoCartao {
    
    DEBITO(1,"Debito"),
    CREDITO(2,"Credito");

    private final Integer valor;
    private final String nome;

    private ModalidadePagamentoCartao(Integer valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    // caso o valor seja null a aplicação não para de rodar
    public static ModalidadePagamentoCartao valueOf(Integer valor) throws IllegalArgumentException {
        if (valor == null)
            return null;
        for(ModalidadePagamentoCartao modalidadePagamentoCartao : ModalidadePagamentoCartao.values()) {
            if (valor.equals(modalidadePagamentoCartao.getValor()))
                return modalidadePagamentoCartao;
        }
        throw new IllegalArgumentException("valor inválido:" + valor);
    }
   
}
