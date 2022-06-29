package jshop.modulo.modelo;

import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 *
 * @author jp
 */
public class Const {

    //Expresiones reguales
    public static final String REGEX_NUMEROS_INT_POSITIVOS = "([0-9]*)";
    public static final String REGEX_NUMEROS_DOUBLE = REGEX_NUMEROS_INT_POSITIVOS + "|" + REGEX_NUMEROS_INT_POSITIVOS + "." + REGEX_NUMEROS_INT_POSITIVOS;
    public static final String REGEX_TEXTO = "[a-zA-Z]";
    public static final String REGEX_TEXTO_Y_ESPACIOS = "(" + REGEX_TEXTO + " )*";

    //--Diseño--//
    public static final LineBorder BORDER_BLACK = new LineBorder(Color.BLACK);
    public static final LineBorder BORDER_RED = new LineBorder(Color.RED);
    public static final Color C = new Color(207, 207, 207);
    private static final String ID = "id";
    private static final String NOMBRE = "nombre";

    //--- BD ---//
    private static final String[] BD_EMPLEADOS = {
        ID, NOMBRE, "ap", "am", "cargo", "usuario", "contra"
    };
    private static final String[] BD_PRODUCTOS = {
        ID, "clave", NOMBRE, "marca", "contenido", "udm", "precio", "img"
    };
    private static final String[] BD_HISTORIAL = {
        "id", "fecha", "hora", "usuario", "movimiento"
    };
    private static final String[] BD_MARCAS = {
        "id", NOMBRE
    };
    private static final String[] BD_MOVIMIENTOS = {
        ID
    };
    private static final String[] BD_PROVEEDORES = {
        ID, NOMBRE, "productos"
    };
    private static final String[] DIAS_SEMANA = {
        "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
    };
    private static final String[] MESES = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    public static String getDia(int index) {
        return DIAS_SEMANA[index];
    }

    public static String getMes(int index) {
        return MESES[index];
    }

    private static final String[] MOVIMIENTOS_TIPOS = {
        "Inicio de sesion",
        "Cierre de sesion",
        "Nueva venta",
        "Venta cancelada",
        "Nuevo Registro",
        "Eliminacion de un registro",
        "Actualizacion de un registro"
    };

    public static LineBorder getBORDER_BLACK() {
        return BORDER_BLACK;
    }

    public static LineBorder getBORDER_RED() {
        return BORDER_RED;
    }

    public static String[] getBD_EMPLEADOS() {
        return BD_EMPLEADOS;
    }

    public static String[] getBD_PRODUCTOS() {
        return BD_PRODUCTOS;
    }

    public static String[] getBD_MOVIMIENTOS() {
        return BD_MOVIMIENTOS;
    }

    public static String[] getBD_PROVEEDORES() {
        return BD_PROVEEDORES;
    }

    public static String[] getBD_HISTORIAL() {
        return BD_HISTORIAL;
    }

    public static String[] getBD_MARCAS() {
        return BD_MARCAS;
    }

    public static String[] getDIAS_SEMANA() {
        return DIAS_SEMANA;
    }

    public static String[] getMESES() {
        return MESES;
    }

    public static String[] getMOVIMIENTOS_TIPOS() {
        return MOVIMIENTOS_TIPOS;
    }
}
