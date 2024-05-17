package org.acme.repository;

import org.acme.model.Usuario;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    
    public PanacheQuery<Usuario> findByUsername(String username) {
        if (username == null)
            return null;

        return find("username = ?1 ", username);
    }
    public PanacheQuery<Usuario> findByUsernameAndSenha(String username, String senha) {
        return find("login = ?1 AND  senha = ?2", username, senha);
    }
}
