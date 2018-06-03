/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CtlVehiculo extends ControladorAbstracto {

    public DefaultTableModel listarFiltrado(Map<String, String> campos) {
        String[] lista = {"Placa", "Modelo", "Linea", "Marca", "Clase vehiculo", "Tipo vehiculo", "Nacionalidad"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar("Vehiculo/TraerVehiculos/" + this.crearConsultaRegexpLike(campos));
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

    private String crearConsultaRegexpLike(Map<String, String> campos) {
        String consulta = ""
                + "SELECT "
                + "     * "
                + "FROM"
                + "     Vehiculo "
                + "WHERE ";

        ArrayList<String> keys = new ArrayList<>(campos.keySet());

        for (int i = 0; i < keys.size(); i++) {
            consulta += " regexp_like(" + keys.get(i) + ",'" + campos.get(keys.get(i)) + "','i') ";
            if (i != keys.size() - 1) {
                consulta += " OR ";
            }
        }
        try {
            return URLEncoder.encode(consulta, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

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

    public boolean guardarDueño(String placa, String modelo,
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
                empresa = ((JSONObject) (new JSONParser().parse(traerlistar("Empresa/" + Integer.parseInt(empresa_nit)))));
                request.put("empresa_nit", empresa);
                request.put("no_targeta_operacion", no_targeta_operacion);
            }

            request.put("licencia_transito", licencia_transito);
            request.put("clase_vehiculo", clase_vehiculo);
            request.put("marca", marca);
            request.put("lugar_matricula", lugar_matricula);
            request.put("nacionalidad", nacionalidad);
            request.put("color", color);
            request.put("capacidad_carga", capacidad_carga);
            request.put("numero_pasajeros", numero_pasajeros);

            return request.toString();
        } catch (ParseException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

}
