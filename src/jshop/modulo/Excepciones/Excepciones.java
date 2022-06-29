package jshop.modulo.Excepciones;

/**
 *
 * @author jp
 */
public abstract class Excepciones extends Exception {

    private static String Excepcion(String clase, String error) {
        return "Error en la clase: " + clase + "\nProble ocurrido" + error;
    }

    public Excepciones(String error, String clase, String causa) {
        super(Excepcion(error, clase), new Throwable(causa));
    }

}
