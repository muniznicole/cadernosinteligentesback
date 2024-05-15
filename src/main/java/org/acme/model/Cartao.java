package org.acme.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Cartao extends Default{
    
    @Column
    String titularCartao;

    @Column
    String numeroCartao;

    @Column
    Integer cv;

    @Column
    Date validade;

    @Enumerated(EnumType.STRING)
    private ModalidadePagamentoCartao modalidadePagamentoCartao;

    public String getTitularCartao() {
        return titularCartao;
    }

    public void setTitularCartao(String titularCartao) {
        this.titularCartao = titularCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Integer getCv() {
        return cv;
    }

    public void setCv(Integer cv) {
        this.cv = cv;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public ModalidadePagamentoCartao getModalidadePagamentoCartao() {
        return modalidadePagamentoCartao;
    }

    public void setModalidadePagamentoCartao(ModalidadePagamentoCartao modalidadePagamentoCartao) {
        this.modalidadePagamentoCartao = modalidadePagamentoCartao;
    }
    
}
