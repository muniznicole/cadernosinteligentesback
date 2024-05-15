package org.acme.service;

import java.util.List;

import org.acme.dto.TemaResponse;
import org.acme.dto.UsuarioResponse;
import org.acme.dto.UsuarioResquest;

public interface UsuarioService {
    public UsuarioResponse adicionar(UsuarioResquest adicionarUsuario);

    public UsuarioResponse buscar(Long idUsuario);

    public List<UsuarioResponse> buscarTodos();

    public UsuarioResponse alterar(Long idUsuario, UsuarioResquest novoUsuario);

    public void delete(Long idPauta);
    UsuarioResponse findByUsernameAndSenha(String login, String senha);
}
