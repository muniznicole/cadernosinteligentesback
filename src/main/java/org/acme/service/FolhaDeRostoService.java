package org.acme.service;

import java.util.List;

import org.acme.dto.FolhaDeRostoRequest;
import org.acme.dto.FolhaDeRostoResponse;

public interface FolhaDeRostoService {
    public FolhaDeRostoResponse adicionar(FolhaDeRostoRequest adicionarFolhaDeRosto);

    public FolhaDeRostoResponse buscar(Long idFolhaDeRosto);

    public List<FolhaDeRostoResponse> buscarTodos();

    public FolhaDeRostoResponse alterar(Long idFolhaDeRosto, FolhaDeRostoRequest novoFolhaDeRosto);

    public void delete(Long idFolhaDeRosto);
}
