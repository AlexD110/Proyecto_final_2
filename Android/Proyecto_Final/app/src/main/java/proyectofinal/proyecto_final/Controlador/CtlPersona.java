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
import java.util.HashMap;
import java.util.List;

import proyectofinal.proyecto_final.Activities.Accidente.RegistroVehiculoAccidente;

public class CtlPersona extends Cliente{

    private Activity activity;

    public CtlPersona(Activity activity){
        this.activity = activity;
    }

    public void registrar(String nip, String nombreCompleto, String direccion, String telefono, String eps,
                             int tipoDocumento, int municipio, Date fechaN){
        try {
            JSONObject request = new JSONObject(), tipoDocumentoId = new JSONObject(), municipioId = new JSONObject();
            request.put("direccion", direccion);
            request.put("eps", eps);
            request.put("fechaNacimiento", (new SimpleDateFormat("yyyy-MM-dd").format(fechaN))+"T00:00:00-05:00");
            municipioId = this.traerBD("Municipio",municipio);
            request.put("municipioId", municipioId);
            request.put("nip", nip);
            request.put("nombreCompleto", nombreCompleto);
            request.put("telefono", telefono);
            tipoDocumentoId = this.traerBD("TipoDocumento",tipoDocumento);
            request.put("tipoDocumento", tipoDocumentoId);

            this.registrar("La Persona",request,activity,true);

        }catch(Exception ex){
            Toast.makeText(this.activity,"No se ha podido registrar la persona",Toast.LENGTH_SHORT).show();
        }
    }

    public void registrar(String tipoPerjudicado,String nipPersona,String sexo,String gravedad,
            char cinturon,char casco,int vehiculoAfectado){
        try {
            JSONObject request = new JSONObject();
            request.put("casco", casco);
            request.put("cinturon", cinturon);
            request.put("gravedad", gravedad);
            request.put("id", this.asignarId("Perjudicados"));
            request.put("personaNip", this.traerBD("Persona",nipPersona));
            request.put("sexo", sexo);
            request.put("tipoPerjudicado", tipoPerjudicado);
            request.put("vehiculosAfectadosId", this.traerBD("VehiculosAfectados",vehiculoAfectado));

            this.registrar("El Perjudicados",request,this.activity,false);



        }catch(Exception ex){
            Toast.makeText(this.activity,"No se ha podido registrar la persona",Toast.LENGTH_SHORT).show();
        }
    }

    public void listarPerjudicados(ListView lstComparendo,int idVehiculo) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(this.urlPeticion+"Perjudicados/Informe/"+idVehiculo);
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

                String item = "Nip del Perjudicado: - "+((JSONObject)(obj.get("personaNip"))).get("nip").toString()+"\n";
                item += "Nombre del Perjudicado: - "+((JSONObject)(obj.get("personaNip"))).get("nombreCompleto").toString()+"\n";
                item += "Placa del vehiculo: - "+((JSONObject)(((JSONObject)(obj.get("vehiculosAfectadosId"))).get("vehiculoPlaca"))).get("placa").toString()+"\n";
                item += "Nip del agente: - "+((JSONObject)(((JSONObject)(((JSONObject)(obj.get("vehiculosAfectadosId"))).get("informeAccidenteTransitoId"))).get("agente"))).get("nip").toString()+"\n";

                items.add(item);
            }

            ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_list_item_1, new ArrayList(items));
            dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

            lstComparendo.setAdapter(dataAdapter);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
