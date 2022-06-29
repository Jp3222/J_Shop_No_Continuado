package jshop.modulo.vistas;

import java.util.ArrayList;
import jshop.modulo.controlador.Con_Menu;
import jshop.modulo.controlador.Con_Menu.Con_Caja;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import jshop.modulo.Auxiliares.Observador;
import jshop.modulo.OperacioneDelSistema;
import jshop.modulo.Programa;
import jshop.modulo.controlador.ControladorWindows;
import jshop.modulo.modelo.Cache;
import jshop.modulo.modelo.Objetos.OProducto;
import jshop.modulo.modelo.Sistema;
import jshop.modulo.modelo.func;

/**
 *
 * @author jp
 */
public class Vista_Menu extends Vista implements BasicoFrame {

    //Ventanas
    private Vista_Administracion administracion;
    private final Vista_Login login;
    //Controladores
    private ControladorWindows controladorWindows;
    private Con_Menu controlador;
    //Sub clases auxiliares
    private Caja caja;
    //Variables
    private DefaultListModel<String> lista_modelo_productos;
    private Cache memoria_cache;
    private ArrayList<OProducto> lista_productos;

    public Vista_Menu(Vista_Login login) {
        super("menu");
        this.login = login;
        initComponents();
        Ventana();
        initVariables();
    }

    @Override
    public final void Ventana() {
        this.setTitle(Programa.getTitulo(1));
        this.setIconImage(Programa.getICONO());

    }

    @Override
    public final void initVariables() {
        this.lista_modelo_productos = new DefaultListModel<>();
        this.memoria_cache = Cache.getInstancia();
        this.lista_productos = memoria_cache.getProductos();
        //Ventanas
        this.administracion = new Vista_Administracion(this);
        //controladores
        this.controlador = new Con_Menu(this);
        this.controladorWindows = new ControladorWindows();
        //asignando ventanas siguientes
        this.controlador.setLogin(login);
        //this.controlador.setProductos(productos);
        this.controlador.setAdministracion(administracion);
        //Sub Clases
        this.caja = new Caja();
        this.jlProductos_Listados.setModel(lista_modelo_productos);
        addListerners();
    }

    @Override
    public void addListerners() {
        this.addWindowListener(controladorWindows);
        //Botones
        jbtAdministracion.addActionListener(controlador);
        jbtSalir.addActionListener(controlador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtSalir = new javax.swing.JButton();
        jbtAdministracion = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCarrito = new javax.swing.JTable();
        jbtBuscar = new javax.swing.JButton();
        jbtCobrar = new javax.swing.JButton();
        jbtNuevo = new javax.swing.JButton();
        jbtQuitar = new javax.swing.JButton();
        jbtAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfProductoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfProductoPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jspProductoPiezas = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jtfRecibido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfCambio = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jtfProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlProductos_Listados = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVisitas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu - JShop");
        setMinimumSize(new java.awt.Dimension(1200, 600));

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1210, 600));

        jPanel2.setBackground(new java.awt.Color(168, 168, 168));
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

