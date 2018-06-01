/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.InformeAccidenteTransito;
import com.eam.proyecto.DTO.Perjudicados;
import java.util.ArrayList;

/**
 *
 * @author Daryl Ospina
 */
public class InformeAccidenteNegocio extends Negocio<InformeAccidenteTransito>{
    
    public InformeAccidenteNegocio(Class<InformeAccidenteTransito> entityClass) {
        super(entityClass);
    }
    
    public ArrayList<InformeAccidenteTransito> cargarConConsulta(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, InformeAccidenteTransito.class));
    }
    
    public ArrayList<Perjudicados> consultarPerjudicados(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, Perjudicados.class));
    }
}
