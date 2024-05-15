package org.acme.dto;

import org.acme.model.CampoIdentificacao;

public record CampoIdentificacaoResponse(
   Long id,
   String nomeCampo) {
   public static CampoIdentificacaoResponse valueOf(CampoIdentificacao campoIdentificacao) {
      return new CampoIdentificacaoResponse(
            campoIdentificacao.getId(),
            campoIdentificacao.getNomeCampo());
   }
}
