package Modelo;

import static Modelo.Objetos.Objeto;
import static Modelo.Objetos.Producto;
import static Modelo.Objetos.Empleado;
import com.jsql.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Operaciones {

    private static final Productos productos = new Productos();

    private static final Empleados empleados = new Empleados();

    private static final Marcas marcas = new Marcas();

    public static Productos getProductos() {
        return productos;
    }

    public static Empleados getEmpleados() {
        return empleados;
    }

    public static Marcas getMarcas() {
        return marcas;
    }

    private static abstract class Funcciones {

        protected final Conexion cn;

        public Funcciones() {
            this.cn = Conexion.getInstancia();
        }

        public abstract boolean update(int index, String[] campos, String[] datos);

        public abstract <T extends Objeto> boolean push(T o);

        public abstract <T> T get(int type, String key);

        public abstract boolean delete(int index);

        public Conexion getCn() {
            return cn;
        }

    }

    public static class Productos extends Funcciones {

        private final String Tabla = "productos";

        @Override
        public boolean update(int index, String[] campos, String[] datos) {
            try {
                cn.update(Tabla,
                        cn.getCampos_Datos(campos, datos),
                        "id = '" + index + "'"
                );
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } finally {
                cn.close();
            }
            return false;
        }

        @Override
        public <T extends Objeto> boolean push(T o) {
            
            return false;
        }

        /**
         * @param type el tipo de parametro con el cual se buscara el objeto
         * <br>1.- id
         * <br>2.- clave
         * <br>3.- nombre
         * @param key el valor con el cual se va a buscar el objeto
         * @return un objeto de tipo producto
         */
        @Override
        public Producto get(int type, String key) {
            Producto o;
            String search = "";
            switch (type) {
                case 1:
                    search = "id";
                    break;
                case 2:
                    search = "clave";
                    break;
                case 3:
                    search = "nombre";
                    break;
                default:
                    System.out.println("error");
            }

            try {
                ResultSet rs = cn.select(Tabla, "*", search + " = '" + key + "'");
                if (rs.next()) {
                    o = new Producto();
                    o.setId(rs.getInt("id"));
                    o.setClave(rs.getString("clave"));
                    o.setNombre(rs.getString("nombre"));
                    o.setProveedor(rs.getString("proveedor"));
                    o.setContenido(rs.getString("contenido"));
                    o.setUdm(rs.getString("udm"));
                    o.setPrecio(rs.getString("rs"));
                    o.setImg(rs.getString("img"));
                    return o;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } finally {
                cn.close();
            }
            return null;
        }

        @Override
        public boolean delete(int index) {

            return true;
        }

    }

    public static class Empleados extends Funcciones {

        private final String tabla = "empleados";

        @Override
        public boolean update(int index, String[] campos, String[] datos) {
            try {
                cn.update(tabla, cn.getCampos_Datos(campos, datos), "id = '" + index + "'");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } finally {
                cn.close();
            }
            return false;
        }

        @Override
        public boolean push(Objeto o) {
            try {
                cn.insert("productos",
                        cn.getColumnas(Const.PRODUCTOS),
                        cn.getDatos(func.exp(o.getDatos(), 0))
                );
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                cn.close();
            }
            return false;
        }

        @Override
        public Empleado get(int type, String key) {
            String campo = "";
            switch (type) {
                case 1:
                    campo = "id";
                    break;
                case 2:
                    campo = "nombre";
                default:
                    System.out.println("error");
            }
            try {
                ResultSet select = cn.select(tabla, "*", campo + "='" + key + "'");
                if (select.next()) {
                    Empleado o = new Empleado();
                    o.setId(select.getInt("id"));
                    o.setNombre(select.getString("nombre"));
                    o.setA_paterno(select.getString("ap"));
                    o.setA_materno(select.getString("am"));
                    o.setUsuario("usuario");
                    o.setContraseña("contra");
                    return o;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cn.close();
            }
            return null;
        }

        @Override
        public boolean delete(int index) {
            return false;
        }
    }

    public static class Marcas {
    }
}
