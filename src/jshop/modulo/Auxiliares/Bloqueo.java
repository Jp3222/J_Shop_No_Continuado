package jshop.modulo.Auxiliares;

/**
 *
 * @author jp
 */
public interface Bloqueo {

    public void Ocupado();

    public void desOcupar();

    public boolean isOcupado();

    public boolean isProcesando();
}
