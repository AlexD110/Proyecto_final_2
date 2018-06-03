package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.Vehiculo;
import java.util.ArrayList;

/**
 * @author Daryl Ospina
 */
public class VehiculoNegocio extends Negocio<Vehiculo>{
    
    public VehiculoNegocio(Class<Vehiculo> entityClass) {
        super(entityClass);
    }
    
    public ArrayList<Vehiculo> cargarConConsulta(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, Vehiculo.class));
    }
}
