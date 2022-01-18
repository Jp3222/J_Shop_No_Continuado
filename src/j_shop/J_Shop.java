package j_shop;

import Modelo.Sistema;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.DebugGraphics;

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
