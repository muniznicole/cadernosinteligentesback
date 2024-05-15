package org.acme.repository;

import org.acme.model.Disco;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DiscoRepository implements PanacheRepository<Disco> {
    
}
