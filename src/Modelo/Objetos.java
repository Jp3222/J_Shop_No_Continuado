package Modelo;

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

    }

    public static class Empleado extends Objeto {
        private int id;
        private String usuario, pass, nombre, a_paterno, a_materno;
        private boolean exist;

        public Empleado() {
            this.id = 0;
            this.usuario = null;
            this.pass = null;
            this.nombre = null;
            this.a_paterno = null;
            this.a_materno = null;
            this.exist = false;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
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
            String[] info = getInformacion();
            this.setId(Integer.parseInt(info[0]));
            this.usuario = info[1];
            this.pass = info[2];
            this.nombre = info[3];
            this.a_paterno = info[4];
            this.a_materno = info[5];
        }

    }

    public static class Producto {
    }

    public static class proveedor {
    }

    public static class Movimiento {
    }

}
