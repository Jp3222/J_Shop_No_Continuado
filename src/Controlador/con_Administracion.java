package Controlador;

import Modelo.func;
import Vistas.Vista_Administracion;
import Vistas.Vista_Administracion.Marcas;
import Vistas.Vista_Menu;
import com.jsql.conexion.Conexion;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jp
 */
public class con_Administracion extends Controlador {

    private final Vista_Administracion administracion;
    private Vista_Menu menu;
    private final Conexion cn;
    //
    private con_Marcas con_marcas;

    public con_Administracion(Vista_Administracion administracion) {
        this.administracion = administracion;
        cn = Conexion.getNodo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "b4" ->
                Salir();
        }
    }

    public void Salir() {
        administracion.dispose();
        menu.setVisible(true);
    }

    public void setMenu(Vista_Menu menu) {
        this.menu = menu;
    }

    public con_Marcas getCon_marcas(Marcas marcas) {
        if (con_marcas == null) {
            con_marcas = new con_Marcas(marcas);
        }
        return con_marcas;
    }

    public class con_Marcas extends Controlador {

        private Marcas marcas;

        public con_Marcas(Marcas marcas) {
            this.marcas = marcas;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            switch (e.getActionCommand()) {
                case "b1" ->
                    Nueva();
                case "b2" ->
                    Eliminar();
                case "b3" ->
                    Actualizar_Tabla();
            }

        }

        public void Nueva() {
            try {
                String marca = JOptionPane.showInputDialog(null, "Ingrese el nombre de la marca", "Nueva Marca", JOptionPane.INFORMATION_MESSAGE);
                marca = func.filer_IN(marca);
                if (marca == null) {
                    JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                    return;
                }
                cn.insert("proveedores",
                        cn.getColumnas("marca", "no_prod"),
                        cn.getDatos(marca, "0")
                );
                JOptionPane.showMessageDialog(null, "Producto registrado con exito");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        public void Eliminar() {
            System.out.println("xd");
            try {
                String id = JOptionPane.showInputDialog(null, "Ingrese el id de la marca", "Eliminar Marca", JOptionPane.INFORMATION_MESSAGE);
                if (id == null) {
                    JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                    return;
                }
                cn.DELETE("proveedores", "id = '" + id + "'");
            } catch (HeadlessException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void Actualizar_Tabla() {
            DefaultTableModel tb = new DefaultTableModel();
            try {
                tb.addColumn("ID");
                tb.addColumn("Nombre");
                tb.addColumn("No. Productos");
                ResultSet select = cn.select("proveedores", "*");
                while (select.next()) {
                    String[] xd = new String[3];
                    xd[0] = select.getString(1);
                    xd[1] = select.getString(2);
                    xd[2] = select.getString(3);
                    tb.addRow(xd);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            marcas.setModelo(tb);
            Puentes.getInicio().Actualizar_Lista();
        }
    }
}
