package jshop.modulo.vistas;

import jshop.modulo.modelo.Cache;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import jshop.modulo.modelo.Objetos.OProducto;

/**
 *
 * @author jp
 */
public class Vista_Buscar extends javax.swing.JFrame {

    private OProducto producto;
    private boolean buscar_click;
    private String tipoBusqueda, datoSeleccionado;
    private final Cache cache = Cache.getInstancia();
    private final ArrayList<OProducto> lista = cache.getProductos();
    private final DefaultListModel<String> model = new DefaultListModel<>();

    /**
     * Creates new form Vista_Buscar
     */
    public Vista_Buscar() {
        initComponents();
        jList1.setModel(model);
        //
        ImageIcon image = new ImageIcon(getClass().getResource("/Icons/Ico/Icono.png"));
        this.setIconImage(image.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jtfBuscar = new javax.swing.JTextField();
        jbtBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(132, 132, 132));

        jComboBox1.setBackground(new java.awt.Color(254, 254, 254));
        jComboBox1.setForeground(new java.awt.Color(1, 1, 1));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Clave", "Nombre" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtfBuscar.setBackground(new java.awt.Color(254, 254, 254));
        jtfBuscar.setForeground(new java.awt.Color(207, 207, 207));
        jtfBuscar.setText("Buscar");
        jtfBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfBuscarMouseClicked(evt);
            }
        });
        jtfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfBuscarKeyPressed(evt);
            }
        });

        jbtBuscar.setBackground(new java.awt.Color(209, 209, 209));
        jbtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtBuscar.setForeground(new java.awt.Color(1, 1, 1));
        jbtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe.png"))); // NOI18N
        jbtBuscar.setText("Buscar");
        jbtBuscar.setActionCommand("b1");
        jbtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtBuscar.setFocusPainted(false);

        jList1.setBackground(new java.awt.Color(204, 204, 204));
        jList1.setForeground(new java.awt.Color(0, 0, 0));
        jList1.setFocusCycleRoot(true);
        jList1.setSelectionBackground(new java.awt.Color(51, 255, 204));
        jList1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfBuscarMouseClicked
        if (!buscar_click) {
            jtfBuscar.setText("");
            jtfBuscar.setForeground(Color.black);
            buscar_click = true;
        }
    }//GEN-LAST:event_jtfBuscarMouseClicked

    //
    private void jtfBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarKeyPressed
        model.removeAllElements();
        lista.stream().filter((t) -> t.getNombre().contains(jtfBuscar.getText())).
                forEach((t) -> {
                    model.addElement(t.getNombre());
                });
    }//GEN-LAST:event_jtfBuscarKeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        jtfBuscar.setText(jList1.getSelectedValue());
        if (evt.getClickCount() == 2) {
            synchronized (this) {
                this.setVisible(false);
                this.notify();
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    @Override
    public void dispose() {
        super.dispose(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        synchronized (this) {
            this.notify();
        }
    }

    private void setProducto(OProducto o) {

    }

    public OProducto getProducto() {
        return producto;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
