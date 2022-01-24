package Controlador;

import Modelo.Operaciones;
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
    private final Operaciones op;

    public Con_Login(Vista_Login login) {
        this.login = login;
        op = Operaciones.getNodo();
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
        try {
            ResultSet rs = op.Consulta("empleados", "*", "usuario = '" + login.getUsuario() + "'");
            if (rs.next()) {
                if (rs.getString("pass").equals(login.getPass())) {
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

        } catch (SQLException e) {
        }

    }

    public void setMenu(Vista_Menu menu) {
        this.menu = menu;
    }

}
