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
import java.util.HashMap;
import static form.pasien.getTanggalFromTable;
import static form.pasien.nampungtgl;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 *
 */
public class diagnosis extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    public static String kode;

    public diagnosis() {
        initComponents();
        this.setLocationRelativeTo(null);
        data_pasien();
        data_dokter();
        datatableDiagnosis();
    }

    public void data_pasien() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            String sql = "SELECT * FROM pasien";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String jns = rs.getString("Nama_Lengkap");
                cmbpasien.addItem(jns);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void tampil_pasien() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM pasien WHERE Nama_Lengkap = '" + cmbpasien.getSelectedItem() + "'");
            while (res.next()) {
                txtkdpasien.setText(res.getString("Kode_Pasien"));
            }
            res.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void data_dokter() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            String sql = "SELECT * FROM dokter";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String jns = rs.getString("Nama_Dokter");
                cmbnamadokter.addItem(jns);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void tampil_dokter() {
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM dokter WHERE Nama_Dokter = '" + cmbnamadokter.getSelectedItem() + "'");
            while (res.next()) {
                txtkddokter.setText(res.getString("Id_Dokter"));
            }
            res.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void refresh() {
        txtkdpemer.setText("");
        cmbpasien.setSelectedItem("-PILIH-");
        tglpemer.setDate(null);
        cmbnamadokter.setSelectedItem("--PILIH--");
        txthasil.setText("");
    }

    public void datatableDiagnosis() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Diagnosis");
        tbl.addColumn("Nama Pasien");
        tbl.addColumn("Hasil Diagnosis");
        tbl.addColumn("Tanggal Pemeriksaan");
        tbl.addColumn("Nama Dokter");
        table.setModel(tbl);
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM hasil_diagnosis INNER JOIN pasien ON hasil_diagnosis.Kode_Pasien=pasien.Kode_Pasien INNER JOIN dokter ON hasil_diagnosis.Id_Dokter=dokter.Id_Dokter");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("hasil_diagnosis.Kode_Diagnosis"),
                    res.getString("pasien.Nama_Lengkap"),
                    res.getString("hasil_diagnosis.Hasil_Diagnosis"),
                    res.getString("hasil_diagnosis.tanggal_pemeriksaan"),
                    res.getString("dokter.Nama_Dokter")
                });
                table.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtkdpemer = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        cmbpasien = new javax.swing.JComboBox<>();
        btndelete = new javax.swing.JPanel();
        btn_delete = new javax.swing.JLabel();
        btnedit = new javax.swing.JPanel();
        btn_edit = new javax.swing.JLabel();
        btnrefresh = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JPanel();
        btn_simpan = new javax.swing.JLabel();
        cmbnamadokter = new javax.swing.JComboBox<>();
        btncetak = new javax.swing.JPanel();
        btn_cetak = new javax.swing.JLabel();
        tglpemer = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnhome = new javax.swing.JPanel();
        j1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnpemeriksaan = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        j6 = new javax.swing.JPanel();
        txtkdpasien = new javax.swing.JLabel();
        txtkddokter = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txthasil = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1185, 695));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(15, 88, 5));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(53, 53, 53))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 970, 90));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel19.setText("PEMERIKSAAN");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, -1, -1));

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel25.setText("Kode Pemeriksaan");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, 30));

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel26.setText(":");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 10, -1));

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel29.setText("Hasil Pemeriksaan");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, 20));

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel30.setText(":");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 10, 20));

        jLabel31.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel31.setText("Tanggal Pemeriksaan");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel32.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel32.setText(":");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 10, -1));

        jLabel33.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel33.setText("Nama Dokter");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        jLabel34.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel34.setText(":");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 10, -1));
        getContentPane().add(txtkdpemer, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 190, 30));

        jLabel90.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel90.setText("Nama Pasien");
        getContentPane().add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, 30));

        jLabel91.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel91.setText(":");
        getContentPane().add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 10, 30));

        cmbpasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-PILIH-" }));
        cmbpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpasienActionPerformed(evt);
            }
        });
        getContentPane().add(cmbpasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 190, 30));

        btndelete.setBackground(new java.awt.Color(255, 0, 0));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));

        btn_delete.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btndeleteLayout = new javax.swing.GroupLayout(btndelete);
        btndelete.setLayout(btndeleteLayout);
        btndeleteLayout.setHorizontalGroup(
            btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndeleteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btn_delete)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        btndeleteLayout.setVerticalGroup(
            btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btndeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_delete)
                .addContainerGap())
        );

        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 140, 40));

        btnedit.setBackground(new java.awt.Color(0, 0, 255));
        btnedit.setForeground(new java.awt.Color(255, 255, 255));

        btn_edit.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btneditLayout = new javax.swing.GroupLayout(btnedit);
        btnedit.setLayout(btneditLayout);
        btneditLayout.setHorizontalGroup(
            btneditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btneditLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btn_edit)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        btneditLayout.setVerticalGroup(
            btneditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btneditLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_edit)
                .addContainerGap())
        );

        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 140, 40));

        btnrefresh.setBackground(new java.awt.Color(204, 204, 0));
        btnrefresh.setForeground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Refresh");
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnrefreshLayout = new javax.swing.GroupLayout(btnrefresh);
        btnrefresh.setLayout(btnrefreshLayout);
        btnrefreshLayout.setHorizontalGroup(
            btnrefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnrefreshLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel43)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        btnrefreshLayout.setVerticalGroup(
            btnrefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnrefreshLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel43)
                .addContainerGap())
        );

        getContentPane().add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 140, 40));

        btnsimpan.setBackground(new java.awt.Color(0, 204, 51));
        btnsimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsimpanMouseClicked(evt);
            }
        });

        btn_simpan.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnsimpanLayout = new javax.swing.GroupLayout(btnsimpan);
        btnsimpan.setLayout(btnsimpanLayout);
        btnsimpanLayout.setHorizontalGroup(
            btnsimpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnsimpanLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(btn_simpan)
                .addGap(38, 38, 38))
        );
        btnsimpanLayout.setVerticalGroup(
            btnsimpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnsimpanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_simpan)
                .addContainerGap())
        );

        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 140, 40));

        cmbnamadokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--" }));
        cmbnamadokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnamadokterActionPerformed(evt);
            }
        });
        getContentPane().add(cmbnamadokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 260, 29));

        btncetak.setBackground(new java.awt.Color(255, 102, 0));

        btn_cetak.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btn_cetak.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak.setText("Cetak");
        btn_cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cetakMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btncetakLayout = new javax.swing.GroupLayout(btncetak);
        btncetak.setLayout(btncetakLayout);
        btncetakLayout.setHorizontalGroup(
            btncetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btncetakLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btn_cetak)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        btncetakLayout.setVerticalGroup(
            btncetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btncetakLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(btncetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 110, 100));

        tglpemer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglpemerPropertyChange(evt);
            }
        });
        getContentPane().add(tglpemer, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 260, 30));

        jPanel5.setBackground(new java.awt.Color(18, 239, 38));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/profil.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Andi Wijaya");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DOKTER");

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

        btnpemeriksaan.setBackground(new java.awt.Color(51, 51, 51));
        btnpemeriksaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpemeriksaanMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/laporan.png"))); // NOI18N
        jLabel17.setText("PEMERIKSAAN");

        j6.setBackground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout j6Layout = new javax.swing.GroupLayout(j6);
        j6.setLayout(j6Layout);
        j6Layout.setHorizontalGroup(
            j6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        j6Layout.setVerticalGroup(
            j6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnpemeriksaanLayout = new javax.swing.GroupLayout(btnpemeriksaan);
        btnpemeriksaan.setLayout(btnpemeriksaanLayout);
        btnpemeriksaanLayout.setHorizontalGroup(
            btnpemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpemeriksaanLayout.createSequentialGroup()
                .addComponent(j6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        btnpemeriksaanLayout.setVerticalGroup(
            btnpemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnpemeriksaanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(j6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(btnpemeriksaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 220, 50));

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

        txtkdpasien.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(txtkdpasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 60, 20));

        txtkddokter.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(txtkddokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 60, 20));

        txthasil.setColumns(20);
        txthasil.setRows(5);
        jScrollPane1.setViewportView(txthasil);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 340, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 630, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void cmbpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpasienActionPerformed
        // TODO add your handling code here:
        tampil_pasien();
    }//GEN-LAST:event_cmbpasienActionPerformed

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        String kode = txtkdpemer.getText();
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            statement.executeUpdate("delete from resep_obat where Kode_Diagnosa ='" + kode + "';");
            statement.executeUpdate("delete from hasil_diagnosis where Kode_Diagnosis ='" + kode + "';");
            JOptionPane.showMessageDialog(null, "Data berhasil di HAPUS");
            refresh();
            txtkdpemer.requestFocus();
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Data gagal di HAPUS");
        }
        datatableDiagnosis();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        String kode_diagnosis = txtkdpemer.getText();
        String id_pasien = txtkdpasien.getText();
        String nama_dokter = txtkddokter.getText();
        String tgl = nampungtgl;
        String hasil = txthasil.getText();
        try {
            Statement statement = (Statement) koneksi.GetConnection().createStatement();
            statement.executeUpdate("UPDATE hasil_diagnosis SET Kode_Pasien = '" + id_pasien
                    + "', Hasil_Diagnosis ='" + hasil + "', tanggal_pemeriksaan='" + tgl
                    + "', Id_Dokter='" + nama_dokter + "' where Kode_Diagnosis = '" + kode_diagnosis + "'");
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Berhasil di Update");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Gagal di Update");
            System.out.println(e.getMessage());
        }
        datatableDiagnosis();
        refresh();
    }//GEN-LAST:event_btn_editMouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        refresh();
    }//GEN-LAST:event_jLabel43MouseClicked

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        // TODO add your handling code here:
        String kode_diagnosis = txtkdpemer.getText();
        String id_pasien = txtkdpasien.getText();
        String nama_dokter = txtkddokter.getText();
        String tgl = nampungtgl;
        String hasil = txthasil.getText();
        try {
            if (txtkdpemer.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else if (cmbnamadokter.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else if (cmbnamadokter.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else if (nampungtgl.equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else if (hasil.equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {
                Statement statement = (Statement) koneksi.GetConnection().createStatement();
                statement.executeUpdate("INSERT INTO hasil_diagnosis VALUES('" + kode_diagnosis + "','"
                        + id_pasien + "','" + hasil + "','" + tgl + "','" + nama_dokter + "');");
                statement.close();
                kode = txtkdpemer.getText();
                resep_obat rs = new resep_obat(kode);
                rs.setVisible(true);
            }
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Gagal Disimpan");
            System.out.println(t.getMessage());
        }
        datatableDiagnosis();
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseClicked

    }//GEN-LAST:event_btnsimpanMouseClicked

    private void cmbnamadokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnamadokterActionPerformed
        tampil_dokter();
    }//GEN-LAST:event_cmbnamadokterActionPerformed

    private void btn_cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetakMouseClicked
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/puskesmas", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(diagnosis.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(diagnosis.class.getName()).log(Level.SEVERE, null, ex);
        }
        String file = "C:\\Folder1\\Kelompok-4-TIF-B-Project-Akhir\\kelompok 4\\src\\report\\obat_1.jrxml";;
        HashMap hash = new HashMap();
        hash.put("resep1", txtkdpemer.getText());
        JasperReport jr;
        try {
            jr = JasperCompileManager.compileReport(file);
            JasperPrint jp = JasperFillManager.fillReport(jr, hash, koneksi);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            Logger.getLogger(diagnosis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_cetakMouseClicked

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        // TODO add your handling code here:
        new form_dokter().show();
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnpemeriksaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpemeriksaanMouseClicked
        // TODO add your handling code here:
        new diagnosis().show();
        this.dispose();
    }//GEN-LAST:event_btnpemeriksaanMouseClicked

    private void tglpemerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglpemerPropertyChange
        // TODO add your handling code here:
        if (tglpemer.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
            nampungtgl = format.format(tglpemer.getDate());
            System.out.println(nampungtgl);
        }
    }//GEN-LAST:event_tglpemerPropertyChange

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int i = table.getSelectedRow();

        String tgl;

        if (i >= 0) {
            txtkdpemer.setText((String) table.getValueAt(i, 0));
            cmbpasien.setSelectedItem((String) table.getValueAt(i, 1));
            tglpemer.setDate(getTanggalFromTable(table, 3));
            cmbnamadokter.setSelectedItem((String) table.getValueAt(i, 4));
            txthasil.setText((String) table.getValueAt(i, 2));
        }
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(diagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(diagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(diagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(diagnosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new diagnosis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_cetak;
    private javax.swing.JLabel btn_delete;
    private javax.swing.JLabel btn_edit;
    private javax.swing.JLabel btn_simpan;
    private javax.swing.JPanel btncetak;
    private javax.swing.JPanel btndelete;
    private javax.swing.JPanel btnedit;
    private javax.swing.JPanel btnhome;
    private javax.swing.JPanel btnpemeriksaan;
    private javax.swing.JPanel btnrefresh;
    private javax.swing.JPanel btnsimpan;
    private javax.swing.JComboBox<String> cmbnamadokter;
    private javax.swing.JComboBox<String> cmbpasien;
    private javax.swing.JPanel j1;
    private javax.swing.JPanel j6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser tglpemer;
    private javax.swing.JTextArea txthasil;
    private javax.swing.JLabel txtkddokter;
    private javax.swing.JLabel txtkdpasien;
    private javax.swing.JTextField txtkdpemer;
    // End of variables declaration//GEN-END:variables
}
