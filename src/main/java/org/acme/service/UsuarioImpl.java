package org.acme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.TemaResponse;
import org.acme.dto.UsuarioResponse;
import org.acme.dto.UsuarioResquest;
import org.acme.model.Acessorio;
import org.acme.model.CadernoPersonalizado;
import org.acme.model.Endereco;
import org.acme.model.Usuario;
import org.acme.repository.CadernoPersonalizadoRepository;
import org.acme.repository.EnderecoRepository;
import org.acme.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioImpl implements UsuarioService {

    @Inject
    UsuarioRepository repository;
    @Inject
    EnderecoRepository enderecoRepository;
    @Inject
    CadernoPersonalizadoRepository cadernoPersonalizadoRepository;

    @Override
    public UsuarioResponse adicionar(UsuarioResquest adicionarUsuario) {
        Usuario usuario = new Usuario();

        usuario.setNome(adicionarUsuario.nome());
        usuario.setNome(adicionarUsuario.login());
        usuario.setEmail(adicionarUsuario.email());
        usuario.setSenha(adicionarUsuario.senha());
        usuario.setCpf(adicionarUsuario.cpf());
        usuario.setTelefone(adicionarUsuario.telefone());
        usuario.setPerfilUsuarioerfilUsuario(adicionarUsuario.perfilUsuario());

        repository.persist(usuario);

        return UsuarioResponse.valueOf(usuario);
    }

    @Override
    public UsuarioResponse buscar(Long idUsuario) {
        Usuario buscarUsuario = new Usuario();

        buscarUsuario = repository.findById(idUsuario);

        return UsuarioResponse.valueOf(buscarUsuario);
    }

    @Override
    public UsuarioResponse alterar(Long idUsuario, UsuarioResquest novoUsuario) {
        Usuario antigoUsuario = new Usuario();

        antigoUsuario = repository.findById(idUsuario);
        
        antigoUsuario.setNome(novoUsuario.nome());
        antigoUsuario.setNome(novoUsuario.login());
        antigoUsuario.setEmail(novoUsuario.email());
        antigoUsuario.setSenha(novoUsuario.senha());
        antigoUsuario.setCpf(novoUsuario.cpf());
        antigoUsuario.setTelefone(novoUsuario.telefone());
        antigoUsuario.setPerfilUsuarioerfilUsuario(novoUsuario.perfilUsuario());

        return UsuarioResponse.valueOf(antigoUsuario);
    }

    @Override
    public void delete(Long idPauta) {
        repository.delete(repository.findById(idPauta));
    }

    @Override
    public List<UsuarioResponse> buscarTodos() {
        List<UsuarioResponse> listaUsuarioResponses = repository.findAll().stream().map(usuario -> {
            return UsuarioResponse.valueOf(usuario);
        })
                .collect(Collectors.toList());

        // Retornar a lista de respostas de acessório
        return listaUsuarioResponses;
    }

    @Override
    public UsuarioResponse findByUsernameAndSenha(String login, String senha) {
        Usuario usuario = repository.findByUsernameAndSenha(login, senha).firstResult();

    //    if (usuario == null)
      //      throw new ValidationException(username, "Username ou senha inválido");
        return UsuarioResponse.valueOf(usuario);
    }
    

}
