package org.acme.service;

import java.util.List;

import org.acme.dto.CapaContraCapaRequest;
import org.acme.dto.CapaContraCapaResponse;

public interface CapaContraCapaService {
     public CapaContraCapaResponse adicionar(CapaContraCapaRequest adicionarCapaContraCapa);
    public CapaContraCapaResponse buscar(Long idCapaContraCapa);
    public List<CapaContraCapaResponse> buscarTodos();
    public CapaContraCapaResponse alterar(Long idCapaContraCapa,CapaContraCapaRequest novoCapaContraCapa);
    public void delete(Long idCapaContraCapa);
}
