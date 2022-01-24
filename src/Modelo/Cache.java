package Modelo;

import java.util.ArrayList;
import Modelo.Objetos.Proveedores;
import com.jsql.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Cache {

    private static final Cache Nodo = new Cache();

    public static Cache getNodo() {
        return Nodo;
    }

    private final ArrayList<Proveedores> proveedores;
    private final Conexion cn;

    private Cache() {
        this.proveedores = new ArrayList<>();
        this.cn = Conexion.getNodo();
    }

    public void initProveedores() {
        try {
            ResultSet select = cn.select("proveedores", "*");
            final int size = cons.PROVEEDORES.length;
            int i;
            while (select.next()) {
                String[] proveedor = new String[size];
                i = 0;
                for (String string : cons.PROVEEDORES) {
                    proveedor[i] = select.getString(string);
                    i++;
                }
                Proveedores pro = new Proveedores("proveedores");
                pro.setExist(true);
                pro.setInformacion(proveedor);
                pro.init();
                this.proveedores.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cache.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
