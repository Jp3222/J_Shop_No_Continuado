package Modelo;

import java.awt.Color;

/**
 *
 * @author jp
 */
public class Colores {

    private static Colores instancia;
    private final boolean oscuro;

    public static Colores getInstancia(boolean oscuro) {
        if (instancia == null) {
            instancia = new Colores(oscuro);
        }
        return instancia;
    }

    public static Colores getInstancia() {
        return instancia;
    }

    private Color border;
    private Color border2;
    private Color background;
    private Color background2;
    private Color front;

    private Colores(boolean oscuro) {
        this.oscuro = oscuro;
    }

    private void modoClaro() {
        border = Color.black;
        front = Color.white;
        background = new Color(168, 168, 168);
        background2 = new Color(132, 132, 132);
    }

    private void modoOscuro() {
        border = Color.black;
        border2 = new Color(0, 107, 255);
        front = Color.white;
        background = new Color(35, 35, 40);
        background2 = new Color(30, 30, 40);
    }

    public void init() {
        if (oscuro) {
            modoOscuro();
        } else {
            modoClaro();
        }
    }

    public Color getBorder() {
        return border;
    }

    public Color getFront() {
        return front;
    }

    public Color getBackground() {
        return background;
    }

    public Color getBackground2() {
        return background2;
    }

}
