/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo.modelo.Objetos;

import java.util.Objects;

/**
 * @author juan pablo Clase que abstrae y contiene la informacion de los
 * proveedores de la base de datos a un objeto
 */
public class OMarcas extends Objeto {

    private String Nombre;

    public OMarcas(String[] valores) {
        super(valores);
        this.Nombre = valores[1];
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.Nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OMarcas other = (OMarcas) obj;

        return Objects.equals(this.Nombre, other.Nombre);
    }

    @Override
    public String toString() {
        return "Proveedores{" + "Marca=" + Nombre + '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.Nombre = null;
    }

    public void s() {
    }
}
