package br.com.larimaia.rest;

import br.com.larimaia.bo.TipoEventoBO;
import br.com.larimaia.entity.TipoEvento;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Lucas on 25/09/2015.
 */
@Path("/tipoevento")
public class TipoEventoResources {
    @Inject
    TipoEventoBO tipoEventoBO;

    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(TipoEvento tipoEvento){
        tipoEventoBO.salvar(tipoEvento);
        return Response.status(200).entity(tipoEvento).build();
    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id){return Response.status(200).entity(tipoEventoBO.editar(id)).build();}

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){tipoEventoBO.remover(id); }

    @GET
    @Path("/listar")
    @Produces("application/json")
    public Response listar(){

        return Response.status(200).entity(tipoEventoBO.listar()).build();
    }

}
