package Modelo;

import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 *
 * @author jp
 */
public class cons {

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
}
