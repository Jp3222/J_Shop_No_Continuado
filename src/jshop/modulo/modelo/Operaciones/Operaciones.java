package jshop.modulo.modelo.Operaciones;

import com.jsql.conexion.Conexion;
import java.sql.ResultSet;
import jshop.modulo.modelo.func;

/**
 *
 * @author jp
 */
public abstract class Operaciones {

    private final Conexion cn = Conexion.getInstancia();

    protected boolean add(String tabla, String[] columnas, String[] o) {
        return cn.insert(tabla, cn.getCampos(func.exp(columnas, 0)), cn.getDatos(func.exp(o, 0)));

    }

    protected boolean remove(String tabla, String where) {
        return cn.delete(tabla, where);
    }

    protected boolean update(String tabla, String[] campos, String[] valores, String where) {
        return cn.update(tabla, cn.getCampos_Datos(campos, valores), where);
    }

    protected boolean update(String tabla, String campo, String valor, String where) {
        return cn.update(tabla, campo, valor, where);
    }

    protected ResultSet get(String tabla, String campos, String where) {
        return cn.select(tabla, campos, where);
    }

    public Conexion getCn() {
        return cn;
    }

}
