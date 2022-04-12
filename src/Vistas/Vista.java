package Vistas;

import javax.swing.JFrame;

public abstract class Vista extends JFrame {

    private boolean oscuro;
    private final String Nombre;

    public Vista(String Nombre) {
        this.Nombre = Nombre;
    }

    protected abstract void initVariables();


    protected abstract void addListerners();

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
