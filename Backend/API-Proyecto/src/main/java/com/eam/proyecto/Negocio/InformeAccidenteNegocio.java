/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.CaracteristicaLugar;
import com.eam.proyecto.DTO.CaracteristicaVia;
import com.eam.proyecto.DTO.InformeAccidenteTransito;
import com.eam.proyecto.DTO.Lugar;
import com.eam.proyecto.DTO.Perjudicados;
import com.eam.proyecto.DTO.Testigos;
import com.eam.proyecto.DTO.VehiculosAfectados;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daryl Ospina
 */
public class InformeAccidenteNegocio extends Negocio<InformeAccidenteTransito> {

    private final CaracteristicasLugarNegocio caracteristicasLugarNego = new CaracteristicasLugarNegocio(CaracteristicaLugar.class);

    private final CaracteristicasViaNegocio caracteristicasViaNego = new CaracteristicasViaNegocio(CaracteristicaVia.class);

    private final LugarNegocio lugarNego = new LugarNegocio(Lugar.class);

    public InformeAccidenteNegocio(Class<InformeAccidenteTransito> entityClass) {
        super(entityClass);
    }

    public ArrayList<InformeAccidenteTransito> cargarConConsulta(String consulta) {
        return new ArrayList<>(this.dao.cargarConsulta(consulta, InformeAccidenteTransito.class));
    }

    public ArrayList<Perjudicados> consultarPerjudicados(String consulta) {
        return new ArrayList<>(this.dao.cargarConsulta(consulta, Perjudicados.class));
    }

    public ArrayList<InformeAccidenteTransito> actualizarListar(String consulta) {

        ArrayList<InformeAccidenteTransito> informes = this.cargarConConsulta(consulta);

        try {
            for (InformeAccidenteTransito informe : informes) {
                informe.setCaracteristicaLugar(this.caracteristicasLugarNego.cargarConConsulta(""
                        + "SELECT "
                        + "     CL.* "
                        + "FROM "
                        + "     CARACTERISTICA_LUGAR CL "
                        + "JOIN "
                        + "     INFORME_ACCIDENTE_TRANSITO IA "
                        + "ON(IA.ID=CL.ID) "
                        + "WHERE "
                        + "     CL.ID=" + informe.getId()).get(0));
                informe.setLugar(this.lugarNego.cargarConConsulta(""
                        + "SELECT "
                        + "     L.* "
                        + "FROM "
                        + "     LUGAR L "
                        + "JOIN "
                        + "     INFORME_ACCIDENTE_TRANSITO IA "
                        + "ON(IA.ID=L.ID) "
                        + "WHERE "
                        + "     L.ID=" + informe.getId()).get(0));
                informe.setCaracteristicaVia(this.caracteristicasViaNego.cargarConConsulta(""
                        + "SELECT "
                        + "     CV.* "
                        + "FROM "
                        + "     CARACTERISTICA_VIA CV "
                        + "JOIN "
                        + "     INFORME_ACCIDENTE_TRANSITO IA "
                        + "ON(IA.ID=CV.ID) "
                        + "WHERE "
                        + "     CV.ID=" + informe.getId()).get(0));
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("[Informacion] : No se ha encontrado nada de las listas excepcion: "+e);
        }
        return informes;
    }

    public List<Testigos> consultarTestigos(String consulta) {
        return new ArrayList<>(this.dao.cargarConsulta(consulta, Testigos.class));
    }

    public List<VehiculosAfectados> consultarVehiculosAfectados(String consulta) {
        return new ArrayList<>(this.dao.cargarConsulta(consulta, VehiculosAfectados.class));
    }
}
