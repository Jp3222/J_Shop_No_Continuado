package Modelo;

import Vistas.Vista_Login;
import com.jsql.conexion.Conexion;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TimerTask;

/**
 *
 * @author jp
 */
public class Sistema {

    private static final Sistema Nodo = new Sistema();

    public static Sistema getNodo() {
        return Nodo;
    }

    private Conexion cn;
    private Operaciones op;
    private Calendar cl;
    private Tareas t;
    private Vista_Login login;
    private Sistema() {
        constructor();
    }

    private void constructor() {
        cn = Conexion.getNodo("root", "12345", Conexion.getLOCAL_URL("jshop"));
        cn.conectar();
        op = Operaciones.getNodo();
        login =  new Vista_Login();
    }

    public void run() {
        login.setVisible(true);
    }

    private class Tareas extends TimerTask {

        @Override
        public void run() {

        }

    }

}