        jbtAdministracion.setBackground(new java.awt.Color(33, 176, 255));
        jbtAdministracion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtAdministracion.setForeground(new java.awt.Color(254, 254, 254));
        jbtAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/investigacion.png"))); // NOI18N
        jbtAdministracion.setText("Administracion");
        jbtAdministracion.setActionCommand("opc3");
        jbtAdministracion.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(254, 254, 254));
        jTabbedPane1.setForeground(new java.awt.Color(1, 1, 1));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(653, 400));

        jPanel3.setBackground(new java.awt.Color(132, 132, 132));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(875, 553));

        jtbCarrito.setAutoCreateRowSorter(true);
        jtbCarrito.setBackground(new java.awt.Color(254, 254, 254));
        jtbCarrito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbCarrito.setForeground(new java.awt.Color(1, 1, 1));
        jtbCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clave", "Producto", "Piezas", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbCarrito.setToolTipText("Lista de productos con el precio de los productos añadidos");
        jtbCarrito.setCellSelectionEnabled(false);
        jtbCarrito.setGridColor(new java.awt.Color(0, 203, 255));
        jtbCarrito.setInheritsPopupMenu(true);
        jtbCarrito.setSelectionBackground(new java.awt.Color(254, 254, 254));
        jtbCarrito.setSelectionForeground(new java.awt.Color(1, 1, 1));
        jtbCarrito.setShowGrid(true);
        jtbCarrito.getTableHeader().setReorderingAllowed(false);
        jtbCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCarritoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCarrito);

        jbtBuscar.setBackground(new java.awt.Color(209, 209, 209));
        jbtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtBuscar.setForeground(new java.awt.Color(1, 1, 1));
        jbtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe.png"))); // NOI18N
        jbtBuscar.setText("buscar");
        jbtBuscar.setToolTipText("Este boton despliega una ventana con la cual se podra buscar algun producto identificado por id. nombre o clave");
        jbtBuscar.setActionCommand("b1");
        jbtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtCobrar.setBackground(new java.awt.Color(209, 209, 209));
        jbtCobrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtCobrar.setForeground(new java.awt.Color(1, 1, 1));
        jbtCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dinero.png"))); // NOI18N
        jbtCobrar.setText("Cobrar");
        jbtCobrar.setActionCommand("b5");
        jbtCobrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtNuevo.setBackground(new java.awt.Color(209, 209, 209));
        jbtNuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtNuevo.setForeground(new java.awt.Color(1, 1, 1));
        jbtNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/limpiar.png"))); // NOI18N
        jbtNuevo.setText("Nuevo");
        jbtNuevo.setActionCommand("b4");
        jbtNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        jbtQuitar.setBackground(new java.awt.Color(209, 209, 209));
        jbtQuitar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtQuitar.setForeground(new java.awt.Color(1, 1, 1));
        jbtQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/quitar-del-carrito (1).png"))); // NOI18N
        jbtQuitar.setText("Quitar");
        jbtQuitar.setActionCommand("b3");
        jbtQuitar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jbtAgregar.setBackground(new java.awt.Color(209, 209, 209));
        jbtAgregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtAgregar.setForeground(new java.awt.Color(1, 1, 1));
        jbtAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/carrito-de-compras (1).png"))); // NOI18N
        jbtAgregar.setText("Agregar");
        jbtAgregar.setToolTipText("- Agregar -\nAgrega el producto buscado con el precio ya calculado (determinado por las piezas seleccionadas)\ndentro de la lista de compra");
        jbtAgregar.setActionCommand("b2");
        jbtAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jtfProductoNombre.setEditable(false);
        jtfProductoNombre.setBackground(new java.awt.Color(254, 254, 254));
        jtfProductoNombre.setForeground(new java.awt.Color(1, 1, 1));

        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Precio");

        jtfProductoPrecio.setEditable(false);
        jtfProductoPrecio.setBackground(new java.awt.Color(254, 254, 254));
        jtfProductoPrecio.setForeground(new java.awt.Color(1, 1, 1));

        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Piezas");

        jspProductoPiezas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jspProductoPiezas.setToolTipText("Con este componente puede definir cuantos productos agregar al carrito");
        jspProductoPiezas.setEditor(new javax.swing.JSpinner.NumberEditor(jspProductoPiezas, ""));
        jspProductoPiezas.setRequestFocusEnabled(false);

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

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Clave", "Id" }));
        jComboBox1.setBorder(null);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jtfProducto.setBackground(new java.awt.Color(255, 255, 255));
        jtfProducto.setForeground(new java.awt.Color(0, 0, 0));
        jtfProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfProductoKeyPressed(evt);
            }
        });

        jlProductos_Listados.setBackground(new java.awt.Color(255, 255, 255));
        jlProductos_Listados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jlProductos_Listados.setForeground(new java.awt.Color(0, 0, 0));
        jlProductos_Listados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlProductos_Listados.setToolTipText("Esta seccion muestra un listado de todos <br>\nlos productos que coinciden con el texto escrito");
        jlProductos_Listados.setSelectionBackground(new java.awt.Color(102, 255, 255));
        jlProductos_Listados.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jlProductos_Listados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlProductos_ListadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jlProductos_Listados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfRecibido)
                            .addComponent(jtfTotal)
                            .addComponent(jtfCambio)))
                    .addComponent(jbtCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfProductoNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfProductoPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jspProductoPiezas, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, 124, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfProductoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfProductoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jspProductoPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jScrollPane1))
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
            .addGap(0, 890, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Visitas", new javax.swing.ImageIcon(getClass().getResource("/Icons/la-proxima-semana.png")), jPanel4); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void admin() {
        jbtAdministracion.setEnabled(true);
    }

    public void empleado() {
        jbtAdministracion.setEnabled(false);
    }

    private void jlProductos_ListadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductos_ListadosMouseClicked
        if (evt.getClickCount() == 1) {
            jtfProducto.setText(jlProductos_Listados.getSelectedValue());
        }
        if (evt.getClickCount() == 2) {
            caja.setProducto(func.Filtro_Entrada(jtfProducto.getText()));
            lista_modelo_productos.removeAllElements();
            jtfProducto.setText("");
        }
    }//GEN-LAST:event_jlProductos_ListadosMouseClicked


    private void jtfProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfProductoKeyPressed
        lista_modelo_productos.removeAllElements();
        String entrada = jtfProducto.getText();
        String campo = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
        listar_productos(campo.toLowerCase(), func.Filtro_Entrada(entrada));
    }//GEN-LAST:event_jtfProductoKeyPressed

    public void listar_productos(String campo, String valor) {
        boolean filtro;
        for (OProducto o : lista_productos) {
            filtro = filtar_x_produtos(campo, valor, o);
            if (filtro) {
                lista_modelo_productos.addElement(func.Filtro_Salida(o.getNombre()));
            }
        }
    }

    public boolean filtar_x_produtos(String campo, String valor, OProducto o) {
        switch (campo) {
            case "nombre":
                return o.getNombre().contains(valor);
            case "clave":
                return o.getClave().contains(valor);
            case "id":
                String aux = "" + o.getId();
                return aux.contains(valor);
        }
        return false;
    }

    public void xd(String entrada) {
        lista_productos.stream()
                .filter((t) -> t.getNombre().contains(func.Filtro_Entrada(entrada)))
                .forEach((t) -> {
                    lista_modelo_productos.addElement(func.Filtro_Salida(t.getNombre()));
                });
    }

    private void jtbCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCarritoMouseClicked
        caja.setProductoQuitar(jtbCarrito.getSelectedRow());
    }//GEN-LAST:event_jtbCarritoMouseClicked

    public class Caja implements Observador, Basico {

        private String producto;
        private Con_Caja controladorCaja;

        public Caja() {
            initVariables();
        }

        @Override
        public final void initVariables() {
            controladorCaja = controlador.getCon_Caja(this, this, (DefaultTableModel) jtbCarrito.getModel());
            addListerners();
        }

        @Override
        public void addListerners() {
            jbtBuscar.addActionListener(controladorCaja);
            jbtAgregar.addActionListener(controladorCaja);
            jbtQuitar.addActionListener(controladorCaja);
            jbtNuevo.addActionListener(controladorCaja);
            jbtCobrar.addActionListener(controladorCaja);
        }

        public void setProducto(String producto) {
            this.producto = producto;
            controladorCaja.Buscar();
        }

        public void setProductoQuitar(int row) {
            controladorCaja.setQuitar(row);
        }

        public boolean datosProductoVacios() {
            return noValido(jtfProductoNombre.getText()) && noValido(jtfProductoPrecio.getText());
        }

        public boolean buscarProductoVacio() {
            return noValido(jtfProducto.getText());
        }

        private boolean noValido(String str) {
            return str == null || str.trim().isEmpty();
        }

        public void mostrarTotal() {
            jtfTotal.setText(controladorCaja.getTotal());
            jtfRecibido.setText(controladorCaja.getIngresado());
            jtfCambio.setText(controladorCaja.getCambio());
        }

        public void quitarTotal() {
            jtfTotal.setText("0.0");
            jtfRecibido.setText("0.0");
            jtfCambio.setText("0.0");
        }

        public void quitarDatosProducto() {
            jtfProductoNombre.setText("");
            jtfProductoPrecio.setText("");
            jspProductoPiezas.setValue(1);
        }

        public void actualizarTablaInvenario() {
            administracion.actualizarTablaInventario();
        }

        public String getProducto() {
            producto = func.Filtro_Entrada(jtfProducto.getText());
            return producto;
        }

        public int getPiezas() {
            return (Integer) jspProductoPiezas.getValue();
        }

        @Override
        public void event() {
            jtfProductoNombre.setText(producto);
            jtfProductoPrecio.setText(controladorCaja.getPrecio());
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

    // <editor-fold defaultstate="collapsed" desc="Variables generadas">
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtAdministracion;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtCobrar;
    private javax.swing.JButton jbtNuevo;
    private javax.swing.JButton jbtQuitar;
    private javax.swing.JButton jbtSalir;
    private javax.swing.JList<String> jlProductos_Listados;
    private javax.swing.JSpinner jspProductoPiezas;
    private javax.swing.JTable jtVisitas;
    private javax.swing.JTable jtbCarrito;
    private javax.swing.JTextField jtfCambio;
    private javax.swing.JTextField jtfProducto;
    private javax.swing.JTextField jtfProductoNombre;
    private javax.swing.JTextField jtfProductoPrecio;
    private javax.swing.JTextField jtfRecibido;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>     

}
