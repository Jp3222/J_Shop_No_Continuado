package Controlador;

import Vistas.Vista_Login;
import Vistas.Vista_Menu;
import Vistas.Vista_Productos;
import java.awt.event.ActionEvent;

/**
 *
 * @author jp
 */
public class Con_Menu extends Controlador {

    public final Vista_Menu MENU;
    public Vista_Login login;

    public Con_Menu(Vista_Menu MENU) {
        this.MENU = MENU;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "opc4" ->
                Salir();
        }
    }

    public void Salir() {
        MENU.dispose();
        login.setVisible(true);
    }

    public void setLogin(Vista_Login login) {
        this.login = login;
    }

}
