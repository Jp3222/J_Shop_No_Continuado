package jshop.modulo.vistas;

import javax.swing.JFrame;

public abstract class Vista extends JFrame {

    private boolean oscuro;
    private final String Nombre;

    public Vista(String Nombre) {
        this.Nombre = Nombre;
    }

    void Propiedades() {
    }

    public void Fondos() {
    }

    public void ToolTips() {

    }

    public void setOscuro(boolean oscuro) {
        this.oscuro = oscuro;
    }

    public boolean isOscuro() {
        return oscuro;
    }

    public String getNombre() {
        return Nombre;
    }

}
