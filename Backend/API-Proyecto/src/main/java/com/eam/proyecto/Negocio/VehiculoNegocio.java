
package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.Vehiculo;
import java.util.ArrayList;


public class VehiculoNegocio extends Negocio<Vehiculo> {

    public VehiculoNegocio(Class<Vehiculo> entityClass) {
        super(entityClass);
    }

    public ArrayList<Object[]> cargarDueño(String placa) {
        String consulta = "select * from HISTORIAL_DUENO WHERE  VEHICULO_PLACA ='"+placa+"' AND ROWNUM =1\n"
                + "ORDER BY ID DESC ;";

        return new ArrayList(this.dao.cargarConsulta(consulta, null));
    }

    
    public ArrayList<Vehiculo> cargarConConsulta(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, Vehiculo.class));
    }

}
