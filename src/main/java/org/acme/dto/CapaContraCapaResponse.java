package org.acme.dto;

import org.acme.model.CapaContraCapa;

public record CapaContraCapaResponse(
        Long id,
        String nome,
        String descricao,
        Double precoUnitario,
        Integer estoque) {
    public static CapaContraCapaResponse valueOf(CapaContraCapa capaContraCapa) {
        return new CapaContraCapaResponse(
                capaContraCapa.getId(),
                capaContraCapa.getNome(),
                capaContraCapa.getDescricao(),
                capaContraCapa.getPrecoUnitario(),
                capaContraCapa.getEstoque());
    }
}
