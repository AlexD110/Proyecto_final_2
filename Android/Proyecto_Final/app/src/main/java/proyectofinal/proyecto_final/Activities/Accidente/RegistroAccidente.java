package proyectofinal.proyecto_final.Activities.Accidente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import proyectofinal.proyecto_final.Controlador.CtlAccidente;
import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.R;

public class RegistroAccidente extends AppCompatActivity {


    private Spinner cbTipoGravedadAccidentes,cbClaseAccidentes,cbChoqueCon,cbObjetoFijos,cbAreaAccidente,
            cbSectorAccidente,cbZonaAccidente,cbDisenioAccidente,cbTiempo,cbCarac1,cbCarac2,cbCarac3
            ,cbUtilizacion,cbCalzada,cbCarril,cbMaterial,cbEstado,cbCondicion,cbIluminacion,cbDisminucion,cbSemaforo
            ,cbDemarcacion;
    private EditText txtNumeroMuertoss,txtNumeroHeridoss,txtfechaAccidetes,txtCoordenadaX,txtCoordenadaY
            ,txtDireccion,txtLocalidadComina,txtSenial;
    private CtlCombo controladorCombo;
    private CtlAccidente controladorAccidente;
    private String nipAgente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_accidente);

        this.controladorCombo = new CtlCombo(this);
        this.controladorAccidente = new CtlAccidente(this);

        Bundle bundle = getIntent().getExtras();
        this.nipAgente = bundle.getString("cedulaAgente");

        cbTipoGravedadAccidentes = (Spinner) findViewById(R.id.cbTipoGravedadAccidente);
        cbClaseAccidentes = (Spinner) findViewById(R.id.cbClaseAccidente);
        cbChoqueCon = (Spinner) findViewById(R.id.cbChoqueCon);
        cbObjetoFijos = (Spinner) findViewById(R.id.cbObjetoFijo);

        cbAreaAccidente = (Spinner) findViewById(R.id.cbAreaAccidente);
        cbSectorAccidente = (Spinner) findViewById(R.id.cbSectorAccidente);
        cbZonaAccidente = (Spinner) findViewById(R.id.cbZonaAccidente);
        cbDisenioAccidente = (Spinner) findViewById(R.id.cbDisenioAccidente);
        cbTiempo = (Spinner) findViewById(R.id.cbTiempo);

        cbCarac1 = (Spinner) findViewById(R.id.cbCarac1_accidente);
        cbCarac2 = (Spinner) findViewById(R.id.cbCarac2_accidente);
        cbCarac3 = (Spinner) findViewById(R.id.cbCarac3_accidente);
        cbUtilizacion = (Spinner) findViewById(R.id.cbUtilizacion_accidente);
        cbCalzada = (Spinner) findViewById(R.id.cbCalzada_accidente);
        cbCarril = (Spinner) findViewById(R.id.cbCarril_accidente);
        cbMaterial = (Spinner) findViewById(R.id.cbMaterial_accidente);
        cbEstado = (Spinner) findViewById(R.id.cbEstado_accidente);
        cbCondicion= (Spinner) findViewById(R.id.cbCondicion_accidente);
        cbIluminacion = (Spinner) findViewById(R.id.cbIluminacion_accidente);
        cbDisminucion = (Spinner) findViewById(R.id.cbDisminucion_accidente);
        cbSemaforo = (Spinner) findViewById(R.id.cbSemaforo_accidente);
        cbDemarcacion = (Spinner) findViewById(R.id.cbDemarcacion_accidente);

        txtNumeroMuertoss = (EditText) findViewById(R.id.txtNumeroMuertos);
        txtNumeroHeridoss = (EditText) findViewById(R.id.txtNumeroHeridos);
        txtfechaAccidetes = (EditText) findViewById(R.id.txtfechaAccidete);
        txtCoordenadaX = (EditText) findViewById(R.id.txtCoordenadaX_accidente);
        txtCoordenadaY = (EditText) findViewById(R.id.txtCoordenadaY_accidente);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion_accidente);
        txtLocalidadComina = (EditText) findViewById(R.id.txtLocalidaComuna_accidente);
        txtSenial = (EditText) findViewById(R.id.txtSenial_accidente);

        this.controladorCombo.cargarTipoGravedad(cbTipoGravedadAccidentes);
        this.controladorCombo.cargarClaseAccidente(cbClaseAccidentes);
        this.controladorCombo.cargarChoqueCon(cbChoqueCon);
        this.controladorCombo.cargarObjetoFijo(cbObjetoFijos);

        this.controladorCombo.cargarAreaAccidente(cbAreaAccidente);
        this.controladorCombo.cargarSectorAccidente(cbSectorAccidente);
        this.controladorCombo.cargarZonaAccidente(cbZonaAccidente);
        this.controladorCombo.cargarDisenioAccidente(cbDisenioAccidente);
        this.controladorCombo.cargarTiempoAccidente(cbTiempo);
        this.controladorCombo.cargarCaracteristica1(cbCarac1);
        this.controladorCombo.cargarCaracteristica2(cbCarac2);
        this.controladorCombo.cargarCaracteristica3(cbCarac3);
        this.controladorCombo.cargarUtilizacion(cbUtilizacion);
        this.controladorCombo.cargarCarrilCalzada(cbCalzada);
        this.controladorCombo.cargarCarrilCalzada(cbCarril);
        this.controladorCombo.cargarMaterial(cbMaterial);
        this.controladorCombo.cargarEstadoVia(cbEstado);
        this.controladorCombo.cargarCondicion(cbCondicion);
        this.controladorCombo.cargarIluminacion(cbIluminacion);
        this.controladorCombo.cargarDisminucion(cbDisminucion);
        this.controladorCombo.cargarSemaforo(cbSemaforo);
        this.controladorCombo.cargarDemarcacion(cbDemarcacion);
    }

    public void siguiente(View view){
        if(cbTiempo.getSelectedItemPosition()==0 || cbDisenioAccidente.getSelectedItemPosition()==0 || cbZonaAccidente.getSelectedItemPosition()==0
                || cbSectorAccidente.getSelectedItemPosition()==0 || cbTipoGravedadAccidentes.getSelectedItemPosition()==0 ||cbClaseAccidentes.getSelectedItemPosition()==0
                || cbChoqueCon.getSelectedItemPosition()==0 || cbObjetoFijos.getSelectedItemPosition()==0 || cbAreaAccidente.getSelectedItemPosition()==0
                || txtfechaAccidetes.getText().toString().isEmpty() || txtNumeroHeridoss.getText().toString().isEmpty() || txtNumeroMuertoss.getText().toString().isEmpty()
                || txtCoordenadaX.getText().toString().trim().isEmpty() || txtCoordenadaY.getText().toString().trim().isEmpty() || txtDireccion.getText().toString().trim().isEmpty()
                || txtLocalidadComina.getText().toString().trim().isEmpty() || txtSenial.getText().toString().trim().isEmpty() || cbCarac1.getSelectedItemPosition() == 0
                || cbCarac2.getSelectedItemPosition() == 0 || cbCarac3.getSelectedItemPosition() == 0 || cbUtilizacion.getSelectedItemPosition() == 0 || cbCalzada.getSelectedItemPosition() == 0
                || cbCarril.getSelectedItemPosition() == 0 || cbMaterial.getSelectedItemPosition() == 0 || cbEstado.getSelectedItemPosition() == 0 || cbCondicion.getSelectedItemPosition() == 0
                || cbIluminacion.getSelectedItemPosition() == 0 || cbDisminucion.getSelectedItemPosition() == 0 || cbSemaforo.getSelectedItemPosition() == 0 || cbDemarcacion.getSelectedItemPosition() == 0){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }else {

            //Accidente
            String tipoGravedad, ClaseAccidente, ChoqueCon, objetoFijo;
            Date fecha = null;
            int muertos, heridos;

            tipoGravedad = cbTipoGravedadAccidentes.getSelectedItem().toString();
            ClaseAccidente = cbClaseAccidentes.getSelectedItem().toString();
            ChoqueCon = cbChoqueCon.getSelectedItem().toString();
            objetoFijo = cbObjetoFijos.getSelectedItem().toString();
            try {
                fecha = (new SimpleDateFormat("yyyy-MM-dd").parse(txtfechaAccidetes.getText().toString().trim()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            muertos = Integer.parseInt(txtNumeroMuertoss.getText().toString().trim());
            heridos = Integer.parseInt(txtNumeroHeridoss.getText().toString().trim());

            //Caracteristicas del lugar
            String area,sector,zona,disenio,tiempo;

            area = this.cbAreaAccidente.getSelectedItem().toString().trim();
            sector = this.cbSectorAccidente.getSelectedItem().toString().trim();
            zona = this.cbZonaAccidente.getSelectedItem().toString().trim();
            disenio = this.cbDisenioAccidente.getSelectedItem().toString().trim();
            tiempo = this.cbAreaAccidente.getSelectedItem().toString().trim();

            //Lugar
            String coordenadaX,coordenadaY,direccion,localidad;

            coordenadaX = txtCoordenadaX.getText().toString().trim();
            coordenadaY = txtCoordenadaY.getText().toString().trim();
            direccion = txtDireccion.getText().toString().trim();
            localidad = txtLocalidadComina.getText().toString().trim();

            //Caracteristicas via
            String carac1,carac2,carac3,utilizacion,calzada,carril,material,estado,condicion,iluminacion,disminucion,semaforo,senial,
                    demarcacion;

            carac1 = cbCarac1.getSelectedItem().toString().trim();
            carac2 = cbCarac2.getSelectedItem().toString().trim();
            carac3 = cbCarac3.getSelectedItem().toString().trim();
            utilizacion = cbUtilizacion.getSelectedItem().toString().trim();
            calzada = cbCalzada.getSelectedItem().toString().trim();
            carril = cbCarril.getSelectedItem().toString().trim();
            material = cbMaterial.getSelectedItem().toString().trim();
            estado = cbEstado.getSelectedItem().toString().trim();
            condicion = cbCondicion.getSelectedItem().toString().trim();
            iluminacion = cbIluminacion.getSelectedItem().toString().trim();
            disminucion = cbDisminucion.getSelectedItem().toString().trim();
            semaforo = cbSemaforo.getSelectedItem().toString().trim();
            senial = txtSenial.getText().toString().trim();
            demarcacion = cbDemarcacion.getSelectedItem().toString().trim();

            this.controladorAccidente.registrar(fecha,tipoGravedad,ClaseAccidente,ChoqueCon,objetoFijo,area,sector,zona
            ,disenio,tiempo,coordenadaX,coordenadaY,direccion,localidad,carac1,carac2,carac3,utilizacion,calzada,carril,material
            ,estado,condicion,iluminacion,nipAgente,disminucion,semaforo,senial,demarcacion,heridos,muertos);
        }

    }
}
