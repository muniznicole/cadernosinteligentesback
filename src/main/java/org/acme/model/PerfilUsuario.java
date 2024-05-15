package org.acme.model;

public enum PerfilUsuario {
    
    CLIENTE(1,"cliente"),
    ADMINSTRADOR(2,"Adminstrador");

    private final String descricao;
    private final Integer valor;
    
    private PerfilUsuario(Integer valor, String descricao) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getValor() {
        return valor;
    }
 
}
