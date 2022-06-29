package jshop.modulo.vistas;

import com.jsql.conexion.Conexion;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import jshop.modulo.Auxiliares.Observador;
import jshop.modulo.Programa;
import jshop.modulo.controlador.Con_Productos;
import jshop.modulo.modelo.Cache;
import jshop.modulo.modelo.Const;
import jshop.modulo.modelo.Objetos.OMarcas;
import jshop.modulo.modelo.func;

/**
 *
 * @author jp
 */
public final class Vista_Productos extends Vista implements Observador, BasicoFrame {

    private Con_Productos controlador;
    private final Conexion cn;
    private final Cache cache;
    private final ArrayList<OMarcas> lista_de_marcas;

    /**
     * Creates new form Productos
     *
     * @param administracion
     * @param menu
     */
    public Vista_Productos(Vista_Administracion administracion) {
         
        super("productos");
        //variables
        cn = Conexion.getInstancia();
        cache = Cache.getInstancia();
        lista_de_marcas = cache.getMarcas();
        //componentes
        initComponents();
        initVariables();
        Ventana();
        controlador.setMenu(administracion);
        ImageIcon image = new ImageIcon(getClass().getResource("/Icons/Ico/JSHOP_2.png"));
        this.setIconImage(image.getImage());
    }

    @Override
    public void Ventana() {
        this.setTitle(Programa.getTitulo(3));
        this.setIconImage(Programa.getICONO());
    }

    @Override
    public void initVariables() {
        controlador = new Con_Productos(this);
        controlador.setTbmConsultas((DefaultTableModel) jtConsultas.getModel());
        controlador.setTbActualizacion((DefaultTableModel) jtActualizar.getModel());
        addListerners();
    }

    @Override
    public void addListerners() {
        jbtGuardar.addActionListener(controlador);
        jbtAtras.addActionListener(controlador);
        jbtConsultarReiniciarTabla.addActionListener(e -> controlador.ActualizarTablaConsultas(0, -1, -1));
        //
        jtpCRUD.addChangeListener((e) -> CambioDePanel(e));
        //
        jbtAplicar.addActionListener(e -> aplicar_filtro());
    }

    public void CambioDePanel(ChangeEvent e) {
        if (jpConsultar.isVisible()) {
            controlador.ActualizarTablaConsultas(0, -1, -1);
        } else {
            controlador.RemoverTablaConsultas();
        }
        //
        if (jpActualizar.isVisible()) {
            controlador.ActualizarTablaActualizaciones();
        } else {
            controlador.RemoverTablaActualizaciones();
        }
    }

    public String[] getDatosInserccion() {
        final String info[] = new String[Const.getBD_PRODUCTOS().length];
        info[0] = "" + 0;
        info[3] = jcbMarcas.getItemAt(jcbMarcas.getSelectedIndex());
        info[4] = jtfCont.getText();
        info[5] = jcbUdm.getItemAt(jcbUdm.getSelectedIndex());
        info[6] = jtfPrecio.getText();
        info[7] = "null";
        info[2] = jtfNombre.getText() + " " + info[4] + info[5];
        int i = getIdMarca(info[3]);
        info[3] = "" + i;
        info[1] = func.key(i, info[2], info[4], info[5]);
        return info;
    }

    public String[] getActualizacion() {
        final String info[] = new String[Const.getBD_PRODUCTOS().length];
        info[0] = "" + 0;
        info[3] = jcbMarcas.getItemAt(jcbMarcas.getSelectedIndex());
        info[4] = jtfCont.getText();
        info[5] = jcbUdm.getItemAt(jcbUdm.getSelectedIndex());
        info[6] = jtfPrecio.getText();
        info[7] = "null";
        info[2] = jtfNombre.getText() + " " + info[4] + info[5];
        int i = getIdMarca(info[3]);
        info[3] = i + "";
        info[1] = func.key(i, info[2], info[4], info[5]);
        return info;
    }

    public int getIdMarca(String marca) {
        for (OMarcas o : lista_de_marcas) {
            if (marca.equalsIgnoreCase(o.getNombre())) {
                return o.getId();
            }
        }
        return -1;
    }

