package jshop.modulo.modelo.Objetos;

/**
 * @author juan pablo Clase padre que hereda a todas las clases: poducto
 * empleado proveedores
 *
 */
public abstract class Objeto {

    protected int id;
    protected boolean existe;
    protected String[] valores;

    public Objeto(String[] valores) {
        if (valores != null) {
            this.id = Integer.parseInt(valores[0]);
            this.existe = true;
            this.valores = valores;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public String[] getValores() {
        return valores;
    }

    public void setValores(String[] valores) {
        this.valores = valores;
    }

}
