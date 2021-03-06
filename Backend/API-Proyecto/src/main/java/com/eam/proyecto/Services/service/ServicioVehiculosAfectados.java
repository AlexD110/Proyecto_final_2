/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.service;

import com.eam.proyecto.DTO.InformeAccidenteTransito;
import com.eam.proyecto.Negocio.EstructuraRestFulNegocio;
import com.eam.proyecto.DTO.VehiculosAfectados;
import com.eam.proyecto.Negocio.InformeAccidenteNegocio;
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
@Path("VehiculosAfectados")
public class ServicioVehiculosAfectados extends EstructuraRestFulNegocio<VehiculosAfectados> {
    
    private final InformeAccidenteNegocio nego = new InformeAccidenteNegocio(InformeAccidenteTransito.class);
    
    public ServicioVehiculosAfectados() {
        super(VehiculosAfectados.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response guardar(VehiculosAfectados entity) {
        return super.guardar(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") BigDecimal id, VehiculosAfectados entity) {
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
    public VehiculosAfectados find(@PathParam("id") BigDecimal id) {
        return super.buscar(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<VehiculosAfectados> listar() {
        return super.listar();
    }
    
    @GET
    @Path("Informe/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<VehiculosAfectados> listar(@PathParam("id") BigDecimal id) {
        return this.nego.consultarVehiculosAfectados(""
                + "SELECT "
                + "     VF.* "
                + "FROM "
                + "     Vehiculos_Afectados VF "
                + "JOIN "
                + "     Informe_Accidente_Transito IA "
                + "ON(IA.ID=VF.Informe_Accidente_Transito_Id) "
                + "WHERE "
                + "     IA.ID="+id.intValue());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<VehiculosAfectados> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.buscarRango(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.contar());
    }
    
}
