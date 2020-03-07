package Frames;

import Uml.Factura;
import java.awt.event.ItemEvent;
import java.util.Date;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Opciones extends javax.swing.JFrame {

    File archivo;
    private BufferedWriter bw;
    Thread cronometro;

    public Opciones() {
        //HILO CRONOMETRO
        this.cronometro = new Thread() {
            @Override
            public void run() {
                int hor = 0, min = 0, seg = 0;
                for (;;) {
                    try {
                        //System.out.println(hor+":"+min+":"+seg);
                        seg++;
                        if (seg > 59) {
                            seg = 0;
                            min++;
                        }
                        if (min > 59) {
                            seg = 0;
                            min = 0;
                            hor++;
                        }
                        int cont = 0;
                        int filas = datosTable2.getRowCount();
                        if (seg == 10) {
                            int fila = datosTable2.getSelectedRow();
                            datosTable2.getSelectedRow();
                            DefaultTableModel model = (DefaultTableModel) datosTable2.getModel();
                            model.removeRow(fila);
                            dispose();
                            lblTime.resetKeyboardActions();
                            lblTime.setText(String.valueOf("0"));
                            seg = 0;
                            cont = cont + 1;
                        }
                        if (cont == filas) {
                            JOptionPane.showMessageDialog(null, "Pedido listo para entregar a la mesa.");
                            break;
                        }

                        lblTime.setText(hor + ":" + min + ":" + seg);
                        Thread.sleep(999);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        initComponents();
        int totalisimo = 0;
        Pedido.setLocationRelativeTo(null);
        Cocina.setLocationRelativeTo(null);
        Factura.setLocationRelativeTo(null);

        //ESCRITURA DE PARRAFO EN UN LABEL
        fac.setText("<html><p>RESTAURANTE PITAKS </p><p>Colombia, Barranquilla</p><p>Teléfono: 30011111 - 31900000</p></html>");
        horario.setText("<html><p>Lunes a Sábado 9:00 a.m a 9:00 p.m </p><p> Domingos y Festivos 10:00 a.m a 8:00 p.m</p></html>");

        //PRODUCTOS
        ptr1 = new Nodo();
        ptr2 = null;

    }

    class Nodo {

        Nodo link;
        int numero;
    }

    class Nodo2 {

        Nodo2 link;
        int total;
        int mesa;
    }

    Nodo ptr1, ptr2;
    Nodo2 ptr3;

    Nodo agregarCola(Nodo ptr) {
        Nodo p = new Nodo();
        if (ptr == null) {
            ptr = p;
        } else {
            Nodo q = ptr;
            while (q.link != null) {
                q = q.link;
            }
            q.link = p;
        }
        return ptr;
    }

    Nodo agregarCola1(Nodo ptr, int num) {
        Nodo p = new Nodo();
        p.numero = num;
        if (ptr == null) {
            ptr = p;
        } else {
            Nodo q = ptr;
            while (q.link != null) {
                q = q.link;
            }
            q.link = p;
        }
        return ptr;

    }

    class NodoMesero {

        String nombre;
        int id;
        int mesero;
        String mesa;
        NodoMesero link;

    }
    NodoMesero ptr;

    private void GuardarInfoMesero(NodoMesero ptr) throws IOException {
        try (BufferedWriter bwr = new BufferedWriter(new FileWriter("Mesero.txt"))) {
            bwr.write("");

            NodoMesero p = ptr;

            while (p != null) {
                bwr.write(p.nombre + " " + p.id + " " + p.mesero + " " + p.mesa);
                p = p.link;
                bwr.newLine();
            }
        }
        bw.close();
    }

    NodoMesero agregarInfoMesero(NodoMesero ptr, String nom, int id, int mesero, String mesa) {
        NodoMesero p = new NodoMesero();
        p.nombre = nom;
        p.id = id;
        p.mesero = mesero;
        p.mesa = mesa;

        if (ptr == null) {
            ptr = p;
        } else {
            NodoMesero q = ptr;
            while (q.link != null) {
                q = q.link;
            }
            q.link = p;
        }
        return ptr;
    }

    File archivo2;

    void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this,
                mensaje,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }

    void guardarArchivo() throws IOException {
        // Crear un nuevo escritor
        try (BufferedWriter bwr = new BufferedWriter(
                new FileWriter(archivo))) {
            // Hallamos el numero de filas
            int filas = datosTable.getRowCount();

            // Tomamos el modelo
            DefaultTableModel model = (DefaultTableModel) datosTable.getModel();

            for (int i = 0; i < filas; ++i) {
                Object ingrediente = model.getValueAt(i, 0);
                Object cantidad = model.getValueAt(i, 1);

                bwr.write(ingrediente + "," + cantidad);
                bwr.newLine();
            }
        }
    }

    void limpiarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        imgSexi = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tiposBebidas = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        psici = new javax.swing.JLabel();
        pgriega = new javax.swing.JLabel();
        brasilia = new javax.swing.JComboBox<>();
        pitaSiciliana = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        pitaGriega = new javax.swing.JComboBox<>();
        pitaOpera = new javax.swing.JComboBox<>();
        damaBlanca = new javax.swing.JComboBox<>();
        bebidaCant = new javax.swing.JComboBox<>();
        brasi = new javax.swing.JLabel();
        popera = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dblanca = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        StockIngredientes = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        nombreArchivoTextField = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        fc = new javax.swing.JFileChooser();
        Mesero = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        nameMesero = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        numMesero = new javax.swing.JComboBox<>();
        guardarInfo = new javax.swing.JButton();
        generar = new javax.swing.JButton();
        mesasAsign = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Pedido = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        numMesa = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        datosTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        numMeserito = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        AñadirProd = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        cantProdNuevo = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        nuevoProd = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        Cocina = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        datosTable2 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        generaFact = new javax.swing.JButton();
        cocinar = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        Factura = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        factTable = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        telCli = new javax.swing.JTextField();
        cedulaCli = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        nombreCli = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        infoFact = new javax.swing.JLabel();
        fac = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jTextField40 = new javax.swing.JLabel();
        nombreMese = new javax.swing.JLabel();
        numMesa2 = new javax.swing.JLabel();
        horario = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TOTALtot = new javax.swing.JLabel();
        IVA = new javax.swing.JLabel();
        PROPINA = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        Estadisticas = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        emergente = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        mesaFact = new javax.swing.JTextField();
        generate = new javax.swing.JButton();
        resumenVentas = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMesas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        mejorPlato = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        nombrePlato0 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        fotoplato = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        nombrePlato1 = new javax.swing.JLabel();
        nombrePlato2 = new javax.swing.JLabel();
        nombrePlato3 = new javax.swing.JLabel();
        nombrePlato4 = new javax.swing.JLabel();
        nombrePlato5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        verMenu = new javax.swing.JButton();
        doPedido = new javax.swing.JButton();
        verCocina = new javax.swing.JButton();
        verEstadisticas = new javax.swing.JButton();
        infoMeseros = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        pagos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        Menu.setTitle("MENU PITAKS");
        Menu.setMinimumSize(new java.awt.Dimension(850, 611));
        Menu.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(19, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgSexi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gaseosa.png"))); // NOI18N
        jPanel2.add(imgSexi, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 100, 90));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/damablanca.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 100, 90));

        jButton1.setBackground(java.awt.Color.white);
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("VOLVER A OPCIONES");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 190, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pSiciliana.jpg"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 120, 90));

        tiposBebidas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tiposBebidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gaseosa Ligth : $ 2000", "Te Frío : $ 2500", "Agua Mineral : $ 3000" }));
        tiposBebidas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tiposBebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tiposBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposBebidasActionPerformed(evt);
            }
        });
        jPanel2.add(tiposBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, -1, 20));

        jButton2.setBackground(java.awt.Color.white);
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("TERMINAR ORDEN");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 160, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brasilia.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 120, 90));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pOpera.jpg"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 120, 90));

        psici.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        psici.setForeground(new java.awt.Color(255, 255, 255));
        psici.setText("Pita Siciliana: $27000");
        psici.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(psici, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 130, -1));

        pgriega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pgriega.setForeground(new java.awt.Color(255, 255, 255));
        pgriega.setText("Pita Griega: $20000");
        pgriega.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pgriega.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(pgriega, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 130, 20));

        brasilia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        brasilia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        brasilia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(brasilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, 40));

        pitaSiciliana.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pitaSiciliana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        pitaSiciliana.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(pitaSiciliana, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 40, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pgriega.jpg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 120, 90));

        pitaGriega.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        pitaGriega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        pitaGriega.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pitaGriega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pitaGriegaActionPerformed(evt);
            }
        });
        jPanel2.add(pitaGriega, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 40, 40));

        pitaOpera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pitaOpera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        pitaOpera.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(pitaOpera, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 40, 40));

        damaBlanca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        damaBlanca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        damaBlanca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        damaBlanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                damaBlancaActionPerformed(evt);
            }
        });
        jPanel2.add(damaBlanca, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 40, 40));

        bebidaCant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bebidaCant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        bebidaCant.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bebidaCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebidaCantActionPerformed(evt);
            }
        });
        jPanel2.add(bebidaCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 40, 40));

        brasi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        brasi.setForeground(new java.awt.Color(255, 255, 255));
        brasi.setText("Postre Brasilia: $10000");
        brasi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(brasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

        popera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        popera.setForeground(new java.awt.Color(255, 255, 255));
        popera.setText("Pita Opera: $15000");
        popera.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(popera, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 130, -1));

        jLabel1.setBackground(new java.awt.Color(51, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plantilla-de-menu-de-restaurante_23-2147535344.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 580, 570));

        dblanca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dblanca.setForeground(new java.awt.Color(255, 255, 255));
        dblanca.setText("Postre Dama Blanca: $8000");
        dblanca.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(dblanca, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plantilla-de-menu-de-restaurante_23-2147535344.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 600, 570));

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu.getContentPane());
        Menu.getContentPane().setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        StockIngredientes.setTitle("STOCK");
        StockIngredientes.setMinimumSize(new java.awt.Dimension(622, 433));
        StockIngredientes.setResizable(false);

        jPanel4.setMaximumSize(new java.awt.Dimension(623, 418));
        jPanel4.setMinimumSize(new java.awt.Dimension(623, 418));
        jPanel4.setPreferredSize(new java.awt.Dimension(622, 418));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setMaximumSize(new java.awt.Dimension(622, 418));
        jPanel6.setMinimumSize(new java.awt.Dimension(622, 418));
        jPanel6.setName(""); // NOI18N
        jPanel6.setLayout(null);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/VER PROD.png"))); // NOI18N
        jButton4.setText("VER INGREDIENTES");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);
        jButton4.setBounds(350, 90, 250, 60);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Archivo:");
        jPanel6.add(jLabel27);
        jLabel27.setBounds(30, 60, 60, 20);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/AÑADIR PROD.png"))); // NOI18N
        jButton5.setText("AÑADIR INGREDIENTES");
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);
        jButton5.setBounds(350, 160, 250, 60);

        nombreArchivoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreArchivoTextFieldActionPerformed(evt);
            }
        });
        jPanel6.add(nombreArchivoTextField);
        nombreArchivoTextField.setBounds(90, 60, 240, 20);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MODIF PROD.png"))); // NOI18N
        jButton6.setText("ELIMINAR INGREDIENTE");
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6);
        jButton6.setBounds(350, 240, 250, 60);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back (1).png"))); // NOI18N
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9);
        jButton9.setBounds(20, 340, 50, 50);

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INGREDIENTE", "CANTIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 0));
        jScrollPane3.setViewportView(jTable1);

        jPanel6.add(jScrollPane3);
        jScrollPane3.setBounds(30, 90, 300, 230);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kitchenthis.jpg"))); // NOI18N
        jPanel6.add(jLabel24);
        jLabel24.setBounds(0, 0, 620, 420);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout StockIngredientesLayout = new javax.swing.GroupLayout(StockIngredientes.getContentPane());
        StockIngredientes.getContentPane().setLayout(StockIngredientesLayout);
        StockIngredientesLayout.setHorizontalGroup(
            StockIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        StockIngredientesLayout.setVerticalGroup(
            StockIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Mesero.setTitle("INFO.MESERO");
        Mesero.setMinimumSize(new java.awt.Dimension(544, 481));
        Mesero.setResizable(false);

        jPanel8.setLayout(null);

        nameMesero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameMesero.setForeground(new java.awt.Color(255, 255, 255));
        nameMesero.setText("Nombre: ");
        jPanel8.add(nameMesero);
        nameMesero.setBounds(40, 100, 70, 20);

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel8.add(nombre);
        nombre.setBounds(210, 100, 100, 20);

        label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Numero de mesero:");
        jPanel8.add(label);
        label.setBounds(40, 180, 150, 20);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField1);
        jTextField1.setBounds(210, 140, 100, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Asignacion de mesas: ");
        jPanel8.add(jLabel10);
        jLabel10.setBounds(40, 230, 180, 17);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back (1).png"))); // NOI18N
        jButton16.setText("jButton16");
        jButton16.setContentAreaFilled(false);
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton16);
        jButton16.setBounds(20, 410, 60, 41);

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Numero identificacion: ");
        jPanel8.add(label1);
        label1.setBounds(40, 140, 160, 20);

        numMesero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        numMesero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        jPanel8.add(numMesero);
        numMesero.setBounds(230, 180, 60, 20);

        guardarInfo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        guardarInfo.setText("Guardar");
        guardarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarInfoActionPerformed(evt);
            }
        });
        jPanel8.add(guardarInfo);
        guardarInfo.setBounds(120, 380, 120, 30);

        generar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        generar.setText("Generar");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });
        jPanel8.add(generar);
        generar.setBounds(190, 260, 120, 30);

        mesasAsign.setBackground(new java.awt.Color(255, 255, 255));
        mesasAsign.setForeground(new java.awt.Color(255, 255, 255));
        mesasAsign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel8.add(mesasAsign);
        mesasAsign.setBounds(40, 300, 270, 60);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/JE_opt (3).jpg"))); // NOI18N
        jPanel8.add(jLabel15);
        jLabel15.setBounds(0, 0, 550, 480);

        javax.swing.GroupLayout MeseroLayout = new javax.swing.GroupLayout(Mesero.getContentPane());
        Mesero.getContentPane().setLayout(MeseroLayout);
        MeseroLayout.setHorizontalGroup(
            MeseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        MeseroLayout.setVerticalGroup(
            MeseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        Pedido.setTitle("PEDIDOS");
        Pedido.setMinimumSize(new java.awt.Dimension(840, 580));
        Pedido.setModal(true);
        Pedido.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(105, 92, 100));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Numero de mesa: ");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 158, 160, -1));

        numMesa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        numMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        numMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        numMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numMesaActionPerformed(evt);
            }
        });
        jPanel3.add(numMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 100, -1));

        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/atras.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 70, 70));

        datosTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        datosTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        datosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "VALOR", "CANTIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(datosTable);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 400, 230));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Numero de mesero:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 160, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/avatar3.jpg"))); // NOI18N
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 0, 500, 570));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PITAKS ");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 240, -1));

        numMeserito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        numMeserito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4" }));
        numMeserito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        numMeserito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numMeseritoActionPerformed(evt);
            }
        });
        jPanel3.add(numMeserito, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 100, -1));

        jButton3.setBackground(java.awt.Color.white);
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setText("MANDAR A COCINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 190, 30));

        javax.swing.GroupLayout PedidoLayout = new javax.swing.GroupLayout(Pedido.getContentPane());
        Pedido.getContentPane().setLayout(PedidoLayout);
        PedidoLayout.setHorizontalGroup(
            PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        PedidoLayout.setVerticalGroup(
            PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AñadirProd.setTitle("AÑADIR");
        AñadirProd.setMinimumSize(new java.awt.Dimension(403, 214));
        AñadirProd.setResizable(false);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(null);

        cantProdNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantProdNuevoActionPerformed(evt);
            }
        });
        cantProdNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantProdNuevoKeyTyped(evt);
            }
        });
        jPanel7.add(cantProdNuevo);
        cantProdNuevo.setBounds(210, 100, 130, 20);

        jButton8.setBackground(java.awt.Color.white);
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("AÑADIR");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8);
        jButton8.setBounds(110, 140, 130, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("NUEVO PRODUCTO: ");
        jPanel7.add(jLabel14);
        jLabel14.setBounds(40, 60, 140, 20);

        nuevoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProdActionPerformed(evt);
            }
        });
        nuevoProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nuevoProdKeyTyped(evt);
            }
        });
        jPanel7.add(nuevoProd);
        nuevoProd.setBounds(210, 60, 130, 20);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kitchenthis.jpg"))); // NOI18N
        jPanel7.add(jLabel25);
        jLabel25.setBounds(0, -40, 410, 270);

        javax.swing.GroupLayout AñadirProdLayout = new javax.swing.GroupLayout(AñadirProd.getContentPane());
        AñadirProd.getContentPane().setLayout(AñadirProdLayout);
        AñadirProdLayout.setHorizontalGroup(
            AñadirProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        AñadirProdLayout.setVerticalGroup(
            AñadirProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        Cocina.setTitle("COCINA");
        Cocina.setMinimumSize(new java.awt.Dimension(928, 393));
        Cocina.setResizable(false);

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setMaximumSize(new java.awt.Dimension(781, 393));
        jPanel9.setMinimumSize(new java.awt.Dimension(781, 393));
        jPanel9.setLayout(null);

        datosTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        datosTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        datosTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "CANTIDAD", "MESA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(datosTable2);

        jPanel9.add(jScrollPane4);
        jScrollPane4.setBounds(90, 50, 310, 300);

        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton11.setText("REGISTRAR OTRO PEDIDO");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton11);
        jButton11.setBounds(440, 240, 230, 40);

        generaFact.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        generaFact.setText("GENERAR FACTURA");
        generaFact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generaFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaFactActionPerformed(evt);
            }
        });
        jPanel9.add(generaFact);
        generaFact.setBounds(440, 180, 230, 40);

        cocinar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        cocinar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cocinar.setText("COCINAR");
        cocinar.setToolTipText("");
        cocinar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cocinar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cocinarMouseMoved(evt);
            }
        });
        cocinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cocinarActionPerformed(evt);
            }
        });
        jPanel9.add(cocinar);
        cocinar.setBounds(440, 110, 230, 30);

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("00:00:00");
        lblTime.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel9.add(lblTime);
        lblTime.setBounds(440, 50, 230, 40);

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kitchen2.jpg"))); // NOI18N
        jPanel9.add(jLabel26);
        jLabel26.setBounds(343, 0, 590, 390);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("PEDIDOS:");
        jPanel9.add(jLabel28);
        jLabel28.setBounds(90, 30, 100, 17);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back (1).png"))); // NOI18N
        jButton15.setText("jButton15");
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton15);
        jButton15.setBounds(10, 331, 60, 50);

        javax.swing.GroupLayout CocinaLayout = new javax.swing.GroupLayout(Cocina.getContentPane());
        Cocina.getContentPane().setLayout(CocinaLayout);
        CocinaLayout.setHorizontalGroup(
            CocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        CocinaLayout.setVerticalGroup(
            CocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        Factura.setTitle("FACTURA");
        Factura.setMinimumSize(new java.awt.Dimension(680, 694));
        Factura.setModal(true);
        Factura.setResizable(false);
        Factura.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel10.setMaximumSize(new java.awt.Dimension(620, 400));
        jPanel10.setMinimumSize(new java.awt.Dimension(620, 400));
        jPanel10.setLayout(null);

        factTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        factTable.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        factTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "         CONCEPTO", "            PRECIO", "             UNDS", "         SUBTOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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
        factTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(factTable);
        if (factTable.getColumnModel().getColumnCount() > 0) {
            factTable.getColumnModel().getColumn(0).setResizable(false);
            factTable.getColumnModel().getColumn(1).setResizable(false);
            factTable.getColumnModel().getColumn(2).setResizable(false);
            factTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel10.add(jScrollPane5);
        jScrollPane5.setBounds(50, 330, 590, 150);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel11.setLayout(null);

        telCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telCliKeyTyped(evt);
            }
        });
        jPanel11.add(telCli);
        telCli.setBounds(110, 70, 160, 20);

        cedulaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaCliKeyTyped(evt);
            }
        });
        jPanel11.add(cedulaCli);
        cedulaCli.setBounds(110, 40, 160, 20);

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel32.setText("Telefono:");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(10, 70, 90, 20);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel37.setText("Cedula:");
        jPanel11.add(jLabel37);
        jLabel37.setBounds(10, 44, 90, 20);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("Nombre Cliente:");
        jPanel11.add(jLabel29);
        jLabel29.setBounds(10, 14, 90, 20);

        nombreCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCliActionPerformed(evt);
            }
        });
        nombreCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreCliKeyTyped(evt);
            }
        });
        jPanel11.add(nombreCli);
        nombreCli.setBounds(110, 10, 160, 20);

        jPanel10.add(jPanel11);
        jPanel11.setBounds(50, 120, 310, 110);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back.png"))); // NOI18N
        jButton10.setToolTipText("Volver");
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton10);
        jButton10.setBounds(50, 570, 70, 70);

        infoFact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoFact.setText("Atendido por:");
        infoFact.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(infoFact);
        infoFact.setBounds(340, 290, 110, 30);

        fac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fac.setText("RESTAURANTE PITAKS");
        jPanel10.add(fac);
        fac.setBounds(50, 10, 340, 80);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Teléfono: 30011111 - 31900000");
        jPanel10.add(jLabel38);
        jLabel38.setBounds(50, 70, 200, 30);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("       Factura:            001         Serie:            1             Fecha:   ");
        jLabel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(jLabel39);
        jLabel39.setBounds(50, 250, 410, 30);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/store.png"))); // NOI18N
        jButton14.setContentAreaFilled(false);
        jPanel10.add(jButton14);
        jButton14.setBounds(410, 30, 210, 150);

        jTextField40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField40.setText("Mesa: ");
        jTextField40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(jTextField40);
        jTextField40.setBounds(50, 290, 60, 30);

        nombreMese.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreMese.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(nombreMese);
        nombreMese.setBounds(470, 290, 170, 30);

        numMesa2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numMesa2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(numMesa2);
        numMesa2.setBounds(120, 290, 60, 30);

        horario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horario.setText("Lunes a Sábado 9:00 am a 9:00 pm");
        jPanel10.add(horario);
        horario.setBounds(60, 510, 240, 60);

        jLabel33.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("HORARIO DE ATENCION");
        jPanel10.add(jLabel33);
        jLabel33.setBounds(100, 490, 170, 21);

        jLabel16.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel16.setText("+PROPINA");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(360, 510, 90, 20);

        jLabel18.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel18.setText("+IVA");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(360, 490, 90, 20);

        jLabel19.setFont(new java.awt.Font("Courier New", 3, 12)); // NOI18N
        jLabel19.setText("TOTAL COMPRA");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(360, 540, 110, 20);

        TOTALtot.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        TOTALtot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TOTALtot.setText("jLabel20");
        jPanel10.add(TOTALtot);
        TOTALtot.setBounds(530, 540, 80, 17);

        IVA.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        IVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        IVA.setText("jLabel20");
        jPanel10.add(IVA);
        IVA.setBounds(520, 490, 80, 14);

        PROPINA.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        PROPINA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PROPINA.setText("jLabel20");
        jPanel10.add(PROPINA);
        PROPINA.setBounds(520, 510, 80, 14);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pay-per-click (1).png"))); // NOI18N
        jButton19.setContentAreaFilled(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton19);
        jButton19.setBounds(550, 590, 70, 70);

        Factura.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 710));

        Estadisticas.setTitle("ESTADISTICAS");
        Estadisticas.setMinimumSize(new java.awt.Dimension(505, 428));
        Estadisticas.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/bars-chart.png"))); // NOI18N
        jButton13.setContentAreaFilled(false);
        jButton13.setRolloverEnabled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton13);
        jButton13.setBounds(360, 50, 100, 80);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/profits.png"))); // NOI18N
        jButton17.setContentAreaFilled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton17);
        jButton17.setBounds(350, 150, 100, 80);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/line-chart.png"))); // NOI18N
        jButton18.setContentAreaFilled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton18);
        jButton18.setBounds(350, 240, 97, 80);

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("RESUMEN DE VENTAS - MESAS ");
        jButton20.setContentAreaFilled(false);
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton20);
        jButton20.setBounds(50, 70, 270, 40);

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("NUMERO DE VENTAS REALIZADAS");
        jButton21.setContentAreaFilled(false);
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton21);
        jButton21.setBounds(50, 130, 280, 40);

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("PLATO MAS VENDIDO");
        jButton22.setContentAreaFilled(false);
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton22);
        jButton22.setBounds(50, 190, 270, 40);

        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("MESERO DEL DIA");
        jButton23.setContentAreaFilled(false);
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton23);
        jButton23.setBounds(50, 260, 270, 40);

        javax.swing.GroupLayout EstadisticasLayout = new javax.swing.GroupLayout(Estadisticas.getContentPane());
        Estadisticas.getContentPane().setLayout(EstadisticasLayout);
        EstadisticasLayout.setHorizontalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        EstadisticasLayout.setVerticalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        emergente.setMinimumSize(new java.awt.Dimension(366, 181));
        emergente.setUndecorated(true);
        emergente.setResizable(false);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setLayout(null);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("FACTURA DE LA MESA NO. ");
        jPanel12.add(jLabel30);
        jLabel30.setBounds(40, 40, 190, 30);

        mesaFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaFactActionPerformed(evt);
            }
        });
        mesaFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mesaFactKeyTyped(evt);
            }
        });
        jPanel12.add(mesaFact);
        mesaFact.setBounds(230, 40, 70, 30);

        generate.setBackground(java.awt.Color.white);
        generate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        generate.setText("GENERAR");
        generate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });
        jPanel12.add(generate);
        generate.setBounds(110, 90, 140, 30);

        javax.swing.GroupLayout emergenteLayout = new javax.swing.GroupLayout(emergente.getContentPane());
        emergente.getContentPane().setLayout(emergenteLayout);
        emergenteLayout.setHorizontalGroup(
            emergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        emergenteLayout.setVerticalGroup(
            emergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );

        resumenVentas.setTitle("VENTAS");
        resumenVentas.setMinimumSize(new java.awt.Dimension(451, 377));
        resumenVentas.setResizable(false);

        jPanel14.setBackground(new java.awt.Color(153, 153, 0));
        jPanel14.setForeground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(null);

        listMesas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listMesas.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        listMesas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Mesa 1", "Mesa 2", "Mesa 3", "Mesa 4", "Mesa 5", "Mesa 6", "Mesa 7", "Mesa 8", "Mesa 9", "Mesa 10", "Mesa 11", "Mesa 12", "Mesa 13", "Mesa 14", "Mesa 15", "Mesa 16", "Mesa 17", "Mesa 18", "Mesa 19", "Mesa 20" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listMesas.setSelectionBackground(new java.awt.Color(102, 153, 0));
        jScrollPane1.setViewportView(listMesas);

        jPanel14.add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 270, 210);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RESUMEN DE VENTAS pitaks");
        jPanel14.add(jLabel3);
        jLabel3.setBounds(40, 40, 270, 22);

        jButton28.setBackground(java.awt.Color.white);
        jButton28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton28.setText("VER VENTAS");
        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton28);
        jButton28.setBounds(110, 300, 120, 40);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kitchen2.jpg"))); // NOI18N
        jPanel14.add(jLabel20);
        jLabel20.setBounds(0, 0, 470, 390);

        javax.swing.GroupLayout resumenVentasLayout = new javax.swing.GroupLayout(resumenVentas.getContentPane());
        resumenVentas.getContentPane().setLayout(resumenVentasLayout);
        resumenVentasLayout.setHorizontalGroup(
            resumenVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );
        resumenVentasLayout.setVerticalGroup(
            resumenVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        mejorPlato.setMinimumSize(new java.awt.Dimension(547, 301));
        mejorPlato.setResizable(false);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setLayout(null);

        nombrePlato0.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato0.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato0.setText("Pita Griega");
        jPanel13.add(nombrePlato0);
        nombrePlato0.setBounds(40, 180, 210, 40);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MEJOR PLATO");
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(jLabel21);
        jLabel21.setBounds(190, 40, 320, 70);

        fotoplato.setForeground(new java.awt.Color(255, 255, 255));
        fotoplato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        fotoplato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(fotoplato);
        fotoplato.setBounds(260, 140, 220, 110);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/first.png"))); // NOI18N
        jPanel13.add(jLabel22);
        jLabel22.setBounds(50, 30, 160, 140);

        nombrePlato1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato1.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato1.setText("Pita Opera");
        jPanel13.add(nombrePlato1);
        nombrePlato1.setBounds(40, 180, 210, 40);

        nombrePlato2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato2.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato2.setText("Pita Siciliana");
        jPanel13.add(nombrePlato2);
        nombrePlato2.setBounds(40, 180, 210, 40);

        nombrePlato3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato3.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato3.setText("Postre Brasilia");
        jPanel13.add(nombrePlato3);
        nombrePlato3.setBounds(40, 180, 210, 40);

        nombrePlato4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato4.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato4.setText("Postre Dama Blanca");
        jPanel13.add(nombrePlato4);
        nombrePlato4.setBounds(40, 180, 210, 40);

        nombrePlato5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato5.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato5.setText("Bebidas");
        jPanel13.add(nombrePlato5);
        nombrePlato5.setBounds(40, 180, 210, 40);

        javax.swing.GroupLayout mejorPlatoLayout = new javax.swing.GroupLayout(mejorPlato.getContentPane());
        mejorPlato.getContentPane().setLayout(mejorPlatoLayout);
        mejorPlatoLayout.setHorizontalGroup(
            mejorPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );
        mejorPlatoLayout.setVerticalGroup(
            mejorPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(540, 411));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu.png"))); // NOI18N
        verMenu.setContentAreaFilled(false);
        verMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                verMenuMouseMoved(evt);
            }
        });
        verMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMenuActionPerformed(evt);
            }
        });
        jPanel1.add(verMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 140, 140));

        doPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/notas.png"))); // NOI18N
        doPedido.setContentAreaFilled(false);
        doPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doPedido.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                doPedidoMouseMoved(evt);
            }
        });
        doPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(doPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 150, 140));

        verCocina.setForeground(new java.awt.Color(204, 204, 204));
        verCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cocinero.png"))); // NOI18N
        verCocina.setBorderPainted(false);
        verCocina.setContentAreaFilled(false);
        verCocina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verCocina.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                verCocinaMouseMoved(evt);
            }
        });
        verCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCocinaActionPerformed(evt);
            }
        });
        jPanel1.add(verCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 150, 140));

        verEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/estadisticas.png"))); // NOI18N
        verEstadisticas.setContentAreaFilled(false);
        verEstadisticas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verEstadisticas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                verEstadisticasMouseMoved(evt);
            }
        });
        verEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEstadisticasActionPerformed(evt);
            }
        });
        jPanel1.add(verEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 150, 140));

        infoMeseros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/anillo.png"))); // NOI18N
        infoMeseros.setContentAreaFilled(false);
        infoMeseros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoMeseros.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                infoMeserosMouseMoved(evt);
            }
        });
        infoMeseros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMeserosActionPerformed(evt);
            }
        });
        jPanel1.add(infoMeseros, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 140, 140));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exit.png"))); // NOI18N
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 60, 50));

        pagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dinero.png"))); // NOI18N
        pagos.setContentAreaFilled(false);
        pagos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pagos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pagosMouseMoved(evt);
            }
        });
        pagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagosActionPerformed(evt);
            }
        });
        jPanel1.add(pagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 150, 140));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/JE_opt (3).jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int contador = 0;
    int suma = 0;
    
    private void verMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMenuActionPerformed
        Menu.setVisible(true);
        Menu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_verMenuActionPerformed

    private void pagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagosActionPerformed
        Factura.setVisible(true);
        Cocina.dispose();
    }//GEN-LAST:event_pagosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void verMenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMenuMouseMoved
        verMenu.setToolTipText("*VER MENÚ DE PLATOS");
    }//GEN-LAST:event_verMenuMouseMoved

    private void doPedidoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doPedidoMouseMoved
        doPedido.setToolTipText("*INGRESO DE PEDIDOS");
    }//GEN-LAST:event_doPedidoMouseMoved

    private void verCocinaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verCocinaMouseMoved
        verCocina.setToolTipText("*ACCEDER A COCINA/STOCK");
    }//GEN-LAST:event_verCocinaMouseMoved

    private void infoMeserosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMeserosMouseMoved
        infoMeseros.setToolTipText("*ACCEDER INFORMACION DE MESEROS");
    }//GEN-LAST:event_infoMeserosMouseMoved

    private void verEstadisticasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verEstadisticasMouseMoved
        verEstadisticas.setToolTipText("*VER ESTADISTICAS");
    }//GEN-LAST:event_verEstadisticasMouseMoved

    private void pagosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagosMouseMoved
        pagos.setToolTipText("*REGISTRAR PAGO");
    }//GEN-LAST:event_pagosMouseMoved


    private void tiposBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposBebidasActionPerformed
        if (tiposBebidas.getSelectedIndex() == 0) {
            String icon = "/Img/gaseosa.png";
            URL url = this.getClass().getResource(icon);
            ImageIcon icono = new ImageIcon(url);

            imgSexi.setIcon(icono);
        } else if (tiposBebidas.getSelectedIndex() == 1) {
            String icon = "/Img/te_opt.png";
            URL url = this.getClass().getResource(icon);
            ImageIcon icono = new ImageIcon(url);

            imgSexi.setIcon(icono);
        } else {
            String icon = "/Img/agua_opt.png";
            URL url = this.getClass().getResource(icon);
            ImageIcon icono = new ImageIcon(url);

            imgSexi.setIcon(icono);
        }

    }//GEN-LAST:event_tiposBebidasActionPerformed

    void actualizarImagen() {
        tiposBebidas.addItemListener((ItemEvent arg0) -> {
            // TODO
        });
    }

    private void doPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doPedidoActionPerformed
        Pedido.setVisible(true);
        Pedido.setLocationRelativeTo(null);
    }//GEN-LAST:event_doPedidoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //AÑADIMOS PLATOS PEDIDOS EN MENU A TABLA DE PEDIDO        
