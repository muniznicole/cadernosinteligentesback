
package org.acme.resource;

import org.acme.dto.EstadoResquest;
import org.acme.service.EstadoService;

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
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    EstadoService service;

    @POST
    @RolesAllowed({"Administrador"})
    @Transactional
    public Response inserir(EstadoResquest estadoRequest) {
        return Response.status(201).entity(service.adicionar(estadoRequest)).build();
    }
    
    @GET
    @RolesAllowed({"Administrador"})
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return Response.ok(service.buscar(id)).build();
    }
    
    @GET
    @RolesAllowed({"Administrador","Cliente"})
    public Response buscarTodos (
        @QueryParam("page") @DefaultValue("0") int page,
        @QueryParam("pageSize") @DefaultValue("100") int pageSize ) {
            
            return Response.ok(service.buscarTodos(page, pageSize)).build();
        }
        
        @GET
        @Path("/count")
        @RolesAllowed({"Administrador"})
        public long count(){
            return service.count();
        }
        
        @PUT
        @Transactional
        @RolesAllowed({"Administrador"})
        @Path("/{id}")
        public Response alterar(@PathParam("id") Long id, EstadoResquest novoResquest) {
            return Response.ok(service.alterar(id, novoResquest)).build();
        }
        
        @DELETE
        @Transactional
        @RolesAllowed({"Administrador"})
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(201).build();
    }
}
