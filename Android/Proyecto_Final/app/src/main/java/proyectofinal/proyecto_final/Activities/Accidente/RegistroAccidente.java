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


    private Spinner cbTipoGravedadAccidentes,cbClaseAccidentes,cbChoqueCons,cbObjetoFijos,cbAreaAccidente,
            cbSectorAccidente,cbZonaAccidente,cbDisenioAccidente,cbTiempo;

    private EditText txtNumeroMuertoss,txtNumeroHeridoss,txtfechaAccidetes;
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

        cbTipoGravedadAccidentes =(Spinner) findViewById(R.id.cbTipoGravedadAccidente);
        cbClaseAccidentes =(Spinner) findViewById(R.id.cbClaseAccidente);
        cbChoqueCons =(Spinner) findViewById(R.id.cbChoqueCon);
        cbObjetoFijos =(Spinner) findViewById(R.id.cbObjetoFijo);

        cbAreaAccidente =(Spinner) findViewById(R.id.cbAreaAccidente);
        cbSectorAccidente =(Spinner) findViewById(R.id.cbSectorAccidente);
        cbZonaAccidente =(Spinner) findViewById(R.id.cbZonaAccidente);
        cbDisenioAccidente =(Spinner) findViewById(R.id.cbDisenioAccidente);
        cbTiempo =(Spinner) findViewById(R.id.cbTiempo);

        txtNumeroMuertoss = (EditText) findViewById(R.id.txtNumeroMuertos);
        txtNumeroHeridoss = (EditText) findViewById(R.id.txtNumeroHeridos);
        txtfechaAccidetes= (EditText) findViewById(R.id.txtfechaAccidete);

        this.controladorCombo.cargarTipoGravedad(cbTipoGravedadAccidentes);
        this.controladorCombo.cargarClaseAccidente(cbClaseAccidentes);
        this.controladorCombo.cargarChoqueCon(cbChoqueCons);
        this.controladorCombo.cargarObjetoFijo(cbObjetoFijos);

        this.controladorCombo.cargarAreaAccidente(cbAreaAccidente);
        this.controladorCombo.cargarSectorAccidente(cbSectorAccidente);
        this.controladorCombo.cargarZonaAccidente(cbZonaAccidente);
        this.controladorCombo.cargarDisenioAccidente(cbDisenioAccidente);
        this.controladorCombo.cargarTiempoAccidente(cbTiempo);

    }

    public void siguiente(View view){
        if(cbTiempo.getSelectedItemPosition()==0 || cbDisenioAccidente.getSelectedItemPosition()==0 || cbZonaAccidente.getSelectedItemPosition()==0
                || cbSectorAccidente.getSelectedItemPosition()==0 || cbTipoGravedadAccidentes.getSelectedItemPosition()==0 ||cbClaseAccidentes.getSelectedItemPosition()==0
                || cbChoqueCons.getSelectedItemPosition()==0 || cbObjetoFijos.getSelectedItemPosition()==0 || cbAreaAccidente.getSelectedItemPosition()==0
                || txtfechaAccidetes.getText().toString().isEmpty() || txtNumeroHeridoss.getText().toString().isEmpty() || txtNumeroMuertoss.getText().toString().isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }else {

            //Accidente
            String tipoGravedad, ClaseAccidente, ChoqueCon, objetoFijo;
            Date fecha = null;
            int muertos, heridos;

            tipoGravedad = cbTipoGravedadAccidentes.getSelectedItem().toString();
            ClaseAccidente = cbClaseAccidentes.getSelectedItem().toString();
            ChoqueCon = cbChoqueCons.getSelectedItem().toString();
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

            this.controladorAccidente.registrar(tipoGravedad,ClaseAccidente,ChoqueCon,objetoFijo,fecha,muertos,heridos,this.nipAgente
                ,area,sector,zona,disenio,tiempo);
        }

    }
}
