package Controlador;

import Modelo.Operaciones.Empleados;
import java.awt.event.ActionEvent;
import Vistas.Vista_Login;
import Vistas.Vista_Menu;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jp
 */
public class Con_Login extends Controlador {

    private final Vista_Login login;
    private Vista_Menu menu;

    public Con_Login(Vista_Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Log();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Log();
        }
    }

    public void Log() {
        if (true) {
            if (true) {
                login.dispose();
                menu.setVisible(true);
                login.correcto();
                login.Clear();
                login.setClick();
            } else {
                login.incorrecto();
            }
        } else {
            login.incorrecto();
        }

    }

    public void setMenu(Vista_Menu menu) {
        this.menu = menu;
    }

}
