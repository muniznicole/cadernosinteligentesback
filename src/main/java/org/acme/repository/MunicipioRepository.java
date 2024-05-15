package org.acme.repository;

import java.util.List;

import org.acme.model.Municipio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MunicipioRepository implements PanacheRepository<Municipio>{
    
    public List<Municipio> buscarPorNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Municipio> buscarTodos2() {
        return find("SELECT c FROM Municipio c ORDER BY c.nome ").list();
    }

}
