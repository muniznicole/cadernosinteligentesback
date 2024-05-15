package org.acme.resource;

import org.acme.dto.PautaRequest;
import org.acme.service.PautaService;

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

@Path("/pautas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PautaResource {

    @Inject
    PautaService service;

    @POST
    @Transactional
    public Response inserir(PautaRequest pautaRequest) {
        return Response.status(201).entity(service.adicionar(pautaRequest)).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return Response.ok(service.buscar(id)).build();
    }

    @GET
    public Response buscarTodos() {
        return Response.ok(service.buscarTodos()).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response alterar(@PathParam("id") Long id, PautaRequest novoPautaResquest) {
        return Response.ok(service.alterar(id, novoPautaResquest)).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(201).build();
    }
}
