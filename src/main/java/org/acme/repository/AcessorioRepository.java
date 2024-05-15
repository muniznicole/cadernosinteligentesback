package org.acme.repository;

import org.acme.model.Acessorio;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AcessorioRepository implements PanacheRepository<Acessorio>{
    
}
