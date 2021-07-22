/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import com.mysql.jdbc.Driver;
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
import static form.transaksi.kode;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/**
 *
 *
 */
public class resep_obat extends javax.swing.JFrame {

    /**
     * Creates new form detail_transaksi
     */
    String kode;

    public resep_obat(String kode) {
        initComponents();
        this.setLocationRelativeTo(null);;
        datatableResep();
        comboBoxObat();
        this.kode = kode;
        txtDiagnosis.setText(kode);
    }

    public void kosong() {
        cmb_obat.setSelectedItem("-- Select --");
        cmb_jenis1.setSelectedItem("-- Select --");
        cmb_pemakaian.setSelectedItem("-- Select --");
        txtjumlah.setText("");
    }

    public void datatableResep() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Resep");
        tbl.addColumn("Nama Pasien");
        tbl.addColumn("Jenis Obat");
        tbl.addColumn("Harga");
        tbl.addColumn("Jumlah");
        tbl.addColumn("Pemakaian");
        tabel.setModel(tbl);
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM resep_obat INNER JOIN hasil_diagnosis  ON resep_obat.Kode_Diagnosa = hasil_diagnosis.Kode_Diagnosis INNER JOIN obat ON resep_obat.Kode_Obat = obat.Kode_Obat");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("resep_obat.Id_Resep"),
                    res.getString("hasil_diagnosis.Kode_Diagnosis"),
                    res.getString("obat.Nama_Obat"),
                    res.getString("resep_obat.jenis_obat"),
                    res.getString("resep_obat.jumlah"),
                    res.getString("resep_obat.pemakaian")
                });
                tabel.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
            System.out.println(e.getMessage());
        }
    }

    public void comboBoxObat() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM obat");
            while (res.next()) {
                cmb_obat.addItem(res.getString("Nama_Obat"));
            }
            res.last();
            int jumlahdata = res.getRow();
            res.first();
        } catch (Exception e) {
        }
    }

    public void tampilObat() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM obat WHERE Nama_Obat = '" + cmb_obat.getSelectedItem() + "'");
            while (res.next()) {
                txtObat.setText(res.getString("Kode_Obat"));
            }
            res.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        txtObat = new javax.swing.JLabel();
        txtrs = new javax.swing.JLabel();
        btnsimpan4 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        btnrefresh = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        btnedit = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        btndelete = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnKembali = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtDiagnosis = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cmb_obat = new javax.swing.JComboBox<>();
        txtjumlah = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cmb_pemakaian = new javax.swing.JComboBox<>();
        cmb_jenis1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(559, 469));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 90));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel56.setText("RESEP OBAT");
        jPanel2.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        txtObat.setForeground(new java.awt.Color(240, 240, 240));
        jPanel2.add(txtObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 60, 20));

        txtrs.setForeground(new java.awt.Color(240, 240, 240));
        jPanel2.add(txtrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 60, 20));

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

        jPanel2.add(btnsimpan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, 40));

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

        jPanel2.add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, 40));

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

        jPanel2.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 40));

        btndelete.setBackground(new java.awt.Color(255, 0, 0));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Delete");

        javax.swing.GroupLayout btndeleteLayout = new javax.swing.GroupLayout(btndelete);
        btndelete.setLayout(btndeleteLayout);
        btndeleteLayout.setHorizontalGroup(
            btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndeleteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel41)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btndeleteLayout.setVerticalGroup(
            btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btndeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel41)
                .addContainerGap())
        );

        jPanel2.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, 40));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 610, 110));

        btnKembali.setBackground(new java.awt.Color(153, 102, 0));
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKembaliMouseClicked(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Selesai");

        javax.swing.GroupLayout btnKembaliLayout = new javax.swing.GroupLayout(btnKembali);
        btnKembali.setLayout(btnKembaliLayout);
        btnKembaliLayout.setHorizontalGroup(
            btnKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKembaliLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel42)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        btnKembaliLayout.setVerticalGroup(
            btnKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnKembaliLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addContainerGap())
        );

        jPanel2.add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, 40));

        txtDiagnosis.setForeground(new java.awt.Color(240, 240, 240));
        jPanel2.add(txtDiagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 60, 20));

        jLabel36.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel36.setText("Nama Obat");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 30));

        jLabel35.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel35.setText(":");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 10, 30));

        jLabel40.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel40.setText("Jenis Obat");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 30));

        jLabel37.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel37.setText(":");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 10, -1));

        cmb_obat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--" }));
        cmb_obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_obatActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 350, 30));
        jPanel2.add(txtjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 350, 30));

        jLabel43.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel43.setText(":");
        jPanel2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 10, 30));

        jLabel44.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel44.setText("Jumlah");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 84, 31));

        jLabel45.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel45.setText("Pemakaian");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 32));

        jLabel46.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel46.setText(":");
        jPanel2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 10, 30));

        cmb_pemakaian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--", "3x1/hari", "2x1/hari", "1x1/hari" }));
        jPanel2.add(cmb_pemakaian, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 350, 32));

        cmb_jenis1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--", "Kapsul", "Sirup" }));
        jPanel2.add(cmb_jenis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 350, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 700, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void btnsimpan4btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpan4btnsimpanMouseClicked
        // TODO add your handling code here:
        String diagnosis = txtDiagnosis.getText();
        String obat = txtObat.getText();
        String jenis = (String) cmb_jenis1.getSelectedItem();
        String pemakaian = (String) cmb_pemakaian.getSelectedItem();
        String jumlah = txtjumlah.getText();

        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            statement.executeUpdate("insert into resep_obat VALUES (NULL,'" + diagnosis + "','" + obat + "','" + jenis + "','" + jumlah + "','" + pemakaian + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
            System.out.println(e.getMessage());
        }
        datatableResep();
        kosong();
    }//GEN-LAST:event_btnsimpan4btnsimpanMouseClicked

    private void btnrefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrefreshMouseClicked
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btnrefreshMouseClicked

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
        // TODO add your handling code here:
        String resep = txtrs.getText();
        String diagnosis = txtDiagnosis.getText();
        String obat = txtObat.getText();
        String jenis = (String) cmb_jenis1.getSelectedItem();
        String pemakaian = (String) cmb_pemakaian.getSelectedItem();
        String jumlah = txtjumlah.getText();

        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            statement.executeUpdate("UPDATE resep_obat SET Kode_Diagnosa ='" + diagnosis + "', Kode_Obat ='" + obat + "', jenis_obat ='" + jenis + "', jumlah ='" + jumlah + "', pemakaian ='" + pemakaian + "' WHERE Id_Resep ='" + resep + "'");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil diedit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal diedit");
            System.out.println(e.getMessage());
        }
        txtrs.setText("");
        datatableResep();
        kosong();
    }//GEN-LAST:event_btneditMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
        String resep = txtrs.getText();
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            statement.executeUpdate("delete from resep_obat WHERE Id_Resep ='" + resep + "'");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal Dihapus");
        }
        txtrs.setText("");
        datatableResep();
        kosong();
    }//GEN-LAST:event_btndeleteMouseClicked

    private void btnKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseClicked
        // TODO add your handling code here:
        new diagnosis().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliMouseClicked

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:;
        int i = tabel.getSelectedRow();

        String tgl;

        if (i >= 0) {
            txtrs.setText((String) tabel.getValueAt(i, 0));
            txtDiagnosis.setText((String) tabel.getValueAt(i, 1));
            cmb_obat.setSelectedItem((String) tabel.getValueAt(i, 2));
            cmb_jenis1.setSelectedItem((String) tabel.getValueAt(i, 3));
            txtjumlah.setText((String) tabel.getValueAt(i, 4));
            cmb_pemakaian.setSelectedItem((String) tabel.getValueAt(i, 5));
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void cmb_obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_obatActionPerformed
        // TODO add your handling code here:
        tampilObat();
    }//GEN-LAST:event_cmb_obatActionPerformed

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
            java.util.logging.Logger.getLogger(detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new resep_obat("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnKembali;
    private javax.swing.JPanel btndelete;
    private javax.swing.JPanel btnedit;
    private javax.swing.JPanel btnrefresh;
    private javax.swing.JPanel btnsimpan4;
    private javax.swing.JComboBox<String> cmb_jenis1;
    private javax.swing.JComboBox<String> cmb_obat;
    private javax.swing.JComboBox<String> cmb_pemakaian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel txtDiagnosis;
    private javax.swing.JLabel txtObat;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JLabel txtrs;
    // End of variables declaration//GEN-END:variables
}
