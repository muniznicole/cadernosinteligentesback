package org.acme.repository;

import org.acme.model.CampoIdentificacao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CampoIdentificacaoRepository implements PanacheRepository<CampoIdentificacao>{
    
}
