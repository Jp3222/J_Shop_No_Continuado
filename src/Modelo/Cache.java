package Modelo;

import java.util.ArrayList;
import Modelo.Objetos.Producto;
import Modelo.Objetos.Objeto;
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
    private final ArrayList<Producto> productos;
    private final Conexion cn;
    
    private Cache() {
        this.proveedores = new ArrayList<>();
        this.productos = new ArrayList<>();
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
    
    public void initProductos() {
        
    }
    
    @SuppressWarnings("null")
    private void init(String Tabla, String[] campos, ArrayList<Objeto> lista) {
        try {
            Objeto o = null;
            switch (Tabla) {
                case "productos" -> o = new Producto(Tabla);
                case "proveedores" -> o = new Proveedores(Tabla);
            }
            int size = campos.length, i;
            ResultSet rs = cn.select(Tabla, "*");
            while (rs.next()) {
                i = 0;
                String objeto[] = new String[size];
                for (String campo : campos) {
                    objeto[i] = rs.getString(campo);
                    i++;
                }
                
                o.setExist(true);
                
                o.setInformacion(objeto);
                
                o.init();
                
                lista.add((Objeto) o.clone());
            }
        } catch (CloneNotSupportedException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Proveedores> getProveedores() {
        return proveedores;
    }
    
    
    
}
