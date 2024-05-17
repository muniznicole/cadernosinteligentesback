package org.acme.dto;

import java.util.List;

import org.acme.model.CadernoPersonalizado;
import org.acme.model.Endereco;
import org.acme.model.PerfilUsuario;
import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record UsuarioResquest(

@NotBlank
String nome,
@NotBlank
String login,
@NotBlank
String email,
@NotBlank
String senha,
@NotBlank
String cpf,
@NotBlank
String telefone,
@NotNull
PerfilUsuario perfilUsuario

) {
    
}
