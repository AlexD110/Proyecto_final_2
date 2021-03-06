/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.service;

import com.eam.proyecto.Negocio.EstructuraRestFulNegocio;
import com.eam.proyecto.DTO.Comparendo;
import com.eam.proyecto.Negocio.ComparendoNegocio;
import com.eam.proyecto.util.Herramientas;
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
@Path("Comparendo")
public class ServicioComparendo extends EstructuraRestFulNegocio<Comparendo> {
    
    private final ComparendoNegocio comparendoNego = new ComparendoNegocio(Comparendo.class);
    
    public ServicioComparendo() {
        super(Comparendo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response guardar(Comparendo entity) {
        return super.guardar(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") BigDecimal id, Comparendo entity) {
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
    public Comparendo find(@PathParam("id") BigDecimal id) {
        return super.buscar(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Comparendo> listar() {
        return super.listar();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Comparendo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.buscarRango(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.contar());
    }
    
    
    //Pagina para codificar-decodificar prueba http://www.convertstring.com/es/EncodeDecode/Base64Decode
    @GET
    @Path("TraerComparendos/{consulta}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response consultar(@PathParam("consulta") String consulta){
        try {
            String consultaDecodificada = URLDecoder.decode(consulta,"UTF-8");
            return Herramientas.construirResponse(
                    this.comparendoNego.transformarComparendosConPreciosEnJson(
                            this.comparendoNego.cargarPrecios(),
                            this.comparendoNego.cargarConConsulta(consultaDecodificada)));
        } catch (Exception ex) {
            System.out.println("[Error] : "+ex);
        }
        return Herramientas.construirResponse("{\"Respuesta\": false}");
    }

}
