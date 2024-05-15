package org.acme.model;

public enum TipoPagamento {
    
    BOLETO(1,"Boleto"),
    PIX(2,"Pix"),
    CARTAO(3,"Cartao");

    private final Integer valor;
    private final String nome;

    private TipoPagamento(Integer valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }
   
}
