package org.acme.repository;

import org.acme.model.CapaContraCapa;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CapaContraCapaRepository implements PanacheRepository<CapaContraCapa> {
    
}