    public void limpiarCampos() {
        jtfNombre.setText("");
        jtfCont.setText("");
        jtfPrecio.setText("");
        if (!jcbxMarca.isSelected()) {
            jcbMarcas.setSelectedIndex(0);
        }
        if (!jcbxUdm.isSelected()) {
            jcbUdm.setSelectedIndex(0);

        }
    }

    public void aplicar_filtro() {
        String in = jcbMarcas2.getItemAt(jcbMarcas2.getSelectedIndex());
        int marca = -1;
        if (jcbMarcas2.getSelectedIndex() > 0) {
            try {
                ResultSet select = cn.select("marcas", "id", "nombre = '" + in + "'");
                if (select.next()) {
                    marca = select.getInt("id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Vista_Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        double min = 0;
        if (textoValid(jtfMin.getText()) && !jtfMin.getText().equalsIgnoreCase("na")) {
            min = Double.parseDouble(jtfMin.getText());
        }
        double max = -1;
        if (textoValid(jtfMax.getText()) && !jtfMax.getText().equalsIgnoreCase("na")) {
            max = Double.parseDouble(jtfMax.getText());
        }
        controlador.ActualizarTablaConsultas(min, max, marca);
    }

    public boolean CamposVaciosInsert() {
        int i = 0;
        if (!textoValid(jtfNombre.getText())) {
            i++;
        }
        if (jcbMarcas.getSelectedIndex() <= 0) {
            i++;
        }
        if (!textoValid(jtfCont.getText())) {
            i++;
        }
        if (jcbUdm.getSelectedIndex() <= 0) {
            i++;
        }
        if (!textoValid(jtfPrecio.getText())) {
            i++;
        }
        return i > 0;
    }

    public boolean CamposVaciosAct() {
        int i = 0;
        if (!textoValid(jtfNombreAct.getText())) {
            i++;
        }
        if (jcbMarcasAct.getSelectedIndex() <= 0) {
            i++;
        }
        if (!textoValid(jtfContAct.getText())) {
            i++;
        }
        if (jcbUdmAct.getSelectedIndex() <= 0) {
            i++;
        }
        if (!textoValid(jtfPrecioAct.getText())) {
            i++;
        }
        return i > 0;
    }

    public boolean textoValid(String str) {
        return str != null && !str.isEmpty();
    }

    @Override
    public final void event() {
        event1();
        event2();
        event3();
    }

    public void event1() {
        if (jcbMarcas.getItemCount() > 0) {
            jcbMarcas.removeAllItems();
        }
        jcbMarcas.addItem("- - Marcas - - ");
        for (OMarcas marca : lista_de_marcas) {
            jcbMarcas.addItem(marca.getNombre());
        }
    }

    public void event2() {
        if (jcbMarcas2.getItemCount() > 0) {
            jcbMarcas2.removeAllItems();
        }
        jcbMarcas2.addItem("Seleccione una Marca");
        for (OMarcas marca : lista_de_marcas) {
            jcbMarcas2.addItem(marca.getNombre());
        }
    }

    public void event3() {
        if (jcbMarcasAct.getItemCount() > 0) {
            jcbMarcasAct.removeAllItems();
        }
        jcbMarcasAct.addItem("Seleccione una Marca");
        for (OMarcas marca : lista_de_marcas) {
            jcbMarcasAct.addItem(marca.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpRoot = new javax.swing.JPanel();
        jpBarraLateral = new javax.swing.JPanel();
        jlbIcono = new javax.swing.JLabel();
        jbtAtras = new javax.swing.JButton();
        jtpCRUD = new javax.swing.JTabbedPane();
        jpInsertar = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfCont = new javax.swing.JTextField();
        jtfPrecio = new javax.swing.JTextField();
        jbtAtras1 = new javax.swing.JButton();
        jbtGuardar = new javax.swing.JButton();
        Fotos = new javax.swing.JPanel();
        jbtImg = new javax.swing.JButton();
        jcbxMarca = new javax.swing.JCheckBox();
        jcbxUdm = new javax.swing.JCheckBox();
        jcbMarcas = new javax.swing.JComboBox<>();
        jcbUdm = new javax.swing.JComboBox<>();
        jtbActualizarMemoria = new javax.swing.JButton();
        jpConsultar = new javax.swing.JPanel();
        jpProductosBus = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();
        jbtConsultarReiniciarTabla = new javax.swing.JButton();
        jpFiltros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbMarcas2 = new javax.swing.JComboBox<>();
        jtfMin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfMax = new javax.swing.JTextField();
        jbtAplicar = new javax.swing.JButton();
        jbtVerProducto = new javax.swing.JButton();
        jpActualizar = new javax.swing.JPanel();
        jpProductosAct = new javax.swing.JPanel();
        jbtAtras8 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtfNombreAct = new javax.swing.JTextField();
        jcbMarcasAct = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfContAct = new javax.swing.JTextField();
        jcbUdmAct = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtfPrecioAct = new javax.swing.JTextField();
        jbtGuardar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtActualizar = new javax.swing.JTable();
        jbtGuardar2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos - J Shop");

        jpRoot.setBackground(new java.awt.Color(254, 254, 254));
        jpRoot.setPreferredSize(new java.awt.Dimension(1200, 600));

        jpBarraLateral.setBackground(new java.awt.Color(168, 168, 168));
        jpBarraLateral.setForeground(new java.awt.Color(168, 168, 168));
        jpBarraLateral.setPreferredSize(new java.awt.Dimension(288, 268));

        jlbIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (1).png"))); // NOI18N

        jbtAtras.setBackground(new java.awt.Color(255, 22, 0));
        jbtAtras.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtAtras.setForeground(new java.awt.Color(254, 254, 254));
        jbtAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flecha-hacia-atras.png"))); // NOI18N
        jbtAtras.setText("Atras");
        jbtAtras.setActionCommand("atras");
        jbtAtras.setFocusPainted(false);
        jbtAtras.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jpBarraLateralLayout = new javax.swing.GroupLayout(jpBarraLateral);
        jpBarraLateral.setLayout(jpBarraLateralLayout);
        jpBarraLateralLayout.setHorizontalGroup(
            jpBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
            .addGroup(jpBarraLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpBarraLateralLayout.setVerticalGroup(
            jpBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarraLateralLayout.createSequentialGroup()
                .addComponent(jlbIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
                .addComponent(jbtAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtpCRUD.setBackground(new java.awt.Color(254, 254, 254));
        jtpCRUD.setForeground(new java.awt.Color(1, 1, 1));
        jtpCRUD.setOpaque(true);
        jtpCRUD.setPreferredSize(new java.awt.Dimension(840, 588));

        jpInsertar.setBackground(new java.awt.Color(132, 132, 132));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel9.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Nombre :");

        jtfNombre.setBackground(new java.awt.Color(254, 254, 254));
        jtfNombre.setForeground(new java.awt.Color(1, 1, 1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Precio :");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Marca :");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Unidad de medida :");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Contenido :");

        jtfCont.setBackground(new java.awt.Color(254, 254, 254));
        jtfCont.setForeground(new java.awt.Color(1, 1, 1));

        jtfPrecio.setBackground(new java.awt.Color(254, 254, 254));
        jtfPrecio.setForeground(new java.awt.Color(1, 1, 1));

        jbtAtras1.setBackground(new java.awt.Color(255, 22, 0));
        jbtAtras1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtAtras1.setForeground(new java.awt.Color(1, 1, 1));
        jbtAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cancelar.png"))); // NOI18N
        jbtAtras1.setText("Cancelar");
        jbtAtras1.setActionCommand("npCancelar");
        jbtAtras1.setFocusPainted(false);
        jbtAtras1.setPreferredSize(new java.awt.Dimension(100, 40));

        jbtGuardar.setBackground(new java.awt.Color(33, 176, 255));
        jbtGuardar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtGuardar.setForeground(new java.awt.Color(1, 1, 1));
        jbtGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/disquete.png"))); // NOI18N
        jbtGuardar.setText("Guardar");
        jbtGuardar.setActionCommand("npGuardar");
        jbtGuardar.setFocusPainted(false);
        jbtGuardar.setOpaque(true);
        jbtGuardar.setPreferredSize(new java.awt.Dimension(100, 40));

        Fotos.setForeground(new java.awt.Color(198, 183, 216));
        Fotos.setToolTipText("");
        Fotos.setEnabled(false);
        Fotos.setOpaque(false);

        javax.swing.GroupLayout FotosLayout = new javax.swing.GroupLayout(Fotos);
        Fotos.setLayout(FotosLayout);
        FotosLayout.setHorizontalGroup(
            FotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        FotosLayout.setVerticalGroup(
            FotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jbtImg.setBackground(new java.awt.Color(204, 204, 204));
        jbtImg.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtImg.setForeground(new java.awt.Color(1, 1, 1));
        jbtImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/galeria-de-fotos.png"))); // NOI18N
        jbtImg.setText("Añadir Imagen");
        jbtImg.setActionCommand("npImagen");
        jbtImg.setEnabled(false);
        jbtImg.setFocusPainted(false);
        jbtImg.setPreferredSize(new java.awt.Dimension(100, 40));

        jcbxMarca.setText("Mantener marca");

        jcbxUdm.setText("Mantener medida");

        jcbMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Marcas - -" }));

        jcbUdm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidades de Medida.", "KG", "G", "L", "ML" }));

        jtbActualizarMemoria.setBackground(new java.awt.Color(204, 204, 204));
        jtbActualizarMemoria.setForeground(new java.awt.Color(0, 0, 0));
        jtbActualizarMemoria.setText("Actualizar Memoria");
        jtbActualizarMemoria.setToolTipText(""); // NOI18N
        jtbActualizarMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbActualizarMemoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNombre))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jbtGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(jbtAtras1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCont)
                            .addComponent(jcbMarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbUdm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbxUdm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jtbActualizarMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jcbxMarca)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCont, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbUdm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jcbxUdm)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jbtImg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtAtras1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtbActualizarMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Fotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpInsertarLayout = new javax.swing.GroupLayout(jpInsertar);
        jpInsertar.setLayout(jpInsertarLayout);
        jpInsertarLayout.setHorizontalGroup(
            jpInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInsertarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpInsertarLayout.setVerticalGroup(
            jpInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInsertarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpCRUD.addTab("Nuevo Producto", jpInsertar);

        jpConsultar.setBackground(new java.awt.Color(132, 132, 132));

        jpProductosBus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(1, 1, 1))); // NOI18N
        jpProductosBus.setOpaque(false);

        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Marca", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtConsultas);

        jbtConsultarReiniciarTabla.setBackground(new java.awt.Color(255, 22, 0));
        jbtConsultarReiniciarTabla.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtConsultarReiniciarTabla.setForeground(new java.awt.Color(254, 254, 254));
        jbtConsultarReiniciarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        jbtConsultarReiniciarTabla.setText("Reiniciar Tabla");
        jbtConsultarReiniciarTabla.setActionCommand("xd");
        jbtConsultarReiniciarTabla.setFocusPainted(false);
        jbtConsultarReiniciarTabla.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jpProductosBusLayout = new javax.swing.GroupLayout(jpProductosBus);
        jpProductosBus.setLayout(jpProductosBusLayout);
        jpProductosBusLayout.setHorizontalGroup(
            jpProductosBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosBusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProductosBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addComponent(jbtConsultarReiniciarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpProductosBusLayout.setVerticalGroup(
            jpProductosBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductosBusLayout.createSequentialGroup()
                .addComponent(jbtConsultarReiniciarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(1, 1, 1))); // NOI18N
        jpFiltros.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Marca :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Precio");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jcbMarcas2.setBackground(new java.awt.Color(254, 254, 254));
        jcbMarcas2.setForeground(new java.awt.Color(1, 1, 1));
        jcbMarcas2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "todas" }));

        jtfMin.setText("NA");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Precio minimo:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("Precio maximo:");

        jtfMax.setText("NA");

        jbtAplicar.setBackground(new java.awt.Color(255, 22, 0));
        jbtAplicar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtAplicar.setForeground(new java.awt.Color(254, 254, 254));
        jbtAplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        jbtAplicar.setText("Aplicar");
        jbtAplicar.setActionCommand("xd");
        jbtAplicar.setFocusPainted(false);
        jbtAplicar.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jpFiltrosLayout = new javax.swing.GroupLayout(jpFiltros);
        jpFiltros.setLayout(jpFiltrosLayout);
        jpFiltrosLayout.setHorizontalGroup(
            jpFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtAplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbMarcas2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpFiltrosLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfMax))
                    .addGroup(jpFiltrosLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfMin)))
                .addContainerGap())
        );
        jpFiltrosLayout.setVerticalGroup(
            jpFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbMarcas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jbtAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbtVerProducto.setBackground(new java.awt.Color(255, 22, 0));
        jbtVerProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtVerProducto.setForeground(new java.awt.Color(254, 254, 254));
        jbtVerProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe.png"))); // NOI18N
        jbtVerProducto.setText("Ver producto");
        jbtVerProducto.setActionCommand("xd");
        jbtVerProducto.setFocusPainted(false);
        jbtVerProducto.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jpConsultarLayout = new javax.swing.GroupLayout(jpConsultar);
        jpConsultar.setLayout(jpConsultarLayout);
        jpConsultarLayout.setHorizontalGroup(
            jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpProductosBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtVerProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jpFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpConsultarLayout.setVerticalGroup(
            jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpProductosBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpConsultarLayout.createSequentialGroup()
                        .addComponent(jpFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jtpCRUD.addTab("Consultar Productos", jpConsultar);

        jpActualizar.setBackground(new java.awt.Color(132, 132, 132));

        jpProductosAct.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(1, 1, 1))); // NOI18N
        jpProductosAct.setOpaque(false);

        jbtAtras8.setBackground(new java.awt.Color(0, 255, 0));
        jbtAtras8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtAtras8.setForeground(new java.awt.Color(0, 0, 0));
        jbtAtras8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        jbtAtras8.setText("Actualizar");
        jbtAtras8.setActionCommand("xd");
        jbtAtras8.setFocusPainted(false);
        jbtAtras8.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("Nombre :");

        jtfNombreAct.setBackground(new java.awt.Color(254, 254, 254));
        jtfNombreAct.setColumns(3);
        jtfNombreAct.setForeground(new java.awt.Color(1, 1, 1));

        jcbMarcasAct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Marcas - -" }));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("Marca :");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 1, 1));
        jLabel12.setText("Contenido :");

        jtfContAct.setBackground(new java.awt.Color(254, 254, 254));
        jtfContAct.setForeground(new java.awt.Color(1, 1, 1));

        jcbUdmAct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidades de Medida.", "KG", "G", "L", "ML" }));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 1, 1));
        jLabel13.setText("Unidad de medida :");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setText("Precio :");

        jtfPrecioAct.setBackground(new java.awt.Color(254, 254, 254));
        jtfPrecioAct.setForeground(new java.awt.Color(1, 1, 1));

        jbtGuardar1.setBackground(new java.awt.Color(255, 0, 0));
        jbtGuardar1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtGuardar1.setForeground(new java.awt.Color(1, 1, 1));
        jbtGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cancelar.png"))); // NOI18N
        jbtGuardar1.setText("Eliminar");
        jbtGuardar1.setActionCommand("npGuardar");
        jbtGuardar1.setFocusPainted(false);
        jbtGuardar1.setPreferredSize(new java.awt.Dimension(100, 40));

        jtActualizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clave", "Nombre", "Marca", "Contenido", "Udm", "Precio"
            }
        ));
        jtActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtActualizarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtActualizar);

        jbtGuardar2.setBackground(new java.awt.Color(0, 204, 255));
        jbtGuardar2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtGuardar2.setForeground(new java.awt.Color(1, 1, 1));
        jbtGuardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/limpiar.png"))); // NOI18N
        jbtGuardar2.setText("Limpiar");
        jbtGuardar2.setActionCommand("npGuardar");
        jbtGuardar2.setFocusPainted(false);
        jbtGuardar2.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jpProductosActLayout = new javax.swing.GroupLayout(jpProductosAct);
        jpProductosAct.setLayout(jpProductosActLayout);
        jpProductosActLayout.setHorizontalGroup(
            jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductosActLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtAtras8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpProductosActLayout.createSequentialGroup()
                        .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombreAct, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfPrecioAct)
                            .addComponent(jtfContAct, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbMarcasAct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbUdmAct, 0, 189, Short.MAX_VALUE)))
                    .addComponent(jbtGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtGuardar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpProductosActLayout.setVerticalGroup(
            jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosActLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNombreAct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMarcasAct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfContAct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbUdmAct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpProductosActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrecioAct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtAtras8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpProductosActLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpActualizarLayout = new javax.swing.GroupLayout(jpActualizar);
        jpActualizar.setLayout(jpActualizarLayout);
        jpActualizarLayout.setHorizontalGroup(
            jpActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
            .addGroup(jpActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpActualizarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpProductosAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpActualizarLayout.setVerticalGroup(
            jpActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
            .addGroup(jpActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpActualizarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpProductosAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jtpCRUD.addTab("Actualizar Producto", jpActualizar);

        jToolBar1.setBackground(new java.awt.Color(153, 153, 153));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(50, 34));
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 40));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lista-de-deseos.png"))); // NOI18N
        jButton1.setToolTipText("Generar lista de productos");
        jButton1.setDisabledIcon(null);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/reporte-de-negocios.png"))); // NOI18N
        jButton2.setToolTipText("Generar informe");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setText("generar reporte de error");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        javax.swing.GroupLayout jpRootLayout = new javax.swing.GroupLayout(jpRoot);
        jpRoot.setLayout(jpRootLayout);
        jpRootLayout.setHorizontalGroup(
            jpRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpBarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpRootLayout.setVerticalGroup(
            jpRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBarraLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(jpRootLayout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtpCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbActualizarMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbActualizarMemoriaActionPerformed
        cache.reiniciarMarcas();
        cache.reiniciarProductos();
    }//GEN-LAST:event_jtbActualizarMemoriaActionPerformed

    private String array[] = new String[7];

    private void jtActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtActualizarMouseClicked
        int row = jtActualizar.getSelectedRow();
        for (int i = 0; i < jtActualizar.getColumnCount(); i++) {
            array[i] = (String) jtActualizar.getValueAt(row, i);
        }
        jtfNombreAct.setText((String) jtActualizar.getValueAt(row, 2));
        jcbMarcasAct.setSelectedItem(jtActualizar.getValueAt(row, 3) + "");
        jtfContAct.setText((String) jtActualizar.getValueAt(row, 4));
        jcbUdmAct.setSelectedItem(jtActualizar.getValueAt(row, 5) + "");
        jtfPrecioAct.setText((String) jtActualizar.getValueAt(row, 6));
    }//GEN-LAST:event_jtActualizarMouseClicked

// <editor-fold defaultstate="collapsed" desc="Generated Code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fotos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtAplicar;
    private javax.swing.JButton jbtAtras;
    private javax.swing.JButton jbtAtras1;
    private javax.swing.JButton jbtAtras8;
    private javax.swing.JButton jbtConsultarReiniciarTabla;
    private javax.swing.JButton jbtGuardar;
    private javax.swing.JButton jbtGuardar1;
    private javax.swing.JButton jbtGuardar2;
    private javax.swing.JButton jbtImg;
    private javax.swing.JButton jbtVerProducto;
    private javax.swing.JComboBox<String> jcbMarcas;
    private javax.swing.JComboBox<String> jcbMarcas2;
    private javax.swing.JComboBox<String> jcbMarcasAct;
    private javax.swing.JComboBox<String> jcbUdm;
    private javax.swing.JComboBox<String> jcbUdmAct;
    private javax.swing.JCheckBox jcbxMarca;
    private javax.swing.JCheckBox jcbxUdm;
    private javax.swing.JLabel jlbIcono;
    private javax.swing.JPanel jpActualizar;
    private javax.swing.JPanel jpBarraLateral;
    private javax.swing.JPanel jpConsultar;
    private javax.swing.JPanel jpFiltros;
    private javax.swing.JPanel jpInsertar;
    private javax.swing.JPanel jpProductosAct;
    private javax.swing.JPanel jpProductosBus;
    private javax.swing.JPanel jpRoot;
    private javax.swing.JTable jtActualizar;
    private javax.swing.JTable jtConsultas;
    private javax.swing.JButton jtbActualizarMemoria;
    private javax.swing.JTextField jtfCont;
    private javax.swing.JTextField jtfContAct;
    private javax.swing.JTextField jtfMax;
    private javax.swing.JTextField jtfMin;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNombreAct;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfPrecioAct;
    private javax.swing.JTabbedPane jtpCRUD;
    // End of variables declaration//GEN-END:variables
// </editor-fold>

}

class Visor extends JPanel {

    private final String url;

    public Visor(String url) {
        this.url = url;
    }

    @Override
    public void paint(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        ImageIcon image = new ImageIcon(url);
        //g.scale(-0.1, -0.1);
        g.drawImage(image.getImage(), 0, 0, 338, 469, this);
    }

}
