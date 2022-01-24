package Modelo;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author jp
 */
public class Objetos {

    public static abstract class Objeto {

        private int Id;
        private String Tabla;
        private String[] Informacion;
        private boolean Exist;

        public Objeto(String Tabla) {
            this.Tabla = Tabla;
            this.Exist = false;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getTabla() {
            return Tabla;
        }

        public void setTabla(String Tabla) {
            this.Tabla = Tabla;
        }

        public String[] getInformacion() {
            return Informacion;
        }

        public void setInformacion(String[] Informacion) {
            this.Informacion = Informacion;
        }

        public boolean isExist() {
            return Exist;
        }

        public void setExist(boolean Exist) {
            this.Exist = Exist;
        }

        public abstract void init();

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 37 * hash + this.Id;
            hash = 37 * hash + Objects.hashCode(this.Tabla);
            hash = 37 * hash + Arrays.deepHashCode(this.Informacion);
            hash = 37 * hash + (this.Exist ? 1 : 0);
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
            if (this.Exist != other.Exist) {
                return false;
            }
            if (!Objects.equals(this.Tabla, other.Tabla)) {
                return false;
            }
            return Arrays.deepEquals(this.Informacion, other.Informacion);
        }

    }

    public static class Producto extends Objeto {

        private String clave,
                nombre,
                marca,
                udm,
                img;
        private double contenido, precio;

        public Producto(String Tabla) {
            super(Tabla);

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

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getUdm() {
            return udm;
        }

        public void setUdm(String udm) {
            this.udm = udm;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public double getContenido() {
            return contenido;
        }

        public void setContenido(double contenido) {
            this.contenido = contenido;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 13 * hash + Objects.hashCode(this.clave);
            hash = 13 * hash + Objects.hashCode(this.nombre);
            hash = 13 * hash + Objects.hashCode(this.marca);
            hash = 13 * hash + Objects.hashCode(this.udm);
            hash = 13 * hash + Objects.hashCode(this.img);
            hash = 13 * hash + (int) (Double.doubleToLongBits(this.contenido) ^ (Double.doubleToLongBits(this.contenido) >>> 32));
            hash = 13 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
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
            final Producto other = (Producto) obj;
            if (Double.doubleToLongBits(this.contenido) != Double.doubleToLongBits(other.contenido)) {
                return false;
            }
            if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
                return false;
            }
            if (!Objects.equals(this.clave, other.clave)) {
                return false;
            }
            if (!Objects.equals(this.nombre, other.nombre)) {
                return false;
            }
            if (!Objects.equals(this.marca, other.marca)) {
                return false;
            }
            if (!Objects.equals(this.udm, other.udm)) {
                return false;
            }
            return Objects.equals(this.img, other.img);
        }

        @Override
        public void init() {
            String[] info = getInformacion();
            this.setId(Integer.parseInt(info[0]));
            this.clave = info[1];
            this.nombre = info[2];
            this.marca = info[3];
            this.udm = info[4];
            this.contenido = Double.parseDouble(info[5]);
            this.precio = Double.parseDouble(info[6]);
            this.img = info[7];
        }

        @Override
        public String toString() {
            return "Producto{" + "clave=" + clave + ", nombre=" + nombre + ", marca=" + marca + ", udm=" + udm + ", img=" + img + ", contenido=" + contenido + ", precio=" + precio + '}';
        }

    }

    public static class Empleado extends Objeto {

        private String usuario,
                Contraseña,
                Nombre,
                a_paterno,
                a_materno;

        public Empleado(String Tabla) {
            super(Tabla);
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
        public void init() {
            String info[] = getInformacion();
            this.setId(Integer.parseInt(info[0]));
            this.usuario = info[1];
            this.Contraseña = info[2];
            this.Nombre = info[3];
            this.a_paterno = info[4];
            this.a_materno = info[5];
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

    }

    public static class Proveedores extends Objeto {

        private String Marca;
        private int No_Prod;

        public Proveedores(String Tabla) {
            super(Tabla);
        }

        public String getMarca() {
            return Marca;
        }

        public void setMarca(String Marca) {
            this.Marca = Marca;
        }

        public int getNo_Prod() {
            return No_Prod;
        }

        public void setNo_Prod(int No_Prod) {
            this.No_Prod = No_Prod;
        }

        @Override
        public void init() {
            String info[] = getInformacion();
            setId(Integer.parseInt(info[0]));
            Marca = info[1];
            No_Prod = Integer.parseInt(info[2]);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + Objects.hashCode(this.Marca);
            hash = 83 * hash + this.No_Prod;
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
            if (this.No_Prod != other.No_Prod) {
                return false;
            }
            return Objects.equals(this.Marca, other.Marca);
        }

        @Override
        public String toString() {
            return "Proveedores{" + "Marca=" + Marca + ", No_Prod=" + No_Prod + '}';
        }

    }

}
