/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo.controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import jshop.modulo.OperacioneDelSistema;

/**
 *
 * @author jp
 */
public class ControladorWindows extends WindowAdapter {

    private final OperacioneDelSistema operaciones = OperacioneDelSistema.getInstancia();

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        operaciones.FinDeSesion();
    }

}
