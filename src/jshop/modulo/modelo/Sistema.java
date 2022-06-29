package jshop.modulo.modelo;

import jshop.modulo.vistas.Vista_Login;
import jshop.modulo.Vista_User_Config;
import com.jsql.conexion.Conexion;
import javax.swing.SwingUtilities;
import com.org.JFiles.Archivos.AText;
import java.io.File;
import javax.swing.JOptionPane;
import jshop.modulo.modelo.Objetos.OEmpleado;

/**
 *
 * @author jp
 */
public final class Sistema {

    /**
     * instancia del sistema
     */
    private static final Sistema Nodo = new Sistema();

    /**
     * @return una instancia del sistema
     */
    public static Sistema getNodo() {
        return Nodo;
    }
    //
    private final ConstructorDeArchivos c;
    //
    private final Vista_User_Config CONFIG;
    //
    private final String ExepcionSistema;
    //
    private Conexion conexion;
    private Cache cache;
    private Vista_Login login;
    private OEmpleado empleadoSystema;

    public Sistema() {
        ExepcionSistema = "Exepcion en la clase Sistema";
        c = ConstructorDeArchivos.getInstancia();
        CONFIG = Vista_User_Config.getInstancia();
        if (!init()) {
            Contruir();
        }
    }

    private synchronized boolean init() {
        File db = c.getFiles(1);
        if (db.exists()) {
            AText user = new AText();
            String[] info = user.Leer_Archivo(db).split(",");
            //inicializacion de la base de datos
            conexion = Conexion.getInstancia(info[0],info[1],info[2]);
            //inicializacion de la memoria cache
            cache = Cache.getInstancia();
            return true;
        }
        return false;
    }

    private synchronized void Contruir() {
        try {
            synchronized (CONFIG) {
                CONFIG.setVisible(true);
                CONFIG.wait();
            }
            c.run();
            AText user = new AText();
            String text = CONFIG.getUser() + "," + CONFIG.getPassword() + "," + CONFIG.getUrl();
            user.Escribir_Archivo(c.getFiles(1), text);
            init();
        } catch (InterruptedException e) {
            System.out.println(ExepcionSistema + " metodo build");
            System.out.println(e.getMessage());
        }

    }

    public synchronized boolean run() {
        try {
            login = new Vista_Login();
            Runnable runnable = () -> login.setVisible(true);
            SwingUtilities.invokeLater(runnable);
            return true;
        } catch (Exception e) {
            System.out.println(ExepcionSistema + " metodo run");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Algo ah fallado", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            return false;
        }
    }

    public void setEmpleadoSystema(OEmpleado empleadoSystema) {
        this.empleadoSystema = empleadoSystema;
    }

    public OEmpleado getEmpleadoSystema() {
        return empleadoSystema;
    }

}
