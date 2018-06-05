/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.CaracteristicaLugar;
import java.util.ArrayList;

/**
 *
 * @author Daryl Ospina
 */
public class CaracteristicasLugarNegocio extends Negocio<CaracteristicaLugar>{
    
    public CaracteristicasLugarNegocio(Class<CaracteristicaLugar> entityClass) {
        super(entityClass);
    }
    
    public ArrayList<CaracteristicaLugar> cargarConConsulta(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, CaracteristicaLugar.class));
    }
    
}
