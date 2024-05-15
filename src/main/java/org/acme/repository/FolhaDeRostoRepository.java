package org.acme.repository;

import org.acme.model.FolhaDeRosto;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FolhaDeRostoRepository implements PanacheRepository<FolhaDeRosto> {
    
}
