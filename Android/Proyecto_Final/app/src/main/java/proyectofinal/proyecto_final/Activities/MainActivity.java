package proyectofinal.proyecto_final.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import proyectofinal.proyecto_final.Controlador.CtlUsuario;
import proyectofinal.proyecto_final.R;

public class MainActivity extends AppCompatActivity {

    private CtlUsuario controladorUsuario;
    private EditText txtNombreUsu, txtContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.controladorUsuario = new CtlUsuario();

        this.txtNombreUsu = (EditText) findViewById(R.id.txtNombeUsuario);
        this.txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
    }

    public void ingresar(View view) {
        String nombreUsuario, contrasenia;
        try {
            nombreUsuario = txtNombreUsu.getText().toString().trim();
            contrasenia = txtContrasenia.getText().toString().trim();

            this.controladorUsuario.iniciarSesion(nombreUsuario,contrasenia,this);
        } catch (Exception e) {
            Toast.makeText(this, "No se ha podido iniciar sesion", Toast.LENGTH_LONG).show();
        }
    }
}
