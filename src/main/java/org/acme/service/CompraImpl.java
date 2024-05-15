package org.acme.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.CartaoResponse;
import org.acme.dto.CompraRequest;
import org.acme.dto.CompraResponse;
import org.acme.model.Compra;
import org.acme.model.ItemCompra;
import org.acme.repository.CompraRepository;
import org.acme.repository.EnderecoRepository;
import org.acme.repository.ItemCompraRepository;
import org.acme.repository.MeioPagamentoRepository;
import org.acme.repository.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CompraImpl implements CompraService {
    LocalDateTime dataEhoraLocal;

    @Inject
    CompraRepository repository;
    @Inject
    EnderecoRepository enderecoRepository;
    @Inject
    UsuarioRepository usuarioRepository;
    @Inject
    MeioPagamentoRepository meioPagamentoRepository;
    @Inject
    ItemCompraRepository itemCompraRepository;

    @Override
    public CompraResponse adicionar(CompraRequest adicionarCompra) {
        Compra compra = new Compra();

        compra.setDatetime(dataEhoraLocal.now());
        compra.setTotalcompra(adicionarCompra.totalcompra());
        compra.setEndereco(enderecoRepository.findById(adicionarCompra.endereco()));
        compra.setUsuario(usuarioRepository.findById(adicionarCompra.usuario()));
        compra.setMeioPagamento(meioPagamentoRepository.findById(adicionarCompra.meioPagamento()));
        List<ItemCompra> listiItemCompras = new ArrayList<>();
        for (int i = 0; i <= adicionarCompra.itemCopras().size(); i++) {
            listiItemCompras.add(itemCompraRepository.findById(adicionarCompra.itemCopras().get(i)));
        }
        compra.setItemCompras(listiItemCompras);

        repository.persist(compra);

        return CompraResponse.valueOf(compra);

    }

    @Override
    public CompraResponse buscar(Long idCompra) {
        Compra buscarCompra = new Compra();

        buscarCompra = repository.findById(idCompra);

        return CompraResponse.valueOf(buscarCompra);
    }

    @Override
    public CompraResponse alterar(Long idCompra, CompraRequest novoCompra) {

        Compra antigoCompra = new Compra();

        antigoCompra = repository.findById(idCompra);

        antigoCompra.setDatetime(dataEhoraLocal.now());
        antigoCompra.setTotalcompra(novoCompra.totalcompra());
        antigoCompra.setEndereco(enderecoRepository.findById(novoCompra.endereco()));
        antigoCompra.setUsuario(usuarioRepository.findById(novoCompra.usuario()));
        antigoCompra.setMeioPagamento(meioPagamentoRepository.findById(novoCompra.meioPagamento()));
        List<ItemCompra> listiItemCompras = new ArrayList<>();
        for (int i = 0; i <= novoCompra.itemCopras().size(); i++) {
            listiItemCompras.add(itemCompraRepository.findById(novoCompra.itemCopras().get(i)));
        }
        antigoCompra.setItemCompras(listiItemCompras);

        return CompraResponse.valueOf(antigoCompra);
    }

    @Override
    public void delete(Long idCompra) {
        repository.delete(repository.findById(idCompra));
    }

    @Override
    public List<CompraResponse> buscarTodos() {
        // Mapear a lista de acessórios para uma lista de respostas de acessório
        List<CompraResponse> listaCompraResponses = repository.findAll().stream().map(compra -> {
            return CompraResponse.valueOf(compra);
        })
                .collect(Collectors.toList());

        // Retornar a lista de respostas de acessório
        return listaCompraResponses;
    }

}
