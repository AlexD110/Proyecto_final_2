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

    public DefaultTableModel listarFiltrado(Map<String, String> campos) {
        String[] lista = {"Nombre", "T.Documento", "N°documento", "Municipio", "Direccion", "EPS", "Telefono"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar("Persona/TraerPersonas/" + this.crearConsultaRegexpLike(campos));
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

    private String crearConsultaRegexpLike(Map<String, String> campos) {
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

            return (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                    this.crearJson(nombreCompleto, direccion, fechaN,
                            numeroPlaca, eps, tipoDocId, numeroDoc,
                            telefono, municipioId), "Persona").readEntity(String.class)))).get("Resultado");

        } catch (ParseException e) {
            return false;
        }
    }

    public boolean modificar(String nombreCompleto, String direccion,
            Date fechaN, String numeroPlaca, String eps, int tipoDocId,
            String numeroDoc, String telefono, int municipioId) {

        try {

            return (boolean) ((JSONObject) (new JSONParser().parse(
                    modificar(this.crearJson(nombreCompleto, direccion,
                            fechaN, numeroPlaca, eps, tipoDocId, numeroDoc,
                            telefono, municipioId), "Persona", numeroDoc).readEntity(String.class)))).get("Resultado");

        } catch (ParseException e) {
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
        } catch (ParseException | NumberFormatException ex) {
            return null;
        }
    }

    //Metodos añadidos
    public boolean guardarPerjudicado(String nipPersona, String tipoPerjudicado, String sexo, String tipoGravedad, String condicioon,
            char cinturon, char casco, int idVehiculoAfectado) {

        try {

            return (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                    this.crearJson(nipPersona, tipoPerjudicado, sexo, tipoGravedad,
                            condicioon, cinturon, casco, idVehiculoAfectado),
                    "Perjudicados").readEntity(String.class)))).get("Resultado");

        } catch (ParseException e) {
            return false;
        }
    }
    
    public DefaultTableModel listarPerjudicados(int idVehiculoAfectado) {
        String[] lista = {"Nombre", "T.Documento", "N°documento", "Municipio", "Direccion", "EPS","Gravedad"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar("Perjudicados/Informe/"+idVehiculoAfectado);
            JSONArray personas = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < personas.size(); i++) {
                JSONObject perjudicado = (JSONObject) personas.get(i);
                JSONObject persona = (JSONObject) perjudicado.get("personaNip");
                modelo.addRow(new Object[]{
                    persona.get("nombreCompleto").toString(),
                    ((JSONObject) (persona.get("tipoDocumento"))).get("nombre").toString(),
                    persona.get("nip").toString(),
                    ((JSONObject) (persona.get("municipioId"))).get("nombre").toString(),
                    persona.get("direccion").toString(),
                    persona.get("eps").toString(),
                    perjudicado.get("gravedad").toString()
                });
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return modelo;
    }
    

    private String crearJson(String nipPersona, String tipoPerjudicado, String sexo, String tipoGravedad, String condicioon,
            char cinturon, char casco, int idVehiculoAfectado) {
        try {
            JSONObject request = new JSONObject(), tipoDocumento, persona;
            request.put("casco", casco+"");
            request.put("cinturon", cinturon+"");
            request.put("condicion", condicioon);
            request.put("gravedad", tipoGravedad);
            request.put("id", this.asignarId("Perjudicados"));
            persona = ((JSONObject) (new JSONParser().parse(traerlistar("Persona/" + nipPersona))));
            request.put("personaNip", persona);
            request.put("sexo", sexo);
            request.put("tipoPerjudicado", tipoPerjudicado);
            tipoDocumento = ((JSONObject) (new JSONParser().parse(traerlistar("VehiculosAfectados/" + idVehiculoAfectado))));
            request.put("vehiculosAfectadosId", tipoDocumento);

            return request.toString();
        } catch (ParseException | NumberFormatException ex) {
            return null;
        }
    }
    
    public boolean guardarTestigo(int idInforme,String nipPersona,String testimonio) {

        try {

            return (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                    this.crearJson(idInforme, nipPersona, testimonio),
                    "Testigo").readEntity(String.class)))).get("Resultado");

        } catch (ParseException e) {
            return false;
        }
    }
    
    public DefaultTableModel listarTestigos(int idInforme) {
        String[] lista = {"Nombre", "T.Documento", "N°documento", "Municipio", "Direccion", "EPS","Testimonio"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar("Testigo/Informe/"+idInforme);
            JSONArray personas = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < personas.size(); i++) {
                JSONObject testigo = (JSONObject) personas.get(i);
                JSONObject persona = (JSONObject) testigo.get("personaNip");
                modelo.addRow(new Object[]{
                    persona.get("nombreCompleto").toString(),
                    ((JSONObject) (persona.get("tipoDocumento"))).get("nombre").toString(),
                    persona.get("nip").toString(),
                    ((JSONObject) (persona.get("municipioId"))).get("nombre").toString(),
                    persona.get("direccion").toString(),
                    persona.get("eps").toString(),
                    testigo.get("testimonio").toString()
                });
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return modelo;
    }
    
    private String crearJson(int idInforme,String nipPersona,String testimonio) {
        try {
            JSONObject request = new JSONObject(), informeAccidente, persona;
            request.put("id", this.asignarId("Testigo"));
            persona = ((JSONObject) (new JSONParser().parse(traerlistar("Persona/" + nipPersona))));
            request.put("personaNip", persona);
            request.put("testimonio", testimonio);
            informeAccidente = ((JSONObject) (new JSONParser().parse(traerlistar("InformeAccidente/" + idInforme))));
            request.put("informeAccidenteTransitoId", informeAccidente);

            return request.toString();
        } catch (ParseException | NumberFormatException ex) {
            return null;
        }
    }
}
