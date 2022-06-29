/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo;

import java.util.Calendar;
import jshop.modulo.modelo.Objetos.OEmpleado;
import jshop.modulo.modelo.Operaciones.OperacionesHistorial;

/**
 * Esta clase almacena informacion basica del sistema hora, fecha, usuario de
 * sesion al igual que hace los registros de inicio de sesion y fin de sesion
 * del usuario
 *
 * @author jp
 */
public class OperacioneDelSistema {

    private static final OperacioneDelSistema Instancia = new OperacioneDelSistema();

    public static OperacioneDelSistema getInstancia() {
        return Instancia;
    }

    private OEmpleado empleado;
    private final Calendar cl;
    private final OperacionesHistorial historial;

    private OperacioneDelSistema() {
        cl = Calendar.getInstance();
        historial = new OperacionesHistorial();
    }

    public void InicioDeSesion() {
        String[] info = new String[]{
            "0", fecha(), hora(), "" + empleado.getId(), "101"
        };
        this.historial.agregar(info);
    }

    public void FinDeSesion() {
        String[] info = new String[]{
            "0", fecha(), hora(), "" + empleado.getId(), "102"
        };
        this.historial.agregar(info);
    }

    public String fecha() {
        return "" + cl.get(Calendar.DAY_OF_MONTH) + "-" + cl.get(Calendar.MONTH) + "-" + cl.get(Calendar.YEAR);
    }

    public String hora() {
        return "" + cl.get(Calendar.HOUR_OF_DAY) + "-" + cl.get(Calendar.MINUTE) + "-" + cl.get(Calendar.SECOND);
    }

    public OEmpleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(OEmpleado empleado) {
        this.empleado = empleado;
    }
}
