package org.acme.service;

import org.acme.dto.UsuarioResponse;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface JwtService  {
    public String generateJwt(UsuarioResponse dto);
}
