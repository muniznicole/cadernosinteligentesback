package org.acme.resource;
import org.acme.dto.ProdutoRequest;
import org.acme.service.ProdutoService;

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

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoService service;

    @POST
    @RolesAllowed({"Administrador"})
    @Transactional
    public Response inserir(ProdutoRequest produtoRequest) {
        return Response.status(201).entity(service.adicionar(produtoRequest)).build();
    }
    
    @GET
    @RolesAllowed({"Administrador"})
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return Response.ok(service.buscar(id)).build();
    }
    
    @GET
    @RolesAllowed({"Administrador","Cliente"})
    public Response buscarTodos() {
        return Response.ok(service.buscarTodos()).build();
    }
    
    @PUT
    @RolesAllowed({"Administrador"})
    @Transactional
    @Path("/{id}")
    public Response alterar(@PathParam("id") Long id, ProdutoRequest novoProdutoResquest) {
        return Response.ok(service.alterar(id, novoProdutoResquest)).build();
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
