package proyectofinal.proyecto_final.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import proyectofinal.proyecto_final.Activities.Accidente.ListaAccidente;
import proyectofinal.proyecto_final.Activities.Accidente.MapaAccidente;
import proyectofinal.proyecto_final.Activities.Accidente.RegistroAccidente;
import proyectofinal.proyecto_final.Activities.Comparendo.BusquedaComparendo;
import proyectofinal.proyecto_final.Activities.Comparendo.RegistrarComparendo;
import proyectofinal.proyecto_final.Activities.Persona.RegistroPersonas;
import proyectofinal.proyecto_final.Activities.Vehiculo.RegistroVehiculo;
import proyectofinal.proyecto_final.Controlador.CtlUsuario;
import proyectofinal.proyecto_final.R;

public class Menu extends AppCompatActivity {

    private String usuario,cedula;
    private TextView lblCedula,lblUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle bundle = getIntent().getExtras();

        cedula = bundle.getString("cedula");
        usuario = bundle.getString("nombreUsuario");

        lblCedula = (TextView) findViewById(R.id.txtCedula_menu);
        lblCedula.setText(cedula);

        lblUsuario = (TextView) findViewById(R.id.txtUsuario_menu);
        lblUsuario.setText(usuario);

        CtlUsuario.objResponse = new JSONObject();
    }


    public void RCiudadano(View view){
        startActivity(new Intent(this,RegistroPersonas.class));
    }

    public void RVehiculo(View view){
        startActivity(new Intent(this,RegistroVehiculo.class));
    }
    public void RComparendo(View view){
        Intent intent = new Intent(this,RegistrarComparendo.class);
        intent.putExtra("cedulaAgente",cedula);
        startActivity(intent);
    }
    public void CComparendo(View view){
        startActivity(new Intent(this,BusquedaComparendo.class));
    }
    public void RAcciodente(View view){
        Intent intent = new Intent(this,RegistroAccidente.class);
        intent.putExtra("cedulaAgente",cedula);
        startActivity(intent);
    }
    public void CAccidente(View view){
        startActivity(new Intent(this, ListaAccidente.class));
    }
    public void MMapa(View view){
        startActivity(new Intent(this, MapaAccidente.class));
    }
}
