package jshop.modulo.vistas;

import jshop.modulo.controlador.Con_Administracion;
import jshop.modulo.controlador.Con_Administracion.Con_Marcas;
import jshop.modulo.controlador.Con_Administracion.Con_Inventario;
import javax.swing.table.DefaultTableModel;
import jshop.modulo.Programa;

/**
 *
 * @author jp
 */
public class Vista_Administracion extends Vista implements BasicoFrame {

    private final Vista_Productos vista_productos;
    //
    private Con_Administracion controlador;
    private Con_Marcas controlador_marcas;
    private Con_Inventario controlador_Inventario;
    private DefaultTableModel tbMarcas, tbInventario;

    public Vista_Administracion(Vista_Menu menu) {
        super("administracion");
        vista_productos = new Vista_Productos(this);
        this.initComponents();
        this.Ventana();
        this.initVariables();
        this.addListerners();
        this.controlador.setMenu(menu);
        this.controlador.setVista_Productos(vista_productos);
        controlador_marcas.Actualizar_Tabla();
    }

    @Override
    public final void Ventana() {
        this.setTitle(Programa.getTitulo(2));
        this.setIconImage(Programa.getICONO());
    }

    @Override
    public final void initVariables() {
        this.controlador = new Con_Administracion(this);
        //
        this.tbMarcas = (DefaultTableModel) jtMarcas.getModel();
        this.tbInventario = (DefaultTableModel) jtInventario.getModel();
        controlador_marcas = controlador.getCon_marcas(vista_productos, tbMarcas);
        controlador_Inventario = controlador.getInventario(tbInventario);
    }

    @Override
    public final void addListerners() {
        jbtAtras.addActionListener(controlador);
        //Marca
        jbtInsertar.addActionListener(controlador_marcas);
        jbtRemover.addActionListener(controlador_marcas);
        jbtActualizar.addActionListener(controlador_marcas);
        jbtAgregarPiezas.addActionListener(controlador_Inventario);
        //
        jbtProductos.addActionListener(controlador);
        //
        jtpPrincipal.addChangeListener(e -> {
            if (jpMarcas.isVisible()) {
                controlador_marcas.Actualizar_Tabla();
            } else {
                controlador_marcas.removerTodos();
            }
            if (jpInventario.isVisible()) {
                controlador_Inventario.ActualizarTablaPiezas();
            } else {
                controlador_Inventario.LimpiarTablaPiezas();
            }
        });
    }

    public void actualizarTablaInventario() {
        controlador_Inventario.ActualizarTablaPiezas();
    }

