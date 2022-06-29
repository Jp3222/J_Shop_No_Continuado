package jshop.modulo.modelo.Operaciones;

import java.util.ArrayList;
import jshop.modulo.modelo.Objetos.Objeto;

/**
 *
 * @author jp
 */
public class OperacionesInventario extends Operaciones implements Funciones {

    private final String TABLA = "inventario";
    private final String[] CAMPOS = {"id", "producto", "piezas", "fecha_ingreso"};

    @Override
    public boolean agregar(String[] o) {
        return super.add(TABLA, CAMPOS, o);
    }

    @Override
    public boolean remover(String where) {
        return super.remove(TABLA, where);
    }

    @Override
    public boolean actualizar(String[] campos, String[] valores, String where) {
        return super.update(TABLA, campos, valores, where);
    }

    @Override
    public boolean actualizar(String campos, String valores, String where) {
        return super.update(TABLA, campos, valores, where);
    }

    @Override
    public <T extends Objeto> ArrayList<T> getLista(String where) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T extends Objeto> T getObjeto(String where) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
