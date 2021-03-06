/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.service;

import com.eam.proyecto.DTO.Comparendo;
import com.eam.proyecto.Negocio.EstructuraRestFulNegocio;
import com.eam.proyecto.DTO.Persona;
import com.eam.proyecto.Negocio.ComparendoNegocio;
import com.eam.proyecto.Negocio.PersonaNegocio;
import com.eam.proyecto.util.Herramientas;
import java.io.UnsupportedEncodingException;
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
@Path("Persona")
public class ServicioPersona extends EstructuraRestFulNegocio<Persona> {
    
    private final ComparendoNegocio comparendoNego = new ComparendoNegocio(Comparendo.class);
    private final PersonaNegocio personaNego = new PersonaNegocio(Persona.class);
    
    public ServicioPersona() {
        super(Persona.class);
    }
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response guardar(Persona entity) {
        return super.guardar(entity);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Persona entity) {
        return super.modificar(entity);
    }
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response remove(@PathParam("id") String id) {
        return super.eliminar(super.buscar(id));
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Persona find(@PathParam("id") String id) {
        return super.buscar(id);
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Persona> listar() {
        return super.listar();
    }
    
    @GET
    @Path("{id}/TraerComparendos")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Comparendo> traerComparendos(@PathParam("id") String id) {
        return this.comparendoNego.cargarConConsulta("SELECT "
                                + "    C.* "
                                + "FROM "
                                + "    Comparendo C "
                                + "WHERE "
                                + "    C.Infractor="+id);
    }
    
    @GET
    @Path("/Agentes")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Persona> traerAgentes() {
        return this.personaNego.cargarConConsulta(""
                + "SELECT "
                + "     P.* "
                + "FROM "
                + "     Persona P "
                + "WHERE "
                + "     P.Placa_Agente IS NOT NULL");
    }
    
    @GET
    @Path("{id}/TraerComparendos/Precios")
    @Produces({MediaType.APPLICATION_JSON})
    public Response traerComparendosConPrecio(@PathParam("id") String id) {
        return Herramientas.construirResponse(
                this.comparendoNego.transformarComparendosConPreciosEnJson(
                        this.comparendoNego.cargarPrecios(),
                        this.comparendoNego.cargarConConsulta("SELECT "
                                + "    C.* "
                                + "FROM "
                                + "    Comparendo C "
                                + "WHERE "
                                + "    C.Infractor="+id)));
    }
    
    @GET
    @Path("TraerPersonas/{consulta}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Persona> listarConConsulta(@PathParam("consulta") String consulta) {
        try {
            String consultaDecodificada = URLDecoder.decode(consulta, "UTF-8");
            return this.personaNego.cargarConConsulta(consultaDecodificada);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("[Error] : fallo al decodificar consulta:"+consulta+" Excepcion:"+ex);
        }
        return super.listar();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Persona> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.buscarRango(new int[]{from, to});
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.contar());
    }
    
}
