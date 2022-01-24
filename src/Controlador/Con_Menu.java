package Controlador;

import Vistas.Vista_Administracion;
import Vistas.Vista_Login;
import Vistas.Vista_Menu;
import Vistas.Vista_Menu.Caja;
import Vistas.Vista_Productos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class Con_Menu extends Controlador {

    public final Vista_Menu MENU;
    public Vista_Login login;
    public Vista_Productos productos;
    private Vista_Administracion administracion;

    public Con_Menu(Vista_Menu MENU) {
        this.MENU = MENU;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "opc1" ->
                Productos();
            case "opc2" ->
                Empleados();
            case "opc3" ->
                Administracion();
            case "opc4" ->
                Salir();
        }
    }

    public void Salir() {
        MENU.dispose();
        login.setVisible(true);
    }

    public void Productos() {
        MENU.dispose();
        productos.setVisible(true);
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

    public static class Con_Caja extends Controlador {

        private ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/iconos-de-dinero.png"));

        private Caja caja;

        public Con_Caja(Caja caja) {
            this.caja = caja;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "b1" ->
                    Buscar();
                case "b2" ->
                    Agregar();
                case "b3" ->
                    Quitar();
                case "b4" ->
                    Nuevo();
                case "b5" ->
                    Cobrar();

            }
        }

        public void Buscar() {
            System.out.println("b1");
        }

        public void Agregar() {
            System.out.println("b1");
        }

        public void Quitar() {
            System.out.println("b1");
        }

        public void Nuevo() {
            System.out.println("b1");
        }

        public void Cobrar() {
            boolean error;
            double ingresado = 0;
            do {
                error = false;
                try {
                    String p = (String) JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero recibida", "Dinero Recibido", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
                    if (p != null) {
                        ingresado = Double.parseDouble(p);
                        if (ingresado < 1) {
                            throw new NumberFormatException("Numero menor a 1");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cobro Cancelado ", "Cobro - Cancelado", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El valor ingresado es nulo por favor intente otra vez", "Error", JOptionPane.ERROR_MESSAGE);
                    error = true;
                }
            } while (error);

            System.out.println(ingresado);
        }

    }

}
