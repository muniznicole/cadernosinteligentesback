package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CadernoPersonalizado extends Default {

    @Column
    Double precoTotal;

    @JoinColumn(name = "id_folha")
    @ManyToOne
    Folha folha;

    @Column
    @Enumerated(EnumType.STRING)
    Tamanho tamanho;

    @JoinColumn(name = "id_pauta")
    @ManyToOne
    Pauta pauta;

    @JoinColumn(name = "id_capacontracapa")
    @ManyToOne
    CapaContraCapa capaContraCapa;

    @JoinColumn(name = "id_disco")
    @ManyToOne
    Disco disco;

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }


    public Folha getFolha() {
        return folha;
    }

    public void setFolha(Folha folha) {
        this.folha = folha;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public CapaContraCapa getCapaContraCapa() {
        return capaContraCapa;
    }

    public void setCapaContraCapa(CapaContraCapa capaContraCapa) {
        this.capaContraCapa = capaContraCapa;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

}
