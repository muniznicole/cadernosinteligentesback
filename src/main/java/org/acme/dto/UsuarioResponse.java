package org.acme.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.acme.model.Acessorio;
import org.acme.model.CadernoPersonalizado;
import org.acme.model.Endereco;
import org.acme.model.PerfilUsuario;
import org.acme.model.Usuario;

public record UsuarioResponse(

Long id,
String nome,
String login,
String email,
String senha,
String cpf,
String telefone,
PerfilUsuario perfilUsuario
) {
    public static UsuarioResponse valueOf(Usuario usuario){
    
        return new UsuarioResponse(
            usuario.getId(),
             usuario.getLogin(),
              usuario.getNome(),
               usuario.getEmail(),
                usuario.getSenha(),
                 usuario.getCpf(),
                  usuario.getTelefone(),
                   usuario.getPerfilUsuarioerfilUsuario());
    }
}
