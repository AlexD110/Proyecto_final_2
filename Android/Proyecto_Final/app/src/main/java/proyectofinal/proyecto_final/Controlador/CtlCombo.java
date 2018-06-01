package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CtlCombo extends Cliente {

    private Activity activity;

    public CtlCombo(Activity activity) {
        this.activity = activity;
    }

    public void cargarFallaen(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione la falla del vehiculo");
        items.add("Frenos");
        items.add("Direccion");
        items.add("Luces");
        items.add("Bocina");
        items.add("Llantas");
        items.add("Suspension");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarOpcion(Spinner spinner, String enunciado) {
        List<String> items = new ArrayList<>();

        items.add(enunciado);
        items.add("Si");
        items.add("No");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarSexo(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione un sexo");
        items.add("Masculino");
        items.add("Femenino");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarGravedad(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione un la gravedad");
        items.add("Muerto");
        items.add("Herido");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargartipoPerjudicado(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione la condicion");
        items.add("Peaton");
        items.add("Pasajero");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarEps(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una EPS");
        items.add("Cafesalud");
        items.add("Nueva EPS");
        items.add("Sanitas");
        items.add("SaludCoop");
        items.add("Golden Group");
        items.add("Coomeva");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarViaSecundaria(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una via secundaria");
        items.add("AV");
        items.add("CL");
        items.add("CR");
        items.add("AU");
        items.add("DG");
        items.add("TR");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarViaPrincipal(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una via principal");
        items.add("AV");
        items.add("CL");
        items.add("CR");
        items.add("AU");
        items.add("DG");
        items.add("TR");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarCategoriaLicencia(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una categoria");
        items.add("Motocicletas");
        items.add("Vehiculos de nivel 1");
        items.add("Vehiculos de nivel 2");
        items.add("Vehiculos de nivel 3");
        items.add("Vehiculos de nivel 4");
        items.add("Vehiculos de nivel 5");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarModalidad(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una modalidad");
        items.add("PASAJEROS COLECTIVO");
        items.add("PASAJEROS  INDIVIDUAL");
        items.add("PASAJEROS  MASIVO");
        items.add("PASAJEROS  ESPECIAL ESCOLAR");
        items.add("PASAJEROS  ESPECIAL ASALARIADO");
        items.add("PASAJEROS  ESPECIAL DE TURISMO");
        items.add("PASAJEROS  ESPECIAL OCASIONAL");
        items.add("MIXTO");
        items.add("CARGA");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarRadio(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione el radio de acción");
        items.add("NACIONAL");
        items.add("MUNICIPAL");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarTipoInfractor(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione tipo de infractor");
        items.add("CONDUCTOR");
        items.add("PEATON");
        items.add("PASAJERO");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarClaseVehiculo(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una clase");
        items.add("Privado");
        items.add("Publico");
        items.add("Diplomatico");
        items.add("Oficial");
        items.add("Especial");
        items.add("Otros");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarNacionalidad(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una nacionalidad");
        items.add("Colombiana");
        items.add("Otra");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarEstadoComparendo(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una estado");
        items.add("Habilitado");
        items.add("Infraccion");
        items.add("Anulado");
        items.add("Cancelado");
        items.add("Juicio");
        items.add("Inasistencia");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarTipoVehiculo(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una clase");
        items.add("Automovil");
        items.add("Bus");
        items.add("Buseta");
        items.add("Camion");
        items.add("Campero");
        items.add("Microbus");
        items.add("Tractocamion");
        items.add("Motocicleta");
        items.add("Motocarro");
        items.add("Mototriciclo");
        items.add("Cuatrimoto");
        items.add("Volqueta");
        items.add("Otro");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarTipoGravedad(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione un tipo de graveda");
        items.add("Con muertos");
        items.add("Con heridos");
        items.add("Solo daños");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarClaseAccidente(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una clase del accidente");
        items.add("Choque");
        items.add("Atropello");
        items.add("Volcamiento");
        items.add("Caida ocupante");
        items.add("Incendio");
        items.add("Otro");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarChoqueCon(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Choque con");
        items.add("Vehiculo");
        items.add("Tren");
        items.add("Semoviente");
        items.add("Objeto fijo");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarObjetoFijo(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione el objeto fijo");
        items.add("Muro");
        items.add("Poste");
        items.add("Arbol");
        items.add("Baranda");
        items.add("Inmueble");
        items.add("Hidrante");
        items.add("Valla");
        items.add("Señal");
        items.add("Tarima");
        items.add("Caseta");
        items.add("Vehiculo estacionado");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarAreaAccidente(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione un area");
        items.add("Urbana");
        items.add("Rural");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarSectorAccidente(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione un sector");
        items.add("Residencial");
        items.add("Industrial");
        items.add("Comercial");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarZonaAccidente(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una zona");
        items.add("Escolar");
        items.add("Militar");
        items.add("Deportiva");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarDisenioAccidente(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione una diseño");
        items.add("Tramo de via");
        items.add("Intercepcion");
        items.add("Via peatonal");
        items.add("Paso elevado");
        items.add("Paso inferior");
        items.add("Paso a nivel");
        items.add("Glorieta");
        items.add("Puente");
        items.add("Via troncal");
        items.add("Lote o predio");
        items.add("Cicloruta");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarTiempoAccidente(Spinner spinner) {
        List<String> items = new ArrayList<>();

        items.add("Seleccione el tiempo");
        items.add("Normal");
        items.add("Lluvia");
        items.add("Viento");
        items.add("Niebla");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargar(Spinner spinner, String entidad, String loqquierover, String primerValor) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(this.urlPeticion + entidad + "/");
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

            JSONArray array = ((JSONArray) (new JSONParser().parse(json)));
            List<String> items = new ArrayList<>();

            items.add(primerValor);

            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = ((JSONObject) (array.get(i)));
                items.add(obj.get(loqquierover).toString());
            }

            ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, new ArrayList(items));
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(dataAdapter);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
