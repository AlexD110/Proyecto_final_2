/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.service;

import com.eam.proyecto.Negocio.EstructuraRestFulNegocio;
import com.eam.proyecto.DTO.Grua;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daryl Ospina
 */
@Path("Grua")
public class ServicioGrua extends EstructuraRestFulNegocio<Grua> {
    
    public ServicioGrua() {
        super(Grua.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response guardar(Grua entity) {
        return super.guardar(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") BigDecimal id, Grua entity) {
        return super.modificar(entity);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response remove(@PathParam("id") BigDecimal id) {
        return super.eliminar(super.buscar(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Grua find(@PathParam("id") BigDecimal id) {
        return super.buscar(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Grua> listar() {
        return super.listar();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Grua> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.buscarRango(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.contar());
    }
    
}
