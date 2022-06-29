package jshop.modulo.modelo.Operaciones;

import java.util.ArrayList;
import jshop.modulo.modelo.Objetos.Objeto;

/**
 *
 * @author jp
 */
public interface Funciones {

    public boolean agregar(String[] o);

    public boolean remover(String where);

    public boolean actualizar(String campos[], String valores[], String where);

    public boolean actualizar(String campos, String valores, String where);

    public <T extends Objeto> ArrayList<T> getLista(String where);

    public <T extends Objeto> T getObjeto(String where);

}
