package Modelo;

import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 *
 * @author jp
 */
public class cons {

    //home
    public static final String HOME = System.getProperty("user.home");

    //Zorin OS
    public static final String ZORIN_ROOT_FOLDER = HOME + "/Documentos/J-Shop";
    //WindOS
    public static final String WINDOWS_ROOT_FOLDER = HOME + "/Desktop/J-Shop";

    //Archivos del programa
    public static final String ROOT_CACHE = "/.cache";
    public static final String ROOT_IMG = ROOT_CACHE + "/img";
    public static final String ROOT_BACKUP = ROOT_CACHE + "/docs";
    public static final String ROOT_BACKUP_SQL = ROOT_CACHE + "/sql";

    //Archivos de usuario
    public static final String USER_ROOT = HOME + "/Escritorio/J-Shop";
    public static final String HISTORIAL = USER_ROOT + "/Historial de movimientos";
    public static final String VENTAS = USER_ROOT + "/Historial de ventas";
    public static final String REPORTES = USER_ROOT + "/Resportes generados";

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
