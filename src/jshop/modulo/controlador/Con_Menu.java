package jshop.modulo.controlador;

import com.jsql.conexion.Conexion;
import jshop.modulo.vistas.Vista_Administracion;
import jshop.modulo.vistas.Vista_Login;
import jshop.modulo.vistas.Vista_Menu;
import jshop.modulo.vistas.Vista_Menu.Caja;
import jshop.modulo.vistas.Vista_Productos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jshop.modulo.Auxiliares.Observador;
import jshop.modulo.Auxiliares.Observale;
import jshop.modulo.OperacioneDelSistema;
import jshop.modulo.modelo.Cache;
import jshop.modulo.modelo.Const;
import jshop.modulo.modelo.Objetos.OProducto;

/**
 *
 * @author jp
 */
public class Con_Menu extends Controlador {

    //Constantes
    private final OperacioneDelSistema operacioneDelSistema;

    //Sub Clases
    private Con_Caja Con_Caja;
    //Ventanas
    private final Vista_Menu MENU;
    private Vista_Login login;
    private Vista_Productos productos;
    private Vista_Administracion administracion;

    public Con_Menu(Vista_Menu MENU) {
        this.MENU = MENU;
        operacioneDelSistema = OperacioneDelSistema.getInstancia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "opc3":
                Administracion();
                break;
            case "opc4":
                Salir();
                break;
        }
    }

    public void Salir() {
        operacioneDelSistema.FinDeSesion();
        operacioneDelSistema.setEmpleado(null);
        MENU.dispose();
        login.setVisible(true);
    }

    public void Empleados() {

    }

    public void Administracion() {
        MENU.dispose();
        administracion.setVisible(true);
    }

    public void setLogin(Vista_Login login) {
        this.login = login;
    }

    public void setProductos(Vista_Productos productos) {
        this.productos = productos;
    }

    public void setAdministracion(Vista_Administracion administracion) {
        this.administracion = administracion;
    }

    public Con_Caja getCon_Caja(Caja caja, Observador o, DefaultTableModel tb) {
        if (Con_Caja == null) {
            Con_Caja = new Con_Caja(caja, o, tb);
        }
        return Con_Caja;
    }

    public class Con_Caja extends Controlador implements Observale {

        private final ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/iconos-de-dinero.png"));
        private final Cache cache = Cache.getInstancia();
        private final ArrayList<OProducto> LISTA_PRODUCTOS = cache.getProductos();
        private final Caja caja;
        private final Observador observador;
        private final DefaultTableModel modelo_carrito;
        private OProducto productoEscogido;
        //Datos Primitivos

        private final int columa_id;
        private final int columa_precio;
        private final int columa_nombre;
        private int fila_borrar;
        private double precio_producto;
        private double campos_restante;
        private double dinero_ingresado;
        private double total_a_pagar;
        private int piezas_escogidas;

        public Con_Caja(Caja caja, Observador o, DefaultTableModel tb) {
            this.caja = caja;
            this.observador = o;
            this.modelo_carrito = tb;
            this.columa_precio = tb.getColumnCount() - 1;
            this.columa_id = 0;
            this.columa_nombre = 2;
            this.fila_borrar = -1;
            this.precio_producto = 0.0;
            this.piezas_escogidas = 0;
            this.campos_restante = 0.0;
            this.dinero_ingresado = 0.0;
            this.total_a_pagar = 0.0;
        }

        public void setQuitar(int row) {
            this.fila_borrar = row;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "b1":
                    Buscar();
                    break;
                case "b2":
                    Agregar();
                    break;
                case "b3":
                    Quitar();
                    break;
                case "b4":
                    reiniciarVariablesDeCaja();
                    break;
                case "b5":
                    Cobrar();
                    break;
            }
        }

        public void Buscar() {
            if (!caja.buscarProductoVacio()) {
                productoEscogido = BuscarEnLista(caja.getProducto());
                if (productoEscogido != null) {
                    precio_producto = productoEscogido.getPrecio();
                    observador.event();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ningun producto con el nombre " + caja.getProducto());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha ingresado ningun producto");
            }
        }

        public void Agregar() {
            if (caja.datosProductoVacios()) {
                return;
            }
            piezas_escogidas = caja.getPiezas();
            if (!inventarioValido(piezas_escogidas, "producto", "" + productoEscogido.getId())) {
                return;
            }
            precio_producto *= piezas_escogidas;
            total_a_pagar += precio_producto;
            String array[] = {
                productoEscogido.getId() + "",
                productoEscogido.getClave(),
                productoEscogido.getNombre(),
                piezas_escogidas + "",
                precio_producto + ""
            };
            modelo_carrito.addRow(array);
            caja.quitarDatosProducto();
            productoEscogido = null;
        }

        public void Quitar() {
            if (modelo_carrito.getRowCount() > 0) {
                if (fila_borrar > -1) {
                    double borrado = Double.parseDouble((String) modelo_carrito.getValueAt(fila_borrar, columa_precio));
                    total_a_pagar -= borrado;
                    modelo_carrito.removeRow(fila_borrar);
                    this.fila_borrar = -1;
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado una producto", "Quitar producto", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "carrito vacio", "Quitar Producto", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void Cobrar() {
            if (total_a_pagar > 0) {
                boolean error;
                do {
                    error = false;
                    try {
                        String dineroIngresado = (String) JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero recibida", "Ingresar Dinero", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
                        if (dineroIngresado != null) {
                            if (!dineroIngresado.matches(Const.REGEX_NUMEROS_DOUBLE)) {
                                JOptionPane.showMessageDialog(null, "El valor ingresado no es por favor intente otra vez", "Error al ingresar dinero", JOptionPane.ERROR_MESSAGE);
                                dinero_ingresado = 0;
                                error = true;
                            }
                            dinero_ingresado = Double.parseDouble(dineroIngresado);
                            if (dinero_ingresado < total_a_pagar) {
                                JOptionPane.showMessageDialog(null, "El valor ingresado no es por favor intente otra vez", "Error al ingresar dinero", JOptionPane.ERROR_MESSAGE);
                                error = true;
                                dinero_ingresado = 0;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Cobro Cancelado ", "Cobro - Cancelado", JOptionPane.ERROR_MESSAGE);
                            reiniciarVariablesDeCaja();
                            return;
                        }
                    } catch (HeadlessException | NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "El valor ingresado es nulo por favor intente otra vez", "Error", JOptionPane.ERROR_MESSAGE);
                        error = true;
                    }
                } while (error);
                campos_restante = dinero_ingresado - total_a_pagar;
                quitarDeInventario();
                caja.mostrarTotal();
                caja.actualizarTablaInvenario();
                caja.quitarDatosProducto();
                dinero_ingresado = 0;
            } else {
                JOptionPane.showMessageDialog(null, "No se esta haciendo alguna venta");
            }
        }

        public OProducto BuscarEnLista(String nombre) {
            for (OProducto t : LISTA_PRODUCTOS) {
                if (nombre.equalsIgnoreCase(t.getNombre())) {
                    return t;
                }
            }
            return null;
        }

        public void reiniciarVariablesDeCaja() {
            productoEscogido = null;
            precio_producto = 0;
            piezas_escogidas = 0;
            campos_restante = 0;
            dinero_ingresado = 0;
            total_a_pagar = 0;
            limpiarTabla();
            caja.quitarDatosProducto();
            caja.quitarTotal();
        }

        public boolean inventarioValido(int piezasSolicitadas, String campo, String valor) {
            ResultSet select = Conexion.getInstancia().select("inventario", "piezas", campo + " = '" + valor + "'");
            try {
                if (select.next()) {
                    int piezasExistentes = select.getInt("piezas");
                    if (piezasExistentes <= 0) {
                        JOptionPane.showMessageDialog(null, "Producto agotado");
                        return false;
                    } else if (piezasSolicitadas > piezasExistentes) {
                        JOptionPane.showMessageDialog(null, "Solo hay " + piezasExistentes + " en el inventario");
                        return false;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Con_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }

        public void quitarDeInventario() {
            int id;
            int pz;
            while (modelo_carrito.getRowCount() > 0) {
                id = Integer.parseInt((String) modelo_carrito.getValueAt(0, 0));
                pz = Integer.parseInt((String) modelo_carrito.getValueAt(0, 3));
                boolean inventario = inventarioValido(pz, "producto", id + "");
                if (inventario) {
                    boolean update = Conexion.getInstancia().updateNumbers("inventario", "piezas", "piezas - " + pz, "producto = " + id);
                } else {
                    total_a_pagar -= Double.parseDouble((String) modelo_carrito.getValueAt(0, modelo_carrito.getColumnCount() - 1));
                    campos_restante += Double.parseDouble((String) modelo_carrito.getValueAt(0, modelo_carrito.getColumnCount() - 1));
                    JOptionPane.showMessageDialog(null, "El producto " + modelo_carrito.getValueAt(0, 2) + " no puede venderse"
                            + "\nnuevo total: " + total_a_pagar);
                }
                modelo_carrito.removeRow(0);
            }
        }

        public void limpiarTabla() {
            while (modelo_carrito.getRowCount() > 0) {
                modelo_carrito.removeRow(0);
            }
        }

        public String getPrecio() {
            return precio_producto + "";
        }

        public String getTotal() {
            return total_a_pagar + "";
        }

        public String getIngresado() {
            return dinero_ingresado + "";
        }

        public String getCambio() {
            return campos_restante + "";
        }

    }

}
