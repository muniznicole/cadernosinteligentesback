package org.acme.repository;

import org.acme.model.Pauta;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PautaRepository implements PanacheRepository<Pauta> {
    
}
