/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jp
 */
public class func {
    
    /**
     * arreglo de numeros primos
     */
    private static final int NoP[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    /**
     * @param <T>
     * @param array
     * @return array de esos elementos indefinidos
     */
    public static <T> T[] getArray(T... array) {
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
    private static <T>boolean in(T[] array, T obj) {
        for (T i : array) {
            if (obj == i) {
                return true;
            }
        }
        return false;
    }
}
