package jshop.modulo.modelo;

import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class func {

    /**
     * arreglo de numeros primos
     */
    private static final int NoP[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static String key(int m, String nom, String cont, String udm) {
        nom = Filtro_Entrada(nom);
        cont = Filtro_Entrada(cont);
        udm = Filtro_Entrada(udm);
        String[] init = nom.split(" ");
        String key = m + "";
        for (String s : init) {
            key += "" + s.charAt(0);
        }
        key += cont + udm + hash(Double.parseDouble(cont) * m);
        return key;
    }

    private static int hash(double n) {
        if (n < 1) {
            n = 1;
        }
        int hash = (int) ((n * n));
        int p = (int) (Math.random() * NoP.length);
        return hash % NoP[p];
    }

    public static String Filtro_Entrada(String str) {
        return str.trim().toUpperCase().replace(".", "").replace(" ", "_");
    }

    public static String Filtro_Salida(String str) {
        return str.trim().toUpperCase().replace("_", " ");
    }

    public static void LimpiarDatos(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Filtro_Entrada(array[i]);
        }
    }

    public static void EnsuciarDatos(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Filtro_Entrada(array[i]);
        }
    }

    /**
     * @param array
     * @return array de esos elementos indefinidos
     */
    public static String[] getArray(String... array) {
        return array;
    }

    /**
     * @param array arreglo de cadenas existentes
     * @param ex indices de las cadenas que se requieran excluir
     * @return arreglo sin elementos excluidos
     */
    public static String[] exp(String array[], Integer... ex) {
        ArrayList<String> obj = new ArrayList<>();
        Integer[] e = ex;
        for (int i = 0; i < array.length; i++) {
            if (!in(e, i)) {
                obj.add(array[i]);
            }
        }
        return obj.toArray(String[]::new);
    }

    /**
     * @param array arreglo de enteros
     * @param obj objeto buscado
     * @return true si el objeto pertenece al conjunto dado
     */
    private static <T> boolean in(T[] array, T obj) {
        for (T i : array) {
            if (i.equals(obj)) {
                return true;
            }
        }
        return false;
    }
}
