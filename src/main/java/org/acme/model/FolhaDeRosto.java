package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class FolhaDeRosto extends Default {

    @Column
    String nome;

    @Column
    String descricao;

    @Column
    Double precoUnitario;

    @Column
    Integer estoque;

    @JoinColumn(name = "id_cor")
    @OneToOne
    Cor cor;

    @JoinColumn(name = "id_camposFolhaDeRosto")
    @OneToOne
    CampoIdentificacao camposFolhaDeRosto;
    
    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public CampoIdentificacao getCamposFolhaDeRosto() {
        return camposFolhaDeRosto;
    }

    public void setCamposFolhaDeRosto(CampoIdentificacao camposFolhaDeRosto) {
        this.camposFolhaDeRosto = camposFolhaDeRosto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

}
