package proyectofinal.proyecto_final.Activities.Comparendo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.Controlador.CtlComparendo;
import proyectofinal.proyecto_final.R;
import proyectofinal.proyecto_final.Util.Herramientas;

public class BusquedaComparendo extends AppCompatActivity {

    private EditText txtPlaca, txtFecha, txtNip;
    private Spinner cbEstado;
    private ListView lstComparendos;

    private Activity activity;

    private CtlCombo controladorCombo;
    private CtlComparendo controladorComparendo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_comparendo);

        this.activity = this;

        this.txtPlaca = (EditText) findViewById(R.id.txtPlaca_busquedaC);
        this.txtFecha = (EditText) findViewById(R.id.txtFecha_busquedaC);
        this.txtNip = (EditText) findViewById(R.id.txtNip_busquedaC);
        this.cbEstado = (Spinner) findViewById(R.id.cbEstadoC_busquedaC);
        this.lstComparendos = (ListView) findViewById(R.id.lstComparendos_busquedaC);

        this.controladorCombo = new CtlCombo(this);
        this.controladorComparendo = new CtlComparendo(this);

        this.controladorCombo.cargarEstadoComparendo(this.cbEstado);
        this.controladorComparendo.listar(this.lstComparendos, null, null, null, null);

        this.lstComparendos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity,VerComparendo.class);
                intent.putExtra("comparendo",lstComparendos.getItemAtPosition(position).toString());
                Herramientas.setObjeto(controladorComparendo);
                startActivity(intent);
            }
        });
    }

    public void actualizarLista(View view){
        this.controladorComparendo.listar(this.lstComparendos, null, null, null, null);
    }

    public void buscar(View view){
        String placa = null,fecha=null,nipInfrac = null,estado = null;

        if (!txtPlaca.getText().toString().isEmpty()){
            placa = txtPlaca.getText().toString().trim();
        }
        if (!txtFecha.getText().toString().isEmpty()){
            fecha = txtFecha.getText().toString().trim();
        }
        if (!txtNip.getText().toString().isEmpty()){
            nipInfrac = txtNip.getText().toString().trim();
        }
        if (cbEstado.getSelectedItemPosition() != 0){
            estado = cbEstado.getSelectedItem().toString().trim();
        }

        if (placa == null && fecha == null && nipInfrac == null && estado == null){
            Toast.makeText(this,"Por favor llene los campos antes de buscar",Toast.LENGTH_SHORT).show();
        }else{
            try {
                this.controladorComparendo.listar(this.lstComparendos, placa, fecha, nipInfrac, estado);
            }catch (Exception e){
                Toast.makeText(this,"Hubo un error al buscar la información requerida",Toast.LENGTH_LONG).show();
            }
        }
    }
}
