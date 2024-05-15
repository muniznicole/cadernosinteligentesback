package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.MeioPagamentoRequest;
import org.acme.dto.MeioPagamentoResponse;
import org.acme.model.MeioPagamento;
import org.acme.repository.CartaoRepository;
import org.acme.repository.MeioPagamentoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MeioPagamentoImpl implements MeioPagamentoService {

    @Inject
    MeioPagamentoRepository repository;
    @Inject
    CartaoRepository cartaoRepository;

    @Override
    public MeioPagamentoResponse adicionar(MeioPagamentoRequest adicionarMeioPagamento) {
        MeioPagamento meioPagamento = new MeioPagamento();

        meioPagamento.setMeioPagamento(adicionarMeioPagamento.meioPagamento());
        meioPagamento.setCartao(cartaoRepository.findById(adicionarMeioPagamento.cartao()));

        repository.persist(meioPagamento);

        return MeioPagamentoResponse.valueOf(meioPagamento);
    }

    @Override
    public MeioPagamentoResponse buscar(Long idMeioPagamento) {

        MeioPagamento buscarMeioPagamento = new MeioPagamento();

        buscarMeioPagamento = repository.findById(idMeioPagamento);

        return MeioPagamentoResponse.valueOf(buscarMeioPagamento);
    }

    @Override
    public MeioPagamentoResponse alterar(Long idMeioPagamento, MeioPagamentoRequest novoMeioPagamento) {
        MeioPagamento antigoMeioPagamento = new MeioPagamento();

        antigoMeioPagamento = repository.findById(idMeioPagamento);

        antigoMeioPagamento.setMeioPagamento(novoMeioPagamento.meioPagamento());
        antigoMeioPagamento.setCartao(cartaoRepository.findById(novoMeioPagamento.cartao()));

        return MeioPagamentoResponse.valueOf(antigoMeioPagamento);
    }

    @Override
    public void delete(Long idMeioPagamento) {
    repository.delete(repository.findById(idMeioPagamento));  
    }

    @Override
    public List<MeioPagamentoResponse> buscarTodos() {
       List<MeioPagamentoResponse> listaMeioPagamentoResponses = repository.findAll().stream().map(meioPagamento -> {
                    return MeioPagamentoResponse.valueOf(meioPagamento);
                })
                .collect(Collectors.toList());
    
        // Retornar a lista de respostas de acessório
        return listaMeioPagamentoResponses;
    }

}
