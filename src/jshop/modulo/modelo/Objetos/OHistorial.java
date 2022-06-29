/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo.modelo.Objetos;

/**
 *
 * @author jp
 */
public class OHistorial extends Objeto {

    private String fecha;
    private String hora;
    private String movimiento;

    public OHistorial(String[] valores) {
        super(valores);
        this.fecha = valores[1];
        this.hora = valores[2];
        this.movimiento = valores[3];
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }
    
    

}
