package Controlador;

import Vistas.Vista_Productos;
import Controlador.con_Administracion.con_Marcas;

/**
 *
 * @author jp
 */
public class Puentes {

    private static Vista_Productos inicio;
    private static con_Administracion.con_Marcas destino;

    public static void setDestino(con_Marcas destino) {
        Puentes.destino = destino;
    }

    public static con_Marcas getDestino() {
        return destino;
    }

    public static void setInicio(Vista_Productos inicio) {
        Puentes.inicio = inicio;
    }

    public static Vista_Productos getInicio() {
        return inicio;
    }

}
