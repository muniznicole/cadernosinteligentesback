package org.acme.model;

public enum Tamanho {

    P (0),
    M (1),
    G (2);

    private final Integer valor;

     Tamanho( Integer valor) {
        this.valor=valor;
    }

    public Integer valor() {
        return valor;
    }

    public Integer getValor() {
        return valor;
    }

}
