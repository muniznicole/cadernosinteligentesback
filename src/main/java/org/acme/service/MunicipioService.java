package org.acme.service;

import java.util.List;

import org.acme.dto.MunicipioRequest;
import org.acme.dto.MunicipioResponse;

public interface MunicipioService {
    public MunicipioResponse adicionar(MunicipioRequest adicionarMunicipio);

    public MunicipioResponse buscar(Long idMunicipio);
    
    public List<MunicipioResponse> buscarTodos();
    
    public MunicipioResponse alterar(Long idMunicipio, MunicipioRequest novoMunicipio);

    public void delete(Long idMunicipio);
}
