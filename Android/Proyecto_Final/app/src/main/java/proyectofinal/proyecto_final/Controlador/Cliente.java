package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Cliente {

    protected String urlPeticion = "http://192.168.1.7:8080/API-Proyecto/Recursos/";

    protected JSONObject traerBD(String entidad, Object dato) {

        JSONObject obj = new JSONObject();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(urlPeticion + entidad + "/" + dato);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = response.toString();

            return ((JSONObject) (new JSONParser().parse(json)));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected int asignarId(String entidad){
        return this.numeroRegistros(entidad)+1;
    }

    protected int numeroRegistros(String entidad) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(urlPeticion + entidad + "/" + "count");
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = response.toString();

            return Integer.parseInt(json);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    protected void modificar(final String entidad, JSONObject request,final Activity activity,Object id){
        try {
            JsonObjectRequest objectRequest = new JsonObjectRequest(
                    Request.Method.PUT,
                    this.urlPeticion + entidad.split(" ")[1] + "/"+id,
                    (new org.json.JSONObject(request.toString())),
                    new Response.Listener<org.json.JSONObject>() {
                        @Override
                        public org.json.JSONObject onResponse(org.json.JSONObject response) {
                            Log.d("Response", response.toString());
                            try {
                                if (response.getBoolean("Resultado")){
                                    Toast.makeText(activity, entidad + " Se ha modificado exitosamente", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(activity, entidad + " No se ha podido modificar", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                Log.d("Error", e.toString());
                                Toast.makeText(activity, entidad + " No se ha podido modificar", Toast.LENGTH_SHORT).show();
                            }
                            return response;
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error", error.toString());
                            Toast.makeText(activity, entidad + " No se ha podido modificar", Toast.LENGTH_SHORT).show();
                        }
                    }
            );

            RequestQueue queue = Volley.newRequestQueue(activity);

            queue.add(objectRequest);

            Thread.sleep(100);
        } catch (Exception e) {
            Toast.makeText(activity, entidad + " No se ha podido modificar", Toast.LENGTH_SHORT).show();
        }
    }

    protected void registrar(final String entidad, JSONObject request, final Activity activity,final boolean cerrar) {

        try {
            JsonObjectRequest objectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    this.urlPeticion + entidad.split(" ")[1] + "/",
                    (new org.json.JSONObject(request.toString())),
                    new Response.Listener<org.json.JSONObject>() {
                        @Override
                        public org.json.JSONObject onResponse(org.json.JSONObject response) {
                            Log.d("Response", response.toString());
                            try {
                                if (response.getBoolean("Resultado")){
                                        Toast.makeText(activity, entidad + " Se ha registrado exitosamente", Toast.LENGTH_SHORT).show();
                                        if (cerrar){
                                            activity.finish();
                                        }
                                }else{
                                        Toast.makeText(activity, entidad + " No se ha podido registrar", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                Log.d("Error", e.toString());
                                    Toast.makeText(activity, entidad + " No se ha podido registrar", Toast.LENGTH_SHORT).show();
                            }
                            return response;
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error", error.toString());
                                Toast.makeText(activity, entidad + " No se ha podido registrar", Toast.LENGTH_SHORT).show();
                        }
                    }
            );

            RequestQueue queue = Volley.newRequestQueue(activity);

            queue.add(objectRequest);

            Thread.sleep(100);
        } catch (Exception e) {
            Toast.makeText(activity, entidad + " No se ha podido registrar", Toast.LENGTH_SHORT).show();
        }

    }
}
