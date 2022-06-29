/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo.Auxiliares;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author jp
 */
public class Decorador implements MouseListener {

    private Color FG_Normal, FG_Evento;
    private Color BG_Presionar, BG_Pasar, BG_Soltar;
    private JComponent componente;

    public Decorador(JComponent componente) {
        this.componente = componente;
    }

    public void Frentes(Color FG_Normal, Color FG_Evento) {
        this.FG_Normal = FG_Normal;
        this.FG_Evento = FG_Evento;
    }

    public void Fondo(Color BG_Presionar, Color BG_Pasar, Color BG_Soltar) {
        this.BG_Presionar = BG_Presionar;
        this.BG_Pasar = BG_Pasar;
        this.BG_Soltar = BG_Soltar;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        componente.setBackground(BG_Pasar);
        componente.setForeground(FG_Normal);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        componente.setBackground(BG_Soltar);
        componente.setForeground(FG_Normal);

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

}
