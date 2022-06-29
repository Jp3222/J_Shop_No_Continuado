package jshop.modulo.controlador;

import jshop.modulo.vistas.Vista_Administracion;
import jshop.modulo.vistas.Vista_Menu;
import com.jsql.conexion.Conexion;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jshop.modulo.Auxiliares.Observador;
import jshop.modulo.Auxiliares.Observale;
import jshop.modulo.modelo.Cache;
import jshop.modulo.modelo.Const;
import jshop.modulo.modelo.Objetos.OProducto;
import jshop.modulo.modelo.Operaciones.OperacionesMarcas;
import jshop.modulo.modelo.Operaciones.OperacionesProductos;
import jshop.modulo.modelo.func;
import jshop.modulo.vistas.Vista_Productos;

/**
 *
 * @author jp
 */
public class Con_Administracion extends Controlador {

    private final Vista_Administracion administracion;
    private Vista_Menu menu;
    private final Conexion cn;
    //
    private Vista_Productos vista_Productos;
    //
    private Con_Marcas con_marcas;
    private Con_Inventario inventario;

    public Con_Administracion(Vista_Administracion administracion) {
        this.administracion = administracion;
        cn = Conexion.getInstancia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "b1":
                irProductos();
                break;
            case "b2":
                irEmpleados();
                break;
            case "b4":
                Salir();
                break;
        }
    }

    public void irProductos() {
        administracion.dispose();
        vista_Productos.setVisible(true);
    }

    public void irEmpleados() {
        System.out.println("Empleados");
    }

    public void Salir() {
        administracion.dispose();
        con_marcas.removerTodos();
        menu.setVisible(true);
    }

    public void setMenu(Vista_Menu menu) {
        this.menu = menu;
    }

    public void setVista_Productos(Vista_Productos vista_Productos) {
        this.vista_Productos = vista_Productos;
    }

    public Con_Marcas getCon_marcas(Observador o, DefaultTableModel tb) {
        if (con_marcas == null) {
            con_marcas = new Con_Marcas(o, tb);
        }
        return con_marcas;
    }

    public Con_Inventario getInventario(DefaultTableModel tb) {
        if (inventario == null) {
            inventario = new Con_Inventario(tb);
        }
        return inventario;
    }

    public class Con_Marcas extends Controlador implements Observale {

        private Observador o;
        private DefaultTableModel tb;
        OperacionesMarcas operacionesMarcas;
        OperacionesProductos operacionesProductos;

        public Con_Marcas(Observador o, DefaultTableModel tb) {
            this.tb = tb;
            operacionesMarcas = new OperacionesMarcas();
            this.addObservador(o);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            switch (e.getActionCommand()) {
                case "b1":
                    Nueva();
                    break;
                case "b2":
                    Eliminar();
                    break;
                case "b3":
                    Actualizar();
                    break;
            }

        }

        public void Nueva() {
            String marca = JOptionPane.showInputDialog(null, "Ingresa una nueva Marca");
            if (marca == null) {
                JOptionPane.showMessageDialog(null, "Operacion Cancelaa");
                return;
            }
            if (marca.isEmpty()) {
                return;
            }
            String[] info = {"0", marca};
            func.LimpiarDatos(info);
            operacionesMarcas.agregar(info);
            ejecutar();
            Actualizar_Tabla();
        }

        public void Eliminar() {
            int marca = administracion.getMarca();
            int id = Integer.parseInt("" + tb.getValueAt(marca, 0));
            String nombre = (String) tb.getValueAt(marca, 1);
            int i = JOptionPane.showConfirmDialog(null, "Desea eliminar la marca " + nombre + " con el id " + id
                    + "\nesto aplicara para todos los productos");
            switch (i) {
                case JOptionPane.YES_OPTION:
                    operacionesProductos.remover("marca = " + id);
                    operacionesMarcas.remover("id = '" + id + "'");
                    break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(null, "La marca " + nombre + " no sera eliminada");
                    break;
                case JOptionPane.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(null, "Operacion cancelada");
                    break;
            }
            ejecutar();
            Actualizar_Tabla();
        }

        public void Actualizar() {
            String id = JOptionPane.showInputDialog(null, "Ingrese el id de la marca");
            System.out.println(id);
            if (id == null) {
                JOptionPane.showMessageDialog(null, "Operacion Cancelaa");
                return;
            }
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Id no valido");
                return;
            }
            String valor = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de la marca");
            valor = func.Filtro_Entrada(valor);
            boolean actualizar = operacionesMarcas.actualizar("nombre", valor, "id = '" + id + "'");
            if (actualizar) {
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la marca de todos los productos en este momento?");
                if (showConfirmDialog == JOptionPane.YES_OPTION) {
                    OperacionesProductos act = new OperacionesProductos();
                    act.actualizar("marca", valor, "where marca = 'marca'");
                }
            }
            ejecutar();
            Actualizar_Tabla();
        }

        public void Actualizar_Tabla() {
            try {
                removerTodos();
                ResultSet select = cn.select("marcas");
                while (select.next()) {
                    String[] xd = new String[2];
                    xd[0] = select.getString(1);
                    xd[1] = select.getString(2);
                    func.EnsuciarDatos(xd);
                    tb.addRow(xd);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        public void removerTodos() {
            while (tb.getRowCount() > 0) {
                tb.removeRow(0);
            }
        }
    }

    public class Con_Inventario extends Controlador {

        private DefaultTableModel tb;
        private final Cache cache = Cache.getInstancia();
        ArrayList<OProducto> productos = cache.getProductos();

        public Con_Inventario(DefaultTableModel tb) {
            this.tb = tb;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "agregarPz":
                    AgregarPiezas();
                    break;
                default:
                    throw new AssertionError();
            }
        }
        String id;

        public void AgregarPiezas() {
            id = JOptionPane.showInputDialog(null, "Ingrese ID del producto");
            if (id == null) {
                JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                return;
            }
            if (id.isEmpty()) {
                return;
            }
            int ID = Integer.parseInt(id);
            String piezas = JOptionPane.showInputDialog(null, "Ingrese las piezas nuevas");

            if (piezas == null) {
                JOptionPane.showMessageDialog(null, "Operacion Cancelaa");
                return;
            }
            if (!piezas.matches(Const.REGEX_NUMEROS_INT_POSITIVOS)) {
                JOptionPane.showMessageDialog(null, "Valor no valido");
                return;
            }
            if (piezas.isEmpty()) {
                return;
            }
            int Piezas = Integer.parseInt(piezas);
            cn.updateNumbers("inventario", "piezas", "piezas + " + piezas, "id = '" + ID + "'");
            JOptionPane.showMessageDialog(null, "Operacion Exitosa");
            ActualizarTablaPiezas();
        }

        public void ActualizarTablaPiezas() {
            try {
                LimpiarTablaPiezas();
                ResultSet select = cn.select("inventario");
                while (select.next()) {
                    int idInve = select.getInt("id");
                    int idProducto = select.getInt("producto");
                    int piezas = select.getInt("piezas");
                    String[] array = {
                        idInve + "",
                        getProducto(productos, idProducto),
                        piezas + ""
                    };
                    tb.addRow(array);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public String getProducto(ArrayList<OProducto> lista, int id) {
            for (OProducto oProducto : lista) {
                if (oProducto.getId() == id) {
                    return oProducto.getNombre();
                }
            }
            return null;
        }

        public void LimpiarTablaPiezas() {
            while (tb.getRowCount() != 0) {
                tb.removeRow(0);
            }
        }
    }
}
