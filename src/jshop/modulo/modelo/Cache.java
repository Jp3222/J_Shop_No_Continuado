package jshop.modulo.modelo;

import jshop.modulo.modelo.Objetos.OProducto;
import java.util.ArrayList;
import com.jsql.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import jshop.modulo.modelo.Objetos.OMarcas;

/**
 *
 * @author jp
 */
public class Cache {

    private static Cache instancia;

    public static Cache getInstancia() {
        if (instancia == null) {
            instancia = new Cache();
        }
        return instancia;
    }

    private final ArrayList<OProducto> productos;
    private final ArrayList<OMarcas> marcas;
    private final Conexion cn = Conexion.getInstancia();

    private Cache() {
        productos = new ArrayList<>();
        marcas = new ArrayList<>();
        initProductos();
        initMarcas();
    }

    private void initProductos() {
        try {
            ResultSet select = cn.select("productos");
            while (select.next()) {
                OProducto p = new OProducto();
                p.setId(select.getInt("id"));
                p.setClave(select.getString("clave"));
                p.setNombre(select.getString("nombre"));
                p.setMarca(select.getInt("marca"));
                p.setContenido(select.getString("contenido"));
                p.setUdm(select.getString("udm"));
                p.setPrecio(select.getDouble("precio"));
                p.setImg(select.getString("img"));
                productos.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void reiniciarProductos() {
        while (!productos.isEmpty()) {
            productos.remove(0);
        }
        initProductos();
    }

    private void initMarcas() {
        try {
            ResultSet select = cn.select("marcas");
            while (select.next()) {
                String[] info = new String[2];
                info[0] = "" + select.getInt("id");
                info[1] = "" + select.getString("nombre");
                marcas.add(new OMarcas(info));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void reiniciarMarcas() {
        while (marcas.isEmpty()) {
            marcas.remove(0);
        }
        initMarcas();
    }

    public ArrayList<OProducto> getProductos() {
        return productos;
    }

    public ArrayList<OMarcas> getMarcas() {
        return marcas;
    }

}
