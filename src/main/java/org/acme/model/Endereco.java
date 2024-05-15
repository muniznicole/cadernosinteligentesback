package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Endereco extends Default{
    
    @Column
    Boolean principal;
    
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    Usuario usuarioEndereco;

    @Column
    String logradouro;
    
    @Column
    String bairro;
    
    @Column
    String numero;
    
    @Column
    String complemento;
    
    @Column
    String cep;

    @JoinColumn(name="id_muncipio")
    @ManyToOne
    Municipio municipio;
    
    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Usuario getUsuarioEndereco() {
        return usuarioEndereco;
    }

    public void setUsuarioEndereco(Usuario usuarioEndereco) {
        this.usuarioEndereco = usuarioEndereco;
    }
  
}
