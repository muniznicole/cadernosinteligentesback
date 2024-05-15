package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Pauta extends Default{
    
    @Column
    Integer quantidadePauta;

    public Integer getQuantidadePauta() {
        return quantidadePauta;
    }

    public void setQuantidadePauta(Integer quantidadePauta) {
        this.quantidadePauta = quantidadePauta;
    }
   
}
