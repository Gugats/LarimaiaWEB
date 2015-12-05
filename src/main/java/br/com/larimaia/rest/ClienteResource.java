package br.com.larimaia.rest;

import br.com.larimaia.bo.ClienteBO;
import br.com.larimaia.entity.Cliente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * Created by Usuario on 23/09/2015.
 */
@Path("/cliente")
public class ClienteResource {
    @Inject
    ClienteBO clienteBO;

    private int id;


    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Cliente cliente) {
        clienteBO.salvar(cliente);
        return Response.status(200).entity(cliente).build();
    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id) {
        return Response.status(200).entity(clienteBO.editar(id)).build();
    }

    @GET
    @Path("/lista")
    @Produces("application/json")
    public Response lista(){

        return Response.status(200).entity(clienteBO.listar()).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id) {
        clienteBO.remover(id);
    }


}
