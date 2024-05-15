package org.acme.service;

import java.util.List;

import org.acme.dto.CompraRequest;
import org.acme.dto.CompraResponse;

public interface CompraService {
  public CompraResponse adicionar(CompraRequest adicionarCompra);

  public CompraResponse buscar(Long idCompra);

  public List<CompraResponse> buscarTodos();

  public CompraResponse alterar(Long idCompra, CompraRequest novoCompra);

  public void delete(Long idCompra);
}
