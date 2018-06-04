/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.Lugar;
import java.util.ArrayList;

/**
 *
 * @author Daryl Ospina
 */
public class LugarNegocio extends Negocio<Lugar>{
    
    public LugarNegocio(Class<Lugar> entityClass) {
        super(entityClass);
    }
    
    public ArrayList<Lugar> cargarConConsulta(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, Lugar.class));
    }
    
}
