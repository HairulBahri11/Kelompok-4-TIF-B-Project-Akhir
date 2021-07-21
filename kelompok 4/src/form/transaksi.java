/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

//import com.mysql.jdbc.Driver;
import java.sql.Driver;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.text.SimpleDateFormat;
import static form.Jadwal.nampungtgl;
import static form.pasien.getTanggalFromTable;
import static form.pasien.nampungtgl;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author MUHAMMAD YUSRIL
 */
public class transaksi extends javax.swing.JFrame {

    JFileChooser jfc;
    File file;

    /**
     * Creates new form dashboard
     */
    public static String kode;
    public transaksi() {
        initComponents();
        this.setLocationRelativeTo(null);
        datatableTransaksi();
        comboBoxPasien();
        comboBoxPetugas();
    }

    public void kosong() {
        txtkdtransaksi.setText("");
        cmbPasien.setSelectedItem("-- Select --");
        jdate_ttl.setCalendar(null);
        cmbPetugas.setSelectedItem("-- Select --");
        pembayaran.setText("0");
        txtharga.setText("0");
        txtkembali.setText("0");
    }

    public static String nampungtgl;

    public void datatableTransaksi() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Transaksi");
        tbl.addColumn("Nama Pasien");
        tbl.addColumn("Tanggal Transaksi");
        tbl.addColumn("Nama Petugas");
        tbl.addColumn("Biaya");
        tbl.addColumn("Tunai");
        tbl.addColumn("Kembali");
        tabel.setModel(tbl);
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM transaksi INNER JOIN pasien ON transaksi.Id_Pasien=pasien.Kode_Pasien INNER JOIN petugas ON transaksi.Id_Petugas=petugas.Id_Petugas");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("transaksi.Id_Transaksi"),
                    res.getString("pasien.Nama_Lengkap"),
                    res.getString("transaksi.Tanggal_Transaksi"),
                    res.getString("petugas.Nama_Petugas"),
                    res.getString("transaksi.biaya"),
                    res.getString("transaksi.tunai"),
                    res.getString("transaksi.kembalian")
                });
                tabel.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
            System.out.println(e.getMessage());
        }
    }

    public void comboBoxPetugas() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM petugas");
            while (res.next()) {
                cmbPetugas.addItem(res.getString("Nama_Petugas"));
            }
            res.last();
            int jumlahdata = res.getRow();
            res.first();
        } catch (Exception e) {
        }
    }

    public void tampilPetugas() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM petugas WHERE Nama_Petugas = '" + cmbPetugas.getSelectedItem() + "'");
            while (res.next()) {
                txtPetugas1.setText(res.getString("Id_Petugas"));
            }
            res.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void comboBoxPasien() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM pasien");
            while (res.next()) {
                cmbPasien.addItem(res.getString("Nama_Lengkap"));
            }
            res.last();
            int jumlahdata = res.getRow();
            res.first();
        } catch (Exception e) {
        }
    }

    public void tampilPasien() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM pasien WHERE Nama_Lengkap = '" + cmbPasien.getSelectedItem() + "'");
            while (res.next()) {
                txtPetugas.setText(res.getString("Kode_Pasien"));
            }
            res.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampilKembalian() {
        int harga = Integer.parseInt(pembayaran.getText());
        int tunai = Integer.parseInt(txtharga.getText());
        int kembalian = harga - tunai;
        String kembalian1 = Integer.toString(kembalian);
        txtkembali.setText(kembalian1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtkdtransaksi = new javax.swing.JTextField();
        jdate_ttl = new com.toedter.calendar.JDateChooser();
        cmbPasien = new javax.swing.JComboBox<>();
        txtPetugas = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        cmbPetugas = new javax.swing.JComboBox<>();
        txtPetugas1 = new javax.swing.JLabel();
        txtkembali = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        txtharga = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnsimpan4 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        btnrefresh = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        btnedit = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        btndelete = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        btnpindah = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txt_cetak = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnhome = new javax.swing.JPanel();
        j1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnpetugas = new javax.swing.JPanel();
        j3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btndokter = new javax.swing.JPanel();
        j4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnjadwal = new javax.swing.JPanel();
        j7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btntransaksi = new javax.swing.JPanel();
        j8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnobat = new javax.swing.JPanel();
        j5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        btnpasien = new javax.swing.JPanel();
        j2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pembayaran = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1185, 695));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(15, 88, 5));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/close.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/minimize.png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/maximize.png"))); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PUSKESMAS");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TERPADU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 630, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(6, 6, 6)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23)
                                .addComponent(jLabel21))
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 970, 90));

        jLabel131.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel131.setText("Kode Pembayaran");
        getContentPane().add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        jLabel132.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel132.setText("Nama Pasien");
        getContentPane().add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jLabel133.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel133.setText("Tanggal Transaksi");
        getContentPane().add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        jLabel136.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel136.setText("Pembayaran");
        getContentPane().add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, -1, -1));

        jLabel137.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel137.setText(":");
        getContentPane().add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 10, -1));

        jLabel138.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel138.setText(":");
        getContentPane().add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));

        jLabel140.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel140.setText(":");
        getContentPane().add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 10, -1));

        jLabel141.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel141.setText(":");
        getContentPane().add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 180, -1, -1));

        jLabel56.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel56.setText("PEMBAYARAN");
        getContentPane().add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        txtkdtransaksi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtkdtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 320, 30));

        jdate_ttl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdate_ttlPropertyChange(evt);
            }
        });
        getContentPane().add(jdate_ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 320, 30));

        cmbPasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --" }));
        cmbPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPasienActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 320, 30));

        txtPetugas.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(txtPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 60, 20));

        jLabel151.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel151.setText("Nama Petugas");
        getContentPane().add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, -1));

        jLabel156.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel156.setText(":");
        getContentPane().add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        cmbPetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --" }));
        cmbPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPetugasActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 320, 30));

        txtPetugas1.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(txtPetugas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 60, 20));

        txtkembali.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtkembali.setText("0");
        getContentPane().add(txtkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 200, -1));

        jLabel159.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel159.setText(":");
        getContentPane().add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 210, -1, -1));

        jLabel160.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel160.setText("Kembalian");
        getContentPane().add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, -1, -1));

        jLabel161.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel161.setText(":");
        getContentPane().add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, -1, -1));

        jLabel162.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel162.setText("Harga");
        getContentPane().add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, -1));

        txtharga.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtharga.setText("0");
        getContentPane().add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 210, -1, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 910, 150));

        btnsimpan4.setBackground(new java.awt.Color(0, 204, 51));
        btnsimpan4.setForeground(new java.awt.Color(255, 255, 255));
        btnsimpan4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsimpan4btnsimpanMouseClicked(evt);
            }
        });

        jLabel103.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Simpan");

        javax.swing.GroupLayout btnsimpan4Layout = new javax.swing.GroupLayout(btnsimpan4);
        btnsimpan4.setLayout(btnsimpan4Layout);
        btnsimpan4Layout.setHorizontalGroup(
            btnsimpan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnsimpan4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel103)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btnsimpan4Layout.setVerticalGroup(
            btnsimpan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnsimpan4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel103)
                .addContainerGap())
        );

        getContentPane().add(btnsimpan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, 40));

        btnrefresh.setBackground(new java.awt.Color(204, 204, 0));
        btnrefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnrefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrefreshMouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Refresh");

        javax.swing.GroupLayout btnrefreshLayout = new javax.swing.GroupLayout(btnrefresh);
        btnrefresh.setLayout(btnrefreshLayout);
        btnrefreshLayout.setHorizontalGroup(
            btnrefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnrefreshLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel38)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnrefreshLayout.setVerticalGroup(
            btnrefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnrefreshLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addContainerGap())
        );

        getContentPane().add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, -1, 40));

        btnedit.setBackground(new java.awt.Color(0, 0, 255));
        btnedit.setForeground(new java.awt.Color(255, 255, 255));
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditMouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Edit");

        javax.swing.GroupLayout btneditLayout = new javax.swing.GroupLayout(btnedit);
        btnedit.setLayout(btneditLayout);
        btneditLayout.setHorizontalGroup(
            btneditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btneditLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel39)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        btneditLayout.setVerticalGroup(
            btneditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btneditLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addContainerGap())
        );

        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, -1, 40));

        btndelete.setBackground(new java.awt.Color(255, 0, 0));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Delete");

        javax.swing.GroupLayout btndeleteLayout = new javax.swing.GroupLayout(btndelete);
        btndelete.setLayout(btndeleteLayout);
        btndeleteLayout.setHorizontalGroup(
            btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndeleteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel40)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btndeleteLayout.setVerticalGroup(
            btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btndeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addContainerGap())
        );

        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, -1, 40));

        btnpindah.setBackground(new java.awt.Color(255, 102, 0));
        btnpindah.setForeground(new java.awt.Color(255, 255, 255));
        btnpindah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpindahMouseClicked(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Tambah Obat");

        javax.swing.GroupLayout btnpindahLayout = new javax.swing.GroupLayout(btnpindah);
        btnpindah.setLayout(btnpindahLayout);
        btnpindahLayout.setHorizontalGroup(
            btnpindahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpindahLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel41)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btnpindahLayout.setVerticalGroup(
            btnpindahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnpindahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel41)
                .addContainerGap())
        );

        getContentPane().add(btnpindah, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 140, 40));

        txt_cetak.setBackground(new java.awt.Color(102, 204, 0));
        txt_cetak.setForeground(new java.awt.Color(255, 255, 255));
        txt_cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cetakMouseClicked(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Cetak");

        javax.swing.GroupLayout txt_cetakLayout = new javax.swing.GroupLayout(txt_cetak);
        txt_cetak.setLayout(txt_cetakLayout);
        txt_cetakLayout.setHorizontalGroup(
            txt_cetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txt_cetakLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel42)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        txt_cetakLayout.setVerticalGroup(
            txt_cetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txt_cetakLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(txt_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 130, 40));

        jPanel5.setBackground(new java.awt.Color(18, 239, 38));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/profil.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Andi Wijaya");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PETUGAS");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(5, 4, 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setBackground(new java.awt.Color(0, 0, 0));
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
        });

        j1.setBackground(new java.awt.Color(0, 255, 51));
        j1.setOpaque(false);

        javax.swing.GroupLayout j1Layout = new javax.swing.GroupLayout(j1);
        j1.setLayout(j1Layout);
        j1Layout.setHorizontalGroup(
            j1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        j1Layout.setVerticalGroup(
            j1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/home.png"))); // NOI18N
        jLabel10.setText(" DASHBOARD");

        javax.swing.GroupLayout btnhomeLayout = new javax.swing.GroupLayout(btnhome);
        btnhome.setLayout(btnhomeLayout);
        btnhomeLayout.setHorizontalGroup(
            btnhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnhomeLayout.createSequentialGroup()
                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(0, 59, Short.MAX_VALUE))
        );
        btnhomeLayout.setVerticalGroup(
            btnhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnhomeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnhomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jPanel2.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 50));

        btnpetugas.setBackground(new java.awt.Color(0, 0, 0));
        btnpetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpetugasMouseClicked(evt);
            }
        });

        j3.setBackground(new java.awt.Color(0, 255, 51));
        j3.setOpaque(false);

        javax.swing.GroupLayout j3Layout = new javax.swing.GroupLayout(j3);
        j3.setLayout(j3Layout);
        j3Layout.setHorizontalGroup(
            j3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        j3Layout.setVerticalGroup(
            j3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Doctor.png"))); // NOI18N
        jLabel14.setText(" DOKTER");

        javax.swing.GroupLayout btnpetugasLayout = new javax.swing.GroupLayout(btnpetugas);
        btnpetugas.setLayout(btnpetugasLayout);
        btnpetugasLayout.setHorizontalGroup(
            btnpetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpetugasLayout.createSequentialGroup()
                .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 69, Short.MAX_VALUE))
        );
        btnpetugasLayout.setVerticalGroup(
            btnpetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpetugasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnpetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.add(btnpetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 220, 50));

        btndokter.setBackground(new java.awt.Color(0, 0, 0));
        btndokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndokterMouseClicked(evt);
            }
        });

        j4.setBackground(new java.awt.Color(0, 255, 51));
        j4.setOpaque(false);

        javax.swing.GroupLayout j4Layout = new javax.swing.GroupLayout(j4);
        j4.setLayout(j4Layout);
        j4Layout.setHorizontalGroup(
            j4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        j4Layout.setVerticalGroup(
            j4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/petugas.png"))); // NOI18N
        jLabel16.setText("PETUGAS");

        javax.swing.GroupLayout btndokterLayout = new javax.swing.GroupLayout(btndokter);
        btndokter.setLayout(btndokterLayout);
        btndokterLayout.setHorizontalGroup(
            btndokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndokterLayout.createSequentialGroup()
                .addComponent(j4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(0, 88, Short.MAX_VALUE))
        );
        btndokterLayout.setVerticalGroup(
            btndokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndokterLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(j4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(btndokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, -1));

        btnjadwal.setBackground(new java.awt.Color(0, 0, 0));
        btnjadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnjadwalMouseClicked(evt);
            }
        });

        j7.setBackground(new java.awt.Color(0, 255, 51));
        j7.setOpaque(false);

        javax.swing.GroupLayout j7Layout = new javax.swing.GroupLayout(j7);
        j7.setLayout(j7Layout);
        j7Layout.setHorizontalGroup(
            j7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        j7Layout.setVerticalGroup(
            j7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/jadwal.png"))); // NOI18N
        jLabel13.setText("  JADWAL");

        javax.swing.GroupLayout btnjadwalLayout = new javax.swing.GroupLayout(btnjadwal);
        btnjadwal.setLayout(btnjadwalLayout);
        btnjadwalLayout.setHorizontalGroup(
            btnjadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnjadwalLayout.createSequentialGroup()
                .addComponent(j7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(0, 94, Short.MAX_VALUE))
        );
        btnjadwalLayout.setVerticalGroup(
            btnjadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnjadwalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnjadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(j7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
        );

        jPanel2.add(btnjadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        btntransaksi.setBackground(new java.awt.Color(51, 51, 51));
        btntransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntransaksiMouseClicked(evt);
            }
        });

        j8.setBackground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout j8Layout = new javax.swing.GroupLayout(j8);
        j8.setLayout(j8Layout);
        j8Layout.setHorizontalGroup(
            j8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        j8Layout.setVerticalGroup(
            j8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pembayaran.png"))); // NOI18N
        jLabel15.setText("  PEMBAYARAN");

        javax.swing.GroupLayout btntransaksiLayout = new javax.swing.GroupLayout(btntransaksi);
        btntransaksi.setLayout(btntransaksiLayout);
        btntransaksiLayout.setHorizontalGroup(
            btntransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btntransaksiLayout.createSequentialGroup()
                .addComponent(j8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(0, 54, Short.MAX_VALUE))
        );
        btntransaksiLayout.setVerticalGroup(
            btntransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btntransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btntransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.add(btntransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        btnobat.setBackground(new java.awt.Color(0, 0, 0));
        btnobat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnobatMouseClicked(evt);
            }
        });

        j5.setBackground(new java.awt.Color(0, 255, 51));
        j5.setOpaque(false);

        javax.swing.GroupLayout j5Layout = new javax.swing.GroupLayout(j5);
        j5.setLayout(j5Layout);
        j5Layout.setHorizontalGroup(
            j5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        j5Layout.setVerticalGroup(
            j5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/obat.png"))); // NOI18N
        jLabel24.setText("OBAT");

        javax.swing.GroupLayout btnobatLayout = new javax.swing.GroupLayout(btnobat);
        btnobat.setLayout(btnobatLayout);
        btnobatLayout.setHorizontalGroup(
            btnobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnobatLayout.createSequentialGroup()
                .addComponent(j5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );
        btnobatLayout.setVerticalGroup(
            btnobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnobatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(j5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );

        jPanel2.add(btnobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 220, 50));

        btnpasien.setBackground(new java.awt.Color(0, 0, 0));
        btnpasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpasienMouseClicked(evt);
            }
        });

        j2.setBackground(new java.awt.Color(0, 255, 51));
        j2.setOpaque(false);

        javax.swing.GroupLayout j2Layout = new javax.swing.GroupLayout(j2);
        j2.setLayout(j2Layout);
        j2Layout.setHorizontalGroup(
            j2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        j2Layout.setVerticalGroup(
            j2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pasien.png"))); // NOI18N
        jLabel12.setText(" PASIEN");

        javax.swing.GroupLayout btnpasienLayout = new javax.swing.GroupLayout(btnpasien);
        btnpasien.setLayout(btnpasienLayout);
        btnpasienLayout.setHorizontalGroup(
            btnpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpasienLayout.createSequentialGroup()
                .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(0, 101, Short.MAX_VALUE))
        );
        btnpasienLayout.setVerticalGroup(
            btnpasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnpasienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
            .addComponent(j2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(btnpasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel9)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 730));

        pembayaran.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        pembayaran.setText("0");
        getContentPane().add(pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jdate_ttlPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdate_ttlPropertyChange
        // TODO add your handling code here:
        if (jdate_ttl.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
            nampungtgl = format.format(jdate_ttl.getDate());
        }
    }//GEN-LAST:event_jdate_ttlPropertyChange

    private void cmbPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPasienActionPerformed
        // TODO add your handling code here:
        tampilPasien();
    }//GEN-LAST:event_cmbPasienActionPerformed

    private void cmbPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPetugasActionPerformed
        // TODO add your handling code here:
        tampilPetugas();
    }//GEN-LAST:event_cmbPetugasActionPerformed

    private void btnsimpan4btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpan4btnsimpanMouseClicked
        // TODO add your handling code here:
        String txtkd = txtkdtransaksi.getText();
        String pasien = txtPetugas.getText();
        String tgl = nampungtgl;
        String petugas = txtPetugas1.getText();
        String transaksi = pembayaran.getText();
        String harga = txtharga.getText();
        String kembali = txtkembali.getText();
        
        
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            statement.executeUpdate("insert into transaksi VALUES ('" + txtkd + "','" + pasien + "','" + tgl + "','" + petugas + "','" + transaksi + "','" + harga + "','" + kembali + "')");
            statement.close();
            kode = txtkdtransaksi.getText();
            detail_transaksi dt = new detail_transaksi(kode);
            dt.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            System.out.println(e.getMessage());
        }
        datatableTransaksi();
    }//GEN-LAST:event_btnsimpan4btnsimpanMouseClicked

    private void btnrefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrefreshMouseClicked
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btnrefreshMouseClicked

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
        // TODO add your handling code here:
        String txtkd = txtkdtransaksi.getText();
        String pasien = txtPetugas.getText();
        String tgl = nampungtgl;
        String petugas = txtPetugas1.getText();
        String transaksi = pembayaran.getText();
        String harga = txtharga.getText();
        String kembali = txtkembali.getText();

        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            statement.executeUpdate("UPDATE transaksi SET Id_Pasien ='" + pasien + "', Tanggal_Transaksi ='" + tgl + "', Id_Petugas ='" + petugas + "', biaya ='" + harga + "', tunai ='" + transaksi + "', kembalian ='" + kembali + "' WHERE Id_Transaksi = '" + txtkd + "'");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil diedit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal diedit");
            System.out.println(e.getMessage());
        }
        datatableTransaksi();
        kosong();
    }//GEN-LAST:event_btneditMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
        String txtkd = txtkdtransaksi.getText();
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            statement.executeUpdate("delete from transaksi where Id_Transaksi = '" + txtkd + "';");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal Dihapus");
        }
        datatableTransaksi();
        kosong();
    }//GEN-LAST:event_btndeleteMouseClicked


    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int i = tabel.getSelectedRow();

        String tgl;

        if (i >= 0) {
            txtkdtransaksi.setText((String) tabel.getValueAt(i, 0));
            cmbPasien.setSelectedItem((String) tabel.getValueAt(i, 1));
            jdate_ttl.setDate(getTanggalFromTable(tabel, 2));
            cmbPetugas.setSelectedItem((String) tabel.getValueAt(i, 3));
            pembayaran.setText((String) tabel.getValueAt(i, 5));
            txtharga.setText((String) tabel.getValueAt(i, 4));
            txtkembali.setText((String) tabel.getValueAt(i, 6));
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void btnpindahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpindahMouseClicked
        // TODO add your handling code here:
        new detail_transaksi("").show();
    }//GEN-LAST:event_btnpindahMouseClicked

    private void txt_cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cetakMouseClicked
        // TODO add your handling code here:
        
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/puskesmas", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String file = "C:\\Folder1\\Kelompok-4-TIF-B-Project-Akhir\\kelompok 4\\src\\report\\transaksi2.jrxml";;
        HashMap hash = new HashMap();
        hash.put("detail", txtkdtransaksi.getText());
        JasperReport jr;
        try {
            jr = JasperCompileManager.compileReport(file);
            JasperPrint jp = JasperFillManager.fillReport(jr, hash, koneksi);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_cetakMouseClicked

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        // TODO add your handling code here:;;
        new dashboard().show();
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnpetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpetugasMouseClicked
        // TODO add your handling code here:
        new dokter().show();
        dispose();
    }//GEN-LAST:event_btnpetugasMouseClicked

    private void btndokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndokterMouseClicked
        // TODO add your handling code here:
        new petugas().show();
        dispose();
    }//GEN-LAST:event_btndokterMouseClicked

    private void btnjadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnjadwalMouseClicked
        // TODO add your handling code here:
        new Jadwal().show();
        dispose();
    }//GEN-LAST:event_btnjadwalMouseClicked

    private void btntransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntransaksiMouseClicked
        // TODO add your handling code here:
        new transaksi().show();
        dispose();
    }//GEN-LAST:event_btntransaksiMouseClicked

    private void btnobatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnobatMouseClicked
        // TODO add your handling code here:
        new obat().show();
        this.dispose();
    }//GEN-LAST:event_btnobatMouseClicked

    private void btnpasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpasienMouseClicked
        // TODO add your handling code here:
        new pasien().show();
        dispose();
    }//GEN-LAST:event_btnpasienMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btndelete;
    private javax.swing.JPanel btndokter;
    private javax.swing.JPanel btnedit;
    private javax.swing.JPanel btnhome;
    private javax.swing.JPanel btnjadwal;
    private javax.swing.JPanel btnobat;
    private javax.swing.JPanel btnpasien;
    private javax.swing.JPanel btnpetugas;
    private javax.swing.JPanel btnpindah;
    private javax.swing.JPanel btnrefresh;
    private javax.swing.JPanel btnsimpan4;
    private javax.swing.JPanel btntransaksi;
    private javax.swing.JComboBox<String> cmbPasien;
    private javax.swing.JComboBox<String> cmbPetugas;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JPanel j1;
    private javax.swing.JPanel j2;
    private javax.swing.JPanel j3;
    private javax.swing.JPanel j4;
    private javax.swing.JPanel j5;
    private javax.swing.JPanel j7;
    private javax.swing.JPanel j8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate_ttl;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel txtPetugas;
    private javax.swing.JLabel txtPetugas1;
    private javax.swing.JPanel txt_cetak;
    private javax.swing.JLabel txtharga;
    private javax.swing.JTextField txtkdtransaksi;
    private javax.swing.JLabel txtkembali;
    // End of variables declaration//GEN-END:variables
}
