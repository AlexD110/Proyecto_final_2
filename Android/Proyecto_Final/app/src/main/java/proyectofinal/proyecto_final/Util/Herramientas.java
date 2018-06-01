package proyectofinal.proyecto_final.Util;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public abstract class Herramientas {

    public static Object objeto;

    public static Object getObjeto() {
        return objeto;
    }

    public static void setObjeto(Object objeto) {
        Herramientas.objeto = objeto;
    }

    public static String codificar(String texto) throws UnsupportedEncodingException {
        return Base64.encodeToString(texto.getBytes("UTF-8"),Base64.DEFAULT);
    }
}
