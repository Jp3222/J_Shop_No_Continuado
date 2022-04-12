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
        "nombre",
        "productos"
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
