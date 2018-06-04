/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.CaracteristicaVia;
import java.util.ArrayList;

/**
 *
 * @author Daryl Ospina
 */
public class CaracteristicasViaNegocio extends Negocio<CaracteristicaVia>{
    
    public CaracteristicasViaNegocio(Class<CaracteristicaVia> entityClass) {
        super(entityClass);
    }
    
    public ArrayList<CaracteristicaVia> cargarConConsulta(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, CaracteristicaVia.class));
    }
    
}
