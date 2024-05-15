package org.acme.repository;

import org.acme.model.MeioPagamento;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MeioPagamentoRepository implements PanacheRepository<MeioPagamento> {
    
}
