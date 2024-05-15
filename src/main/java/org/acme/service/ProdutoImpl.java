package org.acme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.PautaResponse;
import org.acme.dto.ProdutoRequest;
import org.acme.dto.ProdutoResponse;
import org.acme.model.Acessorio;
import org.acme.model.CadernoPersonalizado;
import org.acme.model.ItemCompra;
import org.acme.model.Produto;
import org.acme.repository.AcessorioRepository;
import org.acme.repository.CadernoPersonalizadoRepository;
import org.acme.repository.ProdutoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProdutoImpl implements ProdutoService {

    @Inject
    ProdutoRepository repository;
    @Inject
    CadernoPersonalizadoRepository cadernoPersonalizadoRepository;
    @Inject
    AcessorioRepository acessorioRepository;

    @Override
    public ProdutoResponse adicionar(ProdutoRequest adicionarProduto) {
        Produto produto = new Produto();
        List<CadernoPersonalizado> listCadernoPersonalizados = new ArrayList<>();
        for (int i = 0; i <= adicionarProduto.cadernoPersonalizado().size(); i++) {
            listCadernoPersonalizados
                    .add(cadernoPersonalizadoRepository.findById(adicionarProduto.cadernoPersonalizado().get(i)));
        }
        produto.setCadernoPersonalizado(listCadernoPersonalizados);

        List<Acessorio> listAcessorios = new ArrayList<>();
        for (int i = 0; i <= adicionarProduto.acessorio().size(); i++) {
            listAcessorios.add(acessorioRepository.findById(adicionarProduto.acessorio().get(i)));
        }
        produto.setAcessorio(listAcessorios);

        repository.persist(produto);

        return ProdutoResponse.valueOf(produto);
    }

    @Override
    public ProdutoResponse buscar(Long idProduto) {
        Produto buscarProduto = new Produto();

        buscarProduto = repository.findById(idProduto);

        return ProdutoResponse.valueOf(buscarProduto);
    }

    @Override
    public ProdutoResponse alterar(Long idProduto, ProdutoRequest novoProduto) {
        Produto antigoProduto = new Produto();

        antigoProduto = repository.findById(idProduto);
        List<CadernoPersonalizado> listCadernoPersonalizados = new ArrayList<>();
        for (int i = 0; i <= novoProduto.cadernoPersonalizado().size(); i++) {
            listCadernoPersonalizados
                    .add(cadernoPersonalizadoRepository.findById(novoProduto.cadernoPersonalizado().get(i)));
        }
        antigoProduto.setCadernoPersonalizado(listCadernoPersonalizados);

        List<Acessorio> listAcessorios = new ArrayList<>();
        for (int i = 0; i <= novoProduto.acessorio().size(); i++) {
            listAcessorios.add(acessorioRepository.findById(novoProduto.acessorio().get(i)));
        }
        antigoProduto.setAcessorio(listAcessorios);
        
        return ProdutoResponse.valueOf(antigoProduto);
    }

    @Override
    public void delete(Long idProduto) {
        repository.delete(repository.findById(idProduto));
    }

    @Override
    public List<ProdutoResponse> buscarTodos() {
        List<ProdutoResponse> listaProdutoResponses = repository.findAll().stream().map(produto -> {
            return ProdutoResponse.valueOf(produto);
        })
                .collect(Collectors.toList());

        // Retornar a lista de respostas de acessório
        return listaProdutoResponses;
    }

}
