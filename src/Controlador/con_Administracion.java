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
        cn = Conexion.getInstancia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "b4":
                Salir();
                break;
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

        private final Marcas marcas;

        public con_Marcas(Marcas marcas) {
            this.marcas = marcas;
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
                    Actualizar_Tabla();
                    break;
            }

        }

        public void Nueva() {
            try {
                String entrada = JOptionPane.showInputDialog(null, "Ingrese el nombre de la marca", "Nueva Marca", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(entrada);
                if (entrada != null) {
                    if (!entrada.trim().isEmpty()) {
                        entrada = func.filer_IN(entrada);
                        cn.insert("proveedores",
                                cn.getColumnas("marca", "no_prod"),
                                cn.getDatos(entrada, "0")
                        );

                        JOptionPane.showMessageDialog(null, "Producto registrado con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error en la base de datos llame a tecnico");
            }
        }

        public void addModelo() {
            marcas.getTable().removeAll();
        }

        public void Eliminar() {
            try {
                String id = JOptionPane.showInputDialog(null, "Ingrese el id de la marca", "Eliminar Marca", JOptionPane.INFORMATION_MESSAGE);
                if (id != null) {
                    id = id.trim();
                    if (!id.isEmpty()) {
                        cn.delete("proveedores", "id = '" + id + "'");
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo vacio");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                }
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
            //Puentes.getInicio().Actualizar_Lista();
        }
    }
}
