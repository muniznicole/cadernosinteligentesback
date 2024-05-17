package org.acme.resource;

import org.acme.dto.UsuarioResquest;
import org.acme.service.UsuarioService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    @POST
    @Transactional
    @RolesAllowed({"Administrador","Cliente"})
    public Response inserir(UsuarioResquest usuarioResquest) {
        return Response.status(201).entity(service.adicionar(usuarioResquest)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Administrador","Cliente"})
    public Response buscar(@PathParam("id") Long id) {
        return Response.ok(service.buscar(id)).build();
    }

    @GET
    @RolesAllowed({"Administrador"})
    public Response buscarTodos() {
        return Response.ok(service.buscarTodos()).build();
    }

    @PUT
    @RolesAllowed({"Administrador","Cliente"})
    @Transactional
    @Path("/{id}")
    public Response alterar(@PathParam("id") Long id, UsuarioResquest novoUsuarioResquest) {
        return Response.ok(service.alterar(id, novoUsuarioResquest)).build();
    }

    @DELETE
    @RolesAllowed({"Administrador","Cliente"})
    @Transactional
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(201).build();
    }
}
