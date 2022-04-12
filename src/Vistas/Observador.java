package Vistas;

public class Observador {

    private static Observador instacia;

    public static Observador getInstacia() {
        if (instacia == null) {

        }
        return instacia;
    }

    public boolean event() {
        return true;
    }

}
