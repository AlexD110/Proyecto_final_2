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

public class CtlVehiculo extends ControladorAbstracto {

    @Override
    public DefaultTableModel listar(String entidad) {
        String[] lista = {"Placa", "Modelo", "Linea", "Marca", "Clase vehiculo", "Tipo vehiculo", "Nacionalidad"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar(entidad + "/");
            JSONArray vehiculos = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < vehiculos.size(); i++) {
                JSONObject vehisulo2 = (JSONObject) vehiculos.get(i);
                modelo.addRow(new Object[]{
                    vehisulo2.get("placa").toString(),
                    vehisulo2.get("modelo").toString(),
                    vehisulo2.get("linea").toString(),
                    vehisulo2.get("marca").toString(),
                    vehisulo2.get("claseVehiculo").toString(),
                    vehisulo2.get("tipoVehiculo").toString(),
                    vehisulo2.get("nacionalidad").toString()

                });
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return modelo;
    }

    public Integer numeroRegistros() {
        try {
            String response = this.traerlistar("HistorialDuenio/");
            JSONArray histirial = ((JSONArray) (new JSONParser().parse(response)));
            return histirial.size() + 1;
        } catch (ParseException e) {
            return -1;
        }
    }

    public boolean guardar(String placa, String modelo,
            String linea, String marca, String licencia_transito, String clase_vehiculo,
            String tipo_vehiculo, String lugar_matricula, String nacionalidad, String color,
            String empresa_nit, int capacidad_carga, int numero_pasajeros, int no_targeta_operacion) {

        try {

            return (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                    this.crearJson(placa, modelo, linea, marca, licencia_transito, clase_vehiculo,
                            tipo_vehiculo, lugar_matricula, nacionalidad, color,
                            empresa_nit, capacidad_carga, numero_pasajeros, no_targeta_operacion), "Vehiculo").readEntity(String.class)))).get("Resultado");

        } catch (ParseException e) {
            return false;
        }
    }

    public boolean modificar(String placa, String modelo,
            String linea, String marca, String licencia_transito, String clase_vehiculo,
            String tipo_vehiculo, String lugar_matricula, String nacionalidad, String color,
            String empresa_nit, int capacidad_carga, int numero_pasajeros, int no_targeta_operacion) {

        try {

            return (boolean) ((JSONObject) (new JSONParser().parse(
                    modificar(this.crearJson(placa, modelo, linea, marca, licencia_transito, clase_vehiculo,
                            tipo_vehiculo, lugar_matricula, nacionalidad, color,
                            empresa_nit, capacidad_carga, numero_pasajeros, no_targeta_operacion), "Vehiculo", placa).readEntity(String.class)))).get("Resultado");

        } catch (ParseException e) {
            return false;
        }
    }

    public boolean guardarDueño(String id, String placa, String nip, Date fecha) {

        try {

            return (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                    this.crearJsonDueño(id, placa, nip, fecha), "HistorialDuenio").readEntity(String.class)))).get("Resultado");

        } catch (ParseException e) {
            return false;
        }
    }

    public String propietarioVehiculoActual(String placa) throws ParseException {
        String response = this.traerlistar("HistorialDuenio/");
        JSONArray historial = ((JSONArray) (new JSONParser().parse(response)));
        String id = "";
        int cont =0;
        
        for (int i = 0; i < historial.size(); i++) {
            JSONObject historialOb = (JSONObject) historial.get(i);
            if (((JSONObject)(historialOb.get("vehiculoPlaca"))).get("placa").toString().equalsIgnoreCase(placa) 
                    && Integer.parseInt(historialOb.get("id").toString())>cont) {            
                cont=Integer.parseInt(historialOb.get("id").toString());
                id =(historialOb.get("id").toString());
            }

        }
        return id;
    }

    private String crearJson(String placa, String modelo,
            String linea, String marca, String licencia_transito, String clase_vehiculo,
            String tipo_vehiculo, String lugar_matricula, String nacionalidad, String color,
            String empresa_nit, int capacidad_carga, int numero_pasajeros, int no_targeta_operacion) {
        try {
            JSONObject request = new JSONObject(), empresa;
            request.put("placa", placa);
            request.put("modelo", modelo);
            request.put("linea", linea);
            if (!(empresa_nit == null)) {
                empresa = ((JSONObject) (new JSONParser().parse(traerlistar("Empresa/" + empresa_nit))));
                request.put("empresaNit", empresa);
                request.put("noTargetaOperacion", no_targeta_operacion);
            }
            request.put("tipoVehiculo", tipo_vehiculo);
            request.put("licenciaTransito", licencia_transito);
            request.put("claseVehiculo", clase_vehiculo);
            request.put("marca", marca);
            request.put("lugarMatricula", lugar_matricula);
            request.put("nacionalidad", nacionalidad);
            request.put("color", color);
            request.put("capacidadCarga", capacidad_carga);
            request.put("numeroPasajeros", numero_pasajeros);

            return request.toString();
        } catch (ParseException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    private String crearJsonDueño(String id, String placa, String nip, Date fecha) throws ParseException {
        JSONObject request = new JSONObject(), persona, placaJason;
        request.put("id", numeroRegistros());
        request.put("fecha", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(fecha)));
        persona = ((JSONObject) (new JSONParser().parse(traerlistar("Persona/" + nip))));
        request.put("personaNip", persona);
        placaJason = ((JSONObject) (new JSONParser().parse(traerlistar("Vehiculo/" + placa))));
        request.put("vehiculoPlaca", placaJason);

        return request.toString();
    }

}
