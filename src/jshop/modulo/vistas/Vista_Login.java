package jshop.modulo.vistas;

import jshop.modulo.controlador.Con_Login;
import com.jsql.conexion.Conexion;
import java.awt.Color;
import javax.swing.ImageIcon;
import jshop.modulo.Auxiliares.Decorador;
import jshop.modulo.Auxiliares.Observador;
import jshop.modulo.Programa;
import jshop.modulo.modelo.Const;

/**
 *
 * @author jp
 */
public class Vista_Login extends Vista implements Observador, BasicoFrame {

    private boolean user_click;
    private boolean pass_click;
    private Vista_Menu menu;
    private Con_Login controlador;

    public Vista_Login() {
        super("Vista_Login");
        this.user_click = false;
        this.pass_click = false;
        initComponents();
        Ventana();
        initVariables();
        //
        ImageIcon image = new ImageIcon(getClass().getResource("/Icons/Ico/JSHOP_2.png"));
        this.setIconImage(image.getImage());
    }

    @Override
    public void Ventana() {
        this.setTitle(Programa.getTitulo(0));
        this.setIconImage(Programa.getICONO());

    }

    @Override
    public final void initVariables() {
        this.menu = new Vista_Menu(this);

        this.controlador = new Con_Login(this);
        this.controlador.setMenu(menu);
        Propiedades();
    }

    @Override
    protected void Propiedades() {
        //Labels
        jtfUsuario.setForeground(Color.gray);
        String txt = "                  Estado: ";
        txt += Conexion.getInstancia().isConexion() ? "Conectado" : "No Conectado";
        jlbEstado.setText(txt);
        //JButons
        jbtInicio.setActionCommand("B1");
        addListerners();
    }

    @Override
    public void addListerners() {
        Decorador d = new Decorador(jbtInicio);
        d.Fondo(new Color(33, 176, 255), Color.red, new Color(33, 176, 255));
        d.Frentes(Color.black, Color.white);
        jbtInicio.addActionListener(controlador);
        jbtInicio.addMouseListener(d);
        jtfUsuario.addKeyListener(controlador);
        jpfPass.addKeyListener(controlador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jpfPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jlbEstado = new javax.swing.JLabel();
        jbtInicio = new javax.swing.JButton();
        jbtConfig = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - J Shop 1");
        setBackground(new java.awt.Color(254, 254, 254));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setResizable(false);

        root.setBackground(new java.awt.Color(185, 185, 185));
        root.setPreferredSize(new java.awt.Dimension(400, 600));
        root.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Contraseña");
        root.add(jLabel2);
        jLabel2.setBounds(10, 330, 120, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Ico/JSHOP.png"))); // NOI18N
        root.add(jLabel1);
        jLabel1.setBounds(0, 50, 400, 200);

        jtfUsuario.setBackground(new java.awt.Color(254, 254, 254));
        jtfUsuario.setForeground(new java.awt.Color(207, 207, 207));
        jtfUsuario.setText("ejem: user_1223");
        jtfUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfUsuarioMouseClicked(evt);
            }
        });
        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyPressed(evt);
            }
        });
        root.add(jtfUsuario);
        jtfUsuario.setBounds(140, 260, 250, 30);

        jpfPass.setBackground(new java.awt.Color(254, 254, 254));
        jpfPass.setText("jPasswordField1");
        jpfPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpfPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpfPassFocusGained(evt);
            }
        });
        jpfPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpfPassMouseClicked(evt);
            }
        });
        root.add(jpfPass);
        jpfPass.setBounds(140, 330, 250, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar Sesion");
        root.add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 50);

        jlbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbEstado.setForeground(new java.awt.Color(1, 1, 1));
        jlbEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbEstado.setText("Nombre de usuario");
        jlbEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        root.add(jlbEstado);
        jlbEstado.setBounds(60, 560, 330, 30);

        jbtInicio.setBackground(new java.awt.Color(33, 176, 255));
        jbtInicio.setForeground(new java.awt.Color(0, 0, 0));
        jbtInicio.setText("Entrar");
        jbtInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        root.add(jbtInicio);
        jbtInicio.setBounds(10, 390, 380, 30);

        jbtConfig.setBackground(new java.awt.Color(132, 132, 132));
        jbtConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ajustes-de-engranajes.png"))); // NOI18N
        root.add(jbtConfig);
        jbtConfig.setBounds(10, 560, 30, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nombre de usuario");
        root.add(jLabel5);
        jLabel5.setBounds(10, 260, 120, 30);

        getContentPane().add(root, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfUsuarioMouseClicked
        if (!user_click) {
            jtfUsuario.setText("");
            jtfUsuario.setForeground(Color.black);
            user_click = true;
        }
    }//GEN-LAST:event_jtfUsuarioMouseClicked

    private void jpfPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpfPassMouseClicked
        if (!pass_click) {
            jpfPass.setText("");
            jpfPass.setForeground(Color.black);
            pass_click = true;
        }
    }//GEN-LAST:event_jpfPassMouseClicked

    private void jpfPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfPassFocusGained
        if (!pass_click) {
            jpfPass.setText("");
            jpfPass.setForeground(Color.black);
            pass_click = true;
        }
    }//GEN-LAST:event_jpfPassFocusGained

    private void jtfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyPressed
        if (!user_click) {
            jtfUsuario.setText("");
            jtfUsuario.setForeground(Color.black);
            user_click = true;
        }
    }//GEN-LAST:event_jtfUsuarioKeyPressed

    @Override
    public void event() {
        if (!controlador.isInicio()) {
            this.incorrecto();
            this.Clear();
            this.setClick();
            return;
        }
        this.dispose();
        this.Clear();
        this.setClick();
        this.correcto();
    }

    public String getPass() {
        return String.valueOf(jpfPass.getPassword());
    }

    public String getUsuario() {
        return jtfUsuario.getText();
    }

    public void Clear() {
        jtfUsuario.setText("");
        jpfPass.setText("");
    }

    public void correcto() {
        jtfUsuario.setBorder(Const.BORDER_BLACK);
        jpfPass.setBorder(Const.BORDER_BLACK);
    }

    public void incorrecto() {
        jtfUsuario.setBorder(Const.BORDER_RED);
        jpfPass.setBorder(Const.BORDER_RED);
    }

    public void setClick() {
        jtfUsuario.setForeground(Color.gray);
        jtfUsuario.setText("ejem: user_1223");
        jpfPass.setText("jPasswordField1");
        this.user_click = false;
        this.pass_click = false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbtConfig;
    private javax.swing.JButton jbtInicio;
    private javax.swing.JLabel jlbEstado;
    private javax.swing.JPasswordField jpfPass;
    private javax.swing.JTextField jtfUsuario;
    private javax.swing.JPanel root;
    // End of variables declaration//GEN-END:variables
}
