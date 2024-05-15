package org.acme.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.acme.model.Compra;

public record CompraResponse(
        Long id,
        LocalDateTime dateTime,
        Double totalcompra,
        EnderecoResponse endereco,
        UsuarioResponse usuario,
        MeioPagamentoResponse meioPagamento,
        List<ItemCompraResponse> itemCompras) {
    public static CompraResponse valueOf(Compra compra) {
        List<ItemCompraResponse> listaItemCompraResponse = compra.getItemCompras().stream().map(itemCompra -> {
                    return ItemCompraResponse.valueOf(itemCompra);
                })
                .collect(Collectors.toList());
        return new CompraResponse(
                compra.getId(),
                compra.getDatetime(),
                compra.getTotalcompra(),
                EnderecoResponse.valueOf(compra.getEndereco()),
                UsuarioResponse.valueOf( compra.getUsuario()),
                 MeioPagamentoResponse.valueOf(compra.getMeioPagamento()),
                listaItemCompraResponse);
    }
}
