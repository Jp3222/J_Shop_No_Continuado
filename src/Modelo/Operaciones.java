package Modelo;

import static Modelo.Objetos.Objeto;
import com.jsql.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jp
 */
public class Operaciones {

    private static Operaciones Nodo;

    public static Operaciones getNodo() {
        if (Nodo == null) {
            Nodo = new Operaciones();
        }
        return Nodo;
    }

    private final Conexion cn = Conexion.getNodo();

    public boolean Inserccion(Objeto o) {
        try {
            if (cn.isConexion()) {
                cn.insert(o.getTabla(), cn.getDatos(o.getInformacion()));
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return false;
    }

    public boolean Eliminacion(Objeto o) {
        try {
            if (cn.isConexion()) {
                cn.DELETE(o.getTabla(), "id = " + o.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean Actualizacion(Objeto o, String[] campo, String[] datos) {
        try {
            if (cn.isConexion()) {
                cn.update(
                        o.getTabla(),
                        cn.getCampos_Columas(campo, datos),
                        "id = " + o.getId()
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ResultSet Consulta(String Tabla, String Campo, String Where) {
        try {
            if (cn.isConexion()) {
                return cn.select(Tabla, Campo, Where);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
