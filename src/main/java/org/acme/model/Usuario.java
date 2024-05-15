package org.acme.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario extends Default {
     
    @Column
    String nome;
     
    @Column
    String login;
   
    @Column
    String email;
     
    @Column
    String senha;
    
    @Column
    String cpf;
    
    @Column
    String telefone;
    
    @Column
    @Enumerated(EnumType.STRING)
    PerfilUsuario perfilUsuarioerfilUsuario;
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public PerfilUsuario getPerfilUsuarioerfilUsuario() {
        return perfilUsuarioerfilUsuario;
    }

    public void setPerfilUsuarioerfilUsuario(PerfilUsuario perfilUsuarioerfilUsuario) {
        this.perfilUsuarioerfilUsuario = perfilUsuarioerfilUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    

  

   
    
}
