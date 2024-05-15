package org.acme.service;

import java.util.List;

import org.acme.dto.EnderecoRequest;
import org.acme.dto.EnderecoResponse;

public interface EnderecoService {
    public EnderecoResponse adicionar(EnderecoRequest adicionarEndereco);

    public EnderecoResponse buscar(Long idEndereco);

    public List<EnderecoResponse> buscarTodos();

    public EnderecoResponse alterar(Long idEndereco, EnderecoRequest novoEndereco);

    public void delete(Long idEndereco);
}
