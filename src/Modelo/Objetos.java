package Modelo;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author juan pablo
 */
public class Objetos {

    /**
     * @author juan pablo Clase padre que hereda a todas las clases: poducto
     * empleado proveedores
     *
     */
    public static abstract class Objeto {

        /*variables del objeto*/
        protected int Id;
        protected boolean existe;
        protected String[] datos;

        public Objeto() {
            this.existe = false;
            this.Id = 0;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public boolean Existe() {
            return existe;
        }

        public void setExiste(boolean Exist) {
            this.existe = Exist;
        }

        public void setDatos(String... datos) {
            this.datos = datos;
        }

        public String[] getDatos() {
            return datos;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 37 * hash + this.Id;
            hash = 37 * hash + (this.existe ? 1 : 0);
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
            final Objeto other = (Objeto) obj;
            if (this.Id != other.Id) {
                return false;
            }
            return this.existe == other.existe;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            this.Id = 0;
            this.datos = null;
            this.existe = false;
        }

    }

    /**
     * @author juan pablo
     */
    public static class Producto extends Objeto {

        private String clave, nombre, proveedor, contenido, udm, precio, img;

        public Producto() {
            super();
        }

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getProveedor() {
            return proveedor;
        }

        public void setProveedor(String proveedor) {
            this.proveedor = proveedor;
        }

        public String getContenido() {
            return contenido;
        }

        public void setContenido(String contenido) {
            this.contenido = contenido;
        }

        public String getUdm() {
            return udm;
        }

        public void setUdm(String udm) {
            this.udm = udm;
        }

        public String getPrecio() {
            return precio;
        }

        public void setPrecio(String precio) {
            this.precio = precio;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            clave = null;
            nombre = null;
            proveedor = null;
            contenido = null;
            udm = null;
            precio = null;
            img = null;
        }

    }

    /**
     * @author juan pablo
     */
    public static class Empleado extends Objeto {

        private String usuario,
                Contraseña,
                Nombre,
                a_paterno,
                a_materno;

        public Empleado() {
            super();
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
            final Empleado other = (Empleado) obj;
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

    /**
     */
    public static class Proveedores extends Objeto {

        private String Marca;

        public Proveedores(String Tabla) {
        }

        public String getMarca() {
            return Marca;
        }

        public void setMarca(String Marca) {
            this.Marca = Marca;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + Objects.hashCode(this.Marca);
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
            final Proveedores other = (Proveedores) obj;

            return Objects.equals(this.Marca, other.Marca);
        }

        @Override
        public String toString() {
            return "Proveedores{" + "Marca=" + Marca + '}';
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        }
        
    }
}
