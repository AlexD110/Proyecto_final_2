package proyectofinal.proyecto_final.Activities.Comparendo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import proyectofinal.proyecto_final.Controlador.CtlComparendo;
import proyectofinal.proyecto_final.R;
import proyectofinal.proyecto_final.Util.Herramientas;

public class VerComparendo extends AppCompatActivity {

    private HashMap<Integer,String> comparendos;
    private TextView lblComparendo;
    private int idComparendo;
    private CtlComparendo controladorComparendo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_comparendo);

        this.controladorComparendo = ((CtlComparendo)Herramientas.getObjeto());

        this.comparendos = (HashMap<Integer, String>) this.controladorComparendo.getComparendos();

        Bundle bundle = this.getIntent().getExtras();

        String comparendoString = bundle.get("comparendo").toString();

        this.lblComparendo = (TextView) findViewById(R.id.lblComparendo_ver_comparendo);

        this.ponerDetalleComparendo(comparendoString);
    }

    private void ponerDetalleComparendo(String comparendo){
        try{
            this.idComparendo = Integer.parseInt(comparendo.split(" - ")[0]);
            this.lblComparendo.setText(this.comparendos.get(this.idComparendo));
        }catch (Exception e){
            Toast.makeText(this,"Hubo un error cargando la información.",Toast.LENGTH_LONG).show();
        }
    }

    public void cancelar(View view){
        this.finish();
    }

    public void anularComparendo(View view){
        this.controladorComparendo.modificar(this.idComparendo,"ANULADO");
    }

    public void habilitarComparendo(View view){
        this.controladorComparendo.modificar(this.idComparendo,"HABILITADO");
    }
}
