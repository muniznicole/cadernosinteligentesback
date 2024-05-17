package org.acme.resource;
import org.acme.dto.TemaRequest;
import org.acme.service.TemaService;

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

@Path("/temas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TemaResource {

    @Inject
    TemaService service;

    @POST
    @RolesAllowed({"Administrador"})
    @Transactional
    public Response inserir(TemaRequest temaRequest) {
        return Response.status(201).entity(service.adicionar(temaRequest)).build();
    }

    @GET
    @RolesAllowed({"Administrador"})
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return Response.ok(service.buscar(id)).build();
    }

    @GET
    @RolesAllowed({"Administrador"})
    public Response buscarTodos() {
        return Response.ok(service.buscarTodos()).build();
    }

    @PUT
    @RolesAllowed({"Administrador"})
    @Transactional
    @Path("/{id}")
    public Response alterar(@PathParam("id") Long id, TemaRequest novoTemaResquest) {
        return Response.ok(service.alterar(id, novoTemaResquest)).build();
    }

    @DELETE
    @RolesAllowed({"Administrador"})
    @Transactional
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(201).build();
    }
}
