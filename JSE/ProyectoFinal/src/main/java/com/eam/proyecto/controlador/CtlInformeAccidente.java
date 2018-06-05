/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

import com.eam.proyecto.modelo.Render;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daryl Ospina
 */
public class CtlInformeAccidente extends ControladorAbstracto {

    public void listar(JTable tblAccidentes,Map<String,String> campos,String nipAgente) {
        String[] lista = {"ID","Fecha de informe", "Nombre del agente", "N° de heridos", "N° de muertos", "Croquis"};
        tblAccidentes.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String consulta = "InformeAccidente";
            if (campos != null) {
                consulta += "/TraerAccidente/"+this.crearConsultaRegexpLike(campos,nipAgente);
            }
            String response = this.traerlistar(consulta);
            JSONArray personas = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < personas.size(); i++) {
                JSONObject informe = (JSONObject) personas.get(i);
                JLabel lbl;
                try {
                    lbl = new JLabel(cargarImagen(informe));
                } catch (IOException | NullPointerException e) {
                    lbl = new JLabel("No hay croquis");
                }
                modelo.addRow(new Object[]{
                    informe.get("id").toString(),
                    informe.get("fechaHora").toString(),
                    ((JSONObject) (informe.get("agente"))).get("nombreCompleto").toString(),
                    informe.get("numeroHeridos").toString(),
                    informe.get("numeroMuertos").toString(),
                    lbl});
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        tblAccidentes.setModel(modelo);
        tblAccidentes.setRowHeight(60);
    }
    
