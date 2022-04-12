package Modelo;

import java.util.ArrayList;
import Modelo.Objetos.Producto;
import com.jsql.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Cache {
    
    private static final Cache instancia = new Cache();
    
    public static Cache getInstancia() {
        return instancia;
    }
    
    private final ArrayList<Producto> productos;
    private final Conexion cn = Conexion.getInstancia();
    
    private Cache() {
        productos = new ArrayList<>();
        Productos();
    }

    private void Productos() {
        try {
            ResultSet select = cn.select("productos");
            while (select.next()) {
                Producto p = new Producto();
                p.setId(select.getInt("id"));
                p.setClave(select.getString("clave"));
                p.setNombre(select.getString("nombre"));
                p.setProveedor(select.getString("proveedor"));
                p.setContenido(select.getString("cont"));
                p.setUdm(select.getString("udm"));
                p.setPrecio(select.getString("precio"));
                p.setImg(select.getString("img"));
                productos.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reiniciarProductos() {
        Productos();
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public int sort(Producto x, Producto y) {
        if (x.getId() > y.getId()) {
            return 1;
        } else if (x.getId() < y.getId()) {
            return -1;
        }
        return 0;
    }
}
