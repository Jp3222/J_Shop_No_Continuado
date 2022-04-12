package Modelo;

import Vistas.Vista_Login;
import Vistas.Vista_User_Config;
import com.jsql.conexion.Conexion;
import javax.swing.SwingUtilities;
import com.org.JFiles.Archivos.AText;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Sistema {

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
    
    private final Construir c;
    private Vista_Login login;
    private Vista_User_Config config;
    private Conexion conexion;

    public Sistema() {
        c = Construir.getInstancia();
        if (!init()) {
            config = Vista_User_Config.getNodo();
            build();
        }
    }

    private boolean init() {
        File db = c.getFiles(1);
        if (db.exists()) {
            AText user = new AText();
            String[] info = user.Leer_Archivo(db).split(",");
            conexion = Conexion.getInstancia(info[0], info[1], info[2]);
            conexion.conectar();
            System.out.println(conexion.isConexion());
            return true;
        }
        return false;
    }

    private void build() {
        try {
            
                config.setVisible(true);
                config.wait();
            

            c.run();
            AText user = new AText();
            String text = config.getUser() + "," + config.getPassword() + "," + config.getUrl();
            user.Escribir_Archivo(c.getFiles(1), text);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean run() {
        try {
            login = new Vista_Login();
            Runnable runnable = () -> login.setVisible(true);
            SwingUtilities.invokeLater(runnable);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return false;
        }
    }
}
