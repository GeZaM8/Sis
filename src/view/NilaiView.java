/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.NilaiDAO;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Nilai;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Serge
 */
public class NilaiView extends javax.swing.JFrame implements DataCallback {
    
    private ArrayList<JTextField> textFields;
    NilaiDAO dao = new NilaiDAO();
    Nilai nilai;
    JasperReport jasRep;
    JasperPrint jasPrint;
    JasperDesign jasDes;
    String[] data;

    /**
     * Creates new form NilaiView
     */
    public NilaiView() {
        initComponents();
        textFields = new ArrayList<>();
        textFields.add(inputInduk);
        textFields.add(inputMapel);
        textFields.add(inputPengampu);
        textFields.add(inputNilai);
        textFields.add(tfNamaSiswa);
        textFields.add(tfMapel);
        textFields.add(tfPengampu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        header_text = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputInduk = new javax.swing.JTextField();
        btnLookupSiswa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfNamaSiswa = new javax.swing.JTextField();
        comboSemester = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        scrNilai = new javax.swing.JScrollPane();
        tableNilai = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        inputMapel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputPengampu = new javax.swing.JTextField();
        btnLookupMapel = new javax.swing.JButton();
        btnLookupPengampu = new javax.swing.JButton();
        tfMapel = new javax.swing.JTextField();
        tfPengampu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputNilai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        header.setBackground(new java.awt.Color(0, 0, 153));

        header_text.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        header_text.setForeground(new java.awt.Color(255, 255, 255));
        header_text.setText("DATA NILAI");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(header_text)
                .addContainerGap(847, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header_text, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nomor Induk");

        inputInduk.setOpaque(true);
        inputInduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputIndukKeyReleased(evt);
            }
        });

        btnLookupSiswa.setText("Lookup");
        btnLookupSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLookupSiswaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nama Siswa");

        tfNamaSiswa.setEditable(false);
        tfNamaSiswa.setEnabled(false);

        comboSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        comboSemester.setSelectedIndex(-1);
        comboSemester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSemesterItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Semester");

        tableNilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableNilaiMousePressed(evt);
            }
        });
        scrNilai.setViewportView(tableNilai);

        btnCetak.setText("Cetak Raport");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mata Pelajaran");

        inputMapel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputMapelKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Guru Pengampu");

        inputPengampu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputPengampuKeyReleased(evt);
            }
        });

        btnLookupMapel.setText("Lookup");
        btnLookupMapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLookupMapelActionPerformed(evt);
            }
        });

        btnLookupPengampu.setText("Lookup");
        btnLookupPengampu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLookupPengampuActionPerformed(evt);
            }
        });

        tfMapel.setEditable(false);
        tfMapel.setEnabled(false);

        tfPengampu.setEditable(false);
        tfPengampu.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nilai");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(inputMapel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLookupMapel)
                        .addGap(13, 13, 13)
                        .addComponent(tfMapel))
                    .addComponent(scrNilai)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCetak, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputPengampu)
                                    .addComponent(inputNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLookupPengampu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPengampu))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(530, 530, 530)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSimpan)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLookupMapel)
                    .addComponent(tfMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputPengampu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLookupPengampu)
                        .addComponent(tfPengampu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(inputNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetak)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrNilai, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputInduk, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLookupSiswa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(comboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfNamaSiswa))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLookupSiswa)
                    .addComponent(comboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadData();
    }//GEN-LAST:event_formWindowOpened

    private void inputIndukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputIndukKeyReleased
        tfNamaSiswa.setText(dao.getNamaSiswa(inputInduk.getText()));                                  
        loadData();
    }//GEN-LAST:event_inputIndukKeyReleased

    private void inputPengampuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPengampuKeyReleased
        tfPengampu.setText(dao.getNamaGuru(inputPengampu.getText()));                                  
        loadData();
    }//GEN-LAST:event_inputPengampuKeyReleased

    private void inputMapelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputMapelKeyReleased
        tfMapel.setText(dao.getMapel(inputMapel.getText()));                                  
        loadData();
    }//GEN-LAST:event_inputMapelKeyReleased

    private void btnLookupSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLookupSiswaActionPerformed
        LookView look = new LookView(this, true, "Data Siswa", dao.getLookSiswa());
        look.setVisible(true);
        inputInduk.setText(data[0]);
        tfNamaSiswa.setText(data[1]);
    }//GEN-LAST:event_btnLookupSiswaActionPerformed

    private void btnLookupMapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLookupMapelActionPerformed
        LookView look = new LookView(this, true, "Data Mata Pelajaran", dao.getLookMapel());
        look.setVisible(true);
        inputMapel.setText(data[0]);
        tfMapel.setText(data[1]);
    }//GEN-LAST:event_btnLookupMapelActionPerformed

    private void btnLookupPengampuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLookupPengampuActionPerformed
        LookView look = new LookView(this, true, "Data Guru", dao.getLookGuru());
        look.setVisible(true);
        inputPengampu.setText(data[0]);
        tfPengampu.setText(data[1]);
    }//GEN-LAST:event_btnLookupPengampuActionPerformed

    private void comboSemesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSemesterItemStateChanged
        loadData();
    }//GEN-LAST:event_comboSemesterItemStateChanged

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        loadData();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (!checkFill()) {
            JOptionPane.showMessageDialog(this, "Anda belum menginput semuanya");
            return;
        }
        
        if (confirm("Data akan disimpan", "Simpan Data") == JOptionPane.NO_OPTION) return;
        
        nilai = new Nilai();
        
        nilai.setNis(inputInduk.getText());
        nilai.setKodeMapel(inputMapel.getText());
        nilai.setKodeGuru(inputPengampu.getText());
        nilai.setSemester(comboSemester.getSelectedItem().toString());
        nilai.setNilai(Double.parseDouble(inputNilai.getText()));
        
        dao.saveNilai(nilai);
        loadData();
        removeInput();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tableNilaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNilaiMousePressed
        int selectedRow = tableNilai.rowAtPoint(evt.getPoint());
        
        if (selectedRow != -1) {
            String nisSiswa = inputInduk.getText();
            String kodeMapel = tableNilai.getValueAt(selectedRow, 0).toString();
            String nikGuru = tableNilai.getValueAt(selectedRow, 3).toString();
            
            loadDataTF(new String[] {nisSiswa, kodeMapel, nikGuru});
        }
    }//GEN-LAST:event_tableNilaiMousePressed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (confirm("Data akan dihapus", "Hapus Data") == JOptionPane.NO_OPTION) return;
        
        dao.deleteNilai(inputInduk.getText(), comboSemester.getSelectedItem().toString(), inputMapel.getText());
        loadData();
        removeInput();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        Map<String, Object> para = new HashMap<>();
        para.put("nis", inputInduk.getText());
        para.put("semester", comboSemester.getSelectedItem().toString());
        try {
            File report = new File("src/report/Raport.jrxml");
            jasDes = JRXmlLoader.load(report);
            jasRep = JasperCompileManager.compileReport(jasDes);
            jasPrint = JasperFillManager.fillReport(jasRep, para, koneksi.Koneksi.getConnection());
            JasperViewer viewer = new JasperViewer(jasPrint, false);
            viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Gagal Membuka Laporan : "+e,
                   "Cetak Laporan", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCetakActionPerformed

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
            java.util.logging.Logger.getLogger(NilaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NilaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NilaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NilaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NilaiView().setVisible(true);
            }
        });
    }
    
    @Override
    public void onDataReceived(String[] data) {
        this.data = data;
    }
    
    private void loadData() {
        String semester = "";
        if (comboSemester.getSelectedItem() != null)
            semester = comboSemester.getSelectedItem().toString();
        
        String[] args = {
            inputInduk.getText(),
            inputMapel.getText(),
            inputPengampu.getText(),
            semester
        };
        
        tableNilai.setModel(dao.getModelAllNilai(args));
        scrNilai.setViewportView(tableNilai);
    }
    
    private void loadDataTF(String[] data) {
        Nilai nilai = new Nilai();
        nilai.setNis(data[0]);
        nilai.setKodeMapel(data[1]);
        nilai.setKodeGuru(data[2]);
        
        this.nilai = dao.getSingleNilai(nilai);
        
        inputMapel.setText(this.nilai.getKodeMapel());
        inputPengampu.setText(this.nilai.getKodeGuru());
        inputNilai.setText(String.valueOf(this.nilai.getNilai()));
        comboSemester.setSelectedItem(this.nilai.getSemester());
        
        tfNamaSiswa.setText(this.nilai.getSiswa().getNama());
        tfMapel.setText(this.nilai.getMapel().getMapel());
        tfPengampu.setText(this.nilai.getGuru().getNama());
    }
    
    public void removeInput() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
        comboSemester.setSelectedItem("");
    }
    
    public boolean checkFill() {
        for (JTextField textField : textFields) {
            if (textField.getText().isEmpty())
                return false;
        }
        if (comboSemester.getSelectedItem() == null)
            return false;
        
        return true;
    }
    
    public int confirm(String text, String title) {
        return JOptionPane.showOptionDialog(null, text, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLookupMapel;
    private javax.swing.JButton btnLookupPengampu;
    private javax.swing.JButton btnLookupSiswa;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> comboSemester;
    private javax.swing.JPanel header;
    private javax.swing.JLabel header_text;
    public static javax.swing.JTextField inputInduk;
    public static javax.swing.JTextField inputMapel;
    private javax.swing.JTextField inputNilai;
    public static javax.swing.JTextField inputPengampu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrNilai;
    private javax.swing.JTable tableNilai;
    public static javax.swing.JTextField tfMapel;
    public static javax.swing.JTextField tfNamaSiswa;
    public static javax.swing.JTextField tfPengampu;
    // End of variables declaration//GEN-END:variables
}
