package org.acme.repository;

import org.acme.model.Folha;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FolhaRepository implements PanacheRepository<Folha>{
    
}