// Comprobar si es mayor que 0 para agregarlos a tabla de pedido
        DefaultTableModel model = (DefaultTableModel) datosTable.getModel();

        if (pitaGriega.getSelectedIndex() > 0) {
            String x = pgriega.getText();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1], pitaGriega.getSelectedIndex()});
        }

        if (pitaSiciliana.getSelectedIndex() > 0) {
            String x = psici.getText();
            String[] y;
            y = x.split(":");
            model.addRow(new Object[]{y[0], y[1], pitaSiciliana.getSelectedIndex()});
        }
        if (pitaOpera.getSelectedIndex() > 0) {
            String x = popera.getText();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1], pitaOpera.getSelectedIndex()});
        }
        if (brasilia.getSelectedIndex() > 0) {
            String x = brasi.getText();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1], brasilia.getSelectedIndex()});
        }
        if (damaBlanca.getSelectedIndex() > 0) {
            String x = dblanca.getText();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1], damaBlanca.getSelectedIndex()});

        }
        if (bebidaCant.getSelectedIndex() > 0) {
            String x = (String) tiposBebidas.getSelectedItem();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1], bebidaCant.getSelectedIndex()});
        }

        Pedido.setVisible(true);
        Menu.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed


    private void damaBlancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_damaBlancaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_damaBlancaActionPerformed


    private void bebidaCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebidaCantActionPerformed


    }//GEN-LAST:event_bebidaCantActionPerformed

    private void verEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEstadisticasActionPerformed
        Estadisticas.setVisible(true);
        Estadisticas.setLocationRelativeTo(null);
    }//GEN-LAST:event_verEstadisticasActionPerformed

    private void verCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCocinaActionPerformed

        venPrinc vp = new venPrinc();

        vp.idUser.setText("");
        vp.passwordUser.setText("");
        StockIngredientes.setVisible(true);
        this.dispose();
        StockIngredientes.setLocationRelativeTo(null);
    }//GEN-LAST:event_verCocinaActionPerformed

    private void infoMeserosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMeserosActionPerformed
        Mesero.setVisible(true);
        this.dispose();
        Mesero.setLocationRelativeTo(null);
    }//GEN-LAST:event_infoMeserosActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Pedido.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void nuevoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoProdActionPerformed

    private void cantProdNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantProdNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantProdNuevoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //AÑADIMOS INGREDIENTES A TABLA STOCK

        // Tomar el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String name = nuevoProd.getText();
        int cantidad = Integer.parseInt(cantProdNuevo.getText());

        model.addRow(new Object[]{name, cantidad});

        if (!name.isEmpty()) {
            if (cantidad != 0) {
                JOptionPane.showMessageDialog(null, "Ingrediente se ha añadido satisfactoriamente.");
                AñadirProd.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se han ingresado datos.");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        //ASIGNAMOS A CADA MESERO UN NUMERO DE MESAS
        switch (numMesero.getSelectedIndex()) {
            case 0:
                mesasAsign.setText("Mesas 1 2 3 4 5");
                break;
            case 1:
                mesasAsign.setText("Mesas 6 7 8 9 10");
                break;
            case 2:
                mesasAsign.setText("Mesas 11 12 13 14 15");
                break;
            case 3:
                mesasAsign.setText("Mesas 16 17 18 19 20");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_generarActionPerformed

    private void guardarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarInfoActionPerformed
        //GUARDAMOS ARCHIVO DE MESEROS
        String n = nombre.getText();
        int i = Integer.parseInt(jTextField1.getText());
        int mesero;
        mesero = numMesero.getSelectedIndex();
        mesero = mesero + 1;
        String mesa = mesasAsign.getText();

        NodoMesero p = new NodoMesero();
        ptr = agregarInfoMesero(ptr, n, i, mesero, mesa);
        String archivo1;
        archivo1 = "Mesero.txt";
        JOptionPane.showMessageDialog(null, "La informacion del mesero " + n + " se ha guardado en archivo");
        try {
            GuardarInfoMesero(ptr);

        } catch (IOException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarInfoActionPerformed

    private void numMeseritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numMeseritoActionPerformed

    }//GEN-LAST:event_numMeseritoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //LLENAMOS TABLA DE COCINA
        DefaultTableModel model2 = (DefaultTableModel) datosTable2.getModel();

        if (pitaGriega.getSelectedIndex() > 0) {
            String x = pgriega.getText();
            String[] y;
            y = x.split(":");
            if (numMesa.getSelectedIndex() >= 0) {
                model2.addRow(new Object[]{y[0], pitaGriega.getSelectedIndex(), numMesa.getSelectedIndex()});
            }
        }
        if (pitaSiciliana.getSelectedIndex() > 0) {
            String x = psici.getText();
            String[] y;
            y = x.split(":");
            if (numMesa.getSelectedIndex() >= 0) {
                model2.addRow(new Object[]{y[0], pitaSiciliana.getSelectedIndex(), numMesa.getSelectedIndex()});
            }

        }
        if (pitaOpera.getSelectedIndex() > 0) {
            String x = popera.getText();
            String[] y;
            y = x.split(":");
            if (numMesa.getSelectedIndex() >= 0) {
                model2.addRow(new Object[]{y[0], pitaOpera.getSelectedIndex(), numMesa.getSelectedIndex()});
            }
        }
        if (brasilia.getSelectedIndex() > 0) {
            String x = brasi.getText();
            String[] y;
            y = x.split(":");
            if (numMesa.getSelectedIndex() >= 0) {
                model2.addRow(new Object[]{y[0], brasilia.getSelectedIndex(), numMesa.getSelectedIndex()});
            }
        }
        if (damaBlanca.getSelectedIndex() > 0) {
            String x = dblanca.getText();
            String[] y;
            y = x.split(":");
            if (numMesa.getSelectedIndex() >= 0) {
                model2.addRow(new Object[]{y[0], damaBlanca.getSelectedIndex(), numMesa.getSelectedIndex()});
            }
    }//GEN-LAST:event_jButton3ActionPerformed
        if (bebidaCant.getSelectedIndex() > 0) {
            String x = (String) tiposBebidas.getSelectedItem();
            String[] y;
            y = x.split(":");
            if (numMesa.getSelectedIndex() >= 0) {
                model2.addRow(new Object[]{y[0], bebidaCant.getSelectedIndex(), numMesa.getSelectedIndex()});
            }
        }

        Cocina.setVisible(true);

        Pedido.setVisible(false);
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


    }//GEN-LAST:event_formWindowActivated

    private void numMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numMesaActionPerformed

        //INDICE DE MESA SEGUN EL MESERIO COMBOBOX DE MESA
        if (numMeserito.getSelectedIndex() == 1) {
            if (numMesa.getSelectedIndex() > 5) {
                JOptionPane.showMessageDialog(null, "Numero de mesa invalido para mesero " + numMeserito.getSelectedIndex());
                numMesa.setSelectedIndex(0);
            }

        } else if (numMeserito.getSelectedIndex() == 2) {
            if (numMesa.getSelectedIndex() > 11 || numMesa.getSelectedIndex() < 6) {
                JOptionPane.showMessageDialog(null, "Numero de mesa invalido para mesero " + numMeserito.getSelectedIndex());
                numMesa.setSelectedIndex(0);
            }

        } else if (numMeserito.getSelectedIndex() == 3) {
            if (numMesa.getSelectedIndex() > 16 || numMesa.getSelectedIndex() < 11) {
                JOptionPane.showMessageDialog(null, "Numero de mesa invalido para mesero " + numMeserito.getSelectedIndex());
                numMesa.setSelectedIndex(0);

            }
        } else if (numMesa.getSelectedIndex() > 21 || numMesa.getSelectedIndex() < 15) {
            JOptionPane.showMessageDialog(null, "Numero de mesa invalido para mesero " + numMeserito.getSelectedIndex());
            numMesa.setSelectedIndex(0);
        }


    }//GEN-LAST:event_numMesaActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        StockIngredientes.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Hallar fila
        int fila = jTable1.getSelectedRow();

        // Tomar modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Eliminar fila
        model.removeRow(fila);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AñadirProd.setVisible(true);
        AñadirProd.setLocationRelativeTo(null);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //STOCK INGREDIENTES ARCHIVO        
        // Agregar filtro a FileChooser
        FileNameExtensionFilter filter
                = new FileNameExtensionFilter("Archivos.txt", "txt", "texto");
        fc.setFileFilter(filter);

        // Mostrar el FileChooser
        int opcion = fc.showOpenDialog(this);

        // Si el usuario escogió abrir
        if (opcion == JFileChooser.APPROVE_OPTION) {
            // Asignar archivo y nombre.
            archivo = fc.getSelectedFile();
            nombreArchivoTextField.setText(archivo.getAbsolutePath());

            // Tomar el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            try (Scanner lector = new Scanner(archivo)) {
                // Mientras el archivo tenga otra línea.
                while (lector.hasNextLine()) {
                    // Pedir la linea
                    String linea = lector.nextLine();

                    // Separar los datos
                    String[] datos = linea.split(" ");

                    // Convertir los datos
                    String ingrediente = datos[0];
                    int cantidad = Integer.parseInt(datos[1]);

                    // Agregamos datos a la tabla
                    model.addRow(new Object[]{ingrediente, cantidad});

                }
            } catch (FileNotFoundException ex) {
                mostrarError("Archivo no existe", "No se pudo encontrar el archivo");
            } catch (NullPointerException ex) {
                mostrarError("Formato equivocado", "El archivo no tiene el formato correcto");
                limpiarTabla(jTable1);

            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void cocinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cocinarActionPerformed
        int filas = datosTable2.getRowCount();

        cronometro.start();


    }//GEN-LAST:event_cocinarActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        //Reset valores de pedido tabla de pedidos
        limpiarTabla(datosTable);
        numMesa.setSelectedIndex(0);
        numMeserito.setSelectedIndex(0);
        Menu.setVisible(true);
        Cocina.setVisible(false);
        pitaGriega.setSelectedIndex(0);
        pitaOpera.setSelectedIndex(0);
        pitaSiciliana.setSelectedIndex(0);
        brasilia.setSelectedIndex(0);
        damaBlanca.setSelectedIndex(0);
        bebidaCant.setSelectedIndex(0);


    }//GEN-LAST:event_jButton11ActionPerformed

    private void cocinarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cocinarMouseMoved
        cocinar.setToolTipText("Debe seleccionar un plato de la tabla para cocinar.");
    }//GEN-LAST:event_cocinarMouseMoved

    private void nombreArchivoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreArchivoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreArchivoTextFieldActionPerformed
    
    
    
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Factura.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void nombreCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCliActionPerformed
        JOptionPane.showMessageDialog(null, "El pago se ha realizado satisfactoriamente.");
        cedulaCli.setText("");
        nombreCli.setText("");
        telCli.setText("");
        infoFact.setText("");
    }//GEN-LAST:event_nombreCliActionPerformed

    private void generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateActionPerformed
        //FACTURA
        int contTotal = 0;
        int c1 = numMesa.getSelectedIndex(), c2 = Integer.parseInt(mesaFact.getText());
        int cant6 = bebidaCant.getSelectedIndex(), cant = pitaGriega.getSelectedIndex(), cant5 = damaBlanca.getSelectedIndex();
        int cant2 = pitaSiciliana.getSelectedIndex(), cant3 = pitaOpera.getSelectedIndex(), cant4 = brasilia.getSelectedIndex();

        if (c1 == c2) {
            if (cant > 0) {

                String x = pgriega.getText();
                String[] y;
                y = x.split(":");

                Uml.Factura fact = new Uml.Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant);

                Double total = precio * cant;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue(); //contador total

                //Asignamos valores a cada columna de la tabla
                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            if (cant2 > 0) {

                String x = psici.getText();
                String[] y;
                y = x.split(":");

                Uml.Factura fact = new Uml.Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant2);

                Double total = cant2 * precio;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            if (cant3 > 0) {
                String x = popera.getText();
                String[] y;
                y = x.split(":");

                Uml.Factura fact = new Uml.Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant3);

                Double total = cant3 * precio;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);

            }

            if (cant4 > 0) {
                String x = brasi.getText();
                String[] y;
                y = x.split(":");

                Uml.Factura fact = new Uml.Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant4);

                Double total = cant4 * precio;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            if (cant5 > 0) {
                String x = dblanca.getText();
                String[] y;
                y = x.split(":");

                Uml.Factura fact = new Uml.Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant5);

                Double total = cant5 * precio;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            if (cant6 > 0) {
                String x = (String) tiposBebidas.getSelectedItem();
                String[] y;
                y = x.split(":");

                Uml.Factura fact = new Uml.Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant6);

                Double total = precio * cant6;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            //Asignacion de iva prop y total a labels factura
            Double iva = contTotal * 0.19;
            Double prop = contTotal * 0.10;
            Double tot = iva + prop + contTotal;
            IVA.setText(String.valueOf(iva));
            PROPINA.setText(String.valueOf(prop));
            TOTALtot.setText(String.valueOf(tot));

            venPrinc vp = new venPrinc();
            String c = mesaFact.getText();
            numMesa2.setText(c);
            nombreMese.setText(vp.nombreA);
            Factura.setVisible(true);
            Factura.setLocationRelativeTo(null);
            emergente.setVisible(false);
            String fecha1 = (new Date()).toString();

        } else {
            JOptionPane.showMessageDialog(null, "No coinciden las mesas, verifique nuevamente");
            mesaFact.setText("");
        }

        if (mesaFact.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No ha ingresa numero de mesa para generar factura.");
        }
    }//GEN-LAST:event_generateActionPerformed


    private void generaFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaFactActionPerformed
        int filas = datosTable2.getRowCount();

        emergente.setVisible(true);
        emergente.setLocationRelativeTo(null);
        Cocina.setVisible(false);


    }//GEN-LAST:event_generaFactActionPerformed


    private void mesaFactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesaFactKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_mesaFactKeyTyped

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        Cocina.setVisible(false);
        Menu.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        Mesero.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void nuevoProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoProdKeyTyped
        //Bloqueo de numeros en textField
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && ((c < 'A') | c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_nuevoProdKeyTyped

    private void mesaFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaFactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesaFactActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        venPrinc vp = new venPrinc();
        vp.setVisible(true);
        vp.idUser.setText("");
        vp.passwordUser.setText("");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed

    }//GEN-LAST:event_nombreActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && ((c < 'A') | c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        //Bloqueo de letras en textField
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void nombreCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreCliKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && ((c < 'A') | c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_nombreCliKeyTyped

    private void cedulaCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaCliKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_cedulaCliKeyTyped

    private void telCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telCliKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_telCliKeyTyped

    private void cantProdNuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantProdNuevoKeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_cantProdNuevoKeyTyped

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed


    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        resumenVentas.setVisible(true);
        resumenVentas.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton20ActionPerformed


    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        JOptionPane.showMessageDialog(null, "En el dia de hoy se realizaron" + contador + " ventas. De un total de: " + suma, "PITAKS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed

        int[] vector;
        vector = new int[5];
        int contg = 0, conts = 0, conto = 0, contp1 = 0, contp2 = 0, contb = 0;

        mejorPlato.setVisible(true);
        mejorPlato.setLocationRelativeTo(null);

        if (pitaGriega.getSelectedIndex() > 0) {
            contg = contg + pitaGriega.getSelectedIndex();
            vector[0] = contg;
        }

        if (pitaSiciliana.getSelectedIndex() > 0) {
            conts = conts + pitaSiciliana.getSelectedIndex();
            vector[1] = conts;
        }
        if (pitaOpera.getSelectedIndex() > 0) {
            conto = conto + pitaOpera.getSelectedIndex();
            vector[2] = conto;
        }

        if (damaBlanca.getSelectedIndex() > 0) {
            contp1 = contp1 + damaBlanca.getSelectedIndex();
            vector[3] = contp1;
        }
        if (brasilia.getSelectedIndex() > 0) {
            contp2 = contp2 + brasilia.getSelectedIndex();
            vector[4] = contp2;
        }

        if (bebidaCant.getSelectedIndex() > 0) {
            contb = contb + bebidaCant.getSelectedIndex();
            vector[5] = contb;
        }

        int max;
        max = 0;
        String icon;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max) {
                switch (i) {
                    case 0: {
                        nombrePlato0.setVisible(true);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(false);
                        icon = "/Img/pgriega.jpg";
                        URL url0 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url0);
                        fotoplato.setIcon(icono);
                        max = vector[i];
                        break;
                    }
                    case 1: {

                        icon = "/Img/pOpera.jpg";
                        URL url1 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url1);
                        fotoplato.setIcon(icono);
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(true);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(false);
                        max = vector[i];
                        break;
                    }
                    case 2: {

                        icon = "/Img/pSiciliana.jpg";
                        URL url2 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url2);
                        fotoplato.setIcon(icono);
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(true);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(false);
                        max = vector[i];
                        break;
                    }
                    case 3: {
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(true);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(false);
                        icon = "/Img/brasilia.png";
                        URL url3 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url3);
                        fotoplato.setIcon(icono);
                        max = vector[i];
                        break;
                    }
                    case 4: {
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(true);
                        nombrePlato5.setVisible(false);
                        icon = "/Img/damablanca.png";
                        URL url4 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url4);
                        fotoplato.setIcon(icono);
                        max = vector[i];
                        break;
                    }
                    default: {
                        icon = "/Img/bebidastodas.png";
                        URL url5 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url5);
                        fotoplato.setIcon(icono);
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(true);
                        max = vector[i];
                        break;
                    }
                }
            }
        }
        if (max == 0) {
            JOptionPane.showMessageDialog(null, "No existe ningun maximo.");
        }


    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed


    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        int index = listMesas.getSelectedIndex() + 1;
        String t = TOTALtot.getText();

        if (Integer.parseInt(numMesa2.getText()) == index) {
            JOptionPane.showMessageDialog(null, "La mesa " + index + " tuvo ventas de " + t, "PITAKS", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "La mesa " + index + " no ha realizdo ventas. TOTAL = 0", "PITAKS", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        int cont = 0, cont1 = 0, cont2 = 0, cont3 = 0;
        int[] vector2;
        vector2 = new int[4];

        if (numMeserito.getSelectedIndex() == 1) {
            cont = cont + 1;
            vector2[0] = cont;
        }
        if (numMeserito.getSelectedIndex() == 2) {
            cont1 = cont1 + 1;
            vector2[1] = cont1 + 1;
        }
        if (numMeserito.getSelectedIndex() == 3) {
            cont2 = cont2 + 1;
            vector2[2] = cont2 + 1;
        }
        if (numMeserito.getSelectedIndex() == 4) {
            cont3 = cont3 + 1;
            vector2[3] = cont3 + 1;
        }

        String mayor2 = null;
        int max;
        max = 0;

        for (int i = 0; i < vector2.length; i++) {
            if (vector2[i] > max) {
                max = vector2[i];
                switch (i) {
                    case 0:
                        mayor2 = ("JESUS F");
                        break;
                    case 1:
                        mayor2 = ("MIGUEL J");
                        break;
                    case 2:
                        mayor2 = ("MARLENE D");
                        break;
                    default:
                        mayor2 = ("AUGUSTO S");
                        break;
                }

            }
        }

        JOptionPane.showMessageDialog(null, "El mesero que mas ventas realizo fue: " + mayor2, "PITAKS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        //BOTON FINALIZA FACTURA
        Factura f = new Factura();
        f.numventas = 0;
        
        if ((nombreCli.getText().equals("")) && (cedulaCli.getText().equals("")) && (telCli.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "No ha llenado la informacion del cliente");
            
        } 
        
        if (((!nombreCli.getText().equals("")) && (!cedulaCli.getText().equals("")) && (!telCli.getText().equals("")))) {
            contador++;
            suma = (int) (suma + Double.parseDouble(TOTALtot.getText()));
           f.numventas = f.numventas + 1;
            JOptionPane.showMessageDialog(null, "El pago se ha realizado satisfactoriamente. HASTA LUEGO");
            Factura.setVisible(false);
            this.setVisible(true);
            
            /* nombreCli.setText("");
            cedulaCli.setText("");
            telCli.setText("");
            numMesa2.sertText("");
            limpiarTabla(datosTable);
            limpiarTabla(factTable);
            limpiarTabla(datosTable2);*/

        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void pitaGriegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pitaGriegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pitaGriegaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Opciones().setVisible(true);
            }
        });
    }

    public synchronized boolean isContinuar(boolean continuar) {
        return continuar;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AñadirProd;
    private javax.swing.JDialog Cocina;
    private javax.swing.JFrame Estadisticas;
    private javax.swing.JDialog Factura;
    private javax.swing.JLabel IVA;
    private javax.swing.JFrame Menu;
    private javax.swing.JFrame Mesero;
    private javax.swing.JLabel PROPINA;
    private javax.swing.JDialog Pedido;
    private javax.swing.JFrame StockIngredientes;
    private javax.swing.JLabel TOTALtot;
    private javax.swing.JComboBox<String> bebidaCant;
    private javax.swing.JLabel brasi;
    private javax.swing.JComboBox<String> brasilia;
    private javax.swing.JTextField cantProdNuevo;
    private javax.swing.JTextField cedulaCli;
    private javax.swing.JButton cocinar;
    private javax.swing.JComboBox<String> damaBlanca;
    private javax.swing.JTable datosTable;
    private javax.swing.JTable datosTable2;
    private javax.swing.JLabel dblanca;
    private javax.swing.JButton doPedido;
    private javax.swing.JDialog emergente;
    private javax.swing.JLabel fac;
    private javax.swing.JTable factTable;
    private javax.swing.JFileChooser fc;
    private javax.swing.JLabel fotoplato;
    private javax.swing.JButton generaFact;
    private javax.swing.JButton generar;
    private javax.swing.JButton generate;
    private javax.swing.JButton guardarInfo;
    private javax.swing.JLabel horario;
    private javax.swing.JLabel imgSexi;
    private javax.swing.JLabel infoFact;
    private javax.swing.JButton infoMeseros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jTextField40;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JList<String> listMesas;
    private javax.swing.JDialog mejorPlato;
    private javax.swing.JTextField mesaFact;
    private javax.swing.JLabel mesasAsign;
    private javax.swing.JLabel nameMesero;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombreArchivoTextField;
    private javax.swing.JTextField nombreCli;
    private javax.swing.JLabel nombreMese;
    private javax.swing.JLabel nombrePlato0;
    private javax.swing.JLabel nombrePlato1;
    private javax.swing.JLabel nombrePlato2;
    private javax.swing.JLabel nombrePlato3;
    private javax.swing.JLabel nombrePlato4;
    private javax.swing.JLabel nombrePlato5;
    private javax.swing.JTextField nuevoProd;
    private javax.swing.JComboBox<String> numMesa;
    private javax.swing.JLabel numMesa2;
    private javax.swing.JComboBox<String> numMeserito;
    private javax.swing.JComboBox<String> numMesero;
    private javax.swing.JButton pagos;
    private javax.swing.JLabel pgriega;
    private javax.swing.JComboBox<String> pitaGriega;
    private javax.swing.JComboBox<String> pitaOpera;
    private javax.swing.JComboBox<String> pitaSiciliana;
    private javax.swing.JLabel popera;
    private javax.swing.JLabel psici;
    private javax.swing.JDialog resumenVentas;
    private javax.swing.JTextField telCli;
    private javax.swing.JComboBox<String> tiposBebidas;
    public javax.swing.JButton verCocina;
    public javax.swing.JButton verEstadisticas;
    private javax.swing.JButton verMenu;
    // End of variables declaration//GEN-END:variables
}
