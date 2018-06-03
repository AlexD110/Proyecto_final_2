package com.eam.proyecto.controlador;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Daryl Ospina
 */
public class CtlPersona extends ControladorAbstracto {
    
    public DefaultTableModel listarFiltrado(Map<String,String> campos) {
        String[] lista = {"Nombre", "T.Documento", "N°documento", "Municipio", "Direccion", "EPS", "Telefono"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar("Persona/TraerPersonas/"+this.crearConsultaRegexpLike(campos));
            JSONArray personas = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < personas.size(); i++) {
                JSONObject persona = (JSONObject) personas.get(i);
                modelo.addRow(new Object[]{
                    persona.get("nombreCompleto").toString(),
                    ((JSONObject) (persona.get("tipoDocumento"))).get("nombre").toString(),
                    persona.get("nip").toString(),
                    ((JSONObject) (persona.get("municipioId"))).get("nombre").toString(),
                    persona.get("direccion").toString(),
                    persona.get("eps").toString(),
                    persona.get("telefono")
                });
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return modelo;
    }
    
    private String crearConsultaRegexpLike(Map<String,String> campos){
        String consulta = ""
                + "SELECT "
                + "     P.* "
                + "FROM"
                + "     Persona P "
                + "JOIN "
                + "     Municipio M "
                + "ON(M.Id=P.Municipio_Id) "
                + "JOIN"
                + "    Tipo_Documento TP "
                + "ON(Tp.Id=P.Tipo_Documento) "
                + "WHERE ";
        
        campos.put("TP.Nombre", campos.get("Eps"));
        campos.put("M.Nombre", campos.get("Eps"));
        
        ArrayList<String> keys = new ArrayList<>(campos.keySet());
        
        for (int i = 0; i < keys.size(); i++) {
            consulta += " regexp_like("+keys.get(i)+",'"+campos.get(keys.get(i))+"','i') ";
            if (i != keys.size()-1) {
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
        String[] lista = {"Nombre", "T.Documento", "N°documento", "Municipio", "Direccion", "EPS", "Telefono"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar(entidad + "/");
            JSONArray personas = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < personas.size(); i++) {
                JSONObject persona = (JSONObject) personas.get(i);
                modelo.addRow(new Object[]{
                    persona.get("nombreCompleto").toString(),
                    ((JSONObject) (persona.get("tipoDocumento"))).get("nombre").toString(),
                    persona.get("nip").toString(),
                    ((JSONObject) (persona.get("municipioId"))).get("nombre").toString(),
                    persona.get("direccion").toString(),
                    persona.get("eps").toString(),
                    persona.get("telefono")
                });
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return modelo;
    }

    public boolean guardar(String nombreCompleto, String direccion,
            Date fechaN, String numeroPlaca, String eps, int tipoDocId,
            String numeroDoc, String telefono, int municipioId) {

        try {

            return (boolean) ((JSONObject) 
                    (new JSONParser().parse(this.registrar(
                            this.crearJson(nombreCompleto, direccion, fechaN,
                                    numeroPlaca, eps, tipoDocId, numeroDoc, 
                                    telefono, municipioId), "Persona").readEntity(String.class)))).get("Resultado");

        }catch (ParseException e) {
            return false;
        }
    }

    public boolean modificar(String nombreCompleto, String direccion,
            Date fechaN, String numeroPlaca, String eps, int tipoDocId,
            String numeroDoc, String telefono, int municipioId) {

        try {

            return (boolean) ((JSONObject) 
                    (new JSONParser().parse(
                            modificar(this.crearJson(nombreCompleto, direccion,
                                    fechaN, numeroPlaca, eps, tipoDocId, numeroDoc,
                                    telefono, municipioId), "Persona" ,numeroDoc).readEntity(String.class)))).get("Resultado");

        }catch (ParseException e) {
            return false;
        }
    }

    private String crearJson(String nombreCompleto, String direccion,
            Date fechaN, String numeroPlaca, String eps, int tipoDocId,
            String numeroDoc, String telefono, int municipioId) {
        try {
            JSONObject request = new JSONObject(), tipoDocumento, municipio;
            request.put("direccion", direccion);
            request.put("eps", eps);
            request.put("fechaNacimiento", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(fechaN)));
            if (numeroPlaca != null) {
                request.put("placaAgente", Integer.parseInt(numeroPlaca));
            }   
            municipio = ((JSONObject) (new JSONParser().parse(traerlistar("Municipio/" + municipioId))));
            request.put("municipioId", municipio);
            request.put("nip", numeroDoc);
            request.put("nombreCompleto", nombreCompleto);
            request.put("telefono", telefono);
            tipoDocumento = ((JSONObject) (new JSONParser().parse(traerlistar("TipoDocumento/" + tipoDocId))));
            request.put("tipoDocumento", tipoDocumento);
            
            return request.toString();
        } catch (ParseException ex) {
            return null;
        }catch(Exception ex){
            return null;
        }
    }
}