    public int getMarca() {
        return jtMarcas.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlbIcono = new javax.swing.JLabel();
        jbtAtras = new javax.swing.JButton();
        jbtProductos = new javax.swing.JButton();
        jbtEmpleados = new javax.swing.JButton();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpMarcas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMarcas = new javax.swing.JTable();
        jbtInsertar = new javax.swing.JButton();
        jbtRemover = new javax.swing.JButton();
        jbtActualizar = new javax.swing.JButton();
        jpInventario = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtInventario = new javax.swing.JTable();
        jbtAgregarPiezas = new javax.swing.JButton();
        jpVisitas = new javax.swing.JPanel();
        jpAVentas = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administracion - JShop 1");

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setForeground(new java.awt.Color(168, 168, 168));
        jPanel2.setPreferredSize(new java.awt.Dimension(288, 268));

        jlbIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (1).png"))); // NOI18N

        jbtAtras.setBackground(new java.awt.Color(255, 22, 0));
        jbtAtras.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtAtras.setForeground(new java.awt.Color(254, 254, 254));
        jbtAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flecha-hacia-atras.png"))); // NOI18N
        jbtAtras.setText("Atras");
        jbtAtras.setActionCommand("b4");
        jbtAtras.setFocusPainted(false);
        jbtAtras.setPreferredSize(new java.awt.Dimension(100, 40));

        jbtProductos.setBackground(new java.awt.Color(33, 176, 255));
        jbtProductos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtProductos.setForeground(new java.awt.Color(254, 254, 254));
        jbtProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/estar.png"))); // NOI18N
        jbtProductos.setText("Productos");
        jbtProductos.setActionCommand("b1");
        jbtProductos.setFocusPainted(false);
        jbtProductos.setPreferredSize(new java.awt.Dimension(100, 40));

        jbtEmpleados.setBackground(new java.awt.Color(33, 176, 255));
        jbtEmpleados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtEmpleados.setForeground(new java.awt.Color(254, 254, 254));
        jbtEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/empleado.png"))); // NOI18N
        jbtEmpleados.setText("Empleados");
        jbtEmpleados.setActionCommand("b2");
        jbtEmpleados.setFocusPainted(false);
        jbtEmpleados.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jbtProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlbIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtpPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jtpPrincipal.setForeground(new java.awt.Color(1, 1, 1));
        jtpPrincipal.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jtpPrincipal.setOpaque(true);

        jpMarcas.setBackground(new java.awt.Color(153, 153, 153));

        jtMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID.", "Nombre."
            }
        ));
        jScrollPane1.setViewportView(jtMarcas);

        jbtInsertar.setBackground(new java.awt.Color(204, 204, 204));
        jbtInsertar.setForeground(new java.awt.Color(0, 0, 0));
        jbtInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/anadir.png"))); // NOI18N
        jbtInsertar.setMnemonic('i');
        jbtInsertar.setText("Nueva Marca");
        jbtInsertar.setToolTipText("Nueva Marca (atajo alt + i) este boton permite agregar \nmarcas a la base de datos de las cuales parten los distintos productos"); // NOI18N
        jbtInsertar.setActionCommand("b1");
        jbtInsertar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtRemover.setBackground(new java.awt.Color(204, 204, 204));
        jbtRemover.setForeground(new java.awt.Color(0, 0, 0));
        jbtRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/actualizar-flecha.png"))); // NOI18N
        jbtRemover.setMnemonic('a');
        jbtRemover.setText("Eliminar Marca");
        jbtRemover.setActionCommand("b2");
        jbtRemover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtActualizar.setBackground(new java.awt.Color(204, 204, 204));
        jbtActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jbtActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/basura.png"))); // NOI18N
        jbtActualizar.setMnemonic('e');
        jbtActualizar.setText("Actualizar Marca");
        jbtActualizar.setActionCommand("b3");
        jbtActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpMarcasLayout = new javax.swing.GroupLayout(jpMarcas);
        jpMarcas.setLayout(jpMarcasLayout);
        jpMarcasLayout.setHorizontalGroup(
            jpMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMarcasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jbtRemover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpMarcasLayout.setVerticalGroup(
            jpMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMarcasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMarcasLayout.createSequentialGroup()
                        .addComponent(jbtInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpMarcasLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jtpPrincipal.addTab("Marcas", jpMarcas);

        jpInventario.setBackground(new java.awt.Color(153, 153, 153));

        jtInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Piezas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtInventario);

        jbtAgregarPiezas.setBackground(new java.awt.Color(209, 209, 209));
        jbtAgregarPiezas.setForeground(new java.awt.Color(0, 0, 0));
        jbtAgregarPiezas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregar.png"))); // NOI18N
        jbtAgregarPiezas.setText("Agregar Piezas");
        jbtAgregarPiezas.setActionCommand("agregarPz");
        jbtAgregarPiezas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpInventarioLayout = new javax.swing.GroupLayout(jpInventario);
        jpInventario.setLayout(jpInventarioLayout);
        jpInventarioLayout.setHorizontalGroup(
            jpInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtAgregarPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpInventarioLayout.setVerticalGroup(
            jpInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
            .addGroup(jpInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtAgregarPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Inventario", jpInventario);

        jpVisitas.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jpVisitasLayout = new javax.swing.GroupLayout(jpVisitas);
        jpVisitas.setLayout(jpVisitasLayout);
        jpVisitasLayout.setHorizontalGroup(
            jpVisitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 994, Short.MAX_VALUE)
        );
        jpVisitasLayout.setVerticalGroup(
            jpVisitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jtpPrincipal.addTab("Visitas", jpVisitas);

        jpAVentas.setBackground(new java.awt.Color(153, 153, 153));
        jpAVentas.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jpAVentasLayout = new javax.swing.GroupLayout(jpAVentas);
        jpAVentas.setLayout(jpAVentasLayout);
        jpAVentasLayout.setHorizontalGroup(
            jpAVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 994, Short.MAX_VALUE)
        );
        jpAVentasLayout.setVerticalGroup(
            jpAVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jtpPrincipal.addTab("Analizador de ventas", jpAVentas);

        jToolBar1.setBackground(new java.awt.Color(153, 153, 153));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setFloatable(true);
        jToolBar1.setRollover(true);
        jToolBar1.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpPrincipal)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtpPrincipal)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1306, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtActualizar;
    private javax.swing.JButton jbtAgregarPiezas;
    private javax.swing.JButton jbtAtras;
    private javax.swing.JButton jbtEmpleados;
    private javax.swing.JButton jbtInsertar;
    private javax.swing.JButton jbtProductos;
    private javax.swing.JButton jbtRemover;
    private javax.swing.JLabel jlbIcono;
    private javax.swing.JPanel jpAVentas;
    private javax.swing.JPanel jpInventario;
    private javax.swing.JPanel jpMarcas;
    private javax.swing.JPanel jpVisitas;
    private javax.swing.JTable jtInventario;
    private javax.swing.JTable jtMarcas;
    private javax.swing.JTabbedPane jtpPrincipal;
    // End of variables declaration//GEN-END:variables

}
