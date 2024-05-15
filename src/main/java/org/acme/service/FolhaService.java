package org.acme.service;
import java.util.List;

import org.acme.dto.FolhaRequest;
import org.acme.dto.FolhaResponse;
public interface FolhaService {
    public FolhaResponse adicionar(FolhaRequest adicionarFolha);

    public FolhaResponse buscar(Long idFolha);
  public List<FolhaResponse> buscarTodos();
    public FolhaResponse alterar(Long idFolha, FolhaRequest novoFolha);

    public void delete(Long idFolha);}
