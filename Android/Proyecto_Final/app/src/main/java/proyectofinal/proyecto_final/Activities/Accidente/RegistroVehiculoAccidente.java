package proyectofinal.proyecto_final.Activities.Accidente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import proyectofinal.proyecto_final.Activities.Persona.RegistroPersonas;
import proyectofinal.proyecto_final.Activities.Vehiculo.RegistroVehiculo;
import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.Controlador.CtlPersona;
import proyectofinal.proyecto_final.Controlador.CtlVehiculo;
import proyectofinal.proyecto_final.R;

public class RegistroVehiculoAccidente extends AppCompatActivity {

    private LinearLayout lytVehiculoAfec, lytPerjudicados, lytBtnAniadirPerjudicado, lytListaPerjudicados;

    private int idAccidente;

    //Parte de vehiculo
    public static Spinner cbVehiculoAccidente;
    private Spinner cbFallaEn;
    private EditText txtMovilizado, txtDisposicion, txtLugarImpacto, txtVersion;
    private int idVehiculoAfec;

    //parte de perjudicado
    public static Spinner cbPersonaNipAccidente;
    private Spinner cbtipoPerjudicado, cbCinturon, cbCasco, cbSexo, cbGravedad, cbCondicion;
    private ListView lstPerjudicados;

    private CtlCombo controladorCombo;
    private CtlVehiculo controladorVehiculo;
    private CtlPersona controladorPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__vehiculo);

        this.controladorCombo = new CtlCombo(this);
        this.controladorVehiculo = new CtlVehiculo(this);
        this.controladorPersona = new CtlPersona(this);

        this.idAccidente = Integer.parseInt(this.getIntent().getExtras().get("idAccidente").toString());

        //Vehiculo
        cbVehiculoAccidente = (Spinner) findViewById(R.id.cbVehiculoAccidente);
        cbFallaEn = (Spinner) findViewById(R.id.cbFallaEn);
        txtMovilizado = (EditText) findViewById(R.id.txtMovilizado);
        txtDisposicion = (EditText) findViewById(R.id.txtDisposicion);
        txtLugarImpacto = (EditText) findViewById(R.id.txtLugarImpacto);
        txtVersion = (EditText) findViewById(R.id.txtVersion);

        //Persona
        cbtipoPerjudicado = (Spinner) findViewById(R.id.cbtipoPerjudicado);
        cbPersonaNipAccidente = (Spinner) findViewById(R.id.cbPersonaNipAccidente);
        cbCinturon = (Spinner) findViewById(R.id.cbCinturon);
        cbCasco = (Spinner) findViewById(R.id.cbCasco);
        cbSexo = (Spinner) findViewById(R.id.cbSexo);
        cbGravedad = (Spinner) findViewById(R.id.cbGravedad);
        lstPerjudicados = (ListView) findViewById(R.id.lstPerjudicados);

        this.controladorCombo.cargar(cbVehiculoAccidente, "Vehiculo", "placa", "Seleccione el vehiculo según la placa");
        this.controladorCombo.cargar(cbPersonaNipAccidente, "Persona", "nip", "Seleccione por nip a el perjudicado");
        this.controladorCombo.cargartipoPerjudicado(cbtipoPerjudicado);
        this.controladorCombo.cargarOpcion(cbCinturon, "Selecione si llevaba cinturon");
        this.controladorCombo.cargarOpcion(cbCasco, "Seleccione si llevaba un casco");
        this.controladorCombo.cargarSexo(cbSexo);
        this.controladorCombo.cargarGravedad(cbGravedad);
        this.controladorCombo.cargarFallaen(cbFallaEn);

        this.lytVehiculoAfec = (LinearLayout) findViewById(R.id.layout_Vehiculo_accidente);
        this.lytPerjudicados = (LinearLayout) findViewById(R.id.layout_perjudicados_accidente);
        this.lytBtnAniadirPerjudicado = (LinearLayout) findViewById(R.id.layout_btnAnadir_perjudicado_accidente);
        this.lytListaPerjudicados = (LinearLayout) findViewById(R.id.layout_lstPerjudicados_accidente);

        this.lytPerjudicados.setVisibility(View.GONE);
        this.lytBtnAniadirPerjudicado.setVisibility(View.GONE);
        this.lytListaPerjudicados.setVisibility(View.GONE);
    }

    public void abrirAddVehiculo(View view) {
        this.startActivity(new Intent(this, RegistroVehiculo.class));
    }

    public void abrirAddPersona(View view) {
        this.startActivity(new Intent(this, RegistroPersonas.class));
    }

    public void registrarVehiculo(View view) {

        if (cbVehiculoAccidente.getSelectedItemPosition() == 0 || cbFallaEn.getSelectedItemPosition() == 0
                || txtMovilizado.getText().toString().trim().isEmpty() || txtDisposicion.getText().toString().trim().isEmpty()
                || txtLugarImpacto.getText().toString().trim().isEmpty() || txtVersion.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            String placaVehiculo, falla, movilizado, disposicion, lugar, version;

            placaVehiculo = cbVehiculoAccidente.getSelectedItem().toString().trim();
            falla = cbFallaEn.getSelectedItem().toString().trim();
            movilizado = txtMovilizado.getText().toString().trim();
            disposicion = txtDisposicion.getText().toString().trim();
            lugar = txtLugarImpacto.getText().toString().trim();
            version = txtVersion.getText().toString().trim();

            try {
                this.idVehiculoAfec = this.controladorVehiculo.registrar(placaVehiculo, falla, movilizado, disposicion, lugar, version, idAccidente);
            }catch (Exception e){
                Toast.makeText(this,"Se ha producido un erro al guardar el vehiculo",Toast.LENGTH_SHORT).show();
                this.finish();
            }

            this.lytPerjudicados.setVisibility(View.VISIBLE);
            this.lytBtnAniadirPerjudicado.setVisibility(View.VISIBLE);
            this.lytVehiculoAfec.setVisibility(View.GONE);
        }
    }

    public void añadirPerjudicado(View view) {

        if (cbtipoPerjudicado.getSelectedItemPosition() == 0 || cbPersonaNipAccidente.getSelectedItemPosition() == 0
                || cbCinturon.getSelectedItemPosition() == 0 || cbCasco.getSelectedItemPosition() == 0
                || cbSexo.getSelectedItemPosition() == 0 || cbGravedad.getSelectedItemPosition() == 0){
            Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            String tipoPerjudicado,nipPersona,sexo,gravedad;
            char cinturon,casco;

            tipoPerjudicado = cbtipoPerjudicado.getSelectedItem().toString().trim();
            nipPersona = cbPersonaNipAccidente.getSelectedItem().toString().trim();
            sexo = cbSexo.getSelectedItem().toString().trim();
            gravedad = cbGravedad.getSelectedItem().toString().trim();
            casco = cbCasco.getSelectedItem().toString().trim().charAt(0);
            cinturon = cbCinturon.getSelectedItem().toString().trim().charAt(0);

            try {
                this.controladorPersona.registrar(tipoPerjudicado,nipPersona,sexo,gravedad,cinturon,casco,this.idVehiculoAfec);
            }catch (Exception e){
                Toast.makeText(this,"Se ha producido un erro al guardar el Perjudicado",Toast.LENGTH_SHORT).show();
                this.finish();
            }

            this.lytListaPerjudicados.setVisibility(View.VISIBLE);
            this.controladorPersona.listarPerjudicados(this.lstPerjudicados,this.idVehiculoAfec);

            cbtipoPerjudicado.setSelection(0);
            cbPersonaNipAccidente.setSelection(0);
            cbSexo.setSelection(0);
            cbGravedad.setSelection(0);
            cbCasco.setSelection(0);
            cbCinturon.setSelection(0);
        }

    }

    public void registrarNuevoVehiculo(View view) {
        Intent intent = new Intent(this, RegistroVehiculoAccidente.class);
        intent.putExtra("idAccidente",this.idAccidente);
        this.finish();
        this.startActivity(intent);
    }

    public void terminarRegistro(View view) {
        this.finish();
    }
}
