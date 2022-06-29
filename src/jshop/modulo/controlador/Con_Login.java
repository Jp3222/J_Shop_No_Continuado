package jshop.modulo.controlador;

import jshop.modulo.modelo.Operaciones.OperacionesEmpleados;
import java.awt.event.ActionEvent;
import jshop.modulo.vistas.Vista_Login;
import jshop.modulo.vistas.Vista_Menu;
import java.awt.event.KeyEvent;
import jshop.modulo.Auxiliares.Observale;
import jshop.modulo.OperacioneDelSistema;
import jshop.modulo.modelo.Objetos.OEmpleado;

/**
 *
 * @author jp
 */
public class Con_Login extends Controlador implements Observale {

    private final Vista_Login login;
    //
    private final OperacionesEmpleados operacioes;
    private final OperacioneDelSistema operacionesdelsistema;
    private Vista_Menu menu;
    private boolean inicio = false;

    public Con_Login(Vista_Login login) {
        this.login = login;
        operacioes = new OperacionesEmpleados();
        operacionesdelsistema = OperacioneDelSistema.getInstancia();
        addObservador(login);
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

    private void Log() {
        String usuario = login.getUsuario();
        String contra = login.getPass();
        OEmpleado get = operacioes.getObjeto("usuario = '" + usuario + "' and contra = '" + contra + "'");
        if (get != null) {
            System.out.println(get.getCargo());
            if (get.getCargo().equalsIgnoreCase("admin")) {
                menu.admin();
            } else {
                menu.empleado();
            }
            operacionesdelsistema.setEmpleado(get);
            this.menu.setVisible(true);
            this.inicio = true;
            operacionesdelsistema.InicioDeSesion();
            this.ejecutar();
            return;
        }
        this.inicio = false;
        this.ejecutar();
    }

    public void setMenu(Vista_Menu menu) {
        this.menu = menu;
    }

    public boolean isInicio() {
        return inicio;
    }

}
