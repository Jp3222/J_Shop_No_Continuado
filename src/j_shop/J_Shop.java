package j_shop;

import Modelo.Sistema;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class J_Shop {

    public static void main(String[] args) {
        
        
        Sistema s = Sistema.getNodo();
        s.run();
    }

}
