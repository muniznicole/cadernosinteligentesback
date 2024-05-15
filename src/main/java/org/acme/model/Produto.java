package org.acme.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Produto extends Default{
    
    @JoinColumn(name = "id_cadernoPersonalizado")
    @OneToMany
    List<CadernoPersonalizado> cadernoPersonalizado;

    @JoinColumn(name = "id_acessorio")
    @OneToMany
    List<Acessorio> acessorio;

    public List<Acessorio> getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(List<Acessorio> acessorio) {
        this.acessorio = acessorio;
    }

    public List<CadernoPersonalizado> getCadernoPersonalizado() {
        return cadernoPersonalizado;
    }

    public void setCadernoPersonalizado(List<CadernoPersonalizado> cadernoPersonalizado) {
        this.cadernoPersonalizado = cadernoPersonalizado;
    }
   
}
