package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Tema extends Default {
    
    @Column
    String  nometema;

    public String getNometema() {
        return nometema;
    }

    public void setNometema(String nometema) {
        this.nometema = nometema;
    }
   
}
