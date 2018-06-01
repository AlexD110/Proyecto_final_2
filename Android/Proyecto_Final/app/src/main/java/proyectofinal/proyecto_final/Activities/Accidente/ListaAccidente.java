package proyectofinal.proyecto_final.Activities.Accidente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import proyectofinal.proyecto_final.Controlador.CtlAccidente;
import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.R;

public class ListaAccidente extends AppCompatActivity {

    private EditText txtPlacaVehiculoAccidente, txtFecha;
    private ListView lstAccidente;

    private CtlAccidente controladorVehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_accidente);

        this.controladorVehiculo = new CtlAccidente(this);

        this.txtPlacaVehiculoAccidente = (EditText) findViewById(R.id.txtPlaca_busquedaAc);
        this.txtFecha = (EditText) findViewById(R.id.txtFecha_busquedaAc);
        this.lstAccidente = (ListView) findViewById(R.id.lstAccidentes);

        this.controladorVehiculo.listar(this.lstAccidente,null,null);
    }

    public void actualizarLista(View view){
        this.controladorVehiculo.listar(this.lstAccidente,null,null);
    }

    public void buscar(View view){
        String placa = null,fecha = null;

        if (!txtPlacaVehiculoAccidente.getText().toString().isEmpty()){
            placa = txtPlacaVehiculoAccidente.getText().toString().trim();
        }
        if (!txtFecha.getText().toString().isEmpty()){
            fecha = txtFecha.getText().toString().trim();
        }

        if (placa == null && fecha == null){
            Toast.makeText(this,"Por favor llene los campos antes de buscar",Toast.LENGTH_SHORT).show();
        }else{
            try {
                this.controladorVehiculo.listar(this.lstAccidente, placa, fecha);
            }catch (Exception e){
                Toast.makeText(this,"Hubo un error al buscar la información requerida",Toast.LENGTH_LONG).show();
            }
        }
    }
}
