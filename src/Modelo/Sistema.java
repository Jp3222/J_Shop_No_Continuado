package Modelo;

import Vistas.Vista_Login;
import Vistas.Vista_User_Config;
import com.jsql.conexion.Conexion;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TimerTask;
import com.org.JFiles.Archivos.Archivos_TEXT;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Cache cache;
    private final String SYSTEM = cons.SYSTEM;
    private String Folder_1, Folder_2;

    private Sistema() {
        switch (SYSTEM.toLowerCase()) {
            case "windows" -> {
                Folder_1 = cons.WINDOWS_ROOT_FOLDER;
                Folder_2 = cons.WINDOWS_USER_DESKTOP;
            }
            case "linux" -> {
                Folder_1 = cons.ZORIN_ROOT_FOLDER;
                Folder_2 = cons.ZORIN_USER_DESKTOP;
            }
        }
        constructor();
    }

    private void constructor() {
        File f = new File(Folder_1 + "/" + cons.ROOT_FILE_USER_DB);
        boolean contruido = f.exists();
        Archivos_TEXT text = new Archivos_TEXT();
        if (!contruido) {
            Vista_User_Config config = new Vista_User_Config();
            System.out.println("1");
            Process o;
            
            synchronized (config) {
                try {
                    config.setVisible(true);
                    System.out.println("1");
                    config.wait();
                    System.out.println("1");

                    construir();
                    System.out.println("1");

                    text.Escribir_Archivo(f, config.getText());
                    System.out.println("1");

                } catch (InterruptedException ex) {
                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        String info[] = text.Leer_Archivo(f, "").split(",");
        //inicia la conexio a la base de datos
        cn = Conexion.getNodo(info[0], info[1], info[2]);
        cn.conectar();
        //Carga datos en memoria para el acceso rapido a ellos
        cache = Cache.getNodo();
        cache.initProveedores();
        cache.initProductos();
        //Inicia la clase de operaciones con distintos objetos
        op = Operaciones.getNodo();
        login = new Vista_Login();
    }

    private void construir() {
        try {
            Queue<File> cola = new LinkedList<>();
            //ficheros del programa
            cola.add(new File(Folder_1 + "/" + cons.ROOT_CACHE));
            cola.add(new File(Folder_1 + "/" + cons.ROOT_IMG));
            cola.add(new File(Folder_1 + "/" + cons.ROOT_BACKUP));
            cola.add(new File(Folder_1 + "/" + cons.ROOT_BACKUP_SQL));
            //ficheros de usuario
            cola.add(new File(Folder_2 + "/" + cons.HISTORIAL));
            cola.add(new File(Folder_2 + "/" + cons.REPORTES));
            cola.add(new File(Folder_2 + "/" + cons.VENTAS));
            //archivos
            cola.add(new File(Folder_1 + "/" + cons.ROOT_FILE_USER_DB));
            int n = cola.size();
            System.out.println(n);
            for (int i = 0; !cola.isEmpty(); i++) {
                File archivo = cola.remove();
                System.out.println(archivo.getPath());
                if (i < 7) {
                    if (!archivo.mkdirs()) {
                        System.err.println("Error la ruta: \n"
                                + archivo.getPath() + "\n"
                                + "Ya ha sido creada o no se puede crear\n");
                    }
                } else {
                    if (!archivo.createNewFile()) {
                        System.err.println("Error el fichero: \n"
                                + archivo.getPath() + "\n"
                                + "Ya ha sido creado o no se puede crear\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {

        }
    }

    public void run() {
        login.setVisible(true);
    }

    private class Tareas extends TimerTask {

        @Override
        public void run() {

        }

    }

    public class Funciones {

        public boolean cierre() {
            return inicio() && fin();
        }

        private boolean inicio() {
            return cl.get(Calendar.HOUR_OF_DAY) > 6;
        }

        private boolean fin() {
            return cl.get(Calendar.HOUR_OF_DAY) < 10;
        }
    }

}
