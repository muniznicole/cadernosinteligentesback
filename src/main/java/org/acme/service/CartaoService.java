package org.acme.service;

import java.util.List;

import org.acme.dto.CartaoRequest;
import org.acme.dto.CartaoResponse;

public interface CartaoService {

    public CartaoResponse adicionar(CartaoRequest adicionarCartao);

    public CartaoResponse buscar(Long idCartao);

    public List<CartaoResponse> buscarTodos();

    public CartaoResponse alterar(Long idCartao, CartaoRequest novoCartao);

    public void delete(Long idCartao);
}
