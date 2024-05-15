package org.acme.dto;

import org.acme.model.Endereco;
import org.acme.model.Municipio;

public record EnderecoResponse(
Long id,
UsuarioResponse usuarioid,
Boolean principal,
String logradouro,
String bairro,
String numero,
String complemento,
String cep,
MunicipioResponse municipio
) {
    public static EnderecoResponse valueOf(Endereco endereco){
        return new EnderecoResponse(
            endereco.getId(),
            UsuarioResponse.valueOf(endereco.getUsuarioEndereco()),
            endereco.getPrincipal(),
             endereco.getLogradouro(),
              endereco.getBairro(),
               endereco.getNumero(),
                endereco.getComplemento(),
                 endereco.getCep(),
                 MunicipioResponse.valueOf(endereco.getMunicipio()));
    }
}
