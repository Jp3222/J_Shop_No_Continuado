package jshop.modulo.modelo.Operaciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jshop.modulo.modelo.Const;
import jshop.modulo.modelo.Objetos.OProducto;

/**
 *
 * @author jp
 */
public class OperacionesProductos extends Operaciones implements Funciones {

    public final String TABLA = "productos";
    private final String CAMPOS[] = Const.getBD_PRODUCTOS();

    @Override
    public boolean agregar(String[] o) {
        return super.add(TABLA, CAMPOS, o);
    }

    @Override
    public boolean remover(String where) {
        return super.remove(TABLA, where);
    }

    @Override
    public boolean actualizar(String campos[], String valores[], String where) {
        return super.update(TABLA, campos, campos, where);
    }

    @Override
    public boolean actualizar(String campo, String valor, String where) {
        return super.update(TABLA, campo, valor, where);
    }

    @Override
    public ArrayList<OProducto> getLista(String where) {
        try {
            ResultSet rs = super.get(TABLA, "*", where);
            ArrayList<OProducto> lista = new ArrayList<>();
            int i;
            while (rs.next()) {
                i = 0;
                String[] o = new String[CAMPOS.length];
                for (String campo : CAMPOS) {
                    o[i] = rs.getString(campo);
                }
                OProducto p = new OProducto(o);
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public OProducto getObjeto(String where) {
        try {
            ResultSet rs = super.get(TABLA, "*", where);

            if (rs.next()) {
                int i = 0;
                String[] o = new String[CAMPOS.length];
                for (String campo : CAMPOS) {
                    o[i] = rs.getString(campo);
                }
                OProducto p = new OProducto(o);
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
