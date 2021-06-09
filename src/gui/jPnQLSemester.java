/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.ManagementSemesterController;
import dao.CourseDAO;
import dao.SemesterDAO;
import pojo.SemesterEntity;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

/**
 * @author Xuyen
 */
public class jPnQLSemester extends javax.swing.JPanel {
    /**
     * Creates new form jPnQLGV
     */
    public jPnQLSemester() {
        initComponents();
        labelId.setVisible(false);
        setData();
    }

    void setData() {

        btnDelete.setEnabled(false);
        btnCurrentPeriod.setEnabled(false);
        ManagementSemesterController controller = new ManagementSemesterController(jPnTable, jTFSearch);
        controller.setField(btnDelete, btnCurrentPeriod, jTFName, jTFYear, jDCStart, jDCend, labelId);
        controller.setDataToTableSemester();
        jTFName.requestFocus();
    }

    void setClear() {
        jTFYear.setText("");
        jTFName.setText("");
        jDCStart.setCalendar(null);
        jDCend.setCalendar(null);
        setData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFName = new javax.swing.JTextField();
        jTFYear = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnCurrentPeriod = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTFSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        labelId = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDCStart = new com.toedter.calendar.JDateChooser();
        jDCend = new com.toedter.calendar.JDateChooser();
        jPnTable = new javax.swing.JPanel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên học kì:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Năm học:");

        jTFName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFName.setToolTipText("");
        jTFName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNameKeyReleased(evt);
            }
        });
        jDCStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDCend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N


        jTFYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFYearKeyReleased(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCurrentPeriod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCurrentPeriod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnCurrentPeriod.setText("Set học kì hiện tại");
        btnCurrentPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrentPeriodActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account-search.png"))); // NOI18N

        jTFSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFSearch.setToolTipText("Tìm kiếm");
        jTFSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFSearchActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Bắt đầu:");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Kết thúc:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(labelId))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel1))
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel4))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTFYear, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jTFSearch)
                                                                        .addComponent(jTFName, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                                                        .addComponent(jDCStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jDCend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCurrentPeriod)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jTFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTFYear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jDCStart, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDCend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCurrentPeriod))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelId)
                                .addContainerGap(296, Short.MAX_VALUE))
        );

        jPnTable.setFocusTraversalPolicyProvider(true);
        jPnTable.setPreferredSize(new java.awt.Dimension(700, 630));

        javax.swing.GroupLayout jPnTableLayout = new javax.swing.GroupLayout(jPnTable);
        jPnTable.setLayout(jPnTableLayout);
        jPnTableLayout.setHorizontalGroup(
                jPnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 856, Short.MAX_VALUE)
        );
        jPnTableLayout.setVerticalGroup(
                jPnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPnTable, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPnTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>

    private void jTFSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnCurrentPeriodActionPerformed(java.awt.event.ActionEvent evt) {
        setCurentPeriod();
        // TODO add your handling code here:
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        deleteSemester();
        // TODO add your handling code here:
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        addSesmester();
        // TODO add your handling code here:
    }

    public void addSesmester() {
        String NameSemester = jTFName.getText().toUpperCase();
        String year = jTFYear.getText();
        java.util.Date dateS = jDCStart.getDate();
        java.util.Date dateE = jDCend.getDate();
        if (dateS == null || dateE == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày!");
            return;
        }
        Date dateStart = new Date(dateS.getYear(), dateS.getMonth(), dateS.getDate());
        Date dateEnd = new Date(dateE.getYear(), dateE.getMonth(), dateE.getDate());
        if (NameSemester.length() == 0 || year.length() == 0) {
            JOptionPane.showMessageDialog(null, "Không để trống!");
            return;
        }
        SemesterEntity s = new SemesterEntity();
        s.setYear(year);
        s.setTerm(NameSemester);
        s.setStartsemester(dateStart);
        s.setEndsemester(dateEnd);
        s.setIspresent(false);
        //minitry.setMinitryId(8);
        if (SemesterDAO.addSesmester(s)) {
            JOptionPane.showMessageDialog(null, "Thêm học kỳ thành công!");
            setData();
            setClear();
            return;
        }
        JOptionPane.showMessageDialog(null, "Trùng học kỳ. Vui lòng kiểm tra lại!");
        return;

    }

    public void deleteSemester() {
        int id = Integer.parseInt(labelId.getText());
        if (SemesterDAO.deleteSemester(SemesterDAO.getSemester(id))) {
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            setData();
            setClear();
            return;
        }
        JOptionPane.showMessageDialog(null, "Không tồn tại HK!");
        setClear();

    }


    public void setCurentPeriod() {
        int id = Integer.parseInt(labelId.getText());
        SemesterEntity s = SemesterDAO.getSemester(id);
        List<SemesterEntity> list=SemesterDAO.getSemesterList();
        for(SemesterEntity semester:list){
            semester.setIspresent(false);
            SemesterDAO.updateSemester(semester);
        }
        //currentSemester = id;
        s.setIspresent(true);
        if (SemesterDAO.updateSemester(s)) {
            JOptionPane.showMessageDialog(null, "Set thành công!");
            setData();
            setClear();
            return;
        }
        JOptionPane.showMessageDialog(null, "Thất bại!");
        return;

    }

    private void jTFNameKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTFYear.requestFocus();
        }
    }

    private void jTFYearKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jDCStart.requestFocus();
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCurrentPeriod;
    private javax.swing.JButton btnDelete;
    private com.toedter.calendar.JDateChooser jDCStart;
    private com.toedter.calendar.JDateChooser jDCend;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPnTable;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFSearch;
    private javax.swing.JTextField jTFYear;
    private javax.swing.JLabel labelId;
    // End of variables declaration
}
