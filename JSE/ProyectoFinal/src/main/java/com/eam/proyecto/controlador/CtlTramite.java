/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Fabian
 */
public class CtlTramite extends ControladorAbstracto {

    @Override
    public DefaultTableModel listar(String entidad) {
        String[] lista = {"id", "descripcion", "fecha", "Marca", "tipo tramite", "Cedula del responsable", "Nombre", "Placa del vehiculo", "Valor"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar(entidad + "/");
            JSONArray tramites = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < tramites.size(); i++) {
                JSONObject tramiteObj = (JSONObject) tramites.get(i);
                modelo.addRow(new Object[]{
                    tramiteObj.get("id").toString(),
                    tramiteObj.get("descripcion").toString(),
                    tramiteObj.get("fecha").toString(),
                    ((JSONObject) (tramiteObj.get("tipoTramiteId"))).get("descripcion").toString(),
                    ((JSONObject) (tramiteObj.get("personaNip"))).get("nip").toString(),
                    ((JSONObject) (tramiteObj.get("tipoTramiteId"))).get("nombre").toString(),
                    ((JSONObject) (tramiteObj.get("vehiculoTramiteId"))).get("placa").toString(),
                    tramiteObj.get("valor").toString()

                });
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return modelo;
    }

    private String crearJson(String descripcion, Date fecha, String persona1, String persona2,
            String tipoTramite, String valor, String placa) {
        try {
            JSONObject request = new JSONObject(), persona1Tr, persona2Tra, tipo, placaVeh;
            request.put("id", numeroRegistros() + "");
            request.put("descripcion", descripcion);
            request.put("fecha", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(fecha)));
            if (!(persona2 == null)) {
                persona2Tra = ((JSONObject) (new JSONParser().parse(traerlistar("Persona/" + persona2))));
                request.put("personaNip", persona2Tra);
            }
            persona1Tr = ((JSONObject) (new JSONParser().parse(traerlistar("Persona/" + persona1))));
            request.put("personaNip", persona1Tr);
            request.put("valor", valor);
            tipo = ((JSONObject) (new JSONParser().parse(traerlistar("TipoTramite/" + tipoTramite))));
            request.put("tipoTramiteId", tipo);
            placaVeh = ((JSONObject) (new JSONParser().parse(traerlistar("Vehiculo/" + placa))));
            request.put("vehiculoTramiteId", tipo);

            return request.toString();
        } catch (ParseException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public Integer numeroRegistros() {
        try {
            String response = this.traerlistar("Tramite/");
            JSONArray histirial = ((JSONArray) (new JSONParser().parse(response)));
            return histirial.size() + 1;
        } catch (ParseException e) {
            return -1;
        }
    }
    
        public boolean guardar(String descripcion, Date fecha, String persona1, String persona2,
            String tipoTramite, String valor, String placa) {

        try {

            return (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                    this.crearJson(descripcion, fecha, persona1, persona2, tipoTramite, valor, placa), "Tramite").readEntity(String.class)))).get("Resultado");

        } catch (ParseException e) {
            return false;
        }
    }

}