    private String crearConsultaRegexpLike(Map<String,String> campos,String nipAgente){
        String consulta = ""
                + "SELECT "
                + "     IA.* "
                + "FROM "
                + "     Informe_accidente_transito IA "
                + "JOIN "
                + "     Persona P "
                + "ON(P.Nip=IA.Agente) "
                + "JOIN "
                + "     Caracteristica_Lugar CL "
                + "ON(CL.ID=IA.ID) "
                + "JOIN "
                + "     Caracteristica_Via CV "
                + "ON(CV.ID=IA.ID) "
                + "JOIN "
                + "     Lugar L "
                + "ON(L.ID=IA.ID) "
                + "JOIN "
                + "     MUNICIPIO M "
                + "ON(M.ID=P.MUNICIPIO_ID)"
                + "WHERE ";
        
        campos.put("P.NOMBRE_COMPLETO", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("P.FECHA_NACIMIENTO", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("M.NOMBRE", campos.get("IA.TIPO_GRAVEDAD"));
        
        campos.put("CL.AREA_ID", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CL.SECTOR_ID", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CL.ZONA_ID", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CL.DISENIO_ID", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CL.TIEMPO_ID", campos.get("IA.TIPO_GRAVEDAD"));
        
        campos.put("CV.CARAC_GEOMETRICA_VIA_1", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.CARAC_GEOMETRICA_VIA_2", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.CARAC_GEOMETRICA_VIA_3", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.UTILIZACION", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.CALZADA", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.CARRIL", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.MATERIAL", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.ESTADO", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.CONDICION", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.ILUMINACION", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.DISMINUCION_VISUAL", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.CONTROL_SEMAFORO", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.CONTROL_SENALES", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("CV.CONTROL_DEMARCACION", campos.get("IA.TIPO_GRAVEDAD"));
        
        campos.put("L.COORDENANDA_X", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("L.COORDENADA_Y", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("L.DIRECCION", campos.get("IA.TIPO_GRAVEDAD"));
        campos.put("L.LOCALIDAD_COMUNA", campos.get("IA.TIPO_GRAVEDAD"));
        
        ArrayList<String> keys = new ArrayList<>(campos.keySet());
        
        for (int i = 0; i < keys.size(); i++) {
            consulta += " regexp_like("+keys.get(i)+",'"+campos.get(keys.get(i))+"','i') ";
            if (i != keys.size()-1) {
                consulta += " OR ";
            }
        }
        
        if (nipAgente != null) {
            consulta += " AND P.Nip="+nipAgente;
        }
        
        try {
            return URLEncoder.encode(consulta, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    private ImageIcon cargarImagen(JSONObject informe) throws IOException {
        byte[] bi = Base64.getDecoder().decode(informe.get("croquis").toString());
        BufferedImage image = null;
        InputStream in = new ByteArrayInputStream(bi);
        image = ImageIO.read(in);
        ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
        return imgi;
    }

    public int id() {
        return this.asignarId("InformeAccidente");
    }

    public boolean registrar(Date fechaAccidente,
            String tipoGravedad, String claseAccidente, String choqueCon, String objetoFijo, String areaAccidente, String sectorAccidente,
            String zonaAccidente, String disenioAccidente,
            String tiempo, String coordenadaX, String coordenadaY, String direccionAccidente, String LocalidadComunaAccidente,
            String carac1, String carac2, String carac3, String utilizacion,
            String calzada, String carril, String material, String estado, String condicion, String ilumunacion, String nipAgente,
            String disminucion, String semaforo, String senial,
            String demarcacion, int numHeridos, int numMuertos, int id, File croquis) {
        try {

            boolean bool1, bool2, bool3, bool4, bool5;

            bool1
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                            this.crearJson(fechaAccidente, tipoGravedad, claseAccidente,
                                    choqueCon, objetoFijo, nipAgente, numHeridos, numMuertos, id, null),
                            "InformeAccidente").readEntity(String.class
                            )))).get("Resultado");

            bool2
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                            this.crearJson(coordenadaX, coordenadaY, direccionAccidente, LocalidadComunaAccidente, id),
                            "Lugar").readEntity(String.class
                            )))).get("Resultado");

            bool3
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                            this.crearJson(areaAccidente, sectorAccidente, zonaAccidente, disenioAccidente, tiempo, id),
                            "CaracteristicasLugar").readEntity(String.class
                            )))).get("Resultado");

            bool4
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.registrar(
                            this.crearJson(carac1, carac2, carac3, utilizacion, calzada, carril, material,
                                    estado, condicion, ilumunacion, disminucion, semaforo, senial, demarcacion, id),
                            "CaracteristicasVia").readEntity(String.class
                            )))).get("Resultado");

            bool5
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.modificar(
                            this.crearJson(fechaAccidente, tipoGravedad, claseAccidente,
                                    choqueCon, objetoFijo, nipAgente, numHeridos, numMuertos, id, croquis),
                            "InformeAccidente", id).readEntity(String.class
                            )))).get("Resultado");

            if (!bool1) {
                JOptionPane.showMessageDialog(null, "Hubo un error al guardar el accidente");
            }
            if (!bool2) {
                JOptionPane.showMessageDialog(null, "Hubo un error al guardar el lugar del accidente");
            }
            if (!bool3) {
                JOptionPane.showMessageDialog(null, "Hubo un error al guardar las caracteristicas del lugar");
            }
            if (!bool4) {
                JOptionPane.showMessageDialog(null, "Hubo un error al guardar las caracteristicas de la via");
            }
            if (!bool5) {
                JOptionPane.showMessageDialog(null, "Hubo un error al guardar la imagen");
            }

            return bool1 && bool2 && bool3 && bool4 || bool5;

        } catch (ParseException e) {
            return false;
        }
    }
    public boolean modificar(Date fechaAccidente,
            String tipoGravedad, String claseAccidente, String choqueCon, String objetoFijo, String areaAccidente, String sectorAccidente,
            String zonaAccidente, String disenioAccidente,
            String tiempo, String coordenadaX, String coordenadaY, String direccionAccidente, String LocalidadComunaAccidente,
            String carac1, String carac2, String carac3, String utilizacion,
            String calzada, String carril, String material, String estado, String condicion, String ilumunacion, String nipAgente,
            String disminucion, String semaforo, String senial,
            String demarcacion, int numHeridos, int numMuertos, int id, File croquis) {
        try {

            boolean bool1, bool2, bool3, bool4;

            bool1
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.modificar(
                            this.crearJson(fechaAccidente, tipoGravedad, claseAccidente,
                                    choqueCon, objetoFijo, nipAgente, numHeridos, numMuertos, id, croquis),
                            "InformeAccidente",id).readEntity(String.class
                            )))).get("Resultado");

            bool2
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.modificar(
                            this.crearJson(coordenadaX, coordenadaY, direccionAccidente, LocalidadComunaAccidente, id),
                            "Lugar",id).readEntity(String.class
                            )))).get("Resultado");

            bool3
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.modificar(
                            this.crearJson(areaAccidente, sectorAccidente, zonaAccidente, disenioAccidente, tiempo, id),
                            "CaracteristicasLugar",id).readEntity(String.class
                            )))).get("Resultado");

            bool4
                    = (boolean) ((JSONObject) (new JSONParser().parse(this.modificar(
                            this.crearJson(carac1, carac2, carac3, utilizacion, calzada, carril, material,
                                    estado, condicion, ilumunacion, disminucion, semaforo, senial, demarcacion, id),
                            "CaracteristicasVia",id).readEntity(String.class
                            )))).get("Resultado");

            if (!bool1) {
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar el accidente");
            }
            if (!bool2) {
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar el lugar del accidente");
            }
            if (!bool3) {
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar las caracteristicas del lugar");
            }
            if (!bool4) {
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar las caracteristicas de la via");
            }

            return bool1 && bool2 && bool3 && bool4;

        } catch (ParseException e) {
            return false;
        }
    }

    private String crearJson(String coordenadaX, String coordenadaY, String direccionAccidente, String LocalidadComunaAccidente, int id) {
        try {
            //Lugar
            JSONObject request = new JSONObject();
            if (coordenadaX != null && coordenadaY != null) {
                request.put("coordenadaY", coordenadaY);
                request.put("coordenandaX", coordenadaX);
            }
            request.put("direccion", direccionAccidente);
            request.put("id", id);
            request.put("informeAccidenteTransito", ((JSONObject) (new JSONParser().parse(this.traerlistar("InformeAccidente/" + id)))));
            request.put("localidadComuna", LocalidadComunaAccidente);

            return request.toString();

        } catch (ParseException ex) {
            return null;
        }
    }

    private String crearJson(String carac1, String carac2, String carac3, String utilizacion,
            String calzada, String carril, String material, String estado, String condicion, String ilumunacion,
            String disminucion, String semaforo, String senial,
            String demarcacion, int id) {
        try {
            //Caracteristicas via
            JSONObject request = new JSONObject();
            request.put("calzada", calzada);
            request.put("caracGeometricaVia1", carac1);
            request.put("caracGeometricaVia2", carac2);
            request.put("caracGeometricaVia3", carac3);
            request.put("carril", carril);
            request.put("id", id);
            request.put("informeAccidenteTransito", ((JSONObject) (new JSONParser().parse(this.traerlistar("InformeAccidente/" + id)))));
            if (condicion != null) {
                request.put("condicion", condicion);
            }
            request.put("controlDemarcacion", demarcacion);
            request.put("controlSemaforo", semaforo);
            request.put("controlSenales", senial);
            request.put("disminucionVisual", disminucion);
            request.put("estado", estado);
            request.put("iluminacion", ilumunacion);
            request.put("material", material);
            request.put("utilizacion", utilizacion);

            return request.toString();

        } catch (ParseException ex) {
            return null;
        }
    }

    private String crearJson(String areaAccidente, String sectorAccidente,
            String zonaAccidente, String disenioAccidente,
            String tiempo, int id) {
        try {
            //Caracteristicas Lugar 
            JSONObject request = new JSONObject();
            request.put("areaId", areaAccidente);
            request.put("disenioId", disenioAccidente);
            request.put("id", id);
            request.put("informeAccidenteTransito", ((JSONObject) (new JSONParser().parse(this.traerlistar("InformeAccidente/" + id)))));
            request.put("sectorId", sectorAccidente);
            request.put("tiempoId", tiempo);
            request.put("zonaId", zonaAccidente);

            return request.toString();

        } catch (ParseException ex) {
            return null;
        }
    }

    private String crearJson(Date fechaAccidente,
            String tipoGravedad, String claseAccidente, String choqueCon, String objetoFijo,
            String nipAgente, int numHeridos, int numMuertos, int id, File croquis) {
        try {
            //Informe Accidente
            JSONObject request = new JSONObject();
            request.put("agente", ((JSONObject) (new JSONParser().parse(this.traerlistar("Persona/" + nipAgente)))));
            request.put("choqueCon", choqueCon);
            request.put("claseAccidente", claseAccidente);
            if (croquis != null) {
                byte[] croquisEnBytes = new byte[(int) croquis.length()];
                InputStream input = new FileInputStream(croquis);
                input.read(croquisEnBytes);
                request.put("croquis", Base64.getEncoder().encodeToString(croquisEnBytes));
            }
            request.put("fechaHora", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(fechaAccidente)));
            request.put("id", id);
            request.put("numeroHeridos", numHeridos);
            request.put("numeroMuertos", numMuertos);
            request.put("objetoFijo", objetoFijo);
            request.put("tipoGravedad", tipoGravedad);

            return request.toString();

        } catch (ParseException | FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public DefaultTableModel listar(String entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
