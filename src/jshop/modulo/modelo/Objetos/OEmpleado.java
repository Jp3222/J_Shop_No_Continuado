/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo.modelo.Objetos;

import java.util.Objects;

/**
 * @author juan pablo Clase que abstrae y contiene la informacion de los
 * empleados de la base de datos a un objeto
 */
public class OEmpleado extends Objeto {

    private String usuario,
            Contraseña,
            Nombre,
            a_paterno,
            a_materno,
            cargo;

    public OEmpleado(String[] valores) {
        super(valores);
        this.Nombre = valores[1];
        this.a_paterno = valores[2];
        this.a_materno = valores[3];
        this.cargo = valores[4];
        this.usuario = valores[5];
        this.Contraseña = valores[6];
    }

    public OEmpleado() {
        super(null);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getA_paterno() {
        return a_paterno;
    }

    public void setA_paterno(String a_paterno) {
        this.a_paterno = a_paterno;
    }

    public String getA_materno() {
        return a_materno;
    }

    public void setA_materno(String a_materno) {
        this.a_materno = a_materno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.usuario);
        hash = 41 * hash + Objects.hashCode(this.Contraseña);
        hash = 41 * hash + Objects.hashCode(this.Nombre);
        hash = 41 * hash + Objects.hashCode(this.a_paterno);
        hash = 41 * hash + Objects.hashCode(this.a_materno);
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
        final OEmpleado other = (OEmpleado) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.Contraseña, other.Contraseña)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.a_paterno, other.a_paterno)) {
            return false;
        }
        return Objects.equals(this.a_materno, other.a_materno);
    }

    @Override
    public String toString() {
        return "Empleado{" + "usuario=" + usuario + ", Contrase\u00f1a=" + Contraseña + ", Nombre=" + Nombre + ", a_paterno=" + a_paterno + ", a_materno=" + a_materno + '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        usuario = null;
        Contraseña = null;
        Nombre = null;
        a_paterno = null;
        a_materno = null;
    }

}
