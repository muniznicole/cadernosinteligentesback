package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.FolhaDeRostoResponse;
import org.acme.dto.ItemCompraRequest;
import org.acme.dto.ItemCompraResponse;
import org.acme.model.ItemCompra;
import org.acme.repository.ItemCompraRepository;
import org.acme.repository.ProdutoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ItemCompraImpl implements ItemCompraService {

    @Inject
    ItemCompraRepository repository;
    @Inject
    ProdutoRepository produtoRepository;

    @Override
    public ItemCompraResponse adicionar(ItemCompraRequest adicionarItemCompra) {
        ItemCompra itemCompra = new ItemCompra();

        itemCompra.setQuantidade(adicionarItemCompra.quantidade());
        itemCompra.setPreco(adicionarItemCompra.preco());
        itemCompra.setProduto(produtoRepository.findById(adicionarItemCompra.produto()));

        repository.persist(itemCompra);

        return ItemCompraResponse.valueOf(itemCompra);

    }

    @Override
    public ItemCompraResponse buscar(Long idItemCompra) {
        ItemCompra buscarItemCompra = new ItemCompra();

        buscarItemCompra = repository.findById(idItemCompra);

        return ItemCompraResponse.valueOf(buscarItemCompra);

    }

    @Override
    public ItemCompraResponse alterar(Long idItemCompra, ItemCompraRequest novoItemCompra) {
        ItemCompra antigoItemCompra = new ItemCompra();

        antigoItemCompra = repository.findById(idItemCompra);

        antigoItemCompra.setQuantidade(novoItemCompra.quantidade());
        antigoItemCompra.setPreco(novoItemCompra.preco());
        antigoItemCompra.setProduto(produtoRepository.findById(novoItemCompra.produto()));

        return ItemCompraResponse.valueOf(antigoItemCompra);
    }

    @Override
    public void delete(Long idItemCompra) {
        repository.delete(repository.findById(idItemCompra));
    }

    @Override
    public List<ItemCompraResponse> buscarTodos() {
       List<ItemCompraResponse> listaItemCompraResponses = repository.findAll().stream().map(itemCompra -> {
                    return ItemCompraResponse.valueOf(itemCompra);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaItemCompraResponses;
    }

}
