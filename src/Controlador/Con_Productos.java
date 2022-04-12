package Controlador;

import Modelo.Operaciones;
import Vistas.Vista_Menu;
import Vistas.Vista_Productos;
import java.awt.event.ActionEvent;
import Vistas.Vista_Productos.Insercciones;
import javax.swing.JOptionPane;
import Modelo.Objetos.Producto;

/**
 *
 * @author jp
 */
public class Con_Productos extends Controlador {

    private final Vista_Productos PRODUCTOS;
    private Vista_Menu menu;

    public Con_Productos(Vista_Productos PRODUCTOS) {
        this.PRODUCTOS = PRODUCTOS;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "B1":
                Salir();
                break;
        }
    }

    public void Salir() {
        PRODUCTOS.dispose();
        menu.setVisible(true);
    }

    public void setMenu(Vista_Menu menu) {
        this.menu = menu;
    }

    public static class Con_Insercion extends Controlador {

        private final Insercciones menu;

        public Con_Insercion(Insercciones menu) {
            this.menu = menu;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "b1":
                    Insertar();
                    break;
            }
        }

        public void Insertar() {
            Producto p = menu.getProducto();
            if (p == null) {
                JOptionPane.showMessageDialog(null, "Producto null");
                return;
            }
            
        }
    }

}
