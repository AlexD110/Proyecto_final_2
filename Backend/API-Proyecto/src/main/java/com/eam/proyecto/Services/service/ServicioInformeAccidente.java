/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.service;

import com.eam.proyecto.Negocio.EstructuraRestFulNegocio;
import com.eam.proyecto.DTO.InformeAccidenteTransito;
import com.eam.proyecto.Negocio.InformeAccidenteNegocio;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
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
@Path("InformeAccidente")
public class ServicioInformeAccidente extends EstructuraRestFulNegocio<InformeAccidenteTransito> {
    
    private InformeAccidenteNegocio nego = new InformeAccidenteNegocio(InformeAccidenteTransito.class);
    
    public ServicioInformeAccidente() {
        super(InformeAccidenteTransito.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response guardar(InformeAccidenteTransito entity) {
        return super.guardar(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") BigDecimal id, InformeAccidenteTransito entity) {
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
    public InformeAccidenteTransito find(@PathParam("id") BigDecimal id) {
        return super.buscar(id);
    }
    
    @GET
    @Path("TraerAccidente/{consulta}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<InformeAccidenteTransito> buscarInforme(@PathParam("consulta") String consulta) {
        try {
            return nego.cargarConConsulta(URLDecoder.decode(consulta,"UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("[Error] : "+ex);
        }
        return null;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<InformeAccidenteTransito> listar() {
        return super.listar();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<InformeAccidenteTransito> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.buscarRango(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.contar());
    }
    
}
