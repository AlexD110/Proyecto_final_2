package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
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
import java.util.Map;

public class CtlComparendo extends Cliente implements Serializable{

    private Activity activity;
    private Map<Integer,String> comparendos;

    public CtlComparendo(Activity activity){
        this.activity = activity;
    }

    public void modificar(int id,String estado){
        JSONObject comparendo = traerBD("Comparendo",id);

        comparendo.put("estado",estado);

        this.modificar("El Comparendo",comparendo,this.activity,id);
    }

    public void registrar(int municipio,
            Date fecha,
            String localidad,String viaPrincipal,String viaSecundaria,String descripcion,
                             String modalidad,String radio,String tipoInfractor,
                             String placaVehiculo,String nipTestigo,String nipAgente,
                             String nipInfractor,String tipoInfraccion){
        try {
            JSONObject request = new JSONObject(), testigo = new JSONObject(), agente = new JSONObject(),
                infractor = new JSONObject(),vehiculo = new JSONObject(),tipoInfraccionId = new JSONObject(),
                municipioId = new JSONObject();

            request.put("descripcion", descripcion);
            request.put("fecha", (new SimpleDateFormat("yyyy-MM-dd").format(fecha))+"T00:00:00-05:00");
            request.put("id", this.asignarId("Comparendo"));
            request.put("localidadComuna", localidad);
            request.put("modalidadTransporte", modalidad);
            municipioId = this.traerBD("Municipio",municipio);
            request.put("municipioId", municipioId);
            infractor = this.traerBD("Persona",nipInfractor);
            request.put("infractor", infractor);
            agente = this.traerBD("Persona",nipAgente);
            request.put("agente", agente);
            if (nipTestigo != null){
                testigo = this.traerBD("Persona",nipTestigo);
                request.put("testigo", testigo);
            }
            request.put("radioAccion", radio);
            tipoInfraccionId = this.traerBD("TipoInfraccion",tipoInfraccion);
            request.put("tipoInfraccionCodigo", tipoInfraccionId);
            request.put("tipoInfractor", tipoInfractor);
            vehiculo = this.traerBD("Vehiculo",placaVehiculo);
            request.put("vehiculoPlaca", vehiculo);
            request.put("viaPrincipal", viaPrincipal);
            request.put("viaSecundaria", viaSecundaria);
            request.put("estado","HABILITADO");

            this.registrar("El Comparendo",request,activity,true);

        }catch(Exception ex){
            Toast.makeText(this.activity,"El comparendo no se pudo registrar",Toast.LENGTH_LONG).show();
        }
    }

    public void listar(ListView lstComparendo,String placa,String fecha,String nipInfrac,String estado) {

        this.comparendos = new HashMap<>();

        String ws = "TraerComparendos/";
        String consulta = "SELECT C.* FROM Comparendo C ";

        if (placa != null || fecha != null || nipInfrac != null || estado != null){

            if (placa != null){
                consulta += "WHERE C.Vehiculo_Placa='"+placa+"' ";
                if (fecha != null){
                    consulta += "AND C.Fecha='"+fecha+"' ";
                }
                if (nipInfrac != null){
                    consulta += "AND C.Infractor="+nipInfrac+" ";
                }
                if (estado != null){
                    consulta += "AND Upper(C.Estado)='"+estado.toUpperCase()+"'";
                }
            }else if(fecha != null){
                consulta += "WHERE C.Fecha='"+fecha+"' ";
                if (nipInfrac != null){
                    consulta += "AND C.Infractor="+nipInfrac+" ";
                }
                if (estado != null){
                    consulta += "AND Upper(C.Estado)='"+estado.toUpperCase()+"'";
                }
            }else if (nipInfrac != null){
                consulta += "WHERE C.Infractor="+nipInfrac+" ";
                if (estado != null){
                    consulta += "AND Upper(C.Estado)='"+estado.toUpperCase()+"'";
                }
            }else if (estado != null){
                consulta += "WHERE Upper(C.Estado)='"+estado.toUpperCase()+"'";
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
            url = new URL(this.urlPeticion+"Comparendo/"+ws);
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

                String item = obj.get("id").toString()+" - \n";
                item += "Tipo de infracción: - "+((JSONObject)(obj.get("tipoInfraccionCodigo"))).get("codigo").toString()+"\n";
                item += "Descripción de infracción: - "+((JSONObject)(obj.get("tipoInfraccionCodigo"))).get("descripcion").toString()+"\n";
                item += "Nip del infractor: - "+((JSONObject)(obj.get("infractor"))).get("nip").toString()+"\n";
                item += "Nombre del infractor: - "+((JSONObject)(obj.get("infractor"))).get("nombreCompleto").toString()+"\n";
                item += "Placa del vehiculo: - "+((JSONObject)(obj.get("vehiculoPlaca"))).get("placa").toString()+"\n";
                item += "Nip del agente: - "+((JSONObject)(obj.get("agente"))).get("nip").toString()+"\n";
                item += "Nombre del agente: - "+((JSONObject)(obj.get("agente"))).get("nombreCompleto").toString()+"\n";
                item += "Estado del comparendo: - "+obj.get("estado")+"\n";
                item += "Precio del comparendo:  - "+obj.get("Precio")+"\n";

                this.comparendos.put(Integer.parseInt(obj.get("id").toString()),item);

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

    public Map<Integer, String> getComparendos() {
        return comparendos;
    }

    public void setComparendos(Map<Integer, String> comparendos) {
        this.comparendos = comparendos;
    }
}
