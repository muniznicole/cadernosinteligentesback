package org.acme.service;

import java.util.List;

import org.acme.dto.AcessorioRequest;
import org.acme.dto.AcessorioRespose;

public interface AcessorioService {
    public AcessorioRespose adicionar(AcessorioRequest adicionarAcessorio);
    public AcessorioRespose buscar(Long idAcessorio);
    public List<AcessorioRespose> buscarTodos();
    public AcessorioRespose alterar(Long idAcessorio,AcessorioRequest novoAcessorio);
    public void delete(Long idAcessorio);

}
