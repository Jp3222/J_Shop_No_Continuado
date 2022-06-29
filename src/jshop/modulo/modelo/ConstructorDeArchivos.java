package jshop.modulo.modelo;

import com.org.JFiles.Systema.So;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class ConstructorDeArchivos {

    private static ConstructorDeArchivos instancia;

    public static ConstructorDeArchivos getInstancia() {
        if (instancia == null) {
            instancia = new ConstructorDeArchivos();
        }
        return instancia;
    }
    private final String es = "Documentos";
    private final String en = "Documents";
    private File[] dirs;
    private File[] files;

    private ConstructorDeArchivos() {
        switch (So.SO_NOMBRE.toLowerCase()) {
            case "linux":
                linux();
                break;
            case "windows":
                windows();
                break;
            case "mac":
                mac();
                break;
        }
    }

    private void windows() {
        dirs = new File[9];
        dirs[0] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop");
        dirs[1] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/cache");
        dirs[2] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/img");
        dirs[3] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/docs");
        dirs[4] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/sql");
        dirs[5] = new File(So.USUARIO_DIR_INICIO + "/Desktop/jshop");
        dirs[6] = new File(So.USUARIO_DIR_INICIO + "/Desktop/jshop/Ventas");
        dirs[7] = new File(So.USUARIO_DIR_INICIO + "/Desktop/jshop/Reportes");
        dirs[8] = new File(So.USUARIO_DIR_INICIO + "/Desktop/jshop/Historial");
        files = new File[2];
        files[0] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/conf.jff");
        files[1] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/user.jff");
    }

    private void linux() {
        dirs = new File[9];
        dirs[0] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop");
        dirs[1] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/cache");
        dirs[2] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/img");
        dirs[3] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/docs");
        dirs[4] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/sql");
        dirs[5] = new File(So.USUARIO_DIR_INICIO + "/Desktop/jshop");
        dirs[6] = new File(So.USUARIO_DIR_INICIO + "/Desktop/jshop/Ventas");
        dirs[7] = new File(So.USUARIO_DIR_INICIO + "/Desktop/jshop/Reportes");
        dirs[8] = new File(So.USUARIO_DIR_INICIO + "/Desktop/jshop/Historial");
        files = new File[2];
        files[0] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/conf.jff");
        files[1] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/user.jff");
    }

    private void mac() {
    }

    public void run() {
        for (File dir : dirs) {
            if (dir.mkdir()) {
                System.out.println("ruta: " + dir.getAbsolutePath());
            }
        }
        System.out.println("fin 1");
        for (File file : files) {
            if (file.exists()) {
                System.out.println("ruta: " + file.getAbsolutePath());
            } else {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ConstructorDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("fin 2");
    }

    /**
     * @param i index que determina el objeto retornado
     * <br> 0 "/Documents/.jshop/conf.jff");
     * <br> 1 "/Documents/.jshop/user.jff");
     * @return un objeto de tipo File con la ruta escogida por el index
     */
    public File getFiles(int i) {
        return files[i];
    }

    /**
     *
     * @param i
     * <br> 0 "/Documentos/.jshop"
     * <br> 1 "/Documentos/.jshop/cache"
     * <br> 2 "/Documentos/.jshop/img"
     * <br> 3 "/Documentos/.jshop/docs"
     * <br> 4 "/Documentos/.jshop/sql"
     * @return un objeto de tipo File con la ruta segun el index
     */
    public File getDirs(int i) {
        return dirs[i];
    }

}
