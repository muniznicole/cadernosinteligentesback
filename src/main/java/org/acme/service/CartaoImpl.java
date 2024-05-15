package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.CapaContraCapaResponse;
import org.acme.dto.CartaoRequest;
import org.acme.dto.CartaoResponse;
import org.acme.model.Cartao;
import org.acme.repository.CartaoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CartaoImpl implements CartaoService {

    @Inject
    CartaoRepository repository;

    @Override
    public CartaoResponse adicionar(CartaoRequest adicionarCartao) {
        Cartao cartao=new Cartao();

        cartao.setTitularCartao(adicionarCartao.titularCartao());
        cartao.setNumeroCartao(adicionarCartao.numeroCartao());
        cartao.setCv(adicionarCartao.cv());
        cartao.setValidade(adicionarCartao.validade());

        repository.persist(cartao);

        return CartaoResponse.valueOf(cartao);
    }

    @Override
    public CartaoResponse buscar(Long idCartao) {
        
        Cartao busCartao = new Cartao();

        busCartao=repository.findById(idCartao);

        return CartaoResponse.valueOf(busCartao);
    }

    @Override
    public CartaoResponse alterar(Long idCartao, CartaoRequest novoCartao) {
        Cartao antigoCartao = new Cartao();

        antigoCartao=repository.findById(idCartao);

        antigoCartao.setTitularCartao(novoCartao.titularCartao());
        antigoCartao.setNumeroCartao(novoCartao.numeroCartao());
        antigoCartao.setCv(novoCartao.cv());
        antigoCartao.setValidade(novoCartao.validade());

        return CartaoResponse.valueOf(antigoCartao);
    }

    @Override
    public void delete(Long idCartao) {

        repository.delete(repository.findById(idCartao));
    }

    @Override
    public List<CartaoResponse> buscarTodos() {
       // Mapear a lista de acessórios para uma lista de respostas de acessório
        List<CartaoResponse> listaCartaoResponses = repository.findAll().stream().map(cartao -> {
                    return CartaoResponse.valueOf(cartao);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaCartaoResponses;
    }
    
}
