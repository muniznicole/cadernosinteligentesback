package org.acme.service;

import java.util.List;

import org.acme.dto.CampoIdentificacaoRequest;
import org.acme.dto.CampoIdentificacaoResponse;

public interface CampoIdentificacaoService {
    
    public CampoIdentificacaoResponse adicionar(CampoIdentificacaoRequest adicionarCampoIdentificacao);
    
    public CampoIdentificacaoResponse buscar(Long idCampoIdentificacao);
    
    public List<CampoIdentificacaoResponse> buscarTodos();
    
    public CampoIdentificacaoResponse alterar(Long idCampoIdentificacao,CampoIdentificacaoRequest novoCampoIdentificacao);
    
    public void delete(Long idCampoIdentificacao);

}
