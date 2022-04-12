package Modelo;

import java.awt.Color;
import javax.swing.border.LineBorder;
import com.org.JFiles.Systema.So;
import java.io.File;

/**
 *
 * @author jp
 */
public class Const {

    public static final File[] SYSTEM_DIRS = {
        new File(So.USUARIO_DIR_INICIO + "/Documentos"),
        new File(So.USUARIO_DIR_INICIO + "/Documents"),
        new File(So.USUARIO_DIR_INICIO + "/Escritorio"),
        new File(So.USUARIO_DIR_INICIO + "/Desktop"),
        new File(""),
        new File("")
    };

    public static final File[] SYSTEM_FILES = {
        new File(So.USUARIO_DIR_INICIO + "/Documentos/jshop/.cache"),
        new File(""),
        new File(""),
        new File(""),
        new File(""),
        new File("")
    };

    public static final String SYSTEM = So.SO_NOMBRE;
    public static final String SYSTEM_ARCH = So.SO_ARQ;
    public static final String SYSTEM_VERSION = So.SO_VERSION;
    public static final String SYSTEM_LANGUAJE = So.USUARIO_LENGUAGE;

    //Archivos del programa
    public static String getROOT_FOLDER() {
        String root = So.USUARIO_DIR_INICIO;
        String FolderName = SYSTEM_LANGUAJE.equals("es") ? "Documentos" : "Documents";
        switch (SYSTEM.toLowerCase()) {
            case "linux":
                root += "/" + FolderName + "/.J-Shop";
                break;

            case "windows":
                root += "/Documents/.J-Shop";
                break;

            default:
                System.out.println("Ubicacion no disponible2");
        }
        return root;

    }

    public static final String ROOT_FOLDER = getROOT_FOLDER();

    //Archivos del programa
    public static final String ROOT_CACHE = ROOT_FOLDER + "/.cache";
    public static final String ROOT_IMG = ROOT_CACHE + "/img";
    public static final String ROOT_BACKUP = ROOT_CACHE + "/docs";
    public static final String ROOT_BACKUP_SQL = ROOT_CACHE + "/sql";
    public static final String FILE_ROOT_USER_DB = ROOT_CACHE + "/user.jshop";

    public static final String DESKTOP_FOLDER = getDESKTOP_FOLDER();

    public static String getDESKTOP_FOLDER() {
        String root = So.USUARIO_DIR_INICIO;
        String FolderName = SYSTEM_LANGUAJE.equals("es") ? "Documentos" : "Documents";
        System.out.println(root);
        switch (SYSTEM.toLowerCase()) {
            case "linux":
                root += "/" + FolderName + "/J-Shop";
                break;
            case "windows":
                root += "/Desktop/J-Shop";
                break;
        }
        return root;
    }
    //

    //
    public static final String HISTORIAL = DESKTOP_FOLDER + "/Historial de movimientos";
    public static final String VENTAS = DESKTOP_FOLDER + "/Historial de ventas";
    public static final String REPORTES = DESKTOP_FOLDER + "/Resportes generados";

    //--Diseño--//
    public static final LineBorder BORDER_BLACK = new LineBorder(Color.BLACK);
    public static final LineBorder BORDER_RED = new LineBorder(Color.RED);

    //--- BD ---//
    public static final String[] EMPLEADOS = {
        "id",
        "usuario",
        "pass",
        "nombre",
        "apaterno",
        "amaterno"
    };

    public static final String[] PRODUCTOS = {
        "id",
        "clave",
        "nombre",
        "marca",
        "contenido",
        "udm",
        "precio",
        "img"
    };

    public static final String[] MOVIMIENTOS = {};

    public static final String[] PROVEEDORES = {
        "id",
        "marca",
        "no_prod"
    };
    //
    public static final String[] DIAS_SEMANA = {
        "Domingo",
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado"
    };

    public static final String[] MESES = {
        "Enero",
        "Febrero",
        "Marzo",
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    };

    public static String getDia(int index) {
        return DIAS_SEMANA[index];
    }

    public static String getMes(int index) {
        return MESES[index];
    }

    public static final String[] MOVIMIENTOS_TIPOS = {
        "Inicio de sesion",
        "Cierre de sesion",
        "Nueva venta",
        "Venta cancelada",
        "Nuevo Registro",
        "Eliminacion de un registro",
        "Actualizacion de un registro"
    };
}
