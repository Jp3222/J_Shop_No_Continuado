package jshop.modulo.controlador;

import jshop.modulo.vistas.Vista_Menu;
import jshop.modulo.vistas.Vista_Productos;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jshop.modulo.modelo.Cache;
import jshop.modulo.modelo.Objetos.OMarcas;
import jshop.modulo.modelo.Objetos.OProducto;
import jshop.modulo.modelo.Operaciones.OperacionesProductos;
import jshop.modulo.modelo.func;
import jshop.modulo.vistas.Vista_Administracion;

/**
 *
 * @author jp
 */
public class Con_Productos extends Controlador {

    protected final Vista_Productos PRODUCTOS;
    protected Vista_Administracion administracion;
    //
    protected OperacionesProductos operaciones;
    private final Cache o = Cache.getInstancia();
    private final ArrayList<OProducto> LISTA_DE_PRODUCTOS = o.getProductos();
    private DefaultTableModel tbmConsultas, tbmActualizacion;

    public Con_Productos(Vista_Productos PRODUCTOS) {
        this.PRODUCTOS = PRODUCTOS;
        this.operaciones = new OperacionesProductos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "npGuardar":
                Insertar();
                break;
            case "atras":
                Salir();
                break;
        }
    }

    public void Insertar() {
        String[] inserccion = PRODUCTOS.getDatosInserccion();
        if (inserccion == null) {
            JOptionPane.showMessageDialog(PRODUCTOS, "Inserccion Erronea");
            return;
        }
        func.LimpiarDatos(inserccion);
        if (operaciones.agregar(inserccion)) {
            JOptionPane.showMessageDialog(PRODUCTOS, "Inserccion Exitosa");
            o.reiniciarProductos();
            PRODUCTOS.limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(PRODUCTOS, "Inserccion Erronea");
        }

    }

    public void agregarInventario() {
        int opcion = JOptionPane.showConfirmDialog(null, "Desea agregar piezas al inventario de este producto");
        if (opcion == JOptionPane.YES_OPTION) {

        }

    }

    public void Actualizar() {
        String[] array = PRODUCTOS.getActualizacion();
        operaciones.actualizar(
                func.getArray("nombre, marca,productos"),
                func.exp(array, 0, 1),
                "id=" + array[0]
        );
    }

    public void Eliminar() {
        
    }

    public void Seleccionar() {

    }

    public void ActualizarTablaConsultas(double min, double max, int marca) {
        RemoverTablaConsultas();
        for (int i = 0; i < LISTA_DE_PRODUCTOS.size(); i++) {
            OProducto obj = LISTA_DE_PRODUCTOS.get(i);
            if (obj.getPrecio() < min) {
                continue;
            }
            if (max != -1) {
                if (obj.getPrecio() > max) {
                    continue;
                }
            }
            if (marca != -1) {
                if (obj.getMarca() != marca) {
                    continue;
                }
            }
            String[] array = func.getArray(LISTA_DE_PRODUCTOS.get(i).getClave(),
                    LISTA_DE_PRODUCTOS.get(i).getNombre(),
                    LISTA_DE_PRODUCTOS.get(i).getMarca() + "",
                    LISTA_DE_PRODUCTOS.get(i).getPrecio() + ""
            );
            tbmConsultas.addRow(array);
        }
    }

    public void ActualizarTablaActualizaciones() {
        RemoverTablaActualizaciones();
        for (OProducto p : LISTA_DE_PRODUCTOS) {
            String[] array = {
                p.getId() + "",
                p.getClave(),
                p.getNombre(),
                Marca(p.getMarca()),
                p.getContenido(),
                p.getUdm(),
                p.getPrecio() + ""
            };
            tbmActualizacion.addRow(array);
        }
    }

    public String Marca(int i) {
        ArrayList<OMarcas> marcas = o.getMarcas();
        for (OMarcas marca : marcas) {
            if (marca.getId() == i) {
                return marca.getNombre();
            }
        }
        return "N/E";
    }

    public void RemoverTablaActualizaciones() {
        while (tbmActualizacion.getRowCount() > 0) {
            tbmActualizacion.removeRow(0);
        }
    }

    public void RemoverTablaConsultas() {
        while (tbmConsultas.getRowCount() > 0) {
            tbmConsultas.removeRow(0);
        }
    }

    public void Salir() {
        PRODUCTOS.dispose();
        RemoverTablaConsultas();
        RemoverTablaActualizaciones();
        administracion.setVisible(true);
    }

    public void setMenu(Vista_Administracion administracion) {
        this.administracion = administracion;
    }

    public void setTbmConsultas(DefaultTableModel tbmConsultas) {
        this.tbmConsultas = tbmConsultas;
    }

    public void setTbActualizacion(DefaultTableModel tbActualizacion) {
        this.tbmActualizacion = tbActualizacion;
    }

}
