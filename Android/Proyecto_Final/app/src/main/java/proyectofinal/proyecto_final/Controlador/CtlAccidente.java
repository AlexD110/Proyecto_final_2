package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import proyectofinal.proyecto_final.Activities.Accidente.RegistroVehiculoAccidente;

public class CtlAccidente extends Cliente {
    private Activity activity;
    private Map<Integer,String> comparendos;

    public CtlAccidente(Activity activity){
        this.activity = activity;
    }

    public void registrar(Date fechaAccidente,
                          String tipoGravedad, String claseAccidente, String choqueCon, String objetoFijo, String areaAccidente, String sectorAccidente,
                          String zonaAccidente, String disenioAccidente,
                          String tiempo, String coordenadaX, String coordenadaY, String direccionAccidente, String LocalidadComunaAccidente,
                          String carac1, String carac2, String carac3, String utilizacion,
                          String calzada, String carril, String material, String estado, String condicion, String ilumunacion, String nipAgente,
                          String disminucion, String semaforo, String senial,
                          String demarcacion, int numHeridos, int numMuertos){
        try {
            //Accidente
            JSONObject request = new JSONObject(),agente = new JSONObject();

            int id = this.asignarId("InformeAccidente");

            request.put("choqueCon", choqueCon);
            request.put("fechaHora", (new SimpleDateFormat("yyyy-MM-dd").format(fechaAccidente))+"T00:00:00-05:00");
            request.put("id", id);
            request.put("numeroHeridos", numHeridos);
            request.put("numeroMuertos", numMuertos);
            request.put("objetoFijo", objetoFijo);
            agente = this.traerBD("Persona",nipAgente);
            request.put("agente", agente);
            request.put("tipoGravedad", tipoGravedad);
            request.put("claseAccidente", claseAccidente);

            this.registrar("El InformeAccidente",request,activity,false);

            //Caracteristicas lugar
            request = new JSONObject();
            JSONObject informe = this.traerBD("InformeAccidente",id);

            request.put("areaId", areaAccidente);
            request.put("disenioId", disenioAccidente);
            request.put("id", id);
            request.put("sectorId", sectorAccidente);
            request.put("tiempoId", tiempo);
            request.put("zonaId", zonaAccidente);
            request.put("informeAccidenteTransito", informe);

            this.registrar("Las CaracteristicasLugar",request,activity,true);

            //Lugar
            request = new JSONObject();
            if (coordenadaX != null && coordenadaY != null) {
                request.put("coordenadaY", coordenadaY);
                request.put("coordenandaX", coordenadaX);
            }
            request.put("direccion", direccionAccidente);
            request.put("id", id);
            request.put("informeAccidenteTransito", informe);
            request.put("localidadComuna", LocalidadComunaAccidente);

            this.registrar("El Lugar",request,activity,true);

            //Caracteristicas via
            request = new JSONObject();
            request.put("calzada", calzada);
            request.put("caracGeometricaVia1", carac1);
            request.put("caracGeometricaVia2", carac2);
            request.put("caracGeometricaVia3", carac3);
            request.put("carril", carril);
            request.put("id", id);
            request.put("informeAccidenteTransito", informe);
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

            this.registrar("Las CaracteristicasVia",request,activity,true);

            Intent intent = new Intent(this.activity, RegistroVehiculoAccidente.class);

            intent.putExtra("idAccidente",id);

            this.activity.startActivity(intent);

        }catch(Exception ex){
            Toast.makeText(this.activity,"El comparendo no se pudo registrar",Toast.LENGTH_LONG).show();
        }
    }

    public void listar(ListView lstAccidente, String agente, String fecha) {

        String ws = "TraerAccidente/";
        String consulta = "SELECT A.* FROM INFORME_ACCIDENTE_TRANSITO A ";

        if (fecha != null || agente != null ){
            if(agente != null){
                consulta += "JOIN Persona P ON(P.Nip = A.Agente) WHERE P.Placa_Agente="+agente+" ";
                if (fecha != null){
                    consulta += "AND A.fecha_hora='"+fecha+"' ";
                }
            }else if (fecha != null){
                consulta += "WHERE A.fecha_hora='"+fecha+"' ";
            }
        }

        String consultaCodificada = null;
        try {
            consultaCodificada = URLEncoder.encode(consulta,"UTF-8");
            Log.d("Consulta codificada: ", consultaCodificada);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ws += consultaCodificada;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(this.urlPeticion+"InformeAccidente/"+ws);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONArray array = ((JSONArray)(new JSONParser().parse(json)));
            List<String> items = new ArrayList<>();

            for (int i = 0;i < array.size();i++) {
                JSONObject obj = ((JSONObject) (array.get(i)));
                String item = "Codigo: "+obj.get("id")+"\n";
                item += "Choque con: "+obj.get("choqueCon")+"\n";
                item += "Clase del accidente: "+obj.get("claseAccidente")+"\n";
                item += "Fecha accidente: "+obj.get("fechaHora")+"\n";
                item += "Numero de heridos: "+obj.get("numeroHeridos")+"\n";
                item += "Numero de muertos: "+obj.get("numeroMuertos")+"\n";
                item += "Tipo de gravedad: "+obj.get("tipoGravedad")+"\n";
                item += "Nip del agente: "+((JSONObject)(obj.get("agente"))).get("nip").toString()+"\n";
                item += "Nombre del agente: "+((JSONObject)(obj.get("agente"))).get("nombreCompleto").toString()+"\n";
                items.add(item);
            }

            ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_list_item_1, new ArrayList(items));
            dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

            lstAccidente.setAdapter(dataAdapter);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
