package jshop.modulo.Auxiliares;

import java.util.ArrayList;
import jshop.modulo.Excepciones.EventoException;

/**
 *
 * @author jp
 */
public interface Observale {

    final ArrayList<Observador> lista = new ArrayList<>();

    public default void addObservador(Observador o) {
        lista.add(o);
    }

    public default void removeObservador(Observador o) {
        lista.remove(o);
    }
    
    
    public default void ejecutar() {
        for (Observador observador : lista) {
            observador.event();
        }
    }

}
