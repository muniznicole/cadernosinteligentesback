package org.acme.service;

import java.util.List;
    
import org.acme.dto.CadernoPersonalizadoRequest;
import org.acme.dto.CadernoPersonalizadoResponse;

public interface CadernoPersonalizadoService {
     public CadernoPersonalizadoResponse adicionar(CadernoPersonalizadoRequest adicionarCadernoPersonalizado);
    public CadernoPersonalizadoResponse buscar(Long idCadernoPersonalizado);
    public List<CadernoPersonalizadoResponse> buscarTodos();
    public CadernoPersonalizadoResponse alterar(Long idCadernoPersonalizado,CadernoPersonalizadoRequest novoCadernoPersonalizado);
    public void delete(Long idCadernoPersonalizado);

}
