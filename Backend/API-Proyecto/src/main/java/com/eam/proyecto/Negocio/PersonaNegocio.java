/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.Persona;
import java.util.ArrayList;

/**
 *
 * @author Daryl Ospina
 */
public class PersonaNegocio extends Negocio<Persona>{
    
    public PersonaNegocio(Class<Persona> entityClass) {
        super(entityClass);
    }
    
    public ArrayList<Persona> cargarConConsulta(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, Persona.class));
    }
}
