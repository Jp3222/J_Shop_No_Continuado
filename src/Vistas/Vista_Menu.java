package Vistas;

import Controlador.Con_Menu;
import Controlador.Con_Menu.Con_Caja;
import java.awt.Color;
import javax.swing.DefaultCellEditor;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jp
 */
public class Vista_Menu extends Vista {

    private final Con_Menu controlador;
    private final Vista_Productos productos;
    private final Vista_Administracion administracion;
    private final Caja caja;

    public Vista_Menu(Vista_Login login) {
        this.controlador = new Con_Menu(this);
        this.productos = new Vista_Productos(this);
        this.administracion = new Vista_Administracion(this);
        //
        controlador.setLogin(login);
        controlador.setProductos(productos);
        controlador.setAdministracion(administracion);
        initComponents();
        init();
        //
        caja = new Caja();
    }

    private void init() {
        //Botones
        jbtAdministracion.addActionListener(controlador);
        jbtEmpleados.addActionListener(controlador);
        jbtProductos.addActionListener(controlador);
        jbtSalir.addActionListener(controlador);
        //Cajas de texto
        jtfBuscar.setForeground(Color.lightGray);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtSalir = new javax.swing.JButton();
        jbtProductos = new javax.swing.JButton();
        jbtEmpleados = new javax.swing.JButton();
        jbtAdministracion = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCarrito = new javax.swing.JTable();
        jtfBuscar = new javax.swing.JTextField();
        jbtBuscar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jbtCobrar = new javax.swing.JButton();
        jbtNuevo = new javax.swing.JButton();
        jbtQuitar = new javax.swing.JButton();
        jbtAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jspPiezas = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jtfRecibido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfCambio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVisitas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("J - Shop");
        setMinimumSize(new java.awt.Dimension(1200, 600));

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 600));

        jPanel2.setBackground(new java.awt.Color(168, 168, 168));
        jPanel2.setBorder(null);
        jPanel2.setForeground(new java.awt.Color(168, 168, 168));
        jPanel2.setPreferredSize(new java.awt.Dimension(288, 350));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (1).png"))); // NOI18N

        jbtSalir.setBackground(new java.awt.Color(255, 22, 0));
        jbtSalir.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtSalir.setForeground(new java.awt.Color(254, 254, 254));
        jbtSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrar-sesion.png"))); // NOI18N
        jbtSalir.setText("Salir");
        jbtSalir.setActionCommand("opc4");
        jbtSalir.setFocusPainted(false);
        jbtSalir.setPreferredSize(new java.awt.Dimension(100, 40));

        jbtProductos.setBackground(new java.awt.Color(33, 176, 255));
        jbtProductos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtProductos.setForeground(new java.awt.Color(254, 254, 254));
        jbtProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/estar.png"))); // NOI18N
        jbtProductos.setText("Productos");
        jbtProductos.setActionCommand("opc1");
        jbtProductos.setFocusPainted(false);
        jbtProductos.setPreferredSize(new java.awt.Dimension(100, 40));

        jbtEmpleados.setBackground(new java.awt.Color(33, 176, 255));
        jbtEmpleados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtEmpleados.setForeground(new java.awt.Color(254, 254, 254));
        jbtEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/empleado.png"))); // NOI18N
        jbtEmpleados.setText("Empleados");
        jbtEmpleados.setActionCommand("opc2");
        jbtEmpleados.setFocusPainted(false);
        jbtEmpleados.setPreferredSize(new java.awt.Dimension(100, 40));

        jbtAdministracion.setBackground(new java.awt.Color(33, 176, 255));
        jbtAdministracion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtAdministracion.setForeground(new java.awt.Color(254, 254, 254));
        jbtAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/investigacion.png"))); // NOI18N
        jbtAdministracion.setText("Administracion");
        jbtAdministracion.setActionCommand("opc3");
        jbtAdministracion.setFocusPainted(false);
        jbtAdministracion.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtEmpleados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(jbtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(254, 254, 254));
        jTabbedPane1.setForeground(new java.awt.Color(1, 1, 1));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(653, 400));

        jPanel3.setBackground(new java.awt.Color(132, 132, 132));

        jtbCarrito.setAutoCreateRowSorter(true);
        jtbCarrito.setBackground(new java.awt.Color(254, 254, 254));
        jtbCarrito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbCarrito.setForeground(new java.awt.Color(1, 1, 1));
        jtbCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbCarrito.setEnabled(false);
        jtbCarrito.setGridColor(new java.awt.Color(0, 203, 255));
        jtbCarrito.setSelectionBackground(new java.awt.Color(254, 254, 254));
        jtbCarrito.setSelectionForeground(new java.awt.Color(1, 1, 1));
        jScrollPane1.setViewportView(jtbCarrito);

        jtfBuscar.setBackground(new java.awt.Color(254, 254, 254));
        jtfBuscar.setForeground(new java.awt.Color(1, 1, 1));
        jtfBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfBuscarMouseClicked(evt);
            }
        });

        jbtBuscar.setBackground(new java.awt.Color(209, 209, 209));
        jbtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtBuscar.setForeground(new java.awt.Color(1, 1, 1));
        jbtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe.png"))); // NOI18N
        jbtBuscar.setText("buscar");
        jbtBuscar.setActionCommand("b1");
        jbtBuscar.setFocusPainted(false);

        jComboBox1.setBackground(new java.awt.Color(254, 254, 254));
        jComboBox1.setForeground(new java.awt.Color(1, 1, 1));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Clave", "Nombre" }));

        jbtCobrar.setBackground(new java.awt.Color(209, 209, 209));
        jbtCobrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtCobrar.setForeground(new java.awt.Color(1, 1, 1));
        jbtCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dinero.png"))); // NOI18N
        jbtCobrar.setText("Cobrar");
        jbtCobrar.setActionCommand("b5");
        jbtCobrar.setFocusPainted(false);

        jbtNuevo.setBackground(new java.awt.Color(209, 209, 209));
        jbtNuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtNuevo.setForeground(new java.awt.Color(1, 1, 1));
        jbtNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/limpiar.png"))); // NOI18N
        jbtNuevo.setText("Nuevo");
        jbtNuevo.setActionCommand("b4");
        jbtNuevo.setFocusPainted(false);

        jbtQuitar.setBackground(new java.awt.Color(209, 209, 209));
        jbtQuitar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtQuitar.setForeground(new java.awt.Color(1, 1, 1));
        jbtQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/quitar-del-carrito (1).png"))); // NOI18N
        jbtQuitar.setText("Quitar");
        jbtQuitar.setActionCommand("b3");
        jbtQuitar.setFocusPainted(false);

        jbtAgregar.setBackground(new java.awt.Color(209, 209, 209));
        jbtAgregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtAgregar.setForeground(new java.awt.Color(1, 1, 1));
        jbtAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/carrito-de-compras (1).png"))); // NOI18N
        jbtAgregar.setText("Agregar");
        jbtAgregar.setActionCommand("b2");
        jbtAgregar.setFocusPainted(false);

        jLabel3.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Total: $");

        jtfTotal.setEditable(false);
        jtfTotal.setBackground(new java.awt.Color(254, 254, 254));
        jtfTotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jtfTotal.setForeground(new java.awt.Color(1, 1, 1));
        jtfTotal.setText("0.0");

        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Producto");

        jtfProducto.setBackground(new java.awt.Color(254, 254, 254));
        jtfProducto.setForeground(new java.awt.Color(1, 1, 1));
        jtfProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfProductoMouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Precio");

        jtfPrecio.setBackground(new java.awt.Color(254, 254, 254));
        jtfPrecio.setForeground(new java.awt.Color(1, 1, 1));
        jtfPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfPrecioMouseClicked(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Piezas");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconos-de-dinero.png"))); // NOI18N
        jLabel6.setText("Recibido: $");

        jtfRecibido.setEditable(false);
        jtfRecibido.setBackground(new java.awt.Color(254, 254, 254));
        jtfRecibido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jtfRecibido.setForeground(new java.awt.Color(1, 1, 1));
        jtfRecibido.setText("0.0");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/modena.png"))); // NOI18N
        jLabel7.setText("Cambio:   $");

        jtfCambio.setEditable(false);
        jtfCambio.setBackground(new java.awt.Color(254, 254, 254));
        jtfCambio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jtfCambio.setForeground(new java.awt.Color(1, 1, 1));
        jtfCambio.setText("0.0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTotal))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 100, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtBuscar))
                            .addComponent(jtfProducto)
                            .addComponent(jtfPrecio)
                            .addComponent(jspPiezas)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfRecibido)
                            .addComponent(jtfCambio))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jspPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Caja", new javax.swing.ImageIcon(getClass().getResource("/Icons/caja-registradora.png")), jPanel3); // NOI18N

        jPanel4.setBackground(new java.awt.Color(132, 132, 132));

        jtVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtVisitas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Visitas", new javax.swing.ImageIcon(getClass().getResource("/Icons/la-proxima-semana.png")), jPanel4); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean buscar_click = false;

    private void jtfBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfBuscarMouseClicked
        if (!buscar_click) {
            jtfBuscar.setText("");
            jtfBuscar.setForeground(Color.black);
            buscar_click = true;
        }
    }//GEN-LAST:event_jtfBuscarMouseClicked

    private void jtfProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfProductoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfProductoMouseClicked

    private void jtfPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfPrecioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPrecioMouseClicked

    public class Caja {

        private final Con_Caja con;
        private final DefaultTableModel modelo;

        public Caja() {
            modelo = new DefaultTableModel();
            modelo.addColumn("clave");
            modelo.addColumn("producto");
            modelo.addColumn("piezas");
            modelo.addColumn("precio");
            jtbCarrito.setModel(modelo);
            con = new Con_Caja(this);
            jbtBuscar.addActionListener(con);
            jbtAgregar.addActionListener(con);
            jbtQuitar.addActionListener(con);
            jbtNuevo.addActionListener(con);
            jbtCobrar.addActionListener(con);
        }

    }

    public class Visitas {

        private DefaultTableModel modelo;

        public Visitas() {
            modelo = (DefaultTableModel) jtVisitas.getModel();
        }

        public DefaultTableModel getModelo() {
            return modelo;
        }

        public void setModelo(DefaultTableModel modelo) {
            this.modelo = modelo;
            jtVisitas.setModel(modelo);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtAdministracion;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtCobrar;
    private javax.swing.JButton jbtEmpleados;
    private javax.swing.JButton jbtNuevo;
    private javax.swing.JButton jbtProductos;
    private javax.swing.JButton jbtQuitar;
    private javax.swing.JButton jbtSalir;
    private javax.swing.JSpinner jspPiezas;
    private javax.swing.JTable jtVisitas;
    private javax.swing.JTable jtbCarrito;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfCambio;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfProducto;
    private javax.swing.JTextField jtfRecibido;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}
