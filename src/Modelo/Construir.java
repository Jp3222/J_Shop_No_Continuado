package Modelo;

import com.org.JFiles.Systema.So;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Construir {

    private static Construir instancia;

    public static Construir getInstancia() {
        if (instancia == null) {
            instancia = new Construir();
        }
        return instancia;
    }

    private File[] dirs;
    private File[] files;

    private Construir() {
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
        dirs = new File[5];
        dirs[0] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop");
        dirs[1] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/cache");
        dirs[2] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/img");
        dirs[3] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/docs");
        dirs[4] = new File(So.USUARIO_DIR_INICIO + "/Documents/.jshop/sql");
        files = new File[2];
        files[0] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/conf.jff");
        files[1] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/user.jff");
    }

    private void linux() {
        dirs = new File[5];
        dirs[0] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop");
        dirs[1] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/cache");
        dirs[2] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/img");
        dirs[3] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/docs");
        dirs[4] = new File(So.USUARIO_DIR_INICIO + "/Documentos/.jshop/sql");
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
                    Logger.getLogger(Construir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("fin 2");
    }

    public File getFiles(int i) {
        return files[i];
    }

}
