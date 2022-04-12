package j_shop;

import Modelo.Sistema;

/**
 *
 * @author jp
 */
public class J_Shop {

    public static void main(String[] args) {
        Sistema s = Sistema.getNodo();
        boolean run = s.run();
        if (run) {
            System.out.println("JShop OK!!!");
        }
    }
}
