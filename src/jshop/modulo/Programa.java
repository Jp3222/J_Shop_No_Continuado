/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jp
 */
public class Programa {

    private static final ImageIcon ICONO = new ImageIcon(Programa.class.getResource("/Icons/Ico/JSHOP_2.png"));
    private static final String NOMBRE = "JShop";
    private static final String VERSION = "1";
    private static final String[] SECCIONES = {
        "Inicio de sesion", "Menu", "Administracion", "Productos", "Empleados"
    };

    /**
     * Metodo para definir el titulo segun la seccion en la que esta el usuario
     *
     * @param seccion indice que indica la secion
     * @return una cadena que representa el titulo de JFrame
     * <br> 0 Inicio de sesion
     * <br> 1 Menu
     * <br> 2 Administracion
     * <br> 3 Productos
     * <br> 4 Empleados
     */
    public static String getTitulo(int seccion) {
        return SECCIONES[seccion] + " - " + NOMBRE + " " + VERSION;
    }

    public static Image getICONO() {
        return ICONO.getImage();
    }

}
